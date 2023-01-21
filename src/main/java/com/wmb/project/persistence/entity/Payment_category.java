package com.wmb.project.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Payment_category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "payment_category")
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

    public List<Movement_wallet> getMovement_wallet() {
        return movement_wallet;
    }

    public void setMovement_wallet(List<Movement_wallet> movement_wallet) {
        this.movement_wallet = movement_wallet;
    }
}
