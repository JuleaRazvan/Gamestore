package com.project.gamestore.repositories;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.project.gamestore.entities.Transaction;

@Repository
public interface TransactionRepository extends PubliclyIdentifiableRepository<Transaction> {
    public void deleteByPublicIdentifier(UUID publicIdentifier);

    @Query("from Transaction t where t.createdAt >= :startDate and t.createdAt < :endDate")
    List<Transaction> findTransactionsByDateRange(@Param("startDate") Instant startDate,
            @Param("endDate") Instant endDate);
}
