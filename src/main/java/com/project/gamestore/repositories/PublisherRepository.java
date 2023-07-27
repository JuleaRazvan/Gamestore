package com.project.gamestore.repositories;

import java.util.UUID;
import org.springframework.stereotype.Repository;
import com.project.gamestore.entities.Publisher;

@Repository
public interface PublisherRepository extends PubliclyIdentifiableRepository<Publisher> {

    public void deleteByPublicIdentifier(UUID publicIdentifier);
}
