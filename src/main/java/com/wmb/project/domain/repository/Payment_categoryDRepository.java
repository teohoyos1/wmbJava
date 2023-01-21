package com.wmb.project.domain.repository;

import com.wmb.project.domain.Payment_categoryD;

import java.util.List;
import java.util.Optional;

public interface Payment_categoryDRepository {
    List<Payment_categoryD> getAll();
    Optional<Payment_categoryD> getPayment_category(int paymentCategoryId);
    Payment_categoryD save(Payment_categoryD payment_categoryD);
    void delete(int paymentCategoryId);
}
