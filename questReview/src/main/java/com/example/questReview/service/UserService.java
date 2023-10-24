package com.example.questReview.service;

import com.example.questReview.entity.User;
import com.example.questReview.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserDAO userDao;

    @Autowired
    public UserService (UserDAO userDao) {
        this.userDao = userDao;
    }

    public User insertUser(User user) {
        return userDao.save(user);
    }

    public void deleteUserById(Long userId) {
        userDao.deleteById(userId);
    }

    public User updateUser(Long userId, User updateduser) {
        if (userDao.existsById(userId)) {
            updateduser.setId(userId);
            return userDao.save(updateduser);
        } else {
            throw new IllegalArgumentException("Utente non trovato!");
        }
    }
}

