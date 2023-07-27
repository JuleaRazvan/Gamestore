package com.project.gamestore.repositories;

import java.util.UUID;
import org.springframework.stereotype.Repository;
import com.project.gamestore.entities.Review;

@Repository
public interface ReviewRepository extends PubliclyIdentifiableRepository<Review> {
    public void deleteByPublicIdentifier(UUID publicIdentifier);
}
