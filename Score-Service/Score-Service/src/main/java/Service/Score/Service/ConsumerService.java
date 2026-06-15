package Service.Score.Service;

import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;

import org.springframework.stereotype.Component;

import Service.Score.DTO.DevolucaoCriada;
import Service.Score.DTO.ScoreCalculado;
import Service.Score.Enum.Status;
import Service.Score.Model.Score;
import Service.Score.Repository.ScoreRepository;

import org.slf4j.*;
@Component
public class ConsumerService {
private final Logger log = LoggerFactory.getLogger(ConsumerService.class);
private final Idempotencia idempotencia ;
private final Producer producer;
private final ScoreRepository repository;
private final CalculoService calculo ; 


public ConsumerService(Idempotencia idempotencia, Producer producer, ScoreRepository repository,
        CalculoService calculo) {
    this.idempotencia = idempotencia;
    this.producer = producer;
    this.repository = repository;
    this.calculo = calculo;
}



@KafkaListener(topics = "devolucao-criada", groupId = "score-service-group-v1")
public void consumirEvento(DevolucaoCriada evento){
    log.info("Devolução recebida:"+evento.getDevolucaoId());
        
if (idempotencia.devolucaoProcessada(evento.getDevolucaoId())) {
        log.info("Evento já processado: " + evento.getDevolucaoId());
        return;  
    }

    int frequencia = calculo.calcularFrequencia(evento.getFrequencia());
    int disputaAberta = calculo.calcularQuantidadeDeDisputa(evento.getQntdDeDisputaAberta());
    int disputaRealizada = calculo.calcularQuantidadeDeDisputaRealizada(evento.getQntdDeDisputaRealizada());
    int scorefinal = calculo.scoreFinal(frequencia, disputaAberta, disputaRealizada);
    Status status = calculo.definirResultadoFinal(scorefinal);
   

    Score score = entidade(evento, frequencia, disputaAberta, disputaRealizada, scorefinal, status);

    Score salvar = repository.save(score);

    producer.enviarEvento(new ScoreCalculado(salvar.getId(),score.getDevolucaoId(), salvar.getStatus()));
    
    



}



@DltHandler
public void dlqHandler(DevolucaoCriada evento){
    log.error("Erro ao processar evento", evento.getDevolucaoId());
}







private Score entidade(DevolucaoCriada evento, int frequencia , int aberta, int realizada, int scorefinal, Status status){
    Score score = new Score();
    score.setDevolucaoId(evento.getDevolucaoId());
    score.setTransacaoId(evento.getTransacaoId());
    score.setQntdDeDisputaAberta(aberta);
    score.setQntdDeDisputaRealizada(realizada);
    score.setFrequencia(frequencia);
    score.setScorefinal(scorefinal);
    score.setStatus(status);
    

    return score ;
}




}
