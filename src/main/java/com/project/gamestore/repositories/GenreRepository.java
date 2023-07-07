package com.project.gamestore.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.gamestore.entities.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    public Optional<Genre> findByPublicIdentifier(UUID publicIdentifier);

    public void deleteByPublicIdentifier(UUID publicIdentifier);
}