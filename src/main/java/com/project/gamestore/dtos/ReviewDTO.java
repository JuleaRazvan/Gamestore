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
public class ReviewDTO {
    private UUID publicIdentifier;
    private Integer rating;
    private String comment;
    private UUID userId;
    private UUID gameId;
    private Instant createdAt;
    private Instant lastUpdatedAt;
}
