package com.project.gamestore.services;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;
import com.project.gamestore.dtos.UserGameDTO;
import com.project.gamestore.entities.Game;
import com.project.gamestore.entities.User;
import com.project.gamestore.entities.UserGame;
import com.project.gamestore.mappers.UserGameMapper;
import com.project.gamestore.repositories.GameRepository;
import com.project.gamestore.repositories.UserGameRepository;
import com.project.gamestore.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserGameService {

    private UserRepository userRepository;

    private GameRepository gameRepository;

    private UserGameRepository userGameRepository;

    private UserGameMapper userGameMapper;

    public UserGameDTO create(UserGameDTO userGameDTO) {
        UserGame userGame = userGameMapper.mapDtoToEntity(userGameDTO);
        UserGame createdUserGame = userGameRepository.save(userGame);
        return userGameMapper.mapEntityToDTO(createdUserGame);
    }

    public List<UserGameDTO> findAll() {
        return userGameRepository.findAll().stream()
                .map(userGame -> userGameMapper.mapEntityToDTO(userGame))
                .toList();
    }

    public UserGameDTO getByPublicIdentifier(UUID publicIdentifier) {
        UserGame founUserGame = userGameRepository.findByPublicIdentifierMandatory(publicIdentifier);
        return userGameMapper.mapEntityToDTO(founUserGame);
    }

    public UserGameDTO update(UserGameDTO userGameDTO, UUID publicIdentifier) {
        UserGame updatUserGame = userGameRepository.findByPublicIdentifierMandatory(publicIdentifier);

        User user = userRepository.findByPublicIdentifierMandatory(userGameDTO.getUserId());
        updatUserGame.setUser(user);

        Game game = gameRepository.findByPublicIdentifierMandatory(userGameDTO.getGameId());
        updatUserGame.setGame(game);

        updatUserGame = userGameRepository.save(updatUserGame);

        return userGameMapper.mapEntityToDTO(updatUserGame);
    }

    @Transactional
    public void delete(UUID publicIdentifier) {
        userGameRepository.deleteByPublicIdentifier(publicIdentifier);
    }
}
