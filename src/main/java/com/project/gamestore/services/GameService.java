package com.project.gamestore.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;
import com.project.gamestore.dtos.GameApi;
import com.project.gamestore.dtos.GameDTO;
import com.project.gamestore.entities.Game;
import com.project.gamestore.entities.Genre;
import com.project.gamestore.entities.Publisher;
import com.project.gamestore.mappers.GameMapper;
import com.project.gamestore.repositories.GameRepository;
import com.project.gamestore.repositories.GenreRepository;
import com.project.gamestore.repositories.PublisherRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GameService {

    private GameRepository gameRepository;
    
    private GameMapper gameMapper;
    
    private GenreRepository genreRepository;

    private PublisherRepository publisherRepository;

    public GameDTO create(GameApi gameApi) {
        Game game = gameMapper.mapApiToEntity(gameApi);
        Game createdGame = gameRepository.save(game);
        return gameMapper.mapEntityToDTO(createdGame);
    }

    public List<GameDTO> findAll() {
        return gameRepository.findAll().stream()
                .map(game -> gameMapper.mapEntityToDTO(game))
                .toList();
    }

    public GameDTO getByPublicIdentifier(UUID publicIdentifier) {
        Game foundGame = gameRepository.findByPublicIdentifierMandatory(publicIdentifier);
        return gameMapper.mapEntityToDTO(foundGame);
    }

    public GameDTO update(GameApi gameApi, UUID publicIdentifier) {
        Game updateGame = gameRepository.findByPublicIdentifierMandatory(publicIdentifier);
        updateGame.setName(gameApi.getName());
        if (gameApi.getPrice().equals("FREE")) {
            updateGame.setPrice(new BigDecimal(0));
        } else {
            updateGame.setPrice(new BigDecimal(gameApi.getPrice()));
        }
        Genre genre = genreRepository.findByPublicIdentifierMandatory(gameApi.getGenreId());
        updateGame.setGenre(genre);

        Publisher publisher = publisherRepository.findByPublicIdentifierMandatory(gameApi.getPublisherId());
        updateGame.setPublisher(publisher);
        updateGame = gameRepository.save(updateGame);

        return gameMapper.mapEntityToDTO(updateGame);
    }

    @Transactional
    public void delete(UUID publicIdentifier) {
        gameRepository.deleteByPublicIdentifier(publicIdentifier);
    }
}
