package com.example.questReview.controller;

import com.example.questReview.dto.VideogameDto;
import com.example.questReview.service.VideogameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/videogames")
public class VideogameController {

    @Autowired
    private VideogameService videogameService;


    @GetMapping("/get-all")
    public List<VideogameDto> getAllVideogames(){

        return videogameService.getAllVideogames();
    }

    @PostMapping("/add")
    public ResponseEntity<VideogameDto> addVideogame(@RequestBody VideogameDto videogameDto){
        Optional<VideogameDto> videogameOpt = videogameService.addVideogame(videogameDto);

        if(videogameOpt.isPresent()) {
            return ResponseEntity.ok(videogameOpt.get());
        }

        return ResponseEntity.badRequest().build();
    }
}

