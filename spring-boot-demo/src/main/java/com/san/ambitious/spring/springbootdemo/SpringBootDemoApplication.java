package com.san.ambitious.spring.springbootdemo;

import com.san.ambitious.spring.springbootdemo.entity.User;
import com.san.ambitious.spring.springbootdemo.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
@RestController
@Slf4j
public class SpringBootDemoApplication implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(SpringBootDemoApplication.class, args);
        /*Animal animal = context.getBean(Animal.class);
        log.info(animal.getId());
        log.info(animal.getSound());*/
    }

    @GetMapping
    public List<String> welcomeMessage() {
        return List.of("Sanjeev", "Sachin", "Pratiksha");
    }

    @Override
    public void run(String... args) throws Exception {

        User admin = new User("sanjeev", this.bCryptPasswordEncoder.encode("123"), "sanjeevkumarpal@gmail.com", "Admin");
        User normal = new User("sachin", this.bCryptPasswordEncoder.encode("1234"), "kyonsp@gmail.com", "Normal");
        this.userRepository.save(admin);
        this.userRepository.save(normal);
    }
}
