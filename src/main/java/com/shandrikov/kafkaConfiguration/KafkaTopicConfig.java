package com.shandrikov.kafkaConfiguration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic shandrikovTopic(){
        return TopicBuilder.name("shandrikovcode")
                .build();
    }
}
