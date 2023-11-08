package com.example.questReview.entity;

import com.example.questReview.enums.VideogamesGenres;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Videogame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String softwareHouse;
    private String publisher;
    private LocalDate dateOfRelease;
    private VideogamesGenres genre;
    private Integer pegi;
    private String platform;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "videogame_id")

    @OneToMany(mappedBy = "videogame")
    private List<Review> reviewList;

    public Videogame(){

    }
    public Videogame(String title, String softwareHouse, String publisher, LocalDate dateOfRelease, VideogamesGenres genre, Integer pegi, String platform) {
        this.title = title;
        this.softwareHouse = softwareHouse;
        this.publisher = publisher;
        this.dateOfRelease = dateOfRelease;
        this.genre = genre;
        this.pegi = pegi;
        this.platform = platform;

    }

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

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}