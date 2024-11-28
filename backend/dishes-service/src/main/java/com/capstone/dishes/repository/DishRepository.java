package com.capstone.dishes.repository;

import com.capstone.dishes.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DishRepository extends JpaRepository<Dish, Integer> {
    List<Dish> findByRestaurantId(int restaurantId);
}
