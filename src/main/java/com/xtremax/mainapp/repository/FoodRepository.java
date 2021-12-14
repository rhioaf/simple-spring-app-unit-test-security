package com.xtremax.mainapp.repository;

import com.xtremax.mainapp.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface FoodRepository extends JpaRepository<Food, Long> {
}
