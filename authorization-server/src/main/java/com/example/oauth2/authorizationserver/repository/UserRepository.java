package com.example.oauth2.authorizationserver.repository;

import com.example.oauth2.authorizationserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {


    User findUserByUsername(String userName);
}
