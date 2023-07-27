package com.project.gamestore.controllers;

import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.gamestore.dtos.UserGameDTO;
import com.project.gamestore.services.UserGameService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/userGame")
@AllArgsConstructor
public class UserGameController {

    private UserGameService userGameService;

    @PostMapping
    public UserGameDTO create(@RequestBody UserGameDTO userGameDTO) {
        return userGameService.create(userGameDTO);
    }

    @GetMapping
    public List<UserGameDTO> findAll() {
        return userGameService.findAll();
    }

    @GetMapping("/{publicIdentifier}")
    public UserGameDTO findByPublicIdentifier(@PathVariable UUID publicIdentifier) {
        return userGameService.getByPublicIdentifier(publicIdentifier);
    }

    @PutMapping("/{publicIdentifier}")
    public UserGameDTO update(@RequestBody UserGameDTO userGameDTO, @PathVariable UUID publicIdentifier) {
        return userGameService.update(userGameDTO, publicIdentifier);
    }

    @DeleteMapping("/{publicIdentifier}")
    public void delete(@PathVariable UUID publicIdentifier) {
        userGameService.delete(publicIdentifier);
    }
}
