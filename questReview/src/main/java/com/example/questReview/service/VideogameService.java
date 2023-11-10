package com.example.questReview.service;

import com.example.questReview.dto.ReviewDto;
import com.example.questReview.dto.VideogameDto;
import com.example.questReview.entity.Review;
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
        for (Videogame v : videogameList) {
            VideogameDto videogameDto = new VideogameDto();
            videogameDto.setId(v.getId());
            videogameDto.setTitle(v.getTitle());
            videogameDto.setSoftwareHouse(v.getSoftwareHouse());
            videogameDto.setPublisher(v.getPublisher());
            videogameDto.setDateOfRelease(v.getDateOfRelease());
            videogameDto.setGenre(v.getGenre());
            videogameDto.setPegi(v.getPegi());
            videogameDto.setPlatform(v.getPlatform());

            if (v.getUser() != null) {
                videogameDto.setUserId(v.getUser().getId());
            }

            videogameDtoList.add(videogameDto);
        }
        return videogameDtoList;
    }
    public Optional<VideogameDto> addVideogame(VideogameDto videogameDto) {
        Videogame newVideogame = new Videogame();
        newVideogame.setTitle(videogameDto.getTitle());
        newVideogame.setSoftwareHouse(videogameDto.getSoftwareHouse());
        newVideogame.setPublisher(videogameDto.getPublisher());
        newVideogame.setDateOfRelease(videogameDto.getDateOfRelease());
        newVideogame.setGenre(videogameDto.getGenre());
        newVideogame.setPegi(videogameDto.getPegi());
        newVideogame.setPlatform(videogameDto.getPlatform());

        // Fetch the user by ID and set it to the Videogame
        if (videogameDto.getUserId() != null) {
            Optional<User> userOpt = userDAO.findById(videogameDto.getUserId());
            userOpt.ifPresent(newVideogame::setUser);
        }

        Videogame videogameSaved = videogameDAO.save(newVideogame);

        VideogameDto newVideogameDto = new VideogameDto();
        newVideogameDto.setId(videogameSaved.getId());
        newVideogameDto.setTitle(videogameSaved.getTitle());
        newVideogameDto.setSoftwareHouse(videogameSaved.getSoftwareHouse());
        newVideogameDto.setPublisher(videogameSaved.getPublisher());
        newVideogameDto.setDateOfRelease(videogameSaved.getDateOfRelease());
        newVideogameDto.setGenre(videogameSaved.getGenre());
        newVideogameDto.setPegi(videogameSaved.getPegi());
        newVideogameDto.setPlatform(videogameSaved.getPlatform());

        return Optional.of(newVideogameDto);
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

