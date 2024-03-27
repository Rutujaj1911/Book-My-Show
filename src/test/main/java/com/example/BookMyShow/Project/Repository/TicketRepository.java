package com.example.BookMyShow.Project.Repository;

import com.example.BookMyShow.Project.Models.TicketEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketEntity, Integer> {

}
