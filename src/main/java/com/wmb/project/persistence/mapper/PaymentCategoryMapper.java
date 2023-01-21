package com.wmb.project.persistence.mapper;

import com.wmb.project.domain.Payment_categoryD;
import com.wmb.project.persistence.entity.Payment_category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentCategoryMapper {
    @Mappings({
            @Mapping(source = "id", target = "paymentCategoryId"),
            @Mapping(source = "name", target = "nameD"),
    })
    Payment_categoryD toPaymentCategoryD(Payment_category payment_category);
    List<Payment_categoryD> toPaymentCategoryDList(List<Payment_category> payment_categoryList);

    @InheritInverseConfiguration
    @Mapping(target = "movement_wallet", ignore = true)
    Payment_category toPaymentCategory(Payment_categoryD payment_categoryD);
}
