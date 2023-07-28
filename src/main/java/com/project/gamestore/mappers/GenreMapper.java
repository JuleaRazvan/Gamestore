package com.project.gamestore.mappers;

import org.springframework.stereotype.Component;
import com.project.gamestore.dtos.GenreDTO;
import com.project.gamestore.entities.Genre;

@Component
public class GenreMapper {

    public GenreDTO mapEntityToDTO(Genre genre) {
        return GenreDTO.builder()
                .publicIdentifier(genre.getPublicIdentifier())
                .name(genre.getName())
                .popularity(genre.getPopularity())
                .description(genre.getDescription())
                .createdAt(genre.getCreatedAt())
                .lastUpdatedAt(genre.getLastUpdatedAt())
                .build();
    }

    public Genre mapDtoToEntity(GenreDTO genreDTO) {
        return Genre.builder()
                .name(genreDTO.getName())
                .popularity(genreDTO.getPopularity())
                .description(genreDTO.getDescription())
                .build();
    }
}