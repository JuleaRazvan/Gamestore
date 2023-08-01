package com.project.gamestore.services;

import java.util.List;
import java.util.UUID;
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
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class ReviewService {

    private ReviewMapper reviewMapper;

    private ReviewRepository reviewRepository;

    private UserRepository userRepository;

    private GameRepository gameRepository;

    public ReviewDTO createReview(ReviewApi reviewApi) {
        Review review = reviewMapper.mapApiToEntity(reviewApi);
        Review createdReview = reviewRepository.save(review);
        log.info("Created review entity with public identifier {}", createdReview.getPublicIdentifier());
        return reviewMapper.mapEntityToDTO(createdReview);
    }

    public List<ReviewDTO> findAll() {
        return reviewRepository.findAll().stream()
                .map(review -> reviewMapper.mapEntityToDTO(review))
                .toList();
    }

    public ReviewDTO getByPublicIdentifier(UUID publicIdentifier) {
        Review foundReview = reviewRepository.findByPublicIdentifierMandatory(publicIdentifier);
        return reviewMapper.mapEntityToDTO(foundReview);
    }

    public ReviewDTO update(ReviewApi reviewApi, UUID publicIdentifier) {
        Review updateReview = reviewRepository.findByPublicIdentifierMandatory(publicIdentifier);
        updateReview.setRating(reviewApi.getRating());
        updateReview.setComment(reviewApi.getComment());

        User user = userRepository.findByPublicIdentifierMandatory(reviewApi.getUserId());
        updateReview.setUser(user);

        Game game = gameRepository.findByPublicIdentifierMandatory(reviewApi.getGameId());
        updateReview.setGame(game);
        updateReview = reviewRepository.save(updateReview);

        log.info("Updated review with public identifier {}", updateReview.getPublicIdentifier());
        return reviewMapper.mapEntityToDTO(updateReview);
    }

    @Transactional
    public void delte(UUID publicIdentifier) {
        reviewRepository.deleteByPublicIdentifier(publicIdentifier);
        log.info("Deleted review with public identifier {}", publicIdentifier);
    }
}
