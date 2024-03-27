package com.example.BookMyShow.Project.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="users")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String mobile;

    @CreationTimestamp
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdOn;

    @UpdateTimestamp
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date updatedOn;


   //  user class is the parent class of Ticket
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<TicketEntity> listOfTickets;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
