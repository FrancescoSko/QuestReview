package com.example.questReview.controller;


import com.example.questReview.dto.UserDto;
import com.example.questReview.entity.User;
import com.example.questReview.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/get-all")
    public List<UserDto> findAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/add")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
        Optional<UserDto> newUserDto = userService.createUser(userDto);

        if (newUserDto.isPresent()) {
            return ResponseEntity.ok(newUserDto.get());
        } else {
            // Handle the case where the user creation fails
            return ResponseEntity.badRequest().build();
        }
    }
}