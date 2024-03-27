package com.example.BookMyShow.Project.Controllers;

import com.example.BookMyShow.Project.Dtos.UserRequestDto;
import com.example.BookMyShow.Project.Models.UserEntity;
import com.example.BookMyShow.Project.Service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping("/add")
    public String addUser(@RequestBody UserRequestDto userRequestDto){
       return userService.createUser(userRequestDto);
    }
    //find userby name
    //find all users

    @GetMapping("/find-user/{name}")
    public UserEntity findByName(@PathVariable String name){
        return userService.findByName(name);
    }

}
