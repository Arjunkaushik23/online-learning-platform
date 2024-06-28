package com.example.controller;


import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.ACCEPTED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(User user){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.ACCEPTED);

    }

    @GetMapping("/{userId}")
    public  ResponseEntity<User> getUserById(@PathVariable Long userId){
        User userById = userService.getUserById(userId);
        return ResponseEntity.ok(userById);
    }

    @GetMapping("/name/{username}")
    public ResponseEntity<User> getUserByName(@PathVariable String username){
        User userFound = userService.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("user not found"));
        return new ResponseEntity<>(userFound, HttpStatus.OK);
    }
}
