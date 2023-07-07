package com.project.gamestore.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.gamestore.dtos.GenreDTO;
import com.project.gamestore.entities.Genre;
import com.project.gamestore.mappers.GenreMapper;
import com.project.gamestore.repositories.GenreRepository;

import jakarta.transaction.Transactional;

@Service
public class GenreService {

    @Autowired
    public GenreRepository genreRepository;

    @Autowired
    public GenreMapper genreMapper;

    public GenreDTO createGenre(GenreDTO genreDTO) {
        Genre genre = genreMapper.mapDtoToEntity(genreDTO);
        Genre createdGenre = genreRepository.save(genre);
        return genreMapper.mapEntityToDTO(createdGenre);
    }

    public List<GenreDTO> findAll() {
        return genreRepository.findAll().stream()
                .map(genre -> genreMapper.mapEntityToDTO(genre))
                .toList();
    }

    public GenreDTO getByPublicIdentifier(UUID publicIdentifier) {
        Genre foundGenre = genreRepository.findByPublicIdentifier(publicIdentifier).orElseThrow();
        return genreMapper.mapEntityToDTO(foundGenre);
    }

    public GenreDTO update(GenreDTO genreDTO, UUID publicIdentifier) {
        Genre updatGenre = genreRepository.findByPublicIdentifier(publicIdentifier).orElseThrow();
        updatGenre.setName(genreDTO.getName());
        updatGenre.setPopularity(genreDTO.getPopularity());
        updatGenre.setDescription(genreDTO.getDescription());
        updatGenre = genreRepository.save(updatGenre);

        return genreMapper.mapEntityToDTO(updatGenre);
    }

    @Transactional
    public void delete(UUID publicIdentifier) {
        genreRepository.deleteByPublicIdentifier(publicIdentifier);
    }

}
