package com.project.gamestore.repositories;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;
import com.project.gamestore.entities.Game;

@Repository
public interface GameRepository extends PubliclyIdentifiableRepository<Game>{
    
    public void deleteByPublicIdentifier(UUID publicIdentifier);
    public List<Game> findAllByPublisher_PublicIdentifier(UUID publicIdentifier);
}
