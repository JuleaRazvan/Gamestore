package com.project.gamestore.repositories;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.gamestore.entities.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    public Optional<Review> findByPublicIdentifier(UUID publicIdentifier);

    public void deleteByPublicIdentifier(UUID publicIdentifier);
}
