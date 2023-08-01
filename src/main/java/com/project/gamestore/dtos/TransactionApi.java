package com.project.gamestore.dtos;

import java.math.BigDecimal;
import java.util.UUID;
import com.project.gamestore.types.TransactionType;
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
public class TransactionApi {
    private BigDecimal price;
    private TransactionType type;
    private UUID userId;
    private UUID gameId;
}
