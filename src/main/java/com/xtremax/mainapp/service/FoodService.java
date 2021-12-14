package com.xtremax.mainapp.service;

import com.xtremax.mainapp.model.Food;

import java.util.List;
import java.util.Optional;

public interface FoodService {
  List<Food> getAllFood();
  Optional<Food> getById(Long id);
  Food saveFood(Food food);
}
