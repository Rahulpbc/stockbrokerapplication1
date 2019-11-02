package com.example.stockbroker.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface addUser extends MongoRepository<user,String> {
}
