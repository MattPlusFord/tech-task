package com.interview.accountApi.services;

import com.interview.accountApi.models.UserAccount;
import com.interview.accountApi.repositories.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountService {
    private final UserAccountRepository userAccountRepository;

    @Autowired
    public UserAccountService(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    public UserAccount findById(Long id) {
        return userAccountRepository.findById(id).orElse(null);
    }
}
