package com.russellroy.carshop.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CarNotFoundException.class)
    public String handleCarNotFound(CarNotFoundException ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        return "error/error";  // Return a custom error page
    }

    @ExceptionHandler(Exception.class)
    public String handleGenericException(Exception ex, Model model) {
        model.addAttribute("message", "An unexpected error occurred: " + ex.getMessage());
        return "error/error";
    }
}
