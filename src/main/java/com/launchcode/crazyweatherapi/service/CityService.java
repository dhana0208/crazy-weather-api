package com.launchcode.crazyweatherapi.service;


import org.springframework.stereotype.Service;

@Service
public interface CityService {
    void deleteCityByCityId(String cityId);
}
