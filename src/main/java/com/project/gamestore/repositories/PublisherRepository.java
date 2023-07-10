package com.project.gamestore.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.gamestore.entities.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    public Optional<Publisher> findByPublicIdentifier(UUID publicIdentifier);

    public void deleteByPublicIdentifier(UUID publicIdentifier);
}
