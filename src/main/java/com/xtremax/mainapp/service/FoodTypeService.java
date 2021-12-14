package com.xtremax.mainapp.service;

import com.xtremax.mainapp.model.FoodType;

import java.util.List;
import java.util.Optional;

public interface FoodTypeService {
  List<FoodType> getAllFoodType();
  Optional<FoodType> getById(Long id);
  boolean saveFoodType(FoodType foodType);
}
