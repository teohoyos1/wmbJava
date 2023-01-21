package com.wmb.project.web.controller;

import com.wmb.project.domain.Payment_categoryD;
import com.wmb.project.domain.repository.Payment_categoryDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payments")
public class Payment_categoryController {
    @Autowired
    Payment_categoryDRepository payment_categoryDRepository;

    @GetMapping("/all")
    public List<Payment_categoryD> getAll(){
        return payment_categoryDRepository.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Payment_categoryD> getPayment_category(@PathVariable("id") int id){
        return payment_categoryDRepository.getPayment_category(id);
    }

    @PostMapping("/save")
    public Payment_categoryD save(@RequestBody Payment_categoryD payment_categoryD){
        return payment_categoryDRepository.save(payment_categoryD);
    }

    @DeleteMapping("/delete/{id}")
    public List<Payment_categoryD> delete(@PathVariable("id") int id){
        payment_categoryDRepository.delete(id);
        return getAll();
    }
}