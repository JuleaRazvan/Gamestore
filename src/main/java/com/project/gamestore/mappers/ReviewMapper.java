package com.project.gamestore.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.gamestore.dtos.ReviewApi;
import com.project.gamestore.dtos.ReviewDTO;
import com.project.gamestore.entities.Game;
import com.project.gamestore.entities.Review;
import com.project.gamestore.entities.User;
import com.project.gamestore.repositories.GameRepository;
import com.project.gamestore.repositories.UserRepository;

@Component
public class ReviewMapper {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private UserRepository userRepository;

    public ReviewDTO mapEntityToDTO(Review review) {
        return ReviewDTO.builder()
                .publicIdentifier(review.getPublicIdentifier())
                .rating(review.getRating())
                .comment(review.getComment())
                .userId(review.getPublicIdentifier())
                .gameId(review.getPublicIdentifier())
                .createdAt(review.getCreatedAt())
                .lastUpdatedAt(review.getLastUpdatedAt())
                .build();
    }

    public Review mapApiToEntity(ReviewApi reviewApi) {
        User user = userRepository.findByPublicIdentifierMandatory(reviewApi.getUserId());
        Game game = gameRepository.findByPublicIdentifierMandatory(reviewApi.getGameId());

        return Review.builder()
                .rating(reviewApi.getRating())
                .comment(reviewApi.getComment())
                .user(user)
                .game(game)
                .build();
    }
}