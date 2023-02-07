package com.wmb.project.domain;

import com.wmb.project.persistence.entity.Person;
import com.wmb.project.persistence.entity.Step;

import java.time.LocalDateTime;

public class IntegrationD {
    private int integrationId;
    private Long chatIdD;
    private String logIdD;
    private LocalDateTime creation_dateD;
    private Step stepD;

    public int getIntegrationId() {
        return integrationId;
    }

    public void setIntegrationId(int integrationId) {
        this.integrationId = integrationId;
    }

    public Long getChatIdD() {
        return chatIdD;
    }

    public void setChatIdD(Long chatIdD) {
        this.chatIdD = chatIdD;
    }

    public LocalDateTime getCreation_dateD() {
        return creation_dateD;
    }

    public void setCreation_dateD(LocalDateTime creation_dateD) {
        this.creation_dateD = creation_dateD;
    }

    public String getLogIdD() {
        return logIdD;
    }

    public void setLogIdD(String logIdD) {
        this.logIdD = logIdD;
    }

    public Step getStepD() {
        return stepD;
    }

    public void setStepD(Step stepD) {
        this.stepD = stepD;
    }
}
