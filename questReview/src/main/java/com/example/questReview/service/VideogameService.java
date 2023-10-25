package com.example.questReview.service;

import com.example.questReview.entity.Videogame;
import com.example.questReview.repository.VideogameDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideogameService {

    private VideogameDAO videogameDAO;

    @Autowired
    public VideogameService(VideogameDAO videogameDAO){
        this.videogameDAO = videogameDAO;
    }

    public Videogame addVideoGame(Videogame videogame){
        return videogameDAO.save(videogame);
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

