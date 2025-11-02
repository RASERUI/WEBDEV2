package com.russellroy.carshop.exception;

public class CarNotFoundException extends RuntimeException {

    public CarNotFoundException(Integer id) {
        super("Car with ID " + id + " not found.");
    }
}
