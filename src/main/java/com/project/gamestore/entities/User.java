package com.project.gamestore.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User extends IdentifiableEntity {
    private String name;
    private String email;
    private String role;
}
