package com.project.gamestore.dtos;

import java.time.Instant;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GenreDTO {
    private UUID publicIdentifier;
    private String name;
    private Integer popularity;
    private String description;
    private Instant createdAt;
    private Instant lastUpdatedAt;

}
