package com.xtremax.mainapp.service;

import com.xtremax.mainapp.model.FoodType;
import com.xtremax.mainapp.repository.FoodTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodTypeServiceImpl implements FoodTypeService{

  @Autowired
  private FoodTypeRepository foodTypeRepository;

  @Override
  public List<FoodType> getAllFoodType() {
    return foodTypeRepository.findAll();
  }

  @Override
  public Optional<FoodType> getById(Long id) {
    Optional<FoodType> result = foodTypeRepository.findById(id);
    return result;
  }

  @Override
  public boolean saveFoodType(FoodType foodType) {
    FoodType result = foodTypeRepository.save(foodType);
    return result != null;
  }
}
