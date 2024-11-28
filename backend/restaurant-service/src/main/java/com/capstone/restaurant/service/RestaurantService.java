package com.capstone.restaurant.service;

import com.capstone.restaurant.entity.Restaurant;
import com.capstone.restaurant.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    RestTemplate restTemplate;

    private static final String DISH_SERVICE_URL = "http://localhost:9092/dishes";

    private void deleteDishesByRestaurantId(int restaurantId) {
        String url = DISH_SERVICE_URL + "/byRestaurant/" + restaurantId;
        restTemplate.delete(url);
    }

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
            restaurantRepository.save(updatedRestaurant);

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
            deleteDishesByRestaurantId(restaurantId);
            return "Restaurant deleted successfully";
        }
        else {
            return "Restaurant not found";
        }
    }
}
