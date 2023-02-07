package com.wmb.project.persistence;

import com.wmb.project.domain.IntegrationD;
import com.wmb.project.domain.repository.IntegrationDRepository;
import com.wmb.project.persistence.crud.IntegrationCrudRepository;
import com.wmb.project.persistence.entity.Integration;
import com.wmb.project.persistence.mapper.IntegrationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IntegrationRepository implements IntegrationDRepository {

    @Autowired
    IntegrationCrudRepository integrationCrudRepository;

    @Autowired
    IntegrationMapper integrationMapper;

    public Integration getByChatId(Long chatId){
        return integrationCrudRepository.findByChatId(chatId);
    }

    @Override
    public IntegrationD saveOrUpdateD(IntegrationD integrationD) {
        Integration integration = integrationMapper.toIntegration(integrationD);
        return integrationMapper.toIntegrationD(integrationCrudRepository.save(integration));
    }

    @Override
    public Integration saveOrUpdate(Integration integration) {
        return integrationCrudRepository.save(integration);
    }
}
