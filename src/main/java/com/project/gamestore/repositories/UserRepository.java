package com.project.gamestore.repositories;

import java.util.UUID;
import org.springframework.stereotype.Repository;
import com.project.gamestore.entities.User;

@Repository
public interface UserRepository extends PubliclyIdentifiableRepository<User> {

    public void deleteByPublicIdentifier(UUID publicIdentifier);
}