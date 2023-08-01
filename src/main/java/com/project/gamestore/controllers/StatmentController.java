package com.project.gamestore.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.gamestore.routes.Routes;
import com.project.gamestore.utils.StatmentGenerator;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@RestController
@AllArgsConstructor
public class StatmentController {

    private StatmentGenerator statmentGenerater;

    @GetMapping(Routes.STATEMENTS_DAILY)
    @SneakyThrows
    public void generateDailyStatment() {
        statmentGenerater.generateDailyStatment();
    }
}
