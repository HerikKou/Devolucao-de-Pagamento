package Service.Analista_Service.Service;

import org.slf4j.*;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import Service.Analista_Service.DTO.ExplicacaoGerada;
import Service.Analista_Service.DTO.PagamentoProcessado;
import Service.Analista_Service.Model.Explicacao;
import Service.Analista_Service.Reposiitory.ExplicacaoRepository;

@Component
public class ConsumerService {

    private final AnalistaService analista;
    private final ExplicacaoRepository repository;
    private final Idempotencia idempotencia;
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final Logger log = LoggerFactory.getLogger(ConsumerService.class);

    public ConsumerService(AnalistaService analista, ExplicacaoRepository repository,
            Idempotencia idempotencia, KafkaTemplate<String, Object> kafkaTemplate) {
        this.analista = analista;
        this.repository = repository;
        this.idempotencia = idempotencia;
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = "pagamento-processado", groupId = "analista-service-group-v1")
    public void consumir(PagamentoProcessado evento) {
        if (idempotencia.pagamentoJaProcessado(evento.getPagamentoId())) {
            log.info("Pagamento já processado: " + evento.getPagamentoId());
            return;
        }

        String explicacao = analista.explicar(evento.getPagamentoId(), evento.getDecisdaoId());

        Explicacao entidade = new Explicacao();
        entidade.setPagamentoId(evento.getPagamentoId());
        entidade.setDecisaoId(evento.getDecisdaoId());
        entidade.setExplicacao(explicacao);

        Explicacao salvo = repository.save(entidade);

        kafkaTemplate.send("explicacao-gerada", new ExplicacaoGerada(
            salvo.getId(),
            salvo.getDecisaoId(),
            salvo.getPagamentoId()
        ));
    }

    @DltHandler
    public void dlqHandler(Object evento) {
        log.error("Falha ao processar evento: " + evento);
    }
}