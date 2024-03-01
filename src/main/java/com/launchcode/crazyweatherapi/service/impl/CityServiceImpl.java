package com.launchcode.crazyweatherapi.service.impl;

import com.launchcode.crazyweatherapi.repo.UserCityRepository;
import com.launchcode.crazyweatherapi.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl  implements CityService {

    @Autowired
    UserCityRepository cityRepository;
    @Override
    public void deleteCityByCityId(String cityId) {
        cityRepository.deleteById(Integer.valueOf(cityId));
    }
}
