package com.launchcode.crazyweatherapi.response;

public class CityResponse {
    private String cityName;

    public CityResponse(String cityName, Integer cityId) {
        this.cityName = cityName;
        this.cityId = cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    private Integer cityId;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getCityId() {
        return cityId;
    }


}
