package Service.Pagamento.Service;


import org.slf4j.*;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import Service.Pagamento.DTO.PagamentoProcessadoDTO;
import Service.Pagamento.Repository.PagamentoRepository;

@Component
public class Producer {


private final Logger log = LoggerFactory.getLogger(Producer.class);
private final KafkaTemplate<String,Object> kafkaTemplate;

public Producer(KafkaTemplate<String, Object> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
}

public void EnviarEvento(PagamentoProcessadoDTO evento){
    try {
        kafkaTemplate.send("pagamento-processado",evento);
        log.info("Evento enviado ao kafka");
    } catch (Exception e) {
      log.error("Erro ao enviar evento", e);
    }
}









}
