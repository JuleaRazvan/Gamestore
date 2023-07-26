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
        Genre genre = genreRepository.findByPublicIdentifier(gameApi.getGenreId()).orElseThrow();
        Publisher publisher = publisherRepository.findByPublicIdentifier(gameApi.getPublisherId()).orElseThrow();

        return Game.builder()
                .name(gameApi.getName())
                .price(gameApi.getPrice().equals("FREE") ? new BigDecimal(0) : new BigDecimal(gameApi.getPrice()))
                .genre(genre)
                .publisher(publisher)
                .build();
    }
}