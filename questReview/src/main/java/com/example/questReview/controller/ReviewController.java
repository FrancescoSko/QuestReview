package com.example.questReview.controller;

import com.example.questReview.dto.ReviewDto;
import com.example.questReview.entity.Review;
import com.example.questReview.service.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;


    @Operation(summary = "Visualizza tutte le recensioni", description = "Feature che ci permette di visualizzare la lista delle recensioni")
    @GetMapping("/get-all")
    public List<ReviewDto> getAllReviews(){
        return reviewService.getAllReviews();
    }

    @Operation(summary = "Aggiungi una recensione", description = "Feature che ci permette di aggiungere una nuova recensione")
    @PostMapping("/add")
    public ResponseEntity<ReviewDto> addReview(@RequestBody ReviewDto reviewDto){
        Optional<ReviewDto> reviewOpt = reviewService.addReview(reviewDto);

        if(reviewOpt.isPresent()) {
            return ResponseEntity.ok(reviewOpt.get());
        }

        return ResponseEntity.badRequest().build();
    }
}
