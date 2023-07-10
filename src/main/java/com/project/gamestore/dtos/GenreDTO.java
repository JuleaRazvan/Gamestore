package com.project.gamestore.dtos;

import java.time.Instant;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GenreDTO {
    public UUID publicIdentifier;
    private String name;
    private Integer popularity;
    private String description;
    public Instant createdAt;
    public Instant lastUpdatedAt;

}
