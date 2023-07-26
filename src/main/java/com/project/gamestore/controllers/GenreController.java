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

import com.project.gamestore.dtos.GenreDTO;
import com.project.gamestore.services.GenreService;

@RestController
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @PostMapping
    public GenreDTO create(@RequestBody GenreDTO genderDTO) {
        return genreService.createGenre(genderDTO);
    }

    @GetMapping
    public List<GenreDTO> findAll() {
        return genreService.findAll();
    }

    @GetMapping("/{publicIdentifier}")
    public GenreDTO findByPublicIdentifier(@PathVariable UUID publicIdentifier) {
        return genreService.getByPublicIdentifier(publicIdentifier);
    }

    @PutMapping("/{publicIdentifier}")
    public GenreDTO update(@RequestBody GenreDTO genreDTO, @PathVariable UUID publicIdentifier) {
        return genreService.update(genreDTO, publicIdentifier);
    }

    @DeleteMapping("/{publicIdentifier}")
    public void delete(@PathVariable UUID publicIdentifier) {
        genreService.delete(publicIdentifier);
    }
}
