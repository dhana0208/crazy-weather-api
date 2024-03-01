package com.launchcode.crazyweatherapi.repo;

import com.launchcode.crazyweatherapi.entity.CityEntity;
import com.launchcode.crazyweatherapi.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface UserCityRepository  extends JpaRepository<CityEntity,Integer> {



   @Query("select c from CityEntity  c where c.user.userId=?1")
   List<CityEntity> getAllByUserId(Integer userId);
}
