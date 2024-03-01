package com.launchcode.crazyweatherapi.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "city")

public class CityEntity {

    @Id
    @Column(name="user_city_id",length=45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userCityId;

    @Column(name="user_city_name", length= 255)
    private String userCityName;

    @ManyToOne
    @JoinColumn(name="user_id",nullable = false)
    private UserEntity user;


    public int getUserCityId() {
        return userCityId;
    }

    public void setUserCityId(int userCityId) {
        this.userCityId = userCityId;
    }

    public String getUserCityName() {
        return userCityName;
    }

    public void setUserCityName(String userCityName) {
        this.userCityName = userCityName;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
