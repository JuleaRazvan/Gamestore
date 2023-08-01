package com.project.gamestore.dtos;

import java.time.Instant;
import java.util.UUID;
import com.project.gamestore.types.UserRoleType;
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
public class UserDTO {
    private UUID publicIdentifier;
    private String name;
    private String email;
    private UserRoleType role;
    private Instant createdAt;
    private Instant lastUpdatedAt;
}