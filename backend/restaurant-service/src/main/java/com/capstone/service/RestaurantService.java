package com.capstone.service;

import com.capstone.entity.Restaurant;
import com.capstone.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    public List<Restaurant> getRestaurants() {
        List<Restaurant> restaurants = new ArrayList<>();

        var results = restaurantRepository.findAll();

        if(results.isEmpty()){
            return restaurants;
        }else{
            return results;
        }
    }

    public Restaurant findRestaurant(int restaurantId) {
        Optional<Restaurant> results = restaurantRepository.findById(restaurantId);

        return results.orElse(null);
    }

    public String addRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
        return "Restaurant added successfully";
    }

    public String updateRestaurant(Restaurant restaurant) {
        Optional<Restaurant> results = restaurantRepository.findById(restaurant.getRestaurantId());
        if(results.isPresent()){
            var updatedRestaurant = results.get();
            updatedRestaurant.setRestaurantName(restaurant.getRestaurantName());
            updatedRestaurant.setMenuItems(restaurant.getMenuItems());
            restaurantRepository.save(results.get());
            return "Restaurant updated successfully";
        }
        else {
            return "Restaurant not found";
        }
    }

    public String deleteRestaurant(int restaurantId){
        Optional<Restaurant> results = restaurantRepository.findById(restaurantId);
        if(results.isPresent()){
            restaurantRepository.delete(results.get());
            return "Restaurant deleted successfully";
        }
        else {
            return "Restaurant not found";
        }
    }
}
