package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.example.client")
//@EnableFeignClients
public class CommonConfigAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonConfigAppApplication.class, args);
    }

}
