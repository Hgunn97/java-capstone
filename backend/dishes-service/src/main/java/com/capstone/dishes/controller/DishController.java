package com.capstone.dishes.controller;

import com.capstone.dishes.entity.Dish;
import com.capstone.dishes.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dishes")
@CrossOrigin
public class DishController {

    @Autowired
    private DishService dishService;

    @GetMapping("/{dishId}")
    public Dish getDishById(@PathVariable int dishId) {
        return dishService.getDishById(dishId);
    }

    @GetMapping("/byRestaurant/{restaurantId}")
    public List<Dish> getDishesByRestaurant(@PathVariable int restaurantId) {
        return dishService.getDishesByRestaurantId(restaurantId);
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

    @DeleteMapping("/byRestaurant/{restaurantId}")
    public String deleteDishByRestaurant(@PathVariable int restaurantId) {
        return dishService.deleteDishByRestaurant(restaurantId);
    }
}
