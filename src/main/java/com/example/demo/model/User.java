package com.example.demo.model;

import java.util.UUID;

public class User {

    private String userName;
    private UUID userID;

    public User (UUID userID, String userName){
        this.userID = userID;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UUID getUserID() {
        return userID;
    }

    public void setUserID(UUID userID) {
        this.userID = userID;
    }
}
