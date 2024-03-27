package com.example.BookMyShow.Project.Repository;

import com.example.BookMyShow.Project.Models.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieEntity,Integer> {
    MovieEntity findByMovieName(String movieName);
}
