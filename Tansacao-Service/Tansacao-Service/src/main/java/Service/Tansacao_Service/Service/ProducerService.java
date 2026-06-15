package Service.Tansacao_Service.Service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import Service.Tansacao_Service.DTO.TransacaoEvento;

import org.slf4j.*;
@Component
public class ProducerService {
 
private final Logger log = LoggerFactory.getLogger(ProducerService.class);

private final KafkaTemplate<String , Object> kafkaTemplate;

public ProducerService(KafkaTemplate<String , Object> kafkaTemplate){
    this.kafkaTemplate = kafkaTemplate;
}

public void enviarEventoDevolucao(TransacaoEvento evento){
    try {
        kafkaTemplate.send("transacao-realizada", evento.getTransacaoid().toString(),evento);
        log.info("Transacao enviada");
    } catch (Exception e) {
        log.error("Erro ao enviar evento", e.getLocalizedMessage());
    }
}
  

public void enviarEventoDecisao(TransacaoEvento evento){
    try {
        kafkaTemplate.send("transacao-realizada-decisao", evento.getTransacaoid().toString(),evento.getValor());
        log.info("Transacao enviada");
    } catch (Exception e) {
        log.error("Erro ao enviar evento", e.getLocalizedMessage());
    }
}
}
