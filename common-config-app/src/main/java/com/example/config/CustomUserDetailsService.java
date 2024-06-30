package com.example.config;

import com.example.client.UserClient;
import com.example.entity.UserResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserClient userClient;

    private final static Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    public void setUserClient(UserClient userClient) {
        this.userClient = userClient;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserResponse userResponse = userClient.getUserByName(username);
        if (userResponse == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        logger.info("username is: {}", userResponse.getUsername());

        return User.withUsername(userResponse.getUsername())
                .password(userResponse.getPassword())
                .roles(userResponse.getRole())
                .build();

    }
}
