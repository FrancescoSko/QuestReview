package com.example.questReview.service;

import com.example.questReview.entity.User;
import com.example.questReview.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserDAO userDao;


    //METODO PER CREARE UN USER
    public User createUser(User user) {
        return userDao.save(user);
    }


    //METODO PER ELIMINARE UN USER TRAMITE IL SUO ID
    public void deleteUserById(Long userId) {
        userDao.deleteById(userId);
    }


    //METODO PER AGGIORNARE LE INFORMAZIONI DI UNO USER
    public User updateUser(Long userId, User updatedUser) {
        if (userDao.existsById(userId)) {
            updatedUser.setId(userId);
            return userDao.save(updatedUser);
        } else {
            throw new IllegalArgumentException("User not found!");
        }
    }


}

