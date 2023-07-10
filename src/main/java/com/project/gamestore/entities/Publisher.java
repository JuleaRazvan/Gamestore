package com.project.gamestore.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "publishers")
public class Publisher extends IdentifiableEntity {
    private String name;
    private String email;
    private String imageUrl;
    private String website;
}
