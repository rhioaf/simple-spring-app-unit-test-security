package com.xtremax.mainapp.service;

import com.xtremax.mainapp.model.Food;
import com.xtremax.mainapp.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodServiceImpl implements FoodService{

  @Autowired
  private FoodRepository foodRepository;

  @Override
  public List<Food> getAllFood() {
    return foodRepository.findAll();
  }

  @Override
  public Optional<Food> getById(Long id) {
    return foodRepository.findById(id);
  }

  @Override
  public Food saveFood(Food food) {
    Food newFood = foodRepository.save(food);
    return newFood;
  }
}
