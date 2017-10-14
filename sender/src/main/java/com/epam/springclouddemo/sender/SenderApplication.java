package com.epam.springclouddemo.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
@RestController
@EnableEurekaClient
@EnableFeignClients(basePackageClasses = ReceiverFeignClient.class)
public class SenderApplication {

    @Autowired
    ReceiverFeignClient receiverFeignClient;

    private AtomicInteger counter = new AtomicInteger(0);

    @GetMapping("/send")
    public Integer sendCounter() {
        int counterValue = counter.addAndGet(1);
        System.out.println("I send " + counterValue);
        Integer receivedValue = receiverFeignClient.multiplyCounter(counterValue);
        System.out.println("I received " + receivedValue);
        return receivedValue;
    }


    public static void main(String[] args) {
        SpringApplication.run(SenderApplication.class, args);
    }
}