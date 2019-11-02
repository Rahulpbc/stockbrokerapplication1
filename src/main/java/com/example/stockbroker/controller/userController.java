package com.example.stockbroker.controller;

import com.example.stockbroker.dao.addUser;
import com.example.stockbroker.dao.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class userController {

    @Autowired
    addUser u;
    @RequestMapping(value="addUser",method = RequestMethod.POST)
    public String addUser(@RequestBody user use){
        u.save(use);
        return "sucessful";
    }

}
