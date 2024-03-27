package com.example.BookMyShow.Project.Service;

import com.example.BookMyShow.Project.Dtos.BookTicketRequestDto;
import com.example.BookMyShow.Project.Models.ShowEntity;
import com.example.BookMyShow.Project.Models.ShowSeatEntity;
import com.example.BookMyShow.Project.Models.TicketEntity;
import com.example.BookMyShow.Project.Models.UserEntity;
import com.example.BookMyShow.Project.Repository.ShowRepository;
import com.example.BookMyShow.Project.Repository.TicketRepository;
import com.example.BookMyShow.Project.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    ShowRepository showRepository;
    @Autowired
    UserRepository userRepository;
    public String bookTicket(BookTicketRequestDto bookTicketRequestDto) throws Exception{
//        Get the requested seats
        List<String> requestedSeats = bookTicketRequestDto.getRequestSeats();

        ShowEntity showEntity=showRepository.findById(bookTicketRequestDto.getShowId()).get();
        UserEntity userEntity=userRepository.findById(bookTicketRequestDto.getUserId()).get();



//      get the showseats from show entity

        List<ShowSeatEntity> showSeats=showEntity.getListOfSeats();

//      Validate if i can allocate these seats to the requested by user

        List<ShowSeatEntity> bookedSeats=new ArrayList<>();

        for(ShowSeatEntity showSeat : showSeats){

            String seatNo=showSeat.getSeatNo();

            if(showSeat.isBooked()==false && requestedSeats.contains(seatNo)){
                  bookedSeats.add(showSeat);
            }
        }

        if(bookedSeats.size()!=requestedSeats.size()){
//            some of the seats that user requested that are not available
            throw new Exception("Requested seats are not available");

        }
//        FAILURE
//        this means the bookedSeats actually contains booked seats
        TicketEntity ticketEntity=new TicketEntity();
        double totalAmount = 0;
        double multipiler=(double) showEntity.getMultiplier();

        String allotedSeats = "";
//        SUCCESS
//        calculating amount
        int rate=0;
        for(ShowSeatEntity bookedSeat:bookedSeats){
            bookedSeat.setBooked(true);
            bookedSeat.setBookedAt(new Date());
            bookedSeat.setTicket(ticketEntity);
            bookedSeat.setShow(showEntity);

            String seatNo=bookedSeat.getSeatNo();

            allotedSeats=allotedSeats+seatNo+",";

            if(seatNo.charAt(0)=='1')
                rate=100;
            else
                rate=200;
            totalAmount=totalAmount+multipiler+rate;

        }
        ticketEntity.setBookedAt(new Date());
        ticketEntity.setAmount((int)totalAmount);
        ticketEntity.setShow(showEntity);
        ticketEntity.setUser(userEntity);
        ticketEntity.setBookedSeats(bookedSeats);
        ticketEntity.setAlloted_Seats(allotedSeats);
//        bidirectional
         ticketRepository.save(ticketEntity);

         return "Successfully created a ticket";
    }
}
