package Service.Tansacao_Service.Config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopic {


    @Bean
    public NewTopic topicTransacao(){
        return TopicBuilder.name("transacao-realizada").partitions(1).replicas(1).build();
    }

    @Bean
    public NewTopic topicTransacaoDecisao(){
        return TopicBuilder.name("transacao-realizada-decisao").partitions(1).replicas(1).build();
    }
}
