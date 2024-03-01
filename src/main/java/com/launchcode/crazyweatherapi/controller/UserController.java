package com.launchcode.crazyweatherapi.controller;

import com.launchcode.crazyweatherapi.dto.LoginDTO;
import com.launchcode.crazyweatherapi.dto.UserCityDTO;
import com.launchcode.crazyweatherapi.dto.UserDTO;
import com.launchcode.crazyweatherapi.entity.UserEntity;
import com.launchcode.crazyweatherapi.response.CityResponse;
import com.launchcode.crazyweatherapi.response.LoginResponse;
import com.launchcode.crazyweatherapi.response.UserCreationResponse;
import com.launchcode.crazyweatherapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping
    public  ResponseEntity<?> saveUser(@RequestBody UserDTO userDTO) {

        UserCreationResponse  userCreationResponse  = userService.addUser(userDTO);

    return ResponseEntity.ok(userCreationResponse);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO) {
        LoginResponse loginResponse = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }


    @PostMapping(path = "/{userId}/cities")
    public UserEntity saveCitiesForDashBoardToUser(@RequestBody UserCityDTO userCityDTO, @PathVariable String userId) {

       return  userService.saveCities(userCityDTO, userId);
    }




    @GetMapping(path = "/{userId}/cities")
    public ResponseEntity<List<CityResponse>> getCitiesForDashBoardToUser(@PathVariable String userId) {

       return  ResponseEntity.ok(userService.getCities(userId));
    }


    @DeleteMapping(path = "/{cityId}")
    public void deleteCityByUserId(@PathVariable String userId, @PathVariable String cityName) {
        userService.deleteCityOfAUser(userId, cityName);
    }

}

