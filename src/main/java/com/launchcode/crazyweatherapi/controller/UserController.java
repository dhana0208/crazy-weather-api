package com.launchcode.crazyweatherapi.controller;

import com.launchcode.crazyweatherapi.dto.LoginDTO;
import com.launchcode.crazyweatherapi.dto.UserDTO;
import com.launchcode.crazyweatherapi.response.LoginResponse;
import com.launchcode.crazyweatherapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")




public class UserController {
@Autowired
private UserService userService;


    @PostMapping
    public String saveUser(@RequestBody UserDTO userDTO){

        String id = userService.addUser(userDTO);

        return id;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO)
    {
        LoginResponse loginResponse = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }







}
