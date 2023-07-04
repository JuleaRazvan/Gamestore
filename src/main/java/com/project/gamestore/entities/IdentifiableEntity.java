package com.project.gamestore.entities;

import java.time.Instant;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class IdentifiableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    protected UUID publicIdentifier;

    @Column(updatable = false)
    @CreationTimestamp
    private Instant createdAt;

    @Column(updatable = false)
    @UpdateTimestamp
    private Instant lastUpdatedAt;

    @PrePersist
    public void prePersist() {
        if (publicIdentifier == null) {
            publicIdentifier = UUID.randomUUID();
        }
    }
}
