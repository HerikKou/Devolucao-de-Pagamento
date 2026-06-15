package Service.Devolucao.Service;
import org.slf4j.*;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import Service.Devolucao.DTO.DevolucaoEvento;

@Component
public class ProducerService {

     private final Logger log = LoggerFactory.getLogger(ProducerService.class);
     private final KafkaTemplate<String , Object> kafkaTemplate;
     public ProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
     }
     
     public void enviarEvento(DevolucaoEvento evento){
        try {
            kafkaTemplate.send("devolucao-criada",evento);
            log.info("Evento enviado para o kafak");
        } catch (Exception e) {
            log.error("Erro ao enviar evento",e);
        }
     }
}
