package com.example.BookMyShow.Project.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="movies")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(nullable = false,unique = true)
    private String movieName;

    private int duration;
    private Date releaseDate;

    // Movie class is parent class of show class
    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL)
    List<ShowEntity> listOfShows;

}
