package com.wmb.project.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer balance;

    @Column(name = "id_person")
    private Integer idPerson;

    @Column(name = "id_bank")
    private Integer idBank;

    @ManyToOne
    @JoinColumn(name = "id_person", insertable = false, updatable = false)
    private Person person;

    @ManyToOne
    @JoinColumn(name = "id_bank", insertable = false, updatable = false)
    private Bank bank;

    @OneToMany(mappedBy = "wallet")
    private List<Movement_wallet> movement_wallet;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }

    public Integer getIdBank() {
        return idBank;
    }

    public void setIdBank(Integer idBank) {
        this.idBank = idBank;
    }

    public List<Movement_wallet> getMovement_wallet() {
        return movement_wallet;
    }

    public void setMovement_wallet(List<Movement_wallet> movement_wallet) {
        this.movement_wallet = movement_wallet;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
