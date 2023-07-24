package com.project.gamestore.dtos;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewApi {
    private Integer rating;
    private String comment;
    private UUID userId;
    private UUID gameId;
}
