package com.project.gamestore.repositories;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;
import com.project.gamestore.entities.UserGame;

@Repository
public interface UserGameRepository extends PubliclyIdentifiableRepository<UserGame>{

    public void deleteByPublicIdentifier(UUID publicIdentifier);
    public List<UserGame> findAllByUser_PublicIdentifier(UUID userPublicIdentifier);
    public void deleteByUser_PublicIdentifierAndGame_PublicIdentifier(UUID userPublicIdentifier, UUID gamePublicIdentifier); 
}
