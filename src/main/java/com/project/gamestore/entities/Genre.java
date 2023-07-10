package com.project.gamestore.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "genres")
public class Genre extends IdentifiableEntity {
    private String name;
    private Integer popularity;
    private String description;
}
