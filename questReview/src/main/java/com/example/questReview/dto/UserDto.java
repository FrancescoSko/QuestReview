package com.example.questReview.dto;

import com.example.questReview.entity.Review;
import com.example.questReview.entity.Videogame;

import java.util.List;

public class UserDto {

    private Long id;
    private String nickname;
    private String email;

    public UserDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
