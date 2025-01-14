package com.interview.accountApi.services;

import com.interview.accountApi.models.UserAccount;
import com.interview.accountApi.repositories.UserAccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserAccountServiceTests {

    @Mock
    private UserAccountRepository userAccountRepository;

    private UserAccountService userAccountService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        userAccountService = new UserAccountService(userAccountRepository);
    }

    @Test
    public void testCheckFindByIdReturnsAUserAccountIfAccountExists() {
        Long existingAccountId = 1L;
        String username = "David Rose";
        String email = "david.rose@ford.com";
        UserAccount expectedUserAccount = new UserAccount(existingAccountId, username, email);
        Optional<UserAccount> existingUserAccount = Optional.of(expectedUserAccount);
        when(userAccountRepository.findById(existingAccountId)).thenReturn(existingUserAccount);
        UserAccount foundUserAccount = userAccountService.findById(existingAccountId);
        assertEquals(foundUserAccount.getId(), existingAccountId);
        assertEquals(foundUserAccount.getName(), username);
        assertEquals(foundUserAccount.getEmail(), email);
    }

    @Test
    public void testCheckFindByIdReturnsNullIfAccountDoesNotExists() {
        Optional<UserAccount> missingUserAccount = Optional.empty();
        Long nonExistingAccountId = 2L;
        when(userAccountRepository.findById(nonExistingAccountId)).thenReturn(missingUserAccount);
        UserAccount foundUserAccount = userAccountService.findById(nonExistingAccountId);
        assertNull(foundUserAccount);
    }
}