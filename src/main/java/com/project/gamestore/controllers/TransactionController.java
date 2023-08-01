package com.project.gamestore.controllers;

import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.project.gamestore.dtos.TransactionApi;
import com.project.gamestore.dtos.TransactionDTO;
import com.project.gamestore.routes.Routes;
import com.project.gamestore.services.TransactionService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class TransactionController {

    private TransactionService transactionService;

    @PostMapping(Routes.TRANSACTIONS_ROOT)
    public TransactionDTO create(@RequestBody TransactionApi transactionApi) {
        return transactionService.create(transactionApi);
    }

    @GetMapping(Routes.TRANSACTIONS_ROOT)
    public List<TransactionDTO> findAll() {
        return transactionService.findAll();
    }

    @GetMapping(Routes.TRANSACTIONS_ENTRY)
    public TransactionDTO findByPublicIdentifier(@PathVariable UUID publicIdentifier) {
        return transactionService.getByPublicIdentifier(publicIdentifier);
    }

    @PutMapping(Routes.TRANSACTIONS_ENTRY)
    public TransactionDTO update(@RequestBody TransactionApi transactionApi, @PathVariable UUID publicIdentifier) {
        return transactionService.update(transactionApi, publicIdentifier);
    }

    @DeleteMapping(Routes.TRANSACTIONS_ENTRY)
    public void delete(@PathVariable UUID publicIdentifier) {
        transactionService.delete(publicIdentifier);
    }
}