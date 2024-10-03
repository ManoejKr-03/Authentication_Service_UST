package com.example.authentication_service.service;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.example.authentication_service.entity.Roles;
import com.example.authentication_service.entity.UserCredentialsEntity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class CustomUserDetails implements UserDetails {

    private String name;
    private String password;
    private List<SimpleGrantedAuthority> allrole;

    public CustomUserDetails(String name,String password,List<Roles>allrole ) {
        super();
    this.name = name;
    this.password = password;
   this.allrole = allrole.stream().map((role)-> new SimpleGrantedAuthority(role.getRoleName())).toList();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    // return this.allrole;
    return null;
    }
    
    @Override
    public String getPassword() {
    return password;
    }
    
    @Override
    public String getUsername() {
    return name;
    }

    
    }
    