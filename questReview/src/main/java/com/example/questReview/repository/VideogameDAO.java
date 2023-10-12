package com.example.questReview.repository;

import com.example.questReview.entity.Videogame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideogameDAO extends JpaRepository<Videogame, Long> {
}
