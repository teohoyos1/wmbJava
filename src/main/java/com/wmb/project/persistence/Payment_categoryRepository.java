package com.wmb.project.persistence;

import com.wmb.project.domain.Payment_categoryD;
import com.wmb.project.domain.repository.Payment_categoryDRepository;
import com.wmb.project.persistence.crud.PaymentCategoryCrudRepository;
import com.wmb.project.persistence.entity.Payment_category;
import com.wmb.project.persistence.mapper.PaymentCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class Payment_categoryRepository implements Payment_categoryDRepository {
    @Autowired
    PaymentCategoryCrudRepository paymentCategoryCrudRepository;
    @Autowired
    PaymentCategoryMapper paymentCategoryMapper;
    @Override
    public List<Payment_categoryD> getAll() {
        List<Payment_category> payment_categories = (List<Payment_category>) paymentCategoryCrudRepository.findAll();
        return paymentCategoryMapper.toPaymentCategoryDList(payment_categories);
    }

    @Override
    public Optional<Payment_categoryD> getPayment_category(int paymentCategoryId) {
        return paymentCategoryCrudRepository.findById(paymentCategoryId).map(payment_category -> paymentCategoryMapper.toPaymentCategoryD(payment_category));
    }

    @Override
    public Payment_categoryD save(Payment_categoryD payment_categoryD) {
        Payment_category payment_category = paymentCategoryMapper.toPaymentCategory(payment_categoryD);
        return paymentCategoryMapper.toPaymentCategoryD(paymentCategoryCrudRepository.save(payment_category));
    }

    @Override
    public void delete(int paymentCategoryId) {
        paymentCategoryCrudRepository.deleteById(paymentCategoryId);
    }
}
