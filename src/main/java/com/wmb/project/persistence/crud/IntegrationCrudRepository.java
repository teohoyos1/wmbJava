package com.wmb.project.persistence.crud;

import com.wmb.project.persistence.entity.Integration;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IntegrationCrudRepository extends CrudRepository<Integration, Integer> {
    Integration findByChatId(Long chatId);
    Long deleteByChatId(Long chatId);
}
