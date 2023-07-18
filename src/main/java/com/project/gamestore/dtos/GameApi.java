package com.project.gamestore.dtos;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameApi {
    private String name;
    private String price;
    private UUID genreId;
    private UUID publisherId;
}
