package com.example.BookMyShow.Project.Repository;

import com.example.BookMyShow.Project.Models.ShowSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ShowSeatRepository extends JpaRepository<ShowSeatEntity,Integer>{

}