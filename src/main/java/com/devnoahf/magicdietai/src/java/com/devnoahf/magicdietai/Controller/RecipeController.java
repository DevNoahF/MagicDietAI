package com.devnoahf.magicdietai.src.java.com.devnoahf.magicdietai.Controller;

import com.devnoahf.magicdietai.src.java.com.devnoahf.magicdietai.Model.FoodItem;
import com.devnoahf.magicdietai.src.java.com.devnoahf.magicdietai.Model.User;
import com.devnoahf.magicdietai.src.java.com.devnoahf.magicdietai.Service.FoodItemService;
import com.devnoahf.magicdietai.src.java.com.devnoahf.magicdietai.Service.GeminiService;
import com.devnoahf.magicdietai.src.java.com.devnoahf.magicdietai.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private final FoodItemService foodItemService;
    private final GeminiService geminiService;
    private final UserService userService;

    public RecipeController(FoodItemService foodItemService, GeminiService geminiService, UserService userService) {
        this.foodItemService = foodItemService;
        this.geminiService = geminiService;
        this.userService = userService;
    }


    @GetMapping("/generate")
    public Mono<ResponseEntity<String>> generateRecipe() {
        List<FoodItem> foodItems = foodItemService.listar();
        List<User> users = userService.listar();
        return geminiService.generateRecipe(foodItems, users)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
