package com.launchcode.crazyweatherapi.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="user")
public class UserEntity {

    @Id
    @Column(name="user_id",length=45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @Column(name="user_name", length= 255,unique = true,nullable = false)
    private String userName;

    @Column(name="email",length=255,unique = true,nullable = false)
    private String email;

    @Column (name="password",length=255,nullable = false)
    private String password;


    public List<CityEntity> getUserCities() {
        return userCities;
    }

    public void setUserCities(List<CityEntity> userCities) {
        this.userCities = userCities;
    }

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<CityEntity> userCities;

    public UserEntity(int userId, String username, String email, String password) {
        this.userId = userId;
        this.userName = username;
        this.email = email;
        this.password = password;
    }

    public UserEntity() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
