package com.devnoahf.magicdietai.Model;

import com.devnoahf.magicdietai.Enums.Dieta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_user")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(nullable = false)
    private Dieta dieta;


    @OneToMany(mappedBy = "user",orphanRemoval = true)
    private List<FoodItem> foodItems;
}
