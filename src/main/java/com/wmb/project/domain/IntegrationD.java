package com.wmb.project.domain;

import com.wmb.project.persistence.entity.Person;

import java.time.LocalDateTime;

public class IntegrationD {
    private int integrationId;
    private String tokenD;
    private LocalDateTime creation_dateD;
    private int idPersonD;
    private Person personD;

    public int getIntegrationId() {
        return integrationId;
    }

    public void setIntegrationId(int integrationId) {
        this.integrationId = integrationId;
    }

    public String getTokenD() {
        return tokenD;
    }

    public void setTokenD(String tokenD) {
        this.tokenD = tokenD;
    }

    public LocalDateTime getCreation_dateD() {
        return creation_dateD;
    }

    public void setCreation_dateD(LocalDateTime creation_dateD) {
        this.creation_dateD = creation_dateD;
    }

    public int getIdPersonD() {
        return idPersonD;
    }

    public void setIdPersonD(int idPersonD) {
        this.idPersonD = idPersonD;
    }

    public Person getPersonD() {
        return personD;
    }

    public void setPersonD(Person personD) {
        this.personD = personD;
    }
}
