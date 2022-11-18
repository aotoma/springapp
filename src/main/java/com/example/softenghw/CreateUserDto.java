package com.example.softenghw;

public class CreateUserDto {
    private String UserName;
    private String Country;

    public CreateUserDto(){

    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }
}
