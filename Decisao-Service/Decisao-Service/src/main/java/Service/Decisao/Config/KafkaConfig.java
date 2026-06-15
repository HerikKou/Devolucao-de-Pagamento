package Service.Decisao.Config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.util.backoff.FixedBackOff;

@Configuration
public class KafkaConfig {



@Bean
public KafkaTemplate<String, Object> kafkaTemplate (ProducerFactory<String , Object> producerFactory){
    return new KafkaTemplate<>(producerFactory);
}

@Bean
public NewTopic topicDecisao(){
    return TopicBuilder.name("decisao-tomada").partitions(1).replicas(1).build();
}

@Bean
public NewTopic topicDecisaoExplicacao(){
    return TopicBuilder.name("decisao-tomada-explicacao").partitions(1).replicas(1).build();
}

 @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Object> kafkaListenerContainerFactory(
            ConsumerFactory<String, Object> consumerFactory,
            KafkaTemplate<String, Object> kafkaTemplate) {

        
        DeadLetterPublishingRecoverer recoverer = 
            new DeadLetterPublishingRecoverer(kafkaTemplate);

       
        FixedBackOff backOff = new FixedBackOff(2000L, 5L);

        DefaultErrorHandler errorHandler = 
            new DefaultErrorHandler(recoverer, backOff);

        ConcurrentKafkaListenerContainerFactory<String, Object> factory =
            new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        factory.setCommonErrorHandler(errorHandler);

        return factory;
    }




}
