package com.san.ambitious.spring.springbootdemo;

import com.san.ambitious.spring.springbootdemo.entity.Animal;
import com.san.ambitious.spring.springbootdemo.service.AnimalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
@Slf4j
public class SpringBootDemoApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(SpringBootDemoApplication.class, args);
        /*Animal animal = context.getBean(Animal.class);
        log.info(animal.getId());
        log.info(animal.getSound());*/
        AnimalService as = context.getBean(AnimalService.class);
        as.getAnimal();

        List<String> list=new ArrayList<>();
        list.add("Sanjeev");

    }

    @GetMapping
    public List<String> welcomeMessage() {
        return List.of("Sanjeev", "Sachin", "Pratiksha");
    }

}
