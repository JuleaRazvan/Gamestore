package com.project.gamestore.dtos;

import java.time.Instant;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private UUID publicIdentifier;
    private String name;
    private String email;
    private String role;
    private Instant createdAt;
    private Instant lastUpdatedAt;
}