package com.example.BookMyShow.Project.Repository;

import com.example.BookMyShow.Project.Models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    UserEntity findByName(String name);
}
