package com.example.questReview.controller;


import com.example.questReview.entity.User;
import com.example.questReview.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/get-all")
    public List<User> findAllUsers () {
        return userService.getAllUsers();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody User userToCreate) {
        Optional<User> userOpt = userService.createUser(userToCreate);

        if(userOpt.isPresent()) {
            return ResponseEntity.ok("user added: " + userOpt.get());
        } else {
            return ResponseEntity.badRequest().body("Impossible to add the new user, verify all the fields");
        }
    }
}
