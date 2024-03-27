package com.example.BookMyShow.Project.Service;

import com.example.BookMyShow.Project.Dtos.MovieRequestDto;
import com.example.BookMyShow.Project.Models.MovieEntity;
import com.example.BookMyShow.Project.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public String addMovie(MovieRequestDto movieRequestDto){
        // convert dto to entity to save in the database
        MovieEntity movieEntity=MovieEntity.builder().movieName(movieRequestDto.getMovieName()).releaseDate(movieRequestDto.getReleaseDate()).duration(movieRequestDto.getDuration()).build();
        movieRepository.save(movieEntity);
        return "Movie added successfully";
    }
}
