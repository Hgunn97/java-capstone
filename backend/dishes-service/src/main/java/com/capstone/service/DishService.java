package com.capstone.service;

import com.capstone.entity.Dish;
import com.capstone.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService {

    @Autowired
    private DishRepository dishRepository;

    public List<Dish> getDishesByRestaurant(int restaurantId) {
        return dishRepository.findByRestaurantId(restaurantId);
    }

    public String addDish(Dish dish) {
        dishRepository.save(dish);
        return "Dish added successfully";
    }

    public String updateDish(Dish dish) {
        if (dishRepository.existsById(dish.getDishId())) {
            dishRepository.save(dish);
            return "Dish updated successfully";
        } else {
            return "Dish not found";
        }
    }

    public String deleteDish(int dishId) {
        if (dishRepository.existsById(dishId)) {
            dishRepository.deleteById(dishId);
            return "Dish deleted successfully";
        } else {
            return "Dish not found";
        }
    }
}
