package com.russellroy.carshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("cars", carService.getAll());
        return "index"; // index.html
    }

    @GetMapping("/new")
    public String newCar(Model model) {
        model.addAttribute("car", new Car());
        return "form"; // your form.html
    }

    @PostMapping("/save")
    public String saveCar(@ModelAttribute Car car) {
        carService.save(car);
        return "redirect:/";
    }
}
