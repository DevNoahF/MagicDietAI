package com.devnoahf.magicdietai.Repository;

import com.devnoahf.magicdietai.Model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {
}
