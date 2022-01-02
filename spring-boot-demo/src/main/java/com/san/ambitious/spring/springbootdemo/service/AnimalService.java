package com.san.ambitious.spring.springbootdemo.service;

import com.san.ambitious.spring.springbootdemo.entity.Animal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AnimalService {

    @Autowired
    @Qualifier("animalBean")
    private Animal animal;

    public void getAnimal() {
        log.info(animal.getId());
        log.info(animal.getSound());

    }

}
