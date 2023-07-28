package com.project.gamestore.mappers;

import org.springframework.stereotype.Component;
import com.project.gamestore.dtos.UserGameDTO;
import com.project.gamestore.entities.Game;
import com.project.gamestore.entities.User;
import com.project.gamestore.entities.UserGame;
import com.project.gamestore.repositories.GameRepository;
import com.project.gamestore.repositories.UserRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UserGameMapper {

    private GameRepository gameRepository;

    private UserRepository userRepository;

    public UserGameDTO mapEntityToDTO(UserGame userGame) {
        return UserGameDTO.builder()
        .publicIdentifier(userGame.getPublicIdentifier())
        .userId(userGame.getUser().getPublicIdentifier())
        .gameId(userGame.getGame().getPublicIdentifier())
        .createdAt(userGame.getCreatedAt())
        .lastUpdatedAt(userGame.getLastUpdatedAt())
        .build();
    }

    public UserGame mapDtoToEntity(UserGameDTO userGameDTO) {
        User user = userRepository.findByPublicIdentifierMandatory(userGameDTO.getUserId());
        Game game = gameRepository.findByPublicIdentifierMandatory(userGameDTO.getGameId());

        return UserGame.builder()
        .user(user)
        .game(game)
        .build();
    }
}
