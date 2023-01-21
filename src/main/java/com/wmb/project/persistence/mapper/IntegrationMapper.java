package com.wmb.project.persistence.mapper;

import com.wmb.project.domain.IntegrationD;
import com.wmb.project.persistence.entity.Integration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PersonMapper.class})
public interface IntegrationMapper {
    @Mappings({
            @Mapping(source = "id", target = "integrationId"),
            @Mapping(source = "token", target = "tokenD"),
            @Mapping(source = "creation_date", target = "creation_dateD"),
            @Mapping(source = "idPerson", target = "idPersonD"),
            @Mapping(source = "person", target = "personD"),
    })
    IntegrationD toIntegrationD(Integration integration);
    List<IntegrationD> toIntegrationDList(List<Integration> integrationList);

    @InheritInverseConfiguration
    Integration toIntegration(IntegrationD integrationD);
}
