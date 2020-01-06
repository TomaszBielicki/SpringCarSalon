package com.example.demo.utils;

import com.example.demo.model.User;

public class UserHelper {

    public static Object[] getUser(User user){
        return new Object[]{
                user.getUserID(),
                user.getUserName()};
    }
}
