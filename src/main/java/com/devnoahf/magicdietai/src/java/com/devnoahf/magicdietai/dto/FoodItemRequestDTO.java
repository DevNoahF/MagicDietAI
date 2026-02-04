package com.devnoahf.magicdietai.src.java.com.devnoahf.magicdietai.dto;

import com.devnoahf.magicdietai.src.java.com.devnoahf.magicdietai.Enums.Category;

import java.time.LocalDate;

public record FoodItemRequestDTO(String nameFood,
                                 LocalDate validity,
                                 Integer amount,
                                 Category category) {
}
