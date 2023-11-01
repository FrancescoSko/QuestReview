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
    @Autowired
    private VideogameDAO videogameDAO;



    //METODO SELECT
    public List<Videogame> getVideogame() {
        return videogameDAO.findAll();
    }


    //METODO INSERT
<<<<<<< HEAD
    public Optional<Videogame> AddVideogame(Videogame videogame) {
        Optional<Videogame> opt = Optional.of(videogame);
        return Optional.of(videogameDAO.save(videogame));
=======
    public Videogame addVideogame(Videogame videogame) {
        return videogameDAO.save(videogame);
>>>>>>> f637344111ae3b81db91d2d1f1351dd9930f582f
    }


    //METODO DELETE
    public void deleteVideogameById(Long id) {
        videogameDAO.deleteById(id);
    }


    public Videogame editVideogame(Long id, Videogame videogameUpdated) {
        if (videogameDAO.existsById(id)) {
            videogameUpdated.setId(id);
            return videogameDAO.save(videogameUpdated);

        }else{
            throw new IllegalArgumentException("Videogame not found for this id: " + id);
        }

    }


}
