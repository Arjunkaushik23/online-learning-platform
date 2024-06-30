package com.example.service;

import com.example.client.UserClient;
import com.example.entity.UserResponse;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.stereotype.Service;

@Service
public class UserClientService {

    private final UserClient userClient;

    public UserClientService(UserClient userClient) {
        this.userClient = userClient;
    }

    public BasicAuthRequestInterceptor createBasicAuthRequestInterceptor(String username) {
        UserResponse userResponse = userClient.getUserByName(username);
        return new BasicAuthRequestInterceptor(userResponse.getUsername(), userResponse.getPassword());
    }
}
