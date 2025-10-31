package com.russellroy.carshop.controller;

import com.russellroy.carshop.model.User;
import com.russellroy.carshop.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // Check if user is authenticated
    private boolean isAuthenticated() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth != null && auth.isAuthenticated() &&
                !(auth.getPrincipal() instanceof String && auth.getPrincipal().equals("anonymousUser"));
    }

    // Show login page
    @GetMapping("/login")
    public String login() {
        if (isAuthenticated()) {
            return "redirect:/";  // Redirect logged-in users to home
        }
        return "login";  // Show login page to unauthenticated users
    }

    // Show registration page
    @GetMapping("/register")
    public String showRegisterForm(@RequestParam(value = "error", required = false) String error, Model model) {
        if (isAuthenticated()) {
            return "redirect:/";  // Redirect logged-in users to home
        }

        model.addAttribute("user", new User());
        if (error != null) {
            model.addAttribute("error", "Username already exists or passwords don't match.");
        }

        return "register";
    }

    // Handle registration
    @PostMapping("/register")
    public String register(@ModelAttribute User user, @RequestParam("confirmPassword") String confirmPassword) {
        if (userService.usernameExists(user.getUsername())) {
            return "redirect:/register?error";
        }

        if (!user.getPassword().equals(confirmPassword)) {
            return "redirect:/register?error";
        }

        userService.registerUser(user);
        return "redirect:/login";
    }
}
