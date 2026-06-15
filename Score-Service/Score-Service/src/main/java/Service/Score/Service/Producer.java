package Service.Score.Service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import Service.Score.DTO.ScoreCalculado;

import org.slf4j.*;
@Component
public class Producer {

    private final KafkaTemplate<String,Object> template;
   private final Logger log = LoggerFactory.getLogger(ConsumerService.class);
   public Producer(KafkaTemplate<String, Object> template) {
    this.template = template;
   }
   
   public void enviarEvento(ScoreCalculado evento){
    try {
        template.send("score-calculado",evento);
        log.info("Evento enviado");
    } catch (Exception e) {
       log.error("Erro ao enviar evento", e);
    }
   }




}
