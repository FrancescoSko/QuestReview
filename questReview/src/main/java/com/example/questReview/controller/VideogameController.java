package com.example.questReview.controller;

import com.example.questReview.entity.Videogame;
import com.example.questReview.service.VideogameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/videogames")
public class VideogameController {

    @Autowired
    private VideogameService videogameService;


    @GetMapping("/get-all")
    public List<Videogame> getAllVideogames(){
        return videogameService.getAllVideogames();
    }


    @PostMapping("/add")
    public ResponseEntity<String> addVideogame(@RequestBody Videogame videogame){
    Optional<Videogame> opt = videogameService.addVideoGame(videogame);
       if(opt.isPresent()){
           return ResponseEntity.ok("Videogame added : " + videogame.getTitle());
       } else {
           return ResponseEntity.badRequest().body("Impossible to add a new videogame, verify all the fields");
       }
    }



}
