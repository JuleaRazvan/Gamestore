package com.project.gamestore.entities;

import com.project.gamestore.types.UserRoleType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User extends IdentifiableEntity {
    private String name;
    private String email;
    
    @Enumerated(EnumType.STRING)
    private UserRoleType role;
}
