package com.interview.accountApi.services;

import com.interview.accountApi.models.UserAccount;
import com.interview.accountApi.repositories.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountService {
    @Autowired
    private UserAccountRepository userAccountRepository;

    public List<UserAccount> findAll() {
        return userAccountRepository.findAll();
    }

    public UserAccount findById(Long id) {
        return userAccountRepository.findById(id).orElse(null);
    }
}
