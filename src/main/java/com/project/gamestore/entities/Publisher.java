package com.project.gamestore.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "publishers")
public class Publisher extends IdentifiableEntity {
    private String name;
    private String email;
    private String imageUrl;
    private String website;
}
