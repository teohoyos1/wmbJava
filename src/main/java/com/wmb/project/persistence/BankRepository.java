package com.wmb.project.persistence;

import com.wmb.project.domain.BankD;
import com.wmb.project.domain.repository.BankDRepository;
import com.wmb.project.persistence.crud.BankCrudRepository;
import com.wmb.project.persistence.entity.Bank;
import com.wmb.project.persistence.mapper.BankMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BankRepository implements BankDRepository {
    @Autowired
    BankCrudRepository bankCrudRepository;
    @Autowired
    BankMapper bankMapper;

    @ Override
    public List<BankD> getAllBanks() {
        List<Bank> listBanks = (List<Bank>) bankCrudRepository.findAll();
        return bankMapper.toBankDList(listBanks);
    }

    @Override
    public Optional<BankD> getBank(int bankId) {
        return bankCrudRepository.findById(bankId).map(bank -> bankMapper.toBankD(bank));
    }

    @Override
    public BankD save(BankD bankD) {
        Bank bank = bankMapper.toBank(bankD);
        return bankMapper.toBankD(bankCrudRepository.save(bank));
    }

    @Override
    public void delete(int bankId) {
        bankCrudRepository.deleteById(bankId);
    }

    @Override
    public BankD update(BankD bankD) {
        Bank bank = bankMapper.toBank(bankD);
        return bankMapper.toBankD(bankCrudRepository.save(bank));
    }
}
