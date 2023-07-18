package com.project.gamestore.dtos;

import java.time.Instant;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PublisherDTO {
    private UUID publicIdentifier;
    private String name;
    private String email;
    private String imageUrl;
    private String website;
    private Instant createdAt;
    private Instant lastUpdatedAt;

}
