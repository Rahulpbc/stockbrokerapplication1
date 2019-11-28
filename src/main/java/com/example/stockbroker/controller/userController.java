package com.example.stockbroker.controller;

import com.example.stockbroker.dao.userRepository;
import com.example.stockbroker.dao.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/")
public class userController {


    @Autowired
    private userRepository newUser;

    @RequestMapping(value = "signUp", method = RequestMethod.POST, produces = {"application/json"})
    public String addUser(@RequestBody user newUserRegistration) {
        try {
            List<user> existingUsers = newUser.findUsersByEmail(newUserRegistration.getEmail());
            if (existingUsers == null || existingUsers.size() == 0) {
                newUser.save(newUserRegistration);
            }
            return "Created new user";
            }
            catch (Exception e)
            {
            return e.toString();
            }
    }
    @RequestMapping(value = "login", method = RequestMethod.POST, produces = {"application/json"})
    public HashMap<String,String> getUser(@RequestBody user findUser) {
            HashMap<String,String> map=new HashMap<String,String>();
            String email=findUser.getEmail();
            String password=findUser.getPassword();
            for(user existingUsers : newUser.findUsersByEmail(findUser.getEmail())) {
                if(email.equals(existingUsers.getEmail()) && password.equals(existingUsers.getPassword())) {
                    map.put("TOKEN", existingUsers.getEmail());
                    map.put("error", "");
                }
                    else
                    {
                        map.put("TOKEN","");
                        map.put("error", "User Not Found/Wrong Password");
                    }
            }
       return map;
    }
}
