package com.example.stockbroker.controller;

import com.example.stockbroker.dao.addUser;
import com.example.stockbroker.dao.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class userController {

    @Autowired
    addUser newUser;

    @RequestMapping(value="signUp",method = RequestMethod.POST)
    public Boolean addUser(@RequestBody user person){
       /* try
        {
            List<user> users = newUser.findUsersByUsername(person.getUsername());
            if (users.contains(person.getUsername()) ){
            return "error";
        }
            else
                newUser.insert(person);
        }*/

       String uname=person.getUsername();
       String pass=person.getPassword();
        if(uname.equals("saahith")&&pass.equals("1234")) {
            return true;
        }
        else {
            return false;
        }
    }
}
