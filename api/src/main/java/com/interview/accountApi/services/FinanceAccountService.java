package com.interview.accountApi.services;

import com.interview.accountApi.models.FinnceAccount;
import com.interview.accountApi.repositories.FinanceAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinanceAccountService {
    private FinanceAccountRepository financeAccountRepository;

    @Autowired
    public FinanceAccountService(FinanceAccountRepository financeAccountRepository) {
        this.financeAccountRepository = financeAccountRepository;
    }

    public List<FinnceAccount> findByUserId(Long usorId) {
        return financeAccountRepository.findByUser_Id(usorId);
    }
}
