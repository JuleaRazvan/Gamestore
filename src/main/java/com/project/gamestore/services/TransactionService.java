package com.project.gamestore.services;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;
import com.project.gamestore.dtos.TransactionApi;
import com.project.gamestore.dtos.TransactionDTO;
import com.project.gamestore.entities.Game;
import com.project.gamestore.entities.Transaction;
import com.project.gamestore.entities.User;
import com.project.gamestore.mappers.TransactionMapper;
import com.project.gamestore.repositories.GameRepository;
import com.project.gamestore.repositories.TransactionRepository;
import com.project.gamestore.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TransactionService {

    private TransactionMapper transactionMapper;

    private TransactionRepository transactionRepository;

    private UserRepository userRepository;

    private GameRepository gameRepository;

    public TransactionDTO create(TransactionApi transactionApi) {
        Transaction transaction = transactionMapper.mapApiToEntity(transactionApi);
        Transaction createdTransaction = transactionRepository.save(transaction);
        return transactionMapper.mapEntityToDTO(createdTransaction);
    }

    public List<TransactionDTO> findAll() {
        return transactionRepository.findAll().stream()
                .map(transaction -> transactionMapper.mapEntityToDTO(transaction))
                .toList();
    }

    public TransactionDTO getByPublicIdentifier(UUID publicIdentifier) {
        Transaction foundTransaction = transactionRepository.findByPublicIdentifierMandatory(publicIdentifier);
        return transactionMapper.mapEntityToDTO(foundTransaction);
    }

    public TransactionDTO update(TransactionApi transactionApi, UUID publicIdentifier) {
        Transaction updateTransaction = transactionRepository.findByPublicIdentifierMandatory(publicIdentifier);
        updateTransaction.setPrice(transactionApi.getPrice());
        updateTransaction.setType(transactionApi.getType());

        User user = userRepository.findByPublicIdentifierMandatory(transactionApi.getUserId());
        updateTransaction.setUser(user);

        Game game = gameRepository.findByPublicIdentifierMandatory(transactionApi.getGameId());
        updateTransaction.setGame(game);
        updateTransaction = transactionRepository.save(updateTransaction);

        return transactionMapper.mapEntityToDTO(updateTransaction);
    }

    @Transactional
    public void delete(UUID publicIdentifier) {
        transactionRepository.deleteByPublicIdentifier(publicIdentifier);
    }
}