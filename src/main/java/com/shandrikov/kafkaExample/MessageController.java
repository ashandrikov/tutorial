package com.shandrikov.kafkaExample;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/messages")
public class MessageController {

    @Value("${main.topic}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, String>kafkaTemplate;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping
    public void publish(@RequestBody MessageRequest request) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String book = mapper.writeValueAsString(request.book());
        kafkaTemplate.send(topic, book);
//        restTemplate.postForEntity(
//                "http://localhost:8081/api/book",
//                request.book(),
//                String.class
//        );
    }
}
