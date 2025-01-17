package com.interview.accountApi.services;

import com.interview.accountApi.models.FinnceAccount;
import com.interview.accountApi.models.UserAccount;
import com.interview.accountApi.repositories.FinanceAccountRepository;
import com.interview.accountApi.repositories.UserAccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FinanceAccountServiceTest {

    @Mock
    private FinanceAccountRepository financeAccountRepository;

    private FinanceAccountService financeAccountService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        financeAccountService = new FinanceAccountService(financeAccountRepository);
    }

    @Test
    public void testCheckFindAllReturnsAListOfFinanceAccountsIfAnyExists() {
        Long existingUserAccountId = 1L;
        String username = "David Rose";
        String email = "david.rose@ford.com";
        UserAccount existingUserAccount = new UserAccount(existingUserAccountId, username, email);
        List<FinnceAccount> expectedFinanceAccounts = new ArrayList<FinnceAccount>();
        expectedFinanceAccounts.add(new FinnceAccount(1L, existingUserAccount, (float) 1000.00, (float) 2.3));
        expectedFinanceAccounts.add(new FinnceAccount(2L, existingUserAccount, (float) 12354.00, (float) 2.5));
        when(financeAccountRepository.findByUser_Id(existingUserAccountId)).thenReturn(expectedFinanceAccounts);
        List<FinnceAccount> foundFinanceAccounts = financeAccountService.findByUserId(existingUserAccountId);
        assertEquals(foundFinanceAccounts.size(), 2);
        assertEquals(foundFinanceAccounts, expectedFinanceAccounts);
    }

    @Test
    public void testCheckFindAllReturnsEmptyListOfFinanceAccountsWhenNoneExistForUser() {
        List<FinnceAccount> expectedFinanceAccounts = new ArrayList<FinnceAccount>();
        Long nonExistingAccountId = 2L;
        when(financeAccountRepository.findByUser_Id(nonExistingAccountId)).thenReturn(expectedFinanceAccounts);
        List<FinnceAccount> foundFinanceAccounts = financeAccountService.findByUserId(nonExistingAccountId);
        assertEquals(foundFinanceAccounts.size(), 0);
    }
}
