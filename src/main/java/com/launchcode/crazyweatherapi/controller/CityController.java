package com.launchcode.crazyweatherapi.controller;

import com.launchcode.crazyweatherapi.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/cities")
public class CityController {
    @Autowired
    private CityService cityService;
    @DeleteMapping(path = "/{cityId}")
    public void deleteCityByUserId(@PathVariable String cityId) {
        cityService.deleteCityByCityId(cityId);
    }
}
