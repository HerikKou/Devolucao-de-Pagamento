package Service.Devolucao.Config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopic {


    @Bean
    public NewTopic topicDevolucao(){
        return TopicBuilder.name("devolucao-criada").partitions(1).replicas(1).build();
    }
}
