package com.example.questReview.controller;

import com.example.questReview.dto.ReviewDto;
import com.example.questReview.entity.Review;
import com.example.questReview.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;


    @GetMapping("/get-all")
    public List<Review> getAllReviews(){
        return reviewService.getAllReviews();
    }


    @PostMapping("/add")
   public ResponseEntity<String> addReview(@RequestBody ReviewDto reviewDto){
        Optional<Review> optionalReviewDto = reviewService.addReview(reviewDto);

        if(optionalReviewDto.isPresent()){
            return ResponseEntity.ok("New review added" + reviewDto.toString());
        } else {
            return ResponseEntity.badRequest().body("Impossible to add a new review");
        }

    }
}
