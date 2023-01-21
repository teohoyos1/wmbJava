package com.wmb.project.domain;

import java.time.LocalDateTime;

public class Movement_walletD {
    private Integer movement_walletId;
    private String descriptionD;
    private Integer actual_valueD;
    private LocalDateTime record_dateD;
    private Integer idPaymentCategoryD;
    private Integer idWalletD;
    private Payment_categoryD payment_categoryD;
    private WalletD walletD;

    public Integer getMovement_walletId() {
        return movement_walletId;
    }

    public void setMovement_walletId(Integer movement_walletId) {
        this.movement_walletId = movement_walletId;
    }

    public String getDescriptionD() {
        return descriptionD;
    }

    public void setDescriptionD(String descriptionD) {
        this.descriptionD = descriptionD;
    }

    public Integer getActual_valueD() {
        return actual_valueD;
    }

    public void setActual_valueD(Integer actual_valueD) {
        this.actual_valueD = actual_valueD;
    }

    public LocalDateTime getRecord_dateD() {
        return record_dateD;
    }

    public void setRecord_dateD(LocalDateTime record_dateD) {
        this.record_dateD = record_dateD;
    }

    public Integer getIdPaymentCategoryD() {
        return idPaymentCategoryD;
    }

    public void setIdPaymentCategoryD(Integer idPaymentCategoryD) {
        this.idPaymentCategoryD = idPaymentCategoryD;
    }

    public Integer getIdWalletD() {
        return idWalletD;
    }

    public void setIdWalletD(Integer idWalletD) {
        this.idWalletD = idWalletD;
    }

    public Payment_categoryD getPayment_categoryD() {
        return payment_categoryD;
    }

    public void setPayment_categoryD(Payment_categoryD payment_categoryD) {
        this.payment_categoryD = payment_categoryD;
    }

    public WalletD getWalletD() {
        return walletD;
    }

    public void setWalletD(WalletD walletD) {
        this.walletD = walletD;
    }
}
