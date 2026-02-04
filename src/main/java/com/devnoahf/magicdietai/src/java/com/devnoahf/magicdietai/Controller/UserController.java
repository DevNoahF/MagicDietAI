package com.devnoahf.magicdietai.src.java.com.devnoahf.magicdietai.Controller;

import com.devnoahf.magicdietai.src.java.com.devnoahf.magicdietai.Model.User;
import com.devnoahf.magicdietai.src.java.com.devnoahf.magicdietai.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<User>> litar(){
        List<User> user = service.listar();
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> buscar(@PathVariable Long id){
        return service.buscar(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<User> criar(@RequestBody User user){
        User salvo = service.criar(user);
        return ResponseEntity.ok(salvo);
    }

    @PostMapping("/{id}")
    public ResponseEntity<User> atualizar(@PathVariable Long id, @RequestBody User user){
        return service.buscar(id)
                .map(existente -> {
                    user.setId(existente.getId());
                    User atualizado = service.atualizar(id, user);
                    return ResponseEntity.ok(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());

    }
}
