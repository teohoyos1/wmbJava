package com.wmb.project.domain.repository;

import com.wmb.project.domain.BankD;

import java.util.List;
import java.util.Optional;

public interface BankDRepository {
    List<BankD> getAllBanks();
    Optional<BankD> getBank(int bankId);
    BankD save(BankD bankD);
    void delete(int bankId);
    BankD update(BankD bankD);
}
