package com.project.gamestore.dtos;

import java.time.Instant;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserGameDTO {
    private UUID publicIdentifier;
    private UUID userId;
    private UUID gameId;
    private Instant createdAt;
    private Instant lastUpdatedAt;
}
