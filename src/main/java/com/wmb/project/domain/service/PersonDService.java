package com.wmb.project.domain.service;

import com.wmb.project.domain.PersonD;
import com.wmb.project.domain.repository.PersonDRepository;
import com.wmb.project.persistence.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonDService {

    @Autowired
    PersonDRepository personDRepository;

    public PersonD saveOrUpdateD(PersonD personD){
        return personDRepository.saveOrUpdateD(personD);
    }

    public Person saveOrUpdate(Person person){
        return personDRepository.saveOrUpdate(person);
    }
}
