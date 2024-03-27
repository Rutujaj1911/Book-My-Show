package com.example.BookMyShow.Project.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="theater")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class TheaterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String city;
    private String address;



    // Theater class is parent class of show
    @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)
    List<ShowEntity> listOfShows;



    // Theater class is parent class of Theaterseats
    @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)
    List<TheaterSeatEntity> theaterSeatEntityList;

}
