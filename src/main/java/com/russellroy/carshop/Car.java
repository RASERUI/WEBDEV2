package com.russellroy.carshop;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carId")
    private Integer carId;

    @NotBlank(message = "License Plate Number is required.")
    @Size(max = 50, message = "License Plate Number can't exceed 50 characters.")
    @Column(name = "license_plate_number", nullable = false, unique = true)
    private String licensePlateNumber;

    @NotBlank(message = "Make is required.")
    @Size(max = 50, message = "Make can't exceed 50 characters.")
    @Column(name = "make", nullable = false)
    private String make;

    @NotBlank(message = "Model is required.")
    @Size(max = 50, message = "Model can't exceed 50 characters.")
    @Column(name = "model", nullable = false)
    private String model;

    @NotNull(message = "Year is required.")
    @Min(value = 1886, message = "Year must be valid.")
    @Column(name = "year", nullable = false)
    private Integer year;

    @NotBlank(message = "Color is required.")
    @Size(max = 20, message = "Color can't exceed 20 characters.")
    @Column(name = "color", nullable = false)
    private String color;

    @NotBlank(message = "Body Type is required.")
    @Size(max = 20, message = "Body Type can't exceed 20 characters.")
    @Column(name = "body_type", nullable = false)
    private String bodyType;

    @NotBlank(message = "Engine Type is required.")
    @Size(max = 20, message = "Engine Type can't exceed 20 characters.")
    @Column(name = "engine_type", nullable = false)
    private String engineType;

    @NotBlank(message = "Transmission is required.")
    @Size(max = 20, message = "Transmission can't exceed 20 characters.")
    @Column(name = "transmission", nullable = false)
    private String transmission;

    // Getters and Setters

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    @Override
    public String toString() {
        return "Car [carId=" + carId +
                ", licensePlateNumber=" + licensePlateNumber +
                ", make=" + make +
                ", model=" + model +
                ", year=" + year +
                ", color=" + color +
                ", bodyType=" + bodyType +
                ", engineType=" + engineType +
                ", transmission=" + transmission + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Car)) return false;
        Car car = (Car) obj;
        return carId != null && carId.equals(car.carId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
