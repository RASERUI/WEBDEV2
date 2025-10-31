package com.russellroy.carshop.repository;

import com.russellroy.carshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // This method will automatically generate the query to check if a user exists by username
    boolean existsByUsername(String username);

    // Optional: You can also define a method to find a user by username if needed
    Optional<User> findByUsername(String username);
}
