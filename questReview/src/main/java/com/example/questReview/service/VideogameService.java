package com.example.questReview.service;

import com.example.questReview.dto.VideogameDto;
import com.example.questReview.entity.User;
import com.example.questReview.entity.Videogame;
import com.example.questReview.repository.UserDAO;
import com.example.questReview.repository.VideogameDAO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VideogameService {

    @Autowired
    private VideogameDAO videogameDAO;

    @Autowired
    private UserDAO userDAO;

    public List<VideogameDto> getAllVideogames() {
        List<Videogame> videogameList = videogameDAO.findAll();
        List<VideogameDto> videogameDtoList = new ArrayList<>();

        for (Videogame videogame : videogameList) {
            VideogameDto videogameDto = new VideogameDto();
            videogameDto.setId(videogame.getId());
            videogameDto.setTitle(videogame.getTitle());
            videogameDto.setSoftwareHouse(videogame.getSoftwareHouse());
            videogameDto.setPublisher(videogame.getPublisher());
            videogameDto.setDateOfRelease(videogame.getDateOfRelease());
            videogameDto.setPegi(videogame.getPegi());
            videogameDto.setPlatform(videogame.getPlatform());
            videogameDto.setUserId(videogame.getUser().getId());
            videogameDtoList.add(videogameDto);
        }
        return videogameDtoList;
    }

    public VideogameDto createVideogame(VideogameDto videogameDto){
        Videogame videogame = new Videogame();
        BeanUtils.copyProperties(videogameDto, videogame);
        videogame = videogameDAO.save(videogame);
        BeanUtils.copyProperties(videogame, videogameDto);

        Optional<User> userOptional = userDAO.findById(videogameDto.getUserId());
        if (userOptional.isPresent()) {
            videogame.setUser(userOptional.get());
        } else {
            //TODO da gestire
        }

        videogame = videogameDAO.save(videogame);
        BeanUtils.copyProperties(videogame, videogameDto);
        return videogameDto;
    }

    public void removeVideogame(Long id){
        videogameDAO.deleteById(id);
    }

    public Videogame uptadeVideogame(Long id, Videogame uptadeVideogame){
        if (videogameDAO.existsById(id)) {
            uptadeVideogame.setId(id);
            return videogameDAO.save(uptadeVideogame);
        } else {
            throw new IllegalArgumentException("Videogame ID not found!");
        }
    }
}

