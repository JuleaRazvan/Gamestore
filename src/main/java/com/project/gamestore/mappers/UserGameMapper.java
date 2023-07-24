package com.project.gamestore.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.project.gamestore.dtos.UserGameDTO;
import com.project.gamestore.entities.Game;
import com.project.gamestore.entities.User;
import com.project.gamestore.entities.UserGame;
import com.project.gamestore.repositories.GameRepository;
import com.project.gamestore.repositories.UserRepository;

@Component
public class UserGameMapper {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private UserRepository userRepository;

    public UserGameDTO mapEntityToDTO(UserGame userGame) {
        UserGameDTO userGameDTO = new UserGameDTO();
        userGameDTO.setPublicIdentifier(userGame.getPublicIdentifier());
        userGameDTO.setUserId(userGame.getUser().getPublicIdentifier());
        userGameDTO.setGameId(userGame.getGame().getPublicIdentifier());
        userGameDTO.setCreatedAt(userGame.getCreatedAt());
        userGameDTO.setLastUpdatedAt(userGame.getLastUpdatedAt());

        return userGameDTO;
    }

    public UserGame mapDtoToEntity(UserGameDTO userGameDTO) {
        UserGame userGame = new UserGame();
        userGame.setPublicIdentifier(userGameDTO.getPublicIdentifier());

        User user = userRepository.findByPublicIdentifier(userGameDTO.getUserId()).orElseThrow();
        userGame.setUser(user);

        Game game = gameRepository.findByPublicIdentifier(userGameDTO.getGameId()).orElseThrow();
        userGame.setGame(game);

        return userGame;
    }
}
