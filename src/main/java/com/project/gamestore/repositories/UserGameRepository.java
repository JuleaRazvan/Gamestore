package com.project.gamestore.repositories;

import java.util.UUID;
import org.springframework.stereotype.Repository;
import com.project.gamestore.entities.UserGame;

@Repository
public interface UserGameRepository extends PubliclyIdentifiableRepository<UserGame>{

    public void deleteByPublicIdentifier(UUID publicIdentifier);
}
