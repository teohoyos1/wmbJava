package com.wmb.project.persistence.crud;

import com.wmb.project.persistence.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonCrudRepository extends CrudRepository<Person, Integer> {

    Person findByChatId(Long chatId);

    Long deleteByChatId(Long chatId);
}
