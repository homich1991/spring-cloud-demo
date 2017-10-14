package com.epam.springclouddemo.receiver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface Receiver {

    @GetMapping("/multiply/{counter}")
    Integer multiplyCounter(@PathVariable("counter") int counter);
}
