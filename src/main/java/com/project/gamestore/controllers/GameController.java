package com.project.gamestore.controllers;

import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.project.gamestore.dtos.GameApi;
import com.project.gamestore.dtos.GameDTO;
import com.project.gamestore.routes.Routes;
import com.project.gamestore.services.GameService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class GameController {

    private GameService gameService;

    @PostMapping(Routes.GAMES_ROOT)
    public GameDTO create(@RequestBody GameApi gameApi) {
        return gameService.create(gameApi);
    }

    @GetMapping(Routes.GAMES_ROOT)
    public List<GameDTO> findAll() {
        return gameService.findAll();
    }

    @GetMapping(Routes.GAMES_ENTRY)
    public GameDTO findByPublicIdentifier(@PathVariable UUID publicIdentifier) {
        return gameService.getByPublicIdentifier(publicIdentifier);
    }

    @PutMapping(Routes.GAMES_ENTRY)
    public GameDTO update(@RequestBody GameApi gameApi, @PathVariable UUID publicIdentifier) {
        return gameService.update(gameApi, publicIdentifier);
    }

    @DeleteMapping(Routes.GAMES_ENTRY)
    public void delete(@PathVariable UUID publicIdentifier) {
        gameService.delete(publicIdentifier);
    }
}
