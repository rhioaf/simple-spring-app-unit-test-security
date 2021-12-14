package com.xtremax.mainapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "food_type")
public class FoodType {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long foodTypeId;

  @Column(name = "food_type_name")
  private String foodTypeName;

  @OneToMany(mappedBy = "foodType", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JsonIgnoreProperties("foodType")
  private Set<Food> foods = new HashSet<>();

  public Long getFoodTypeId() {
    return foodTypeId;
  }

  public void setFoodTypeId(Long foodTypeId) {
    this.foodTypeId = foodTypeId;
  }

  public String getFoodTypeName() {
    return foodTypeName;
  }

  public void setFoodTypeName(String foodTypeName) {
    this.foodTypeName = foodTypeName;
  }

  public Set<Food> getFoods() {
    return foods;
  }

  public void setFoods(Set<Food> foods) {
    this.foods = foods;

    for(Food f : foods) {
      f.setFoodType(this);
    }
  }
}
