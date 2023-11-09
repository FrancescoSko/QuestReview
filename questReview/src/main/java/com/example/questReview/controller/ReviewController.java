package com.example.questReview.controller;

import com.example.questReview.dto.ReviewDto;
import com.example.questReview.entity.Review;
import com.example.questReview.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ReviewDto addReview(@RequestBody ReviewDto reviewDto){
        //Dto prenderlo e trasformarlo in una entity
        return null;
    }
}
