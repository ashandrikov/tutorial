package com.shandrikov.kafkaExample;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(
            topics = "shandrikovcode",
            groupId = "groupId")
    void listener(String data){
        System.out.println("Data received: " + data);
    }
}
