package com.epam.springclouddemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
@RestController
public class SenderApplication {

    @Autowired
    RestTemplate restTemplate;

    private AtomicInteger counter = new AtomicInteger(0);

    @GetMapping("/send")
    public Integer sendCounter() {
        int counterValue = counter.addAndGet(1);
        System.out.println("I send " + counterValue);
        Integer receivedValue = restTemplate.getForObject("http://localhost:8081/multiply/" + counterValue, Integer.class);
        System.out.println("I received " + receivedValue);
        return receivedValue;
    }


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(SenderApplication.class, args);
    }
}
