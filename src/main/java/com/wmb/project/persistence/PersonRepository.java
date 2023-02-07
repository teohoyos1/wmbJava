package com.wmb.project.persistence;

import com.wmb.project.persistence.crud.PersonCrudRepository;
import com.wmb.project.persistence.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepository {
    @Autowired
    PersonCrudRepository personCrudRepository;

    public Person getByChatId(Long chatId){
        return personCrudRepository.findByChatId(chatId);
    }
}
