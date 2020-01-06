package com.example.demo.service;

import com.example.demo.datasource.UserDataAccess;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserDataAccess userDataAccess;

    @Autowired
    public UserService(UserDataAccess userDataAccess){
        this.userDataAccess = userDataAccess;
    }

    public List<User> getAllUsers(){
        return userDataAccess.selectAllUsers();
    }

    public int addUser(User user){
        return userDataAccess.insert(user);
    }
}
