package com.demo.repository;

import com.demo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserRepository extends MongoRepository<User,String> {

    @Query("{username : ?0}")
    public User findUserByUsername(String username);

    @Query("{name : ?0, password : ?1}")
    public User checkUserByUsernamePasswd(String name,String password);

}
