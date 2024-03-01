package com.launchcode.crazyweatherapi.service.impl;

import com.launchcode.crazyweatherapi.dto.LoginDTO;
import com.launchcode.crazyweatherapi.dto.UserCityDTO;
import com.launchcode.crazyweatherapi.dto.UserDTO;
import com.launchcode.crazyweatherapi.entity.CityEntity;
import com.launchcode.crazyweatherapi.entity.UserEntity;
import com.launchcode.crazyweatherapi.repo.UserCityRepository;
import com.launchcode.crazyweatherapi.repo.UserRespository;
import com.launchcode.crazyweatherapi.response.CityResponse;
import com.launchcode.crazyweatherapi.response.LoginResponse;
import com.launchcode.crazyweatherapi.response.UserCreationResponse;
import com.launchcode.crazyweatherapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
@Autowired
private UserRespository userRepo;

    @Autowired
    private UserCityRepository cityRepo;
@Autowired
private PasswordEncoder passwordEncoder;

    @Override
    public UserCreationResponse addUser(UserDTO userDTO) {

      UserEntity userObj =  userRepo.findByEmailOrUserName(userDTO.getEmail(),userDTO.getUserName());
      if(userObj!=null){
          UserCreationResponse userCreationResponse = new UserCreationResponse();
          userCreationResponse.setStatus(false);
          userCreationResponse.setMessage("User already exists with this email");
          return userCreationResponse;
      }


     UserEntity userEntity = new UserEntity(

             userDTO.getUserId(),
             userDTO.getUserName(),
             userDTO.getEmail(),
             this.passwordEncoder.encode(userDTO.getPassword())

     );

       UserEntity user =  userRepo.save(userEntity);
       UserCreationResponse userCreationResponse = new UserCreationResponse();
       userCreationResponse.setUserName(user.getUsername());
       userCreationResponse.setUserId(user.getUserId());
       userCreationResponse.setStatus(true);
       userCreationResponse.setMessage("successfully created user");
       return userCreationResponse;

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
                Optional<UserEntity> user = userRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (user.isPresent()) {
                    return new LoginResponse("Login Success", true,user.get().getUsername(),user.get().getUserId());
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

    @Override
    public UserEntity saveCities(UserCityDTO userCityDTO, String userId) {

              Optional<UserEntity> userEntity =  userRepo.findById(Integer.valueOf(userId));

     List<CityEntity> cityEntities =   userCityDTO.getCities().stream().map(it->{
            CityEntity city = new CityEntity();
            city.setUserCityName(it);
            city.setUser(userEntity.get());
            return city;
        }).collect(Collectors.toList());
              if(userEntity.isPresent()){
                  userEntity.get().setUserCities(cityEntities);
                 return  userRepo.save(userEntity.get());
              }

              return null;
    }

    @Override
    public List<CityResponse> getCities(String userId) {
     List<CityEntity> cityEntities =  cityRepo.getAllByUserId(Integer.valueOf(userId));

     return cityEntities.stream().map(cityEntity -> {
         return new CityResponse(cityEntity.getUserCityName(), cityEntity.getUserCityId());
     }).toList();

    }

    @Override
    public void deleteCityOfAUser(String userId, String cityName) {

    }


}

