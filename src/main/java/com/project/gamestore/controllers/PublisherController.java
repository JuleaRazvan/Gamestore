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

import com.project.gamestore.dtos.PublisherDTO;
import com.project.gamestore.services.PublisherService;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @PostMapping
    public PublisherDTO create(@RequestBody PublisherDTO publisherDTO) {
        return publisherService.createPublisher(publisherDTO);
    }

    @GetMapping
    public List<PublisherDTO> findAll() {
        return publisherService.findAll();
    }

    @GetMapping("/{publicIdentifier}")
    public PublisherDTO findByPublicIdentifier(@PathVariable UUID publicIdentifier) {
        return publisherService.getByPublicIdentifier(publicIdentifier);
    }

    @PutMapping("/{publicIdentifier}")
    public PublisherDTO update(@RequestBody PublisherDTO publisherDTO, @PathVariable UUID publicIdentifier) {
        return publisherService.update(publisherDTO, publicIdentifier);
    }

    @DeleteMapping("/{publicIdentifier}")
    public void delete(@PathVariable UUID publicIdentifier) {
        publisherService.delete(publicIdentifier);
    }
}
