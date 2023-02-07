package com.wmb.project.domain.repository;

import com.wmb.project.domain.IntegrationD;
import com.wmb.project.persistence.entity.Integration;

public interface IntegrationDRepository {

    IntegrationD saveOrUpdateD(IntegrationD integrationD);

    Integration saveOrUpdate(Integration integration);
}
