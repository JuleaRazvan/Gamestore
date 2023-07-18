package com.project.gamestore.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.gamestore.entities.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    public Optional<Game> findByPublicIdentifier(UUID publicIdentifier);

    public void deleteByPublicIdentifier(UUID publicIdentifier);
}
