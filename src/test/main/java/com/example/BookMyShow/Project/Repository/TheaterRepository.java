package com.example.BookMyShow.Project.Repository;

import com.example.BookMyShow.Project.Models.TheaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends JpaRepository<TheaterEntity,Integer> {
}
