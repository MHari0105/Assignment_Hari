package com.mongodb.Crudapp.repository;

import com.mongodb.Crudapp.entity.UserInfo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserInfoRepository extends MongoRepository<UserInfo, Integer> {
    Optional<UserInfo> findByName(String username);

}
