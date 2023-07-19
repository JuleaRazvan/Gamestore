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

import com.project.gamestore.dtos.ReviewApi;
import com.project.gamestore.dtos.ReviewDTO;
import com.project.gamestore.services.ReviewService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    
    @Autowired
    public ReviewService reviewService;

    @PostMapping
    public ReviewDTO create(@RequestBody ReviewApi reviewApi){
        return reviewService.createReview(reviewApi);
    }

    @GetMapping
    public List<ReviewDTO> findAll(){
        return reviewService.findAll();
    }

    @GetMapping("/{publicIdentifier}")
    public ReviewDTO findByPublicIdentifier(@PathVariable UUID publicIdentifier){
        return reviewService.getByPublicIdentifier(publicIdentifier);
    }

    @PutMapping("/{publicIdentifier}")
    public ReviewDTO update(@RequestBody ReviewApi reviewApi, @PathVariable UUID publicIdentifier){
        return reviewService.update(reviewApi, publicIdentifier);
    }

    @DeleteMapping("/{publicIdentifier}")
    public void delete(@PathVariable UUID publicIdentifier){
        reviewService.delte(publicIdentifier);
    }
}
