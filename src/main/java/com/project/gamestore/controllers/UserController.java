package com.project.gamestore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.gamestore.dtos.UserDTO;

import java.util.*;

import com.project.gamestore.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController{

    @Autowired
    private UserService UserService;
    
    @GetMapping()
    public List<UserDTO> findAll(){
        return UserService.findAll();
    }

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO){
        return UserService.createUser(userDTO);
    }

    @GetMapping("/{publicIdentifier}")
    public UserDTO getByPublicIdentifier(@PathVariable UUID publicIdentifier){
        return UserService.getByPublicIdentifier(publicIdentifier);
    }

    @PutMapping("/{publicIdentifier}")
    public UserDTO update(@RequestBody UserDTO userDTO, @PathVariable UUID publicIdentifier){
        return UserService.update(userDTO, publicIdentifier);
    }

    @DeleteMapping("/{publicIdentifier}")
    public void delete(@PathVariable UUID publicIdentifier){
        UserService.delete(publicIdentifier);
    }

}