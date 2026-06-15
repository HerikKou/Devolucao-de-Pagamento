package Service.Devolucao.Service;

import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.retry.annotation.*;
import org.springframework.stereotype.Component;

import Service.Devolucao.DTO.TransacaoRealizadaDTO;
import Service.Devolucao.Model.Devolucao;
import Service.Devolucao.Repository.DevolucaoRepository;

import org.slf4j.*;
@Component
public class ConsumerService {

    
    private final Logger log = LoggerFactory.getLogger(ConsumerService.class);
    private final Idempotencia idempotencia;
    private final DevolucaoRepository repository;
    
    public ConsumerService(Idempotencia idempotencia, DevolucaoRepository repository) {
        this.idempotencia = idempotencia;
        this.repository = repository;
    }

    @Retryable(maxAttempts = 3, backoff = @Backoff(delay = 3000))
    @KafkaListener(topics = "transacao-realizada", groupId = "devolucao-service-group-v1")
    public void consumirEvento(TransacaoRealizadaDTO transacao){
        log.info("Evento Recebido:"+ transacao.getTransacaoid());
        boolean existe = idempotencia.transacaoJaProcessado(transacao.getTransacaoid());
        Devolucao devolucao  = new Devolucao();
        devolucao.setTransacaoid(transacao.getTransacaoid());
        repository.save(devolucao);

    }

    @DltHandler
    public void dlqHandler(Long transacaoId){
        log.error("Erro ao processar evento", transacaoId);
    }
}
