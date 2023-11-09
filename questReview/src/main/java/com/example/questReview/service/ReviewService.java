package com.example.questReview.service;

import com.example.questReview.dto.ReviewDto;
import com.example.questReview.entity.Review;
import com.example.questReview.entity.User;
import com.example.questReview.entity.Videogame;
import com.example.questReview.repository.ReviewDAO;
import com.example.questReview.repository.UserDAO;
import com.example.questReview.repository.VideogameDAO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    private ReviewDAO reviewDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private VideogameDAO videogameDAO;

    public List<ReviewDto> getAllReviews(){
        List<Review> reviewList = reviewDAO.findAll();
        List<ReviewDto> reviewDtoList = new ArrayList<>();
        for (Review r : reviewList) {
            ReviewDto reviewDto = new ReviewDto();
            reviewDto.setId(r.getId());
            reviewDto.setReviewDate(r.getReviewDate());
            reviewDto.setReviewText(r.getReviewText());
            reviewDto.setUserId(r.getUser().getId());
            reviewDto.setVideogameId(r.getVideogame().getId());
            reviewDtoList.add(reviewDto);
        }
        return reviewDtoList;
    }

    public Optional<ReviewDto> addReview(ReviewDto reviewDto){
        Review newReview = new Review();
        newReview.setReviewText(reviewDto.getReviewText());
        newReview.setReviewDate(reviewDto.getReviewDate());

        Optional<User> userOptional = userDAO.findById(reviewDto.getUserId());

        if(userOptional.isPresent()){
            newReview.setUser(userOptional.get());
        }

        Optional<Videogame> videogameOptional = videogameDAO.findById(reviewDto.getVideogameId());

        if(videogameOptional.isPresent()){
            newReview.setVideogame(videogameOptional.get());
        }

        if(videogameOptional.isEmpty() || userOptional.isEmpty()){
            return Optional.empty();
        } else {
            Review reviewSaved = reviewDAO.save(newReview);

            ReviewDto newReviewDto = new ReviewDto();

            newReviewDto.setId(reviewSaved.getId());
            newReviewDto.setReviewText(reviewSaved.getReviewText());
            newReviewDto.setReviewDate(reviewSaved.getReviewDate());
            newReviewDto.setUserId(reviewSaved.getUser().getId());
            newReviewDto.setVideogameId(reviewSaved.getVideogame().getId());

            return Optional.of(newReviewDto);
        }
    }
}
