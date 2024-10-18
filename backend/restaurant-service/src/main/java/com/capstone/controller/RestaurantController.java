package com.capstone.controller;

import com.capstone.entity.Restaurant;
import com.capstone.service.RestaurantService;
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

    @GetMapping("/byId")
    public Restaurant getRestaurantByName(@RequestParam int Id) {
        return restaurantService.findRestaurant(Id);
    }

    @PostMapping
    public String addRestaurant(Restaurant restaurant) {
        return restaurantService.addRestaurant(restaurant);
    }

    @PutMapping
    public String updateRestaurant(Restaurant restaurant) {
        return restaurantService.updateRestaurant(restaurant);
    }

    @DeleteMapping
    public String deleteRestaurant(@RequestParam int Id){
        return restaurantService.deleteRestaurant(Id);
    }
}
