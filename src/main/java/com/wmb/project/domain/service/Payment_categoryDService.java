package com.wmb.project.domain.service;

import com.wmb.project.domain.Payment_categoryD;
import com.wmb.project.domain.repository.Payment_categoryDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Payment_categoryDService {
    @Autowired
    Payment_categoryDRepository payment_categoryDRepository;

    public List<Payment_categoryD> getAll(){
        return payment_categoryDRepository.getAll();
    }

    public Optional<Payment_categoryD> getPayment_category(int paymentCategoryId){
        return payment_categoryDRepository.getPayment_category(paymentCategoryId);
    }

    public Payment_categoryD save(Payment_categoryD payment_categoryD){
        return payment_categoryDRepository.save(payment_categoryD);
    }

    public boolean delete(int paymentCategoryId){
        return payment_categoryDRepository.getPayment_category(paymentCategoryId).map(payment_categoryD -> {
            payment_categoryDRepository.delete(paymentCategoryId);
            return true;
        }).orElse(false);
    }
}
