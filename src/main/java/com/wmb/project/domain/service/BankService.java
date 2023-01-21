package com.wmb.project.domain.service;

import com.wmb.project.domain.BankD;

import com.wmb.project.domain.dto.repository.BankDRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankService {
    @Autowired
    BankDRepository bankDRepository;

    public List<BankD> getAllBanks(){
        return bankDRepository.getAllBanks();
    }

    public Optional<BankD> getBank(int bankId){
        return bankDRepository.getBank(bankId);
    }

    public BankD save(BankD bankD){
        return bankDRepository.save(bankD);
    }

    public boolean delete(int bankId){
        return getBank(bankId).map(bankD -> {
            bankDRepository.delete(bankId);
            return  true;
        }).orElse(false);
    }

    public BankD update(BankD bankD){
        return bankDRepository.save(bankD);
    }
}
