package com.example.questReview.controller;

import com.example.questReview.dto.VideogameDto;
import com.example.questReview.service.VideogameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public VideogameDto addVideogame(@RequestBody VideogameDto videogameDto){
        return videogameDto = videogameService.createVideogame(videogameDto);
    }

}
