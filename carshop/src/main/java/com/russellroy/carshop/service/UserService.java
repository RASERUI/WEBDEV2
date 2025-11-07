package com.russellroy.carshop.service;

import com.russellroy.carshop.model.User;
import com.russellroy.carshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Check if the username exists
    public boolean usernameExists(String username) {
        return userRepository.existsByUsername(username);
    }

    // Register the user after checking the password
    public void registerUser(User user) {
        // Encrypt the password before saving the user
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);

        // Save the user in the repository
        userRepository.save(user);
    }
}
