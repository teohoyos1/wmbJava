package com.wmb.project.persistence.mapper;

import com.wmb.project.domain.PersonD;
import com.wmb.project.persistence.entity.Person;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mappings({
            @Mapping(source = "id", target = "personId"),
            @Mapping(source = "username", target = "usernameD"),
            @Mapping(source = "first_name", target = "first_nameD"),
            @Mapping(source = "last_name", target = "last_nameD"),
            @Mapping(source = "email", target = "emailD"),
            @Mapping(source = "phone", target = "phoneD"),
            @Mapping(source = "password", target = "passwordD"),
    })
    PersonD toPersonD(Person person);
    List<PersonD> toPersonDList(List<Person> personList);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "wallet", ignore = true),
            @Mapping(target = "integration", ignore = true),
    })
    Person toPerson(PersonD personD);


}
