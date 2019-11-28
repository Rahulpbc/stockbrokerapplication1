package com.example.stockbroker.controller;

import com.example.stockbroker.dao.userRepository;
import com.example.stockbroker.dao.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/")
public class userController {

    @Autowired
    private userRepository newUser;

    @RequestMapping(value="signUp",method = RequestMethod.POST,produces = {"application/json"})
    public HashMap<String,String> addUser(@RequestBody user newUserRegistration) {
        HashMap<String, String> map = new HashMap<>();
        List<user> existingUsers = newUser.findUsersByEmail(newUserRegistration.getEmail());
        if (existingUsers == null || existingUsers.size() == 0) {
            newUser.save(newUserRegistration);
            map.put("token",newUserRegistration.getEmail());
            map.put("error","");
        } else {
            map.put("token","");
            map.put("error" , "User Already Exists/Failed");

        }
        return map;
    }
}
