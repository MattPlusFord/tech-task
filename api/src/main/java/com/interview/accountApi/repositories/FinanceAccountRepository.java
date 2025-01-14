package com.interview.accountApi.repositories;

import com.interview.accountApi.models.FinnceAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;

import java.util.List;

@Repository
public interface FinanceAccountRepository extends JpaRepository<FinnceAccount, Long> {
    List<FinnceAccount> findByUser_Id(Long userId);
}
