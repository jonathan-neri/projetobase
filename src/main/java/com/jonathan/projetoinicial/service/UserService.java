package com.jonathan.projetoinicial.service;

import com.jonathan.projetoinicial.model.User;
import com.jonathan.projetoinicial.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List <User> findAll () {
        return userRepository.findAll();
    }
    public void inserir (User user){
        user.setId(null);
        userRepository.save (user);
    }
    public User buscarPorId (Integer id){
        return userRepository.findById(id).orElse(null);
    }
    public User alterar (User user, Integer id){
        user.setId(id);
        return userRepository.save(user);
    }
    public void excluir (Integer id){
        userRepository.delete(this.buscarPorId(id));
    }

}
