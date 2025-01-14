package com.interview.accountApi.controllers;

import com.interview.accountApi.models.UserAccount;
import com.interview.accountApi.services.UserAccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserAccountControllerTest {
    @Mock
    private UserAccountService userAccountService;

    private UserAccountController userAccountController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        userAccountController = new UserAccountController(userAccountService);
    }

    @Test
    public void testCheckLoadAccountReturns200AndAUserAccountIfAccountExists() {
        Long existingAccountId = 1L;
        String username = "David Rose";
        String email = "david.rose@ford.com";
        UserAccount existingUserAccount = new UserAccount(existingAccountId, username, email);
        when(userAccountService.findById(existingAccountId)).thenReturn(existingUserAccount);
        ResponseEntity<UserAccount> loadAccountResponse = userAccountController.loadAccount(existingAccountId);
        UserAccount loadedUserAccount = loadAccountResponse.getBody();
        assertEquals(HttpStatus.OK, loadAccountResponse.getStatusCode());
        assertNotNull(loadedUserAccount);
        assertEquals(loadedUserAccount.getId(), existingAccountId);
        assertEquals(loadedUserAccount.getName(), username);
        assertEquals(loadedUserAccount.getEmail(), email);
    }

    @Test
    public void testCheckFindByIdReturns404AndNullIfAccountDoesNotExists() {
        UserAccount missingUserAccount = null;
        Long nonExistingAccountId = 2L;
        when(userAccountService.findById(nonExistingAccountId)).thenReturn(missingUserAccount);
        ResponseEntity<UserAccount> loadAccountResponse = userAccountController.loadAccount(nonExistingAccountId);
        assertEquals(HttpStatus.NOT_FOUND, loadAccountResponse.getStatusCode());
        UserAccount loadedUserAccount = loadAccountResponse.getBody();
        assertNull(loadedUserAccount);
    }
}
