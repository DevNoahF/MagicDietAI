package com.devnoahf.magicdietai.src.java.com.devnoahf.magicdietai.dto;

import com.devnoahf.magicdietai.src.java.com.devnoahf.magicdietai.Enums.Diet;

import java.util.List;

public record UserRequestDTO(Diet diet,
                             List<FoodItemRequestDTO> foodItem) {
}
