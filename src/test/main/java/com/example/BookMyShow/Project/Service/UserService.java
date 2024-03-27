package com.example.BookMyShow.Project.Service;

import com.example.BookMyShow.Project.Dtos.UserRequestDto;
import com.example.BookMyShow.Project.Models.UserEntity;
import com.example.BookMyShow.Project.Repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public String createUser(UserRequestDto userRequestDto){
        UserEntity userEntity=UserEntity.builder().name(userRequestDto.getName()).mobile(userRequestDto.getMobile()).build();
        try{
            userRepository.save(userEntity);
        }
        catch (Exception e){
            return "User couldnt be added";
        }
        return "User added successfully";
    }

    public UserEntity findByName(String name){
        return userRepository.findByName(name);
    }
}
