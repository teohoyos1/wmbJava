package com.wmb.project.persistence.mapper;

import com.wmb.project.domain.WalletD;
import com.wmb.project.persistence.entity.Wallet;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PersonMapper.class, BankMapper.class})
public interface WalletMapper {
    @Mappings({
        @Mapping(source = "id", target = "walletId"),
        @Mapping(source = "name", target = "nameD"),
        @Mapping(source = "balance", target = "balanceD"),
        @Mapping(source = "idPerson", target = "idPersonD"),
        @Mapping(source = "idBank", target = "idBankD"),
        @Mapping(source = "person", target = "personD"),
        @Mapping(source = "bank", target = "bankD"),
    })
    WalletD toWalletD(Wallet wallet);
    List<WalletD> toWalletDList(List<Wallet> wallet);

    @InheritInverseConfiguration
    @Mapping(target = "movement_wallet", ignore = true)
    Wallet toWallet(WalletD walletD);
}
