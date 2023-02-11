package com.wmb.project.domain.repository;

import com.wmb.project.domain.PersonD;
import com.wmb.project.persistence.entity.Person;

public interface PersonDRepository {

    PersonD saveOrUpdateD(PersonD personD);

    Person saveOrUpdate(Person person);
}
