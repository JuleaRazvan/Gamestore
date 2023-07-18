package com.project.gamestore.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.gamestore.dtos.GameApi;
import com.project.gamestore.dtos.GameDTO;
import com.project.gamestore.services.GameService;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    public GameService gameService;

    @PostMapping
    public GameDTO create(@RequestBody GameApi gameApi) {
        return gameService.create(gameApi);
    }

    @GetMapping
    public List<GameDTO> findAll() {
        return gameService.findAll();
    }

    @GetMapping("/{publicIdentifier}")
    public GameDTO findByPublicIdentifier(@PathVariable UUID publicIdentifier) {
        return gameService.getByPublicIdentifier(publicIdentifier);
    }

    @PutMapping("/{publicIdentifier}")
    public GameDTO update(@RequestBody GameApi gameApi, @PathVariable UUID publicIdentifier) {
        return gameService.update(gameApi, publicIdentifier);
    }

    @DeleteMapping("/{publicIdentifier}")
    public void delete(@PathVariable UUID publicIdentifier) {
        gameService.delete(publicIdentifier);
    }
}
