package com.project.gamestore.repositories;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import com.project.gamestore.exceptions.EntityNotFoundException;

@NoRepositoryBean
public interface PubliclyIdentifiableRepository<T> extends JpaRepository<T, Long> {
    Optional<T> findByPublicIdentifier(UUID publicIdentifier);

    default T findByPublicIdentifierMandatory(UUID publicIdentifier) {
        return findByPublicIdentifier(publicIdentifier)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Could not found entity with public identifier: " + publicIdentifier));
    }
}
