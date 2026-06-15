package Service.Decisao.Service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import Service.Decisao.DTO.DecisaoEvento;
import Service.Decisao.Model.Decisao;
import org.slf4j.*;
@Component
public class Producer {

private final Logger log = LoggerFactory.getLogger(Producer.class);
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public Producer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void EnviarEvento(DecisaoEvento evento){
        try {
            kafkaTemplate.send("decisao-tomada", evento);
            log.info("Evento enviado ao kafka");
        } catch (Exception e) {
            log.error("Erro ao enviar", e);
        }
    }

    public void EnviarEventoExplicacao(DecisaoEvento evento){
        try {
            kafkaTemplate.send("decisao-tomada-explicacao", evento);
            log.info("Evento enviado ao kafka");
        } catch (Exception e) {
            log.error("Erro ao enviar", e);
        }
    }



}
