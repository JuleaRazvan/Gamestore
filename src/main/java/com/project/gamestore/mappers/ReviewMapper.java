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
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setPublicIdentifier(review.getPublicIdentifier());
        reviewDTO.setRating(review.getRating());
        reviewDTO.setComment(review.getComment());
        reviewDTO.setUserId(review.getUser().getPublicIdentifier());
        reviewDTO.setGameId(review.getGame().getPublicIdentifier());
        reviewDTO.setCreatedAt(review.getCreatedAt());
        reviewDTO.setLastUpdatedAt(review.getLastUpdatedAt());

        return reviewDTO;
    }

    public Review mapApiToEntity(ReviewApi reviewApi) {
        Review review = new Review();
        review.setRating(reviewApi.getRating());
        review.setComment(reviewApi.getComment());

        User user = userRepository.findByPublicIdentifier(reviewApi.getUserId()).orElseThrow();
        review.setUser(user);

        Game game = gameRepository.findByPublicIdentifier(reviewApi.getGameId()).orElseThrow();
        review.setGame(game);

        return review;
    }

}
