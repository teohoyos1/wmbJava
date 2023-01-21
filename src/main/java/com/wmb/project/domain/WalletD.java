package com.wmb.project.domain;

public class WalletD {
    private int walletId;
    private String nameD;
    private int balanceD;
    private int idPersonD;
    private int idBankD;
    private PersonD personD;
    private BankD bankD;

    public int getWalletId() {
        return walletId;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }

    public String getNameD() {
        return nameD;
    }

    public void setNameD(String nameD) {
        this.nameD = nameD;
    }

    public int getBalanceD() {
        return balanceD;
    }

    public void setBalanceD(int balanceD) {
        this.balanceD = balanceD;
    }

    public int getIdPersonD() {
        return idPersonD;
    }

    public void setIdPersonD(int idPersonD) {
        this.idPersonD = idPersonD;
    }

    public int getIdBankD() {
        return idBankD;
    }

    public void setIdBankD(int idBankD) {
        this.idBankD = idBankD;
    }

    public PersonD getPersonD() {
        return personD;
    }

    public void setPersonD(PersonD personD) {
        this.personD = personD;
    }

    public BankD getBankD() {
        return bankD;
    }

    public void setBankD(BankD bankD) {
        this.bankD = bankD;
    }
}
