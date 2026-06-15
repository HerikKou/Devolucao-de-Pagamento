package Service.Decisao.Service;

import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import Service.Decisao.DTO.DecisaoEvento;
import Service.Decisao.DTO.ScoreCalculado;
import Service.Decisao.DTO.TransacaoEvento;
import Service.Decisao.Enums.DecisionStatus;
import Service.Decisao.Model.Decisao;
import Service.Decisao.Repository.DecisaoRepository;

import java.math.BigDecimal;

import org.slf4j.*;
@Component
public class ConsumerService {

private final Service.Decisao.Service.Producer producer;
private final DecisaoRepository repository;
private final Idempotencia idempotencia;
private final ServicePrincipal service;

private final Logger log = LoggerFactory.getLogger(ConsumerService.class);

   

    public ConsumerService(Producer producer, DecisaoRepository repository, Idempotencia idempotencia,
        ServicePrincipal service) {
    this.producer = producer;
    this.repository = repository;
    this.idempotencia = idempotencia;
    this.service = service;
}




    @KafkaListener(topics = "transacao-realizada-decisao", groupId = "decisao-service-group-v1")
    public void ConsumirTransaacao(TransacaoEvento evento){
        if(idempotencia.transacaojaProcessado(evento.getTransacaoid())){
            log.error("Transacao ja processada", evento.getTransacaoid());
            return ;
        }
        Decisao decisao = new Decisao();
        decisao.setTransacaoId(evento.getTransacaoid());
        decisao.setValor(evento.getValor());
        repository.save(decisao);

    }
    



  @KafkaListener(topics = "score-calculado", groupId = "decisao-service-group-v1")
public void consumirScore(ScoreCalculado evento) {
    if (idempotencia.scorejaProcessado(evento.getScoreId())) {
        log.info("Score já processado: " + evento.getScoreId());
        return;
    }

    Decisao decisao = repository.findByDevolucaoId(evento.getDevolucaoId());
        

    decisao.setScoreId(evento.getScoreId());
    decisao.setDevolucaoId(evento.getDevolucaoId());
    decisao.setStatusScore(evento.getStatus());

    BigDecimal valorAprovado = service.aprovarValor(decisao);
    decisao.setValor(valorAprovado);
    decisao.setDecisaoStatus(service.definirStatus(valorAprovado));

    Decisao salvo = repository.save(decisao);

    if (salvo.getDecisaoStatus() == DecisionStatus.APROVADA) {
        producer.EnviarEvento(new DecisaoEvento(
            salvo.getId(),
            salvo.getDevolucaoId(),
            salvo.getValor()
        ));

        producer.EnviarEventoExplicacao(new DecisaoEvento(salvo.getId(), salvo.getValor(), salvo.getStatusScore(), salvo.getDecisaoStatus()));
    }

}}
