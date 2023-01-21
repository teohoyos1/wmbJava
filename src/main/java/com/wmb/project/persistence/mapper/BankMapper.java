package com.wmb.project.persistence.mapper;

import com.wmb.project.domain.BankD;
import com.wmb.project.persistence.entity.Bank;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BankMapper {

    @Mappings({
            @Mapping(source = "id", target = "bankId"),
            @Mapping(source = "name", target = "nameD"),
    })
    BankD toBankD(Bank bank);
    List<BankD> toBankDList(List<Bank> bankList);

    @InheritInverseConfiguration
    @Mapping(target = "wallet", ignore = true)
    Bank toBank(BankD bankD);
}
