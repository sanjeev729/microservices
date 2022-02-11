package com.san.kafka.example.kafkaproducerconsumer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaProducerConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerConsumerApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(KafkaTemplate<String, Object> kafkaTemplate) {
        return args -> {
            for (int i = 0; i < 30; i++) {
                kafkaTemplate.send("sanTopic", "Hello first kafka message" + i);
            }

        };
    }

}