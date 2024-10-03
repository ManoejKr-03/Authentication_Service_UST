package com.example.authentication_service.service;

import java.util.Optional;

import com.example.authentication_service.dao.UserCredentialsDao;
import com.example.authentication_service.entity.UserCredentialsEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserCredentialsDao userCredentialsDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Optional<UserCredentialsEntity>fetchedUserCredentails = userCredentialsDao.findByName(username);

        
        // return fetchedUserCredentails.map((info) -> new CustomUserDetails(info.getName(),info.getPassword(),info.getRoles()))
        return fetchedUserCredentails.map((info) -> new CustomUserDetails(info.getName(),info.getPassword(),info.getRoles()))
        .orElseThrow(()->new UsernameNotFoundException("Username/password not valid!"));

    }

    
}
