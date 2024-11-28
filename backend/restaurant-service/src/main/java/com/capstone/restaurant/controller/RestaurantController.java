package com.capstone.restaurant.controller;

import com.capstone.restaurant.entity.Restaurant;
import com.capstone.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("restaurant")
@CrossOrigin
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping
    public List<Restaurant> getRestaurants() {
        return restaurantService.getRestaurants();
    }

    @GetMapping("/{restaurantId}")
    public Restaurant getRestaurantById(@PathVariable int restaurantId) {
        return restaurantService.findRestaurant(restaurantId);
    }

    @PostMapping
    public String addRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.addRestaurant(restaurant);
    }

    @PutMapping
    public String updateRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.updateRestaurant(restaurant);
    }

    @DeleteMapping("/{restaurantId}")
    public String deleteRestaurant(@PathVariable int restaurantId){
        return restaurantService.deleteRestaurant(restaurantId);
    }
}
