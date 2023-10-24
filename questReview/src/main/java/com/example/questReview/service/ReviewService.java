package com.example.questReview.service;

import com.example.questReview.entity.Review;
import com.example.questReview.entity.Videogame;
import com.example.questReview.repository.ReviewDAO;
import com.example.questReview.repository.VideogameDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    private VideogameDAO videogameDAO;

    @Autowired
    public ReviewService(VideogameDAO videogameDAO) {
        this.videogameDAO = videogameDAO;
    }
    //SELECT
    public List<Videogame> getVideogame() {
        return videogameDAO.findAll();
    }
    //METODO INSERT
    public Videogame AddVideogame(Videogame videogame) {
        return videogameDAO.save(videogame);
    }

    //Metodo DELETE
    public void eliminaVideoGamePerId(Long id) {
        videogameDAO.deleteById(id);
    }

    public Videogame editVideogame(Long id, Videogame videogameup) {
        if (videogameDAO.existsById(id)) {
            videogameup.setId(id);
            return videogameDAO.save(videogameup);

        }else{
            throw new IllegalArgumentException("id del VideoGame da modificare non Trovato");
        }

    }


}
