package com.example.questReview.controller;


import com.example.questReview.dto.UserDto;
import com.example.questReview.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/get-all")
    public List<UserDto> findAllUsers ()
    {
        return userService.getAllUsers();
    }

    @PostMapping("/add")
    public UserDto addUser(@RequestBody UserDto userDTO){
        return userDTO = userService.createUser(userDTO);
    }
}
