package com.project.gamestore.mappers;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.project.gamestore.dtos.GameApi;
import com.project.gamestore.dtos.GameDTO;
import com.project.gamestore.entities.Game;
import com.project.gamestore.entities.Genre;
import com.project.gamestore.entities.Publisher;
import com.project.gamestore.repositories.GenreRepository;
import com.project.gamestore.repositories.PublisherRepository;

@Component
public class GameMapper {

    @Autowired
    private GenreMapper genreMapper;

    @Autowired
    private PublisherMapper publisherMapper;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    public GameDTO mapEntityToDTO(Game game) {
        GameDTO gameDTO = new GameDTO();
        gameDTO.setPublicIdentifier(game.getPublicIdentifier());
        gameDTO.setName(game.getName());
        if (game.getPrice().compareTo(new BigDecimal(0)) == 0) {
            gameDTO.setPrice("FREE");
        } else {
            gameDTO.setPrice(game.getPrice().toString());
        }
        gameDTO.setGenre(genreMapper.mapEntityToDTO(game.getGenre()));
        gameDTO.setPublisher(publisherMapper.mapEntityToDTO(game.getPublisher()));
        gameDTO.setCreatedAt(game.getCreatedAt());
        gameDTO.setLastUpdatedAt(game.getLastUpdatedAt());

        return gameDTO;
    }

    public Game mapApiToEntity(GameApi gameApi) {
        Game game = new Game();
        game.setName(gameApi.getName());
        if (gameApi.getPrice().equals("FREE")) {
            game.setPrice(new BigDecimal(0));
        } else {
            game.setPrice(new BigDecimal(gameApi.getPrice()));
        }
        Genre genre = genreRepository.findByPublicIdentifier(gameApi.getGenreId()).orElseThrow();
        game.setGenre(genre);

        Publisher publisher = publisherRepository.findByPublicIdentifier(gameApi.getPublisherId()).orElseThrow();
        game.setPublisher(publisher);

        return game;
    }
}
