package com.example.questReview.service;

import com.example.questReview.dto.UserDto;
import com.example.questReview.entity.User;
import com.example.questReview.repository.UserDAO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDAO userDao;

    public List<UserDto> getAllUsers(){
        List<User> userList = userDao.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : userList) {
            UserDto userDto = new UserDto();
            userDto.setId(user.getId());
            userDto.setNickname(user.getNickname());
            userDto.setEmail(user.getEmail());
            userDtoList.add(userDto);
        }
        return userDtoList;
    }

    public UserDto createUser(UserDto userDTO){
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        user = userDao.save(user);
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
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

