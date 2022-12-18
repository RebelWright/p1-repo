package com.revature.models;

//dto is a data transfer object. meant to model some data that doesn't match a db table
//we don't have a username/password table
//we need a class that can hold the user inputted username and password that user enters
//will get stored in a login dto object
//you never store a dto in the database. strictly for data transfer for frontend to backend
//Two main use cases: 1-when you don't want to send or use an entire object(just need username/password to login)
//2- we you don't intend to store incoming data in the database. just for java logic
//variables that will hold first_name,last_name(should be username/password in our p1)
public class LoginDTO {
    private String ers_username;
    private String ers_password;

    public LoginDTO(String ers_username, String ers_password) {
        this.ers_username = ers_username;
        this.ers_password = ers_password;
    }

    public String getErs_username() {
        return ers_username;
    }

    public void setErs_username(String ers_username) {
        this.ers_username = ers_username;
    }

    public String getErs_password() {
        return ers_password;
    }

    public void setErs_password(String ers_password) {
        this.ers_password = ers_password;
    }
}
