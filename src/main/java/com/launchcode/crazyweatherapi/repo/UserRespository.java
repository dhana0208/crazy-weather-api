package com.launchcode.crazyweatherapi.repo;


import com.launchcode.crazyweatherapi.entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface UserRespository extends JpaRepository<UserEntity,Integer>


{

    Optional<UserEntity> findOneByEmailAndPassword(String email, String password);
    UserEntity findByEmail(String email);

    UserEntity findByEmailOrUserName(String email,String userName);



}
