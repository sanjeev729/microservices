package com.san.ambitious.spring.springbootdemo.configuration;

import com.san.ambitious.spring.springbootdemo.entity.Animal;
import com.san.ambitious.spring.springbootdemo.entity.Human;
import com.san.ambitious.spring.springbootdemo.entity.Lion;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@Slf4j
public class TestConfiguration {

    @Bean
    @Qualifier("humanBean")
    public Animal getAnimalBean() {
        log.info("Human Bean");
        return new Human();
    }

    @Bean
    @Qualifier("animalBean")
    public Animal getDefaultAnimalBean() {
        log.info("Lion Bean");
        return new Lion();
    }

}
