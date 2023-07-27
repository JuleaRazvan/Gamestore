package com.project.gamestore.mappers;

import org.springframework.stereotype.Component;
import com.project.gamestore.dtos.PublisherDTO;
import com.project.gamestore.entities.Publisher;

@Component
public class PublisherMapper {

    public PublisherDTO mapEntityToDTO(Publisher publisher) {
        return PublisherDTO.builder()
                .publicIdentifier(publisher.getPublicIdentifier())
                .name(publisher.getName())
                .email(publisher.getEmail())
                .imageUrl(publisher.getImageUrl())
                .website(publisher.getWebsite())
                .createdAt(publisher.getCreatedAt())
                .lastUpdatedAt(publisher.getLastUpdatedAt())
                .build();
    }

    public Publisher mapDtoToEntity(PublisherDTO publisherDTO) {
        return Publisher.builder()
                .name(publisherDTO.getName())
                .email(publisherDTO.getEmail())
                .imageUrl(publisherDTO.getImageUrl())
                .website(publisherDTO.getWebsite())
                .build();
    }
}