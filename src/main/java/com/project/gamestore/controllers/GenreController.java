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
import com.project.gamestore.dtos.GenreDTO;
import com.project.gamestore.routes.Routes;
import com.project.gamestore.services.GenreService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class GenreController {

    private GenreService genreService;

    @PostMapping(Routes.GENRES_ROOT)
    public GenreDTO create(@RequestBody GenreDTO genderDTO) {
        return genreService.createGenre(genderDTO);
    }

    @GetMapping(Routes.GENRES_ROOT)
    public List<GenreDTO> findAll() {
        return genreService.findAll();
    }

    @GetMapping(Routes.GENRES_ENTRY)
    public GenreDTO findByPublicIdentifier(@PathVariable UUID publicIdentifier) {
        return genreService.getByPublicIdentifier(publicIdentifier);
    }

    @PutMapping(Routes.GENRES_ENTRY)
    public GenreDTO update(@RequestBody GenreDTO genreDTO, @PathVariable UUID publicIdentifier) {
        return genreService.update(genreDTO, publicIdentifier);
    }

    @DeleteMapping(Routes.GENRES_ENTRY)
    public void delete(@PathVariable UUID publicIdentifier) {
        genreService.delete(publicIdentifier);
    }
}
