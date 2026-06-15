package Service.Pagamento.Service;


import org.slf4j.*;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import Service.Pagamento.DTO.DecisaoEventoDTO;
import Service.Pagamento.DTO.PagamentoProcessadoDTO;
import Service.Pagamento.Model.Pagamento;
import Service.Pagamento.Model.Status;
import Service.Pagamento.Repository.PagamentoRepository;

@Service
public class Consumer {


    private final Logger log = LoggerFactory.getLogger(Consumer.class);
    private final PagamentoRepository repository;
    private final Idempotencia idempotencia;
    private final Producer producer;
    public Consumer(PagamentoRepository repository, Idempotencia idempotencia, Producer producer) {
        this.repository = repository;
        this.idempotencia = idempotencia;
        this.producer = producer;
    }

    @KafkaListener(topics = "decisao-tomada", groupId = "pagamento-service-group-v1")
    public void consumirEvento(DecisaoEventoDTO evento){

        if(idempotencia.DecisaoProcessado(evento.getDecisaoId())){
            log.error("Decisão já processada", evento.getDecisaoId());
            return;
        }
        Pagamento pagamento = entidade(evento);
        Pagamento salvar = repository.save(pagamento);
        producer.EnviarEvento(new PagamentoProcessadoDTO(salvar.getId(), salvar.getDecisaoId()));



    }

    @DltHandler
    public void dlqHandler(DecisaoEventoDTO evento){
        log.error("Erro ao processar evento"+evento.getDecisaoId());
    }

    private Pagamento entidade(DecisaoEventoDTO evento){
        Pagamento pagamento = new Pagamento();
        pagamento.setDecisaoId(evento.getDecisaoId());
        pagamento.setDevolucaoId(evento.getDevolucaoId());
        pagamento.setValorPago(evento.getValorAprovado());
        pagamento.setStatus(Status.PROCESSADO);
        return pagamento;
    }
}
