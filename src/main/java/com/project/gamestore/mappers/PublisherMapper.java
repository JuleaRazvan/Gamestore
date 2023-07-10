package com.project.gamestore.mappers;

import org.springframework.stereotype.Component;

import com.project.gamestore.dtos.PublisherDTO;
import com.project.gamestore.entities.Publisher;

@Component
public class PublisherMapper {

    public PublisherDTO mapEntityToDTO(Publisher publisher) {
        PublisherDTO publisherDTO = new PublisherDTO();
        publisherDTO.setPublicIdentifier(publisher.getPublicIdentifier());
        publisherDTO.setName(publisher.getName());
        publisherDTO.setEmail(publisher.getEmail());
        publisherDTO.setImageUrl(publisher.getImageUrl());
        publisherDTO.setWebsite(publisher.getWebsite());
        publisherDTO.setCreatedAt(publisher.getCreatedAt());
        publisherDTO.setLastUpdatedAt(publisher.getLastUpdatedAt());

        return publisherDTO;
    }

    public Publisher mapDtoToEntity(PublisherDTO publisherDTO) {
        Publisher publisher = new Publisher();
        publisher.setPublicIdentifier(publisherDTO.getPublicIdentifier());
        publisher.setName(publisherDTO.getName());
        publisher.setEmail(publisherDTO.getEmail());
        publisher.setImageUrl(publisherDTO.getImageUrl());
        publisher.setWebsite(publisherDTO.getWebsite());
        publisher.setCreatedAt(publisherDTO.getCreatedAt());
        publisher.setLastUpdatedAt(publisherDTO.getLastUpdatedAt());

        return publisher;
    }

}
