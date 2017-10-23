package com.epam.springclouddemo.receiver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ReceiverApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReceiverApplication.class, args);
    }

    @GetMapping("/multiply/{counter}")
    public Integer multiplyCounter(@PathVariable("counter") int counter) {
        System.out.println("I receive " + counter);
        System.out.println("I send " + counter*2);
        return counter * 2;
    }
}
