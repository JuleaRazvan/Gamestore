package com.project.gamestore.mappers;

import org.springframework.stereotype.Component;

import com.project.gamestore.dtos.GenreDTO;
import com.project.gamestore.entities.Genre;

@Component
public class GenreMapper {

    public GenreDTO mapEntityToDTO(Genre genre) {
        GenreDTO genreDTO = new GenreDTO();
        genreDTO.setPublicIdentifier(genre.getPublicIdentifier());
        genreDTO.setName(genre.getName());
        genreDTO.setPopularity(genre.getPopularity());
        genreDTO.setDescription(genre.getDescription());
        genreDTO.setCreatedAt(genre.getCreatedAt());
        genreDTO.setLastUpdatedAt(genre.getLastUpdatedAt());

        return genreDTO;
    }

    public Genre mapDtoToEntity(GenreDTO genreDTO) {
        Genre genre = new Genre();
        genre.setPublicIdentifier(genreDTO.getPublicIdentifier());
        genre.setName(genreDTO.getName());
        genre.setPopularity(genreDTO.getPopularity());
        genre.setDescription(genreDTO.getDescription());
        genre.setCreatedAt(genreDTO.getCreatedAt());
        genre.setLastUpdatedAt(genreDTO.getLastUpdatedAt());

        return genre;

    }

}
