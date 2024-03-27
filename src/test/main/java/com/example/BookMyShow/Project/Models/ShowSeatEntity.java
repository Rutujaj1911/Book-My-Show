package com.example.BookMyShow.Project.Models;
import com.example.BookMyShow.Project.Enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="show_seats")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShowSeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;
    private boolean booked;
    private Date bookedAt;


    //  ticket class is parent class of showseat class
    @ManyToOne
    @JoinColumn
    private TicketEntity ticket;


    // show class is the parent class of showseat class
    @ManyToOne
    @JoinColumn
    private ShowEntity show;
}
