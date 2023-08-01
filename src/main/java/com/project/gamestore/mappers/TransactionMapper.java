package com.project.gamestore.mappers;

import org.springframework.stereotype.Component;
import com.project.gamestore.dtos.TransactionApi;
import com.project.gamestore.dtos.TransactionDTO;
import com.project.gamestore.entities.Game;
import com.project.gamestore.entities.Transaction;
import com.project.gamestore.entities.User;
import com.project.gamestore.repositories.GameRepository;
import com.project.gamestore.repositories.UserRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class TransactionMapper {

    private UserRepository userRepository;

    private GameRepository gameRepository;

    public TransactionDTO mapEntityToDTO(Transaction transaction) {
        return TransactionDTO.builder()
                .publicIdentifier(transaction.getPublicIdentifier())
                .price(transaction.getPrice())
                .type(transaction.getType())
                .userId(transaction.getUser().getPublicIdentifier())
                .gameId(transaction.getGame().getPublicIdentifier())
                .createdAt(transaction.getCreatedAt())
                .lastUpdatedAt(transaction.getLastUpdatedAt())
                .build();
    }

    public Transaction mapApiToEntity(TransactionApi transactionApi) {
        User user = userRepository.findByPublicIdentifierMandatory(transactionApi.getUserId());
        Game game = gameRepository.findByPublicIdentifierMandatory(transactionApi.getGameId());

        return Transaction.builder()
                .price(transactionApi.getPrice())
                .type(transactionApi.getType())
                .user(user)
                .game(game)
                .build();
    }
}
