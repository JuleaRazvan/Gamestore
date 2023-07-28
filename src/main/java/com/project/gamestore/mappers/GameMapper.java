package com.project.gamestore.mappers;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;
import com.project.gamestore.dtos.GameApi;
import com.project.gamestore.dtos.GameDTO;
import com.project.gamestore.entities.Game;
import com.project.gamestore.entities.Genre;
import com.project.gamestore.entities.Publisher;
import com.project.gamestore.repositories.GenreRepository;
import com.project.gamestore.repositories.PublisherRepository;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class GameMapper {

    private GenreMapper genreMapper;

    private PublisherMapper publisherMapper;

    private GenreRepository genreRepository;

    private PublisherRepository publisherRepository;

    public GameDTO mapEntityToDTO(Game game) {
        return GameDTO.builder()
                .publicIdentifier(game.getPublicIdentifier())
                .name(game.getName())
                .price(game.getPrice().compareTo(new BigDecimal(0)) == 0 ? "FREE" : game.getPrice().toString())
                .genre(genreMapper.mapEntityToDTO(game.getGenre()))
                .publisher(publisherMapper.mapEntityToDTO(game.getPublisher()))
                .createdAt(game.getCreatedAt())
                .lastUpdatedAt(game.getLastUpdatedAt())
                .build();
    }

    public Game mapApiToEntity(GameApi gameApi) {
        Genre genre = genreRepository.findByPublicIdentifierMandatory(gameApi.getGenreId());
        Publisher publisher = publisherRepository.findByPublicIdentifierMandatory(gameApi.getPublisherId());

        return Game.builder()
                .name(gameApi.getName())
                .price(gameApi.getPrice().equals("FREE") ? new BigDecimal(0) : new BigDecimal(gameApi.getPrice()))
                .genre(genre)
                .publisher(publisher)
                .build();
    }
}