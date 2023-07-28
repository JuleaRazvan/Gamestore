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

import com.project.gamestore.dtos.GameDTO;
import com.project.gamestore.dtos.PublisherDTO;
import com.project.gamestore.routes.Routes;
import com.project.gamestore.services.PublisherService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class PublisherController {

    private PublisherService publisherService;

    @PostMapping(Routes.PUBLISHERS_ROOT)
    public PublisherDTO create(@RequestBody PublisherDTO publisherDTO) {
        return publisherService.createPublisher(publisherDTO);
    }

    @GetMapping(Routes.PUBLISHERS_ROOT)
    public List<PublisherDTO> findAll() {
        return publisherService.findAll();
    }

    @GetMapping(Routes.PUBLISHERS_ENTRY)
    public PublisherDTO findByPublicIdentifier(@PathVariable UUID publicIdentifier) {
        return publisherService.getByPublicIdentifier(publicIdentifier);
    }

    @GetMapping(Routes.PUBLISHERS_ENTRY_GAMES)
    public List<GameDTO> getAllGamesByPublisher(@PathVariable UUID publicIdentifier){
        return publisherService.getAllGamesByPublisher(publicIdentifier);
    }

    @PutMapping(Routes.PUBLISHERS_ENTRY)
    public PublisherDTO update(@RequestBody PublisherDTO publisherDTO, @PathVariable UUID publicIdentifier) {
        return publisherService.update(publisherDTO, publicIdentifier);
    }

    @DeleteMapping(Routes.PUBLISHERS_ENTRY)
    public void delete(@PathVariable UUID publicIdentifier) {
        publisherService.delete(publicIdentifier);
    }
}
