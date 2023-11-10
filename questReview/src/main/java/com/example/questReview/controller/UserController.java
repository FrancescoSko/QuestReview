package com.example.questReview.controller;


import com.example.questReview.dto.UserDto;
import com.example.questReview.entity.User;
import com.example.questReview.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Operation(summary = "Visualizza tutti gli utenti", description = "Feature che ci permette di visualizzare tutti gli utenti memorizzati nel database")
    @GetMapping("/get-all")
    public List<UserDto> findAllUsers ()
    {
        return userService.getAllUsers();
    }

    @Operation(summary = "Aggiungi un nuovo utente", description = "Feature che ci permette di aggiungere un nuovo utente al database")
    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody UserDto userDTO){
        return ResponseEntity.ok(userService.createUser(userDTO));
    }
}
