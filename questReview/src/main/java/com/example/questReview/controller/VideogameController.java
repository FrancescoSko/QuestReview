package com.example.questReview.controller;

import com.example.questReview.dto.VideogameDto;
import com.example.questReview.service.VideogameService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/videogames")
public class VideogameController {

    @Autowired
    private VideogameService videogameService;

    @Operation(summary = "Visualizza tutti i videogames", description = "Feature che ci permette di visualizzare tutti i videogame presenti nel nostro database")
    @GetMapping("/get-all")
    public List<VideogameDto> getAllVideogames(){
        return videogameService.getAllVideogames();
    }

    @Operation(summary = "Aggiungi un nuovo videogame", description = "Feature che ci permette di aggiungere un nuovo videogame al nostro database")
    @PostMapping("/add")
    public VideogameDto addVideogame(@RequestBody VideogameDto videogameDto){
        return videogameDto = videogameService.createVideogame(videogameDto);
    }

}
