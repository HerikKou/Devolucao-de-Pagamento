package Service.Historico.Service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import Service.Historico_Service.DTO.ExplicacaoEvento;
import Service.Historico_Service.Model.Historico;
import Service.Historico_Service.Repository.HistoricoRepository;

import java.time.LocalDateTime;

@Component
public class ConsumerService {

    private final Logger log = LoggerFactory.getLogger(ConsumerService.class);
    private final HistoricoRepository repository;

    public ConsumerService(HistoricoRepository repository) {
        this.repository = repository;
    }

    private boolean explicacaoJaProcessada(Long explicacaoId) {
        return repository.existsByExplicacaoId(explicacaoId);
    }

    @KafkaListener(topics = "explicacao-gerada", groupId = "historico-service-group-v1")
    public void consumir(ExplicacaoEvento evento) {
        if (explicacaoJaProcessada(evento.getExplicacaoId())) {
            log.info("Explicação já processada: " + evento.getExplicacaoId());
            return;
        }

        Historico historico = new Historico();
        historico.setExplicacaoId(evento.getExplicacaoId());
        historico.setDecisaoId(evento.getDecisaoId());
        historico.setPagamentoId(evento.getPagamentoId());
        historico.setDataRegistro(LocalDateTime.now());

        repository.save(historico);
        log.info("Histórico registrado: " + historico.getId());
    }

    @DltHandler
    public void dlqHandler(Object evento) {
        log.error("Falha ao processar evento: " + evento);
    }
}