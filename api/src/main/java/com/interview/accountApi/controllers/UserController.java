package com.interview.accountApi.controllers;

import com.interview.accountApi.models.UserAccount;
import com.interview.accountApi.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserAccountService userAccountService;

    @GetMapping("/users/{userId}")
    public UserAccount index(@PathVariable Long userId) {
        return userAccountService.findById(userId);
    }
}
