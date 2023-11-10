package com.example.questReview.dto;

import com.example.questReview.enums.VideogamesGenres;

import java.time.LocalDate;

public class VideogameDto {

    private Long id;
    private String title;
    private String softwareHouse;
    private String publisher;
    private LocalDate dateOfRelease;
    private VideogamesGenres genre;
    private Integer pegi;
    private String platform;
    private Long userId;

    // Non includere il campo "reviewList" in quanto rappresenta una collezione di recensioni

    public VideogameDto() {
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
