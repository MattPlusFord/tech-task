package com.interview.accountApi.controllers;

import com.interview.accountApi.models.UserAccount;
import com.interview.accountApi.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAccountController {
    private final UserAccountService userAccountService;

    @Autowired
    public UserAccountController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserAccount> loadAccount(@PathVariable Long userId) {
        UserAccount userAccount = userAccountService.findById(userId);
        if (userAccount == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(userAccount);
    }
}
