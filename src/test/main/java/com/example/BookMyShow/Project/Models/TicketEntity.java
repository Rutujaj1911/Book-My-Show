package com.example.BookMyShow.Project.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="tickets")
@Data
@NoArgsConstructor
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String alloted_Seats;
    private int amount;
    private Date bookedAt;


    // User class is the parent class of Ticket
    @ManyToOne
    @JoinColumn
    private UserEntity user;



    // show is the parent class of ticket
    @ManyToOne
    @JoinColumn
    private ShowEntity show;



    //ticket class is parent class of showseat class
    @OneToMany(mappedBy = "ticket",cascade = CascadeType.ALL)
    List<ShowSeatEntity> bookedSeats;



}
