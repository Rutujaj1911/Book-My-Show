package com.example.BookMyShow.Project.Service;

import com.example.BookMyShow.Project.Dtos.ShowRequestDto;
import com.example.BookMyShow.Project.Models.*;
import com.example.BookMyShow.Project.Repository.MovieRepository;
import com.example.BookMyShow.Project.Repository.ShowRepository;
import com.example.BookMyShow.Project.Repository.ShowSeatRepository;
import com.example.BookMyShow.Project.Repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    TheaterRepository theaterRepository;
    @Autowired
    ShowSeatRepository showSeatRepository;
    @Autowired
    ShowRepository showRepository;
    public String addShow(ShowRequestDto showRequestDto){

        ShowEntity showEntity=ShowEntity.builder().showDate(showRequestDto.getShowDate()).showTime(showRequestDto.getShowTime()).multiplier(showRequestDto.getMultiplier()).build();


//        need to get the movie Repository
        MovieEntity moiveEntity=movieRepository.findByMovieName(showRequestDto.getMovieName());
////        need to get the theater Repository
        TheaterEntity theaterEntity= theaterRepository.findById(showRequestDto.getTheaterId()).get();
        showEntity.setMovie(moiveEntity);
        showEntity.setTheater(theaterEntity);
//        beacause we are doing bidirectional mapping
        moiveEntity.getListOfShows().add(showEntity);
        theaterEntity.getListOfShows().add(showEntity);

        List<ShowSeatEntity> seatEntityList=createShowSeats(theaterEntity.getTheaterSeatEntityList());
        showEntity.setListOfSeats(seatEntityList);
//      for each show seats we can mark which show it belongs to
        for(ShowSeatEntity showSeat:seatEntityList){
            showSeat.setShow(showEntity);
        }

        movieRepository.save(moiveEntity);
        theaterRepository.save(theaterEntity);
//      showRepository.save(showEntity); this does not need to call beacause  parent save function is called
        return "show added successfully";
    }
    public List<ShowSeatEntity> createShowSeats(List<TheaterSeatEntity> theaterSeatEntityList){
        List<ShowSeatEntity> seats=new ArrayList<>();

        for(TheaterSeatEntity theaterSeat:theaterSeatEntityList){
            ShowSeatEntity showSeat=ShowSeatEntity.builder().seatNo(theaterSeat.getSeatNo()).seatType(theaterSeat.getSeatType()).build();
            seats.add(showSeat);
        }
        showSeatRepository.saveAll(seats);
        return seats;
    }

}
