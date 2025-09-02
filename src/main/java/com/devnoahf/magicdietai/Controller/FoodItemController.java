package com.devnoahf.magicdietai.Controller;

import com.devnoahf.magicdietai.Model.FoodItem;
import com.devnoahf.magicdietai.Service.FoodItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodItemController {

    private final FoodItemService service;

    public FoodItemController(FoodItemService service) {
        this.service = service;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<FoodItem>> listar(){
        List<FoodItem> foodItems = service.listar();
        return ResponseEntity.ok(foodItems);
    }

    @PostMapping
    public ResponseEntity<FoodItem> criar(@RequestBody FoodItem foodItem){
        FoodItem save = service.criar(foodItem);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodItem> buscar(@PathVariable Long id){
        return service.buscar(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}")
    public ResponseEntity<FoodItem> atualizar(@PathVariable Long id, @RequestBody FoodItem foodItem){
        return service.buscar(id)
                .map(existente -> {
                    foodItem.setId(existente.getId());
                    FoodItem atualizado = service.atualizar(foodItem);
                    return ResponseEntity.ok(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
