package com.example.stockbroker.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface addUser extends MongoRepository<user,String> {

    List<user> findUsersByUsername(String username);

}
