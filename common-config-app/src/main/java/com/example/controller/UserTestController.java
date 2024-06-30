package com.example.controller;

import com.example.client.UserClient;
import com.example.entity.UserResponse;
import com.example.service.UserClientService;
import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/common")
public class UserTestController {

    private final UserClientService userAuthService;

    private static final Logger logger = LoggerFactory.getLogger(UserTestController.class);


    public UserTestController(UserClientService userClientService) {
        this.userAuthService = userClientService;
    }

    @GetMapping("/secure-endPoint")
    public String secureEndPoint(@RequestParam String username) {

        BasicAuthRequestInterceptor interceptor = userAuthService.createBasicAuthRequestInterceptor(username);
        // Use this interceptor in your Feign client or other HTTP client
        // Set the interceptor in the Feign client dynamically

        UserClient userClient = Feign.builder()
                .requestInterceptor(interceptor)
                .target(UserClient.class, "http://USER-SERVICE");

        // Now use the userClient to call the secure endpoint
        UserResponse response = userClient.getUserByName(username);

        return response.toString();
    }
}
