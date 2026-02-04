package com.devnoahf.magicdietai.src.java.com.devnoahf.magicdietai.Service;

import com.devnoahf.magicdietai.src.java.com.devnoahf.magicdietai.Model.User;
import com.devnoahf.magicdietai.src.java.com.devnoahf.magicdietai.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void deletar(Long id){
        Optional<User> user = repository.findById(id);
        if (user.isPresent()){
            repository.deleteById(id);
        }
    }

    public List<User> listar(){
        return repository.findAll();
    }

    public Optional<User> buscar(Long id){
        return repository.findById(id);
    }

    public User criar(User user){
        return repository.save(user);
    }

    public User atualizar(Long id, User user){
        return repository.findById(id)
                .map(existente -> {
                    user.setId(existente.getId());
                    return repository.save(user);
                })
                .orElse(null);
    }
}
