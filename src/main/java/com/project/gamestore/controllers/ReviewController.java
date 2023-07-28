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
import com.project.gamestore.dtos.ReviewApi;
import com.project.gamestore.dtos.ReviewDTO;
import com.project.gamestore.routes.Routes;
import com.project.gamestore.services.ReviewService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ReviewController {

    private ReviewService reviewService;

    @PostMapping(Routes.REVIEWS_ROOT)
    public ReviewDTO create(@RequestBody ReviewApi reviewApi) {
        return reviewService.createReview(reviewApi);
    }

    @GetMapping(Routes.REVIEWS_ROOT)
    public List<ReviewDTO> findAll() {
        return reviewService.findAll();
    }

    @GetMapping(Routes.REVIEWS_ENTRY)
    public ReviewDTO findByPublicIdentifier(@PathVariable UUID publicIdentifier) {
        return reviewService.getByPublicIdentifier(publicIdentifier);
    }

    @PutMapping(Routes.REVIEWS_ENTRY)
    public ReviewDTO update(@RequestBody ReviewApi reviewApi, @PathVariable UUID publicIdentifier) {
        return reviewService.update(reviewApi, publicIdentifier);
    }

    @DeleteMapping(Routes.REVIEWS_ENTRY)
    public void delete(@PathVariable UUID publicIdentifier) {
        reviewService.delte(publicIdentifier);
    }
}
