package com.example.client;

import com.example.entity.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("USER-SERVICE")
public interface UserClient {

    @GetMapping("/users/name/{username}")
    UserResponse getUserByName(@PathVariable("username") String username);
}

