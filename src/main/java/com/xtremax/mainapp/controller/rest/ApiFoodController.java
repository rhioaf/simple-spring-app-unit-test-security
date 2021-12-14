package com.xtremax.mainapp.controller.rest;

import com.xtremax.mainapp.errorresponse.NotFound;
import com.xtremax.mainapp.model.Food;
import com.xtremax.mainapp.model.FoodType;
import com.xtremax.mainapp.service.FoodService;
import com.xtremax.mainapp.service.FoodTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/food")
public class ApiFoodController {

  @Autowired
  private FoodService foodService;

  @Autowired
  private FoodTypeService foodTypeService;

  @GetMapping
  public ResponseEntity<List<Food>> getAllFood() {
    List<Food> result = foodService.getAllFood();
    return ResponseEntity.ok(result);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getFoodById(@PathVariable Long id) {
    Optional<Food> optionalFood = foodService.getById(id);
    if(!optionalFood.isPresent()) return new ResponseEntity<>(new NotFound("Couldn't find food!."), HttpStatus.NOT_FOUND);
    return ResponseEntity.ok(optionalFood.get());
  }

  @PostMapping
  public ResponseEntity<?> createFood(@RequestBody Food food) {
    Optional<FoodType> optionalFoodType = foodTypeService.getById(food.getFoodType().getFoodTypeId());
    if(!optionalFoodType.isPresent()) {
      return new ResponseEntity<>(new NotFound("Couldn't find food type!."), HttpStatus.NOT_FOUND);
    }

    food.setFoodType(optionalFoodType.get());
    Food newFood = foodService.saveFood(food);
    return ResponseEntity.ok(newFood);
  }
}
