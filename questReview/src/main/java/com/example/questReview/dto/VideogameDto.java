package com.example.questReview.dto;

import com.example.questReview.entity.Review;
import com.example.questReview.entity.User;
import com.example.questReview.enums.VideogamesGenres;
import jakarta.persistence.ManyToMany;

import java.time.LocalDate;
import java.util.List;

public class VideogameDto {

    private Long id;
    private String title;
    private String softwareHouse;
    private String publisher;
    private LocalDate dateOfRelease;
    private VideogamesGenres genre;
    private Integer pegi;
    private String platform;
    private User user;
    private List<Review> reviewList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSoftwareHouse() {
        return softwareHouse;
    }

    public void setSoftwareHouse(String softwareHouse) {
        this.softwareHouse = softwareHouse;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public LocalDate getDateOfRelease() {
        return dateOfRelease;
    }

    public void setDateOfRelease(LocalDate dateOfRelease) {
        this.dateOfRelease = dateOfRelease;
    }

    public VideogamesGenres getGenre() {
        return genre;
    }

    public void setGenre(VideogamesGenres genre) {
        this.genre = genre;
    }

    public Integer getPegi() {
        return pegi;
    }

    public void setPegi(Integer pegi) {
        this.pegi = pegi;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }
}
