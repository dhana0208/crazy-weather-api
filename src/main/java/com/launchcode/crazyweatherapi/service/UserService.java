package com.launchcode.crazyweatherapi.service;

import com.launchcode.crazyweatherapi.dto.LoginDTO;
import com.launchcode.crazyweatherapi.dto.UserCityDTO;
import com.launchcode.crazyweatherapi.dto.UserDTO;
import com.launchcode.crazyweatherapi.entity.UserEntity;
import com.launchcode.crazyweatherapi.response.CityResponse;
import com.launchcode.crazyweatherapi.response.LoginResponse;
import com.launchcode.crazyweatherapi.response.UserCreationResponse;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
     UserCreationResponse addUser(UserDTO userDTO);

     LoginResponse loginUser(LoginDTO loginDTO);

     UserEntity saveCities(UserCityDTO userCityDTO, String userId);

     List<CityResponse> getCities(String userId);

     void deleteCityOfAUser(String userId, String cityName);
}
