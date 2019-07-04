package com.example.oauth2.authorizationserver.service;

import com.example.oauth2.authorizationserver.model.User;
import com.example.oauth2.authorizationserver.model.security.UserPrinciple;
import com.example.oauth2.authorizationserver.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Slf4j
@Qualifier("oauth2UserDetails")
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        log.debug("Inside user details service");
        User user = repository.findUserByUsername(userName);
        Optional.ofNullable(user).orElseThrow(() -> new UsernameNotFoundException("User not found, please validate username and password"));
        return UserPrinciple.builder().user(user).build();
    }
}
