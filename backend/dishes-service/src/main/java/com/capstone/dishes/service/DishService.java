package com.capstone.dishes.service;

import com.capstone.dishes.entity.Dish;
import com.capstone.dishes.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishService {

    @Autowired
    private DishRepository dishRepository;

    public Dish getDishById(int id) {
        Optional<Dish> dish = dishRepository.findById(id);

        return dish.orElse(null);
    }

    public List<Dish> getDishesByRestaurantId(int restaurantId) {
        return dishRepository.findByRestaurantId(restaurantId);
    }

    public String addDish(Dish dish) {
        dishRepository.save(dish);
        return "Dish added successfully";
    }

    public String updateDish(Dish dish) {
        Optional<Dish> result = dishRepository.findById(dish.getDishId());
        if (result.isPresent()) {
            Dish updatedDish = result.get();
            updatedDish.setDishName(dish.getDishName());
            updatedDish.setCategory(dish.getCategory());
            updatedDish.setDescription(dish.getDescription());
            updatedDish.setPrice(dish.getPrice());
            updatedDish.setRestaurantId(dish.getRestaurantId());
            dishRepository.save(updatedDish);
            return "Dish updated successfully!";
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

    public String deleteDishByRestaurant(int restaurantId) {
        List<Dish> dishes = dishRepository.findByRestaurantId(restaurantId);

        if (dishes.isEmpty()) {
            return "No dishes found";
        }

        dishRepository.deleteAll(dishes);

        return "Dishes deleted successfully";
    }
}
