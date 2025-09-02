package com.devnoahf.magicdietai.Model;

import com.devnoahf.magicdietai.Enums.Categoria;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tb_food")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private LocalDate validade;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Categoria categoria;


    @JsonIgnore

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


}
