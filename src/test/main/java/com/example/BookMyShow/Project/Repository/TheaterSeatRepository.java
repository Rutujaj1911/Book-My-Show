package com.example.BookMyShow.Project.Repository;

import com.example.BookMyShow.Project.Models.TheaterSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TheaterSeatRepository extends JpaRepository<TheaterSeatEntity,Integer> {
}
