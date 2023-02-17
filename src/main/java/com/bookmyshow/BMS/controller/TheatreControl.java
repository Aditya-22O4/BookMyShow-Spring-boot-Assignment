package com.bookmyshow.BMS.controller;

import com.bookmyshow.BMS.model.User;
import com.bookmyshow.BMS.services.MovieServices;
import com.bookmyshow.BMS.services.MovieServicesImp;
import com.bookmyshow.BMS.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieControl {
    @Autowired
    private MovieServices movieServices;

    @GetMapping("/Movieuser/{movieid}")
    private Movie (@PathVariable long userid){
        return this.userService.getUserById(userid);
    }

    @GetMapping("/users")
    private ResponseEntity<List<User>> getAllUser(){
        return ResponseEntity.ok().body(this.userService.getAllUser());
    }

    @PostMapping("/addUser")
    private ResponseEntity<User> saveProduct(@RequestBody User user){
        return ResponseEntity.ok().body(this.userService.createUser(user));
    }

    @PutMapping("/updateUser/{userid}")
    private ResponseEntity<User> updateUser(@PathVariable long userid, @RequestBody User user){
        user.setUserId(userid);
        return ResponseEntity.ok().body(this.userService.updateUser(user));
    }

