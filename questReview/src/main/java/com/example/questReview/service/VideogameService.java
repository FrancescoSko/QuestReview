package com.example.questReview.service;

import com.example.questReview.entity.Videogame;
import com.example.questReview.repository.VideogameDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideogameService {

    @Autowired
    private VideogameDAO videogameDAO;



    public List<Videogame> getAllVideogames(){
        return videogameDAO.findAll();
    }

    public Optional<Videogame> addVideoGame(Videogame videogame){
        return Optional.of(videogame);
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

