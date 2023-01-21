package com.wmb.project.persistence.mapper;

import com.wmb.project.domain.Movement_walletD;
import com.wmb.project.persistence.entity.Movement_wallet;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PaymentCategoryMapper.class, WalletMapper.class})
public interface MovementWalletMapper {

    @Mappings({
            @Mapping(source = "id", target = "movement_walletId"),
            @Mapping(source = "description", target = "descriptionD"),
            @Mapping(source = "actual_value", target = "actual_valueD"),
            @Mapping(source = "record_date", target = "record_dateD"),
            @Mapping(source = "idPaymentCategory", target = "idPaymentCategoryD"),
            @Mapping(source = "idWallet", target = "idWalletD"),
            @Mapping(source = "payment_category", target = "payment_categoryD"),
            @Mapping(source = "wallet", target = "walletD"),
    })
    Movement_walletD toMovementWalletD(Movement_wallet movement_wallet);
    List<Movement_walletD> toMovementWalletDList(List<Movement_wallet> movement_wallet);

    @InheritInverseConfiguration
    Movement_wallet toMovementWallet(Movement_walletD movement_walletD);

}
