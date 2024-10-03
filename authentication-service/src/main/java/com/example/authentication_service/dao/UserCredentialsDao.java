package com.example.authentication_service.dao;

import java.util.Optional;

import com.example.authentication_service.entity.UserCredentialsEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserCredentialsDao extends JpaRepository<UserCredentialsEntity, Integer>{
public Optional<UserCredentialsEntity> findByName(String name);
}

