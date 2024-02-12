package com.launchcode.crazyweatherapi.service.impl;

import com.launchcode.crazyweatherapi.dto.LoginDTO;
import com.launchcode.crazyweatherapi.dto.UserDTO;
import com.launchcode.crazyweatherapi.entity.UserEntity;
import com.launchcode.crazyweatherapi.repo.UserRespository;
import com.launchcode.crazyweatherapi.response.LoginResponse;
import com.launchcode.crazyweatherapi.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
@Autowired
private UserRespository userRepo;
@Autowired
private PasswordEncoder passwordEncoder;

    @Override
    public String addUser(UserDTO userDTO) {

     UserEntity userEntity = new UserEntity(

             userDTO.getUserId(),
             userDTO.getUserName(),
             userDTO.getEmail(),
             this.passwordEncoder.encode(userDTO.getPassword())


     );

        userRepo.save(userEntity);
        return userEntity.getUsername();






    }

    @Override
    public LoginResponse loginUser(LoginDTO loginDTO) {

        String msg = "";
        UserEntity userEntity1 = userRepo.findByEmail(loginDTO.getEmail());
        if (userEntity1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = userEntity1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<UserEntity> employee = userRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (employee.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                return new LoginResponse("password Not Match", false);
            }
        }else {
            return new LoginResponse("Email not exits", false);
        }
    }
}

