package com.project.gamestore.repositories;
import java.util.UUID;
import org.springframework.stereotype.Repository;

import com.project.gamestore.entities.Genre;

@Repository
public interface GenreRepository extends PubliclyIdentifiableRepository<Genre> {
    
    public void deleteByPublicIdentifier(UUID publicIdentifier);
}
