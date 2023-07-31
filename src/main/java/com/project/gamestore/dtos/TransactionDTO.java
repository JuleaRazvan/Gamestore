package com.project.gamestore.dtos;

import java.math.BigDecimal;
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
public class TransactionDTO {
    private UUID publicIdentifier;
    private BigDecimal price;
    private String type;
    private UUID userId;
    private UUID gameId;
    private Instant createdAt;
    private Instant lastUpdatedAt;
}
