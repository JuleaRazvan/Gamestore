package com.project.gamestore.services;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;
import com.project.gamestore.dtos.GenreDTO;
import com.project.gamestore.entities.Genre;
import com.project.gamestore.mappers.GenreMapper;
import com.project.gamestore.repositories.GenreRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class GenreService {

    private GenreRepository genreRepository;

    private GenreMapper genreMapper;

    public GenreDTO createGenre(GenreDTO genreDTO) {
        Genre genre = genreMapper.mapDtoToEntity(genreDTO);
        Genre createdGenre = genreRepository.save(genre);
        log.info("Created genre entity with public identifier {}", createdGenre.getPublicIdentifier());
        return genreMapper.mapEntityToDTO(createdGenre);
    }

    public List<GenreDTO> findAll() {
        return genreRepository.findAll().stream()
                .map(genre -> genreMapper.mapEntityToDTO(genre))
                .toList();
    }

    public GenreDTO getByPublicIdentifier(UUID publicIdentifier) {
        Genre foundGenre = genreRepository.findByPublicIdentifierMandatory(publicIdentifier);
        return genreMapper.mapEntityToDTO(foundGenre);
    }

    public GenreDTO update(GenreDTO genreDTO, UUID publicIdentifier) {
        Genre updateGenre = genreRepository.findByPublicIdentifierMandatory(publicIdentifier);
        updateGenre.setName(genreDTO.getName());
        updateGenre.setPopularity(genreDTO.getPopularity());
        updateGenre.setDescription(genreDTO.getDescription());
        updateGenre = genreRepository.save(updateGenre);

        log.info("Updated genre with public identifier {}", updateGenre.getPublicIdentifier());
        return genreMapper.mapEntityToDTO(updateGenre);
    }

    @Transactional
    public void delete(UUID publicIdentifier) {
        genreRepository.deleteByPublicIdentifier(publicIdentifier);
        log.info("Deleted genre with public identifier {}", publicIdentifier);
    }
}
