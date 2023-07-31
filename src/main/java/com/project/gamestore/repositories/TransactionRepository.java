package com.project.gamestore.repositories;

import java.util.UUID;
import org.springframework.stereotype.Repository;
import com.project.gamestore.entities.Transaction;

@Repository
public interface TransactionRepository extends PubliclyIdentifiableRepository<Transaction> {
    public void deleteByPublicIdentifier(UUID publicIdentifier);
}
