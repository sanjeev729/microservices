package com.san.kafka.example.kafkaproducerconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("kafka/publish")
public class MessageController {
    @Autowired
    KafkaTemplate kafkaTemplate;

    @PostMapping("/api/v1/{message}")
    public void publish(@PathVariable("message") String message) {

        kafkaTemplate.send("sanTopic", message);
    }


}
