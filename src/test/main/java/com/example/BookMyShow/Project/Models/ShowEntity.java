package com.example.BookMyShow.Project.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="shows")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private LocalDate showDate;
    private LocalTime showTime;
    private double multiplier;


    @CreationTimestamp
    private Date createOn;

    @UpdateTimestamp
    private Date updateOn;


    // show class is the parent class of ticket class
    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    private List<TicketEntity> listOfTickets;


    // show class is the parent class of showseat class
    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    private List<ShowSeatEntity> listOfSeats;


    // Movie class is parent class of show
    @ManyToOne
    @JoinColumn
    private MovieEntity movie;


    // Theater class is parent class of show
    @ManyToOne
    @JoinColumn
    private TheaterEntity theater;



}
