package com.project.gamestore.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.project.gamestore.dtos.UserDTO;
import com.project.gamestore.routes.Routes;

import java.util.*;
import com.project.gamestore.services.UserService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UserController {

    private UserService UserService;

    @GetMapping(Routes.USERS_ROOT)
    public List<UserDTO> findAll() {
        return UserService.findAll();
    }

    @PostMapping(Routes.USERS_ROOT)
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return UserService.createUser(userDTO);
    }

    @GetMapping(Routes.USERS_ENTRY)
    public UserDTO getByPublicIdentifier(@PathVariable UUID publicIdentifier) {
        return UserService.getByPublicIdentifier(publicIdentifier);
    }

    @PutMapping(Routes.USERS_ENTRY)
    public UserDTO update(@RequestBody UserDTO userDTO, @PathVariable UUID publicIdentifier) {
        return UserService.update(userDTO, publicIdentifier);
    }

    @DeleteMapping(Routes.USERS_ENTRY)
    public void delete(@PathVariable UUID publicIdentifier) {
        UserService.delete(publicIdentifier);
    }
}