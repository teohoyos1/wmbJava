package com.wmb.project.domain.service;

import com.wmb.project.domain.IntegrationD;
import com.wmb.project.domain.repository.IntegrationDRepository;
import com.wmb.project.persistence.entity.Integration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IntegrationDService {

    @Autowired
    IntegrationDRepository integrationDRepository;

    public IntegrationD saveOrUpdateD(IntegrationD integrationD){
        return integrationDRepository.saveOrUpdateD(integrationD);
    }

    public Integration saveOrUpdate(Integration integration){
        return integrationDRepository.saveOrUpdate(integration);
    }
}
