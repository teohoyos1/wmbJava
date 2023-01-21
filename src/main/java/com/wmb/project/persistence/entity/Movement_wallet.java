package com.wmb.project.persistence.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Movement_wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String description;
    private Integer actual_value;
    private LocalDateTime record_date;

    @Column(name = "id_payment_category")
    private Integer idPaymentCategory;

    @Column(name = "id_wallet")
    private Integer idWallet;

    @ManyToOne
    @JoinColumn(name = "id_payment_category", insertable = false, updatable = false)
    private Payment_category payment_category;

    @ManyToOne
    @JoinColumn(name = "id_wallet", insertable = false, updatable = false)
    private Wallet wallet;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getActual_value() {
        return actual_value;
    }

    public void setActual_value(Integer actual_value) {
        this.actual_value = actual_value;
    }

    public LocalDateTime getRecord_date() {
        return record_date;
    }

    public void setRecord_date(LocalDateTime record_date) {
        this.record_date = record_date;
    }

    public Integer getIdPaymentCategory() {
        return idPaymentCategory;
    }

    public void setIdPaymentCategory(Integer idPaymentCategory) {
        this.idPaymentCategory = idPaymentCategory;
    }

    public Integer getIdWallet() {
        return idWallet;
    }

    public void setIdWallet(Integer idWallet) {
        this.idWallet = idWallet;
    }

    public Payment_category getPayment_category() {
        return payment_category;
    }

    public void setPayment_category(Payment_category payment_category) {
        this.payment_category = payment_category;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
}
