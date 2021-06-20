package com.jonathan.projetoinicial.controller;

import com.jonathan.projetoinicial.model.User;
import com.jonathan.projetoinicial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (value = "/usuarios")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping (value = "todos")
    public ResponseEntity <List<User>> findAll (){
        return ResponseEntity.ok().body(userService.findAll());
    }

    @RequestMapping (method = RequestMethod.GET, value = "inserir")
    public ResponseEntity <Void> inserir (@RequestBody User user){
        userService.inserir(user);
        return ResponseEntity.created(null).build();
    }

    @GetMapping (value = "buscar-por-id/{id}")
    public ResponseEntity <User> buscarPorId (@PathVariable Integer id){
        return ResponseEntity.ok().body(userService.buscarPorId(id));
    }

    @PutMapping (value = "alterar/{id}")
    public ResponseEntity <User> alterar (@PathVariable Integer id, @RequestBody User user){
        return ResponseEntity.ok().body(userService.alterar(user,id));
    }

    @DeleteMapping (value = "excluir/{id}")
    public ResponseEntity <Void> excluir (@PathVariable Integer id){
        userService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
