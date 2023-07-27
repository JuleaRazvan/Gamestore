package com.project.gamestore.repositories;

import java.util.UUID;
import org.springframework.stereotype.Repository;
import com.project.gamestore.entities.Game;

@Repository
public interface GameRepository extends PubliclyIdentifiableRepository<Game>{
    
    public void deleteByPublicIdentifier(UUID publicIdentifier);
}
