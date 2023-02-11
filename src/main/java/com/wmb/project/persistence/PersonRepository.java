package com.wmb.project.persistence;

import com.wmb.project.domain.PersonD;
import com.wmb.project.domain.repository.PersonDRepository;
import com.wmb.project.persistence.crud.PersonCrudRepository;
import com.wmb.project.persistence.entity.Person;
import com.wmb.project.persistence.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepository implements PersonDRepository {
    @Autowired
    PersonCrudRepository personCrudRepository;

    @Autowired
    PersonMapper personMapper;

    public Person getByChatId(Long chatId){
        return personCrudRepository.findByChatId(chatId);
    }

    @Override
    public PersonD saveOrUpdateD(PersonD personD) {
        Person person = personMapper.toPerson(personD);
        return personMapper.toPersonD(personCrudRepository.save(person));
    }

    @Override
    public Person saveOrUpdate(Person person) {
        return personCrudRepository.save(person);
    }
}
