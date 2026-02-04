package com.devnoahf.magicdietai.src.java.com.devnoahf.magicdietai.Service;

import com.devnoahf.magicdietai.src.java.com.devnoahf.magicdietai.dto.FoodItemRequestDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
@Slf4j
public class FoodItemService {

    ArrayList<FoodItemRequestDTO> foodItems;
    public FoodItemService() {
        this.foodItems = new ArrayList<>();
    }

    public ArrayList<FoodItemRequestDTO> getFoodItems() {
        log.info("listando itens");
        return foodItems;
    }

    public ArrayList<FoodItemRequestDTO> addFoodItems(FoodItemRequestDTO foodItemRequestDTO) {
        log.info("adicionando itens");
        foodItems.add(foodItemRequestDTO);
        return foodItems;
    }

    public void deleteFoodItems() {
        log.info("deletando itens");
        foodItems.clear();
    }









}
