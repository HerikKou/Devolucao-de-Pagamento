package Service.Tansacao_Service.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import Service.Tansacao_Service.DTO.TransacaoEvento;


@Configuration
public class KafkaConfig {

    @Bean
    public KafkaTemplate<String, Object> kafkatemplatetransacao(ProducerFactory<String, Object> producerFactory){
        return new KafkaTemplate<>(producerFactory);
    }
}
