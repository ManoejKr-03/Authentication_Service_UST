package com.example.authentication_service.entity;

import java.util.List;
import java.util.Set;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class UserCredentialsEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String name;
private String email;
private String password;


@ManyToMany(fetch = FetchType.EAGER)
@JoinTable(name="authuser_role",
joinColumns = @JoinColumn(name="authuser_id"),
inverseJoinColumns = @JoinColumn(name="role_id")
) 
private List<Roles> roles; 

 
}
