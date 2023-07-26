package com.project.gamestore.dtos;
import java.time.Instant;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GameDTO {
    private UUID publicIdentifier;
    private String name;
    private String price;
    private GenreDTO genre;
    private PublisherDTO publisher;
    private Instant createdAt;
    private Instant lastUpdatedAt;
}