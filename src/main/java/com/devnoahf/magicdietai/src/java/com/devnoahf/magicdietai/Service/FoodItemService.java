package com.devnoahf.magicdietai.src.java.com.devnoahf.magicdietai.Service;

import com.devnoahf.magicdietai.src.java.com.devnoahf.magicdietai.Model.FoodItem;
import com.devnoahf.magicdietai.src.java.com.devnoahf.magicdietai.Repository.FoodItemRepository;
import org.springframework.stereotype.Service;
import java.lang.Long;
import java.util.List;
import java.util.Optional;


@Service
public class FoodItemService {


    private  FoodItemRepository repository;

    public FoodItemService(FoodItemRepository repository) {
        this.repository = repository;
    }

    public FoodItem criar(FoodItem foodItem){
        return repository.save(foodItem);
    }

    public List<FoodItem> listar(){
        return repository.findAll();
    }

    public Optional<FoodItem> buscar(Long id){
        return repository.findById(id);
    }

    public FoodItem atualizar(FoodItem foodItem){
        return repository.save(foodItem);
    }

    public void deletar(Long id){
        Optional<FoodItem> foodItem = repository.findById(id);
        if(foodItem.isPresent()){
            repository.deleteById(id);
        }
    }
}
