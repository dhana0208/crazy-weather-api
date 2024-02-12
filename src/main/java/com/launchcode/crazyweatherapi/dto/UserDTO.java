package com.launchcode.crazyweatherapi.dto;

public class UserDTO {


    private int userId;
    private String userName;
    private String email;
    private String password;

    public UserDTO(int userid, String username, String email, String password) {
        this.userId = userid;
        this.userName = username;
        this.email = email;
        this.password = password;
    }

    public UserDTO() {
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
        return "UserDTO{" +
                "userid=" + userId +
                ", username='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
