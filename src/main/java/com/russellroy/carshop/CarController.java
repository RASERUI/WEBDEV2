package com.russellroy.carshop;

import com.russellroy.carshop.exception.CarNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    // Display the list of cars
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("cars", carService.getAll());
        return "index"; // normal view mode
    }

    // Display the form to add a new car
    @GetMapping("/new")
    public String newCar(Model model) {
        model.addAttribute("car", new Car());
        return "form";
    }

    @PostMapping("/save")
    public String saveCar(@Valid @ModelAttribute Car car, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        carService.save(car);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable("id") Integer id) {
        carService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public String viewCar(@PathVariable("id") Integer id, Model model) {
        Car car = carService.getById(id);
        if (car == null) {
            throw new CarNotFoundException(id);
        }
        model.addAttribute("car", car);
        return "view";
    }

    @GetMapping("/editmode")
    public String editMode(Model model) {
        model.addAttribute("cars", carService.getAll());
        return "index-edit";
    }

    // Display the form to edit an existing car
    @GetMapping("/edit/{id}")
    public String editCar(@PathVariable("id") Integer id, Model model) {
        Car car = carService.getById(id);
        if (car == null) {
            throw new CarNotFoundException(id); // Throw exception if car is not found
        }
        model.addAttribute("car", car);
        return "form"; // Reuse form.html for editing
    }
}
