package com.xtremax.mainapp.controller.rest;

import com.xtremax.mainapp.errorresponse.NotFound;
import com.xtremax.mainapp.model.FoodType;
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
@RequestMapping("/api/food-type")
public class ApiFoodTypeController {
  // Alright this one is about OneToManyRelationship Bidirectional
  // It means access for both side, in this case Food Type and Food,
  // Food Type can have many Food, and every Food has only one Food Type
  // By adding annotations (OneToMany and ManyToOne) for 2 entities (FoodType and Food)
  // Those annotations tells Spring that :
  // - #1 OneToMany (yo this attribute is a collection of other entity or table)
  // - #2 ManyToOne (yo this attribute indicates that current class has data from other entity or table,
  //      by that means ownership of current class)
  // For easily return data we can use FetchType.EAGER so every request includes 2 data either from FoodType or Food

  @Autowired
  private FoodTypeService foodTypeService;

  @GetMapping
  public ResponseEntity<List<FoodType>> getAllFoodType() {
    List<FoodType> result = foodTypeService.getAllFoodType();
    return new ResponseEntity<List<FoodType>>(result, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getFoodType(@PathVariable Long id) {
    Optional<FoodType> optionalFoodType = foodTypeService.getById(id);
    if(!optionalFoodType.isPresent()) return new ResponseEntity<>(new NotFound("Couldn't find food type!."), HttpStatus.NOT_FOUND);
    return ResponseEntity.ok(optionalFoodType.get());
  }

  @PostMapping
  public boolean createFoodType(@RequestBody FoodType foodType) {
    return foodTypeService.saveFoodType(foodType);
  }
}
