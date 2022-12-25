package com.shandrikov.kafkaExample;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(
            topics = "${main.topic}",
            groupId = "${spring.kafka.consumer.group-id}")
    void listener(String data){
        System.out.println("Data received: " + data);
    }
}
