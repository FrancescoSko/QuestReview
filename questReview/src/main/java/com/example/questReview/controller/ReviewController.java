package com.example.questReview.controller;

import com.example.questReview.dto.ReviewDto;
import com.example.questReview.entity.Review;
import com.example.questReview.service.ReviewService;
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


    @GetMapping("/get-all")
    public List<ReviewDto> getAllReviews(){
        return reviewService.getAllReviews();
    }

    @PostMapping("/add")
    public ResponseEntity<ReviewDto> addReview(@RequestBody ReviewDto reviewDto){
        Optional<ReviewDto> reviewOpt = reviewService.addReview(reviewDto);

        if(reviewOpt.isPresent()) {
            return ResponseEntity.ok(reviewOpt.get());
        }

        return ResponseEntity.badRequest().build();
    }
}
