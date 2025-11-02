package com.russellroy.carshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    // No-argument constructor (required by JPA)
    public User() {
    }

    // Parameterized constructor for creating User
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // UserDetails Methods

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Returning an empty list of authorities (can be customized if you have roles/permissions)
        return Collections.emptyList();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Account expiration logic if needed
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Account lock logic if needed
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Credentials expiration logic if needed
    }

    @Override
    public boolean isEnabled() {
        return true; // Logic for enabling/disabling accounts
    }

}
