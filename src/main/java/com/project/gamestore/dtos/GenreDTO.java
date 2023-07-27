package com.project.gamestore.dtos;

import java.time.Instant;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GenreDTO {
    private UUID publicIdentifier;
    private String name;
    private Integer popularity;
    private String description;
    private Instant createdAt;
    private Instant lastUpdatedAt;
}
