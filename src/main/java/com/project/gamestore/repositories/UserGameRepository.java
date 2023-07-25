package com.project.gamestore.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.gamestore.entities.UserGame;

@Repository
public interface UserGameRepository extends JpaRepository<UserGame, Long> {
    public Optional<UserGame> findByPublicIdentifier(UUID publicIdentifier);

    public void deleteByPublicIdentifier(UUID publicIdentifier);
}
