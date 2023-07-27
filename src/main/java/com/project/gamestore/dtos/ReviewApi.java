package com.project.gamestore.dtos;
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
public class ReviewApi {
    private Integer rating;
    private String comment;
    private UUID userId;
    private UUID gameId;
}
