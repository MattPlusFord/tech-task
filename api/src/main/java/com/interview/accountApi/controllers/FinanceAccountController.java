package com.interview.accountApi.controllers;

import com.interview.accountApi.models.FinnceAccount;
import com.interview.accountApi.models.UserAccount;
import com.interview.accountApi.services.FinanceAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FinanceAccountController {
    private final FinanceAccountService finance_account_service;

    @Autowired
    public FinanceAccountController(FinanceAccountService financeAccountService) {
        this.finance_account_service = financeAccountService;
    }

    @GetMapping("/users/{userId}/finance")
    public ResponseEntity<List<FinnceAccount>> loadAccount(@PathVariable Long userId) {
        List<FinnceAccount> financeAccount = finance_account_service.findByUserId(userId);
        return ResponseEntity.ok().body(financeAccount);
    }
}
