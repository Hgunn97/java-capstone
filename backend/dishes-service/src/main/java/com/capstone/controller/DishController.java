package com.capstone.controller;

import com.capstone.entity.Dish;
import com.capstone.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dishes")
@CrossOrigin
public class DishController {

    @Autowired
    private DishService dishService;

    @GetMapping("/restaurant/{restaurantId}")
    public List<Dish> getDishesByRestaurant(@PathVariable int restaurantId) {
        return dishService.getDishesByRestaurant(restaurantId);
    }

    @PostMapping
    public String addDish(@RequestBody Dish dish) {
        return dishService.addDish(dish);
    }

    @PutMapping
    public String updateDish(@RequestBody Dish dish) {
        return dishService.updateDish(dish);
    }

    @DeleteMapping("/{dishId}")
    public String deleteDish(@PathVariable int dishId) {
        return dishService.deleteDish(dishId);
    }
}
