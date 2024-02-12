package com.launchcode.crazyweatherapi.service;

import com.launchcode.crazyweatherapi.dto.LoginDTO;
import com.launchcode.crazyweatherapi.dto.UserDTO;
import com.launchcode.crazyweatherapi.response.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
     String addUser(UserDTO userDTO);

     LoginResponse loginUser(LoginDTO loginDTO);
}
