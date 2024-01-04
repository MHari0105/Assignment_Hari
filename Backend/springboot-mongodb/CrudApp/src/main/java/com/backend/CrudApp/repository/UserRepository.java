package com.backend.CrudApp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.backend.CrudApp.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {
    
}
