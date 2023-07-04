package com.project.gamestore.dtos;

import java.time.Instant;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO{
    public UUID publicIdentifier;
    private String name;
    private String email;
    private String role;
    public Instant createdAt;
    public Instant lastUpdatedAt;
}