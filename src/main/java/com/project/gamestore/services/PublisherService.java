package com.project.gamestore.services;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

import com.project.gamestore.dtos.GameDTO;
import com.project.gamestore.dtos.PublisherDTO;
import com.project.gamestore.entities.Publisher;
import com.project.gamestore.mappers.GameMapper;
import com.project.gamestore.mappers.PublisherMapper;
import com.project.gamestore.repositories.GameRepository;
import com.project.gamestore.repositories.PublisherRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PublisherService {

    private PublisherMapper publisherMapper;

    private PublisherRepository publisherRepository;

    private GameRepository gameRepository;

    private GameMapper gameMapper;

    public PublisherDTO createPublisher(PublisherDTO publisherDTO) {
        Publisher publisher = publisherMapper.mapDtoToEntity(publisherDTO);
        Publisher createdPublisher = publisherRepository.save(publisher);
        return publisherMapper.mapEntityToDTO(createdPublisher);
    }

    public List<PublisherDTO> findAll() {
        return publisherRepository.findAll().stream()
                .map(publisher -> publisherMapper.mapEntityToDTO(publisher))
                .toList();
    }

    public PublisherDTO getByPublicIdentifier(UUID publicIdentifier) {
        Publisher foundPublisher = publisherRepository.findByPublicIdentifierMandatory(publicIdentifier);
        return publisherMapper.mapEntityToDTO(foundPublisher);
    }

    public List<GameDTO> getAllGamesByPublisher(UUID publicIdentifier) {
        return gameRepository.findAllByPublisher_PublicIdentifier(publicIdentifier).stream()
                .map(game -> gameMapper.mapEntityToDTO(game)).toList();
    }

    public PublisherDTO update(PublisherDTO publisherUpdate, UUID publicIdentifier) {
        Publisher publisher = publisherRepository.findByPublicIdentifierMandatory(publicIdentifier);
        publisher.setName(publisherUpdate.getName());
        publisher.setEmail(publisherUpdate.getEmail());
        publisher.setImageUrl(publisherUpdate.getImageUrl());
        publisher.setWebsite(publisherUpdate.getWebsite());
        publisher = publisherRepository.save(publisher);

        return publisherMapper.mapEntityToDTO(publisher);
    }

    @Transactional
    public void delete(UUID publicIdentifier) {
        publisherRepository.deleteByPublicIdentifier(publicIdentifier);
    }
}
