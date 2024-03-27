package com.example.BookMyShow.Project.Models;

import com.example.BookMyShow.Project.Enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="theater_seats")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TheaterSeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private int rate;


    public TheaterSeatEntity(String seatNo,SeatType seatType,int rate){
        this.seatNo=seatNo;
        this.seatType=seatType;
        this.rate=rate;
    }

    // Theater class is parent class of Theaterseats
    @ManyToOne
    @JoinColumn
    private TheaterEntity theater;

}
