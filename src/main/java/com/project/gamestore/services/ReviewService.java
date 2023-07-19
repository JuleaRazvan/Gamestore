package com.project.gamestore.services;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.gamestore.dtos.ReviewApi;
import com.project.gamestore.dtos.ReviewDTO;
import com.project.gamestore.entities.Game;
import com.project.gamestore.entities.Review;
import com.project.gamestore.entities.User;
import com.project.gamestore.mappers.ReviewMapper;
import com.project.gamestore.repositories.GameRepository;
import com.project.gamestore.repositories.ReviewRepository;
import com.project.gamestore.repositories.UserRepository;
import jakarta.transaction.Transactional;

@Service
public class ReviewService {

    @Autowired
    public ReviewMapper reviewMapper;

    @Autowired
    public ReviewRepository reviewRepository;

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public GameRepository gameRepository;

    public ReviewDTO createReview(ReviewApi reviewApi) {
        Review review = reviewMapper.mapApiToEntity(reviewApi);
        Review createdReview = reviewRepository.save(review);
        return reviewMapper.mapEntityToDTO(createdReview);
    }

    public List<ReviewDTO> findAll() {
        return reviewRepository.findAll().stream()
                .map(review -> reviewMapper.mapEntityToDTO(review))
                .toList();
    }

    public ReviewDTO getByPublicIdentifier(UUID publicIdentifier) {
        Review foundReview = reviewRepository.findByPublicIdentifier(publicIdentifier).orElseThrow();
        return reviewMapper.mapEntityToDTO(foundReview);
    }

    public ReviewDTO update(ReviewApi reviewApi, UUID publicIdentifier) {
        Review updateReview = reviewRepository.findByPublicIdentifier(publicIdentifier).orElseThrow();
        updateReview.setRating(reviewApi.getRating());
        updateReview.setComment(reviewApi.getComment());

        User user = userRepository.findByPublicIdentifier(reviewApi.getUserId()).orElseThrow();
        updateReview.setUser(user);

        Game game = gameRepository.findByPublicIdentifier(reviewApi.getGameId()).orElseThrow();
        updateReview.setGame(game);
        updateReview = reviewRepository.save(updateReview);

        return reviewMapper.mapEntityToDTO(updateReview);
    }

    @Transactional
    public void delte(UUID publicIdentifier) {
        reviewRepository.deleteByPublicIdentifier(publicIdentifier);
    }
}
