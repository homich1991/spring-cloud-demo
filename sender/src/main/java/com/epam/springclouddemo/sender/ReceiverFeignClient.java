package com.epam.springclouddemo.sender;

import com.epam.springclouddemo.receiver.Receiver;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "RECEIVER")
public interface ReceiverFeignClient extends Receiver {
}
