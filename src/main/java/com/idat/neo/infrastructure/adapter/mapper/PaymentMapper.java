package com.idat.neo.infrastructure.adapter.mapper;

import com.idat.neo.domain.model.Payment;
import com.idat.neo.infrastructure.adapter.entity.PaymentData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    @Mapping(source = "enrollmentData", target = "enrollment")
    Payment toDomain(PaymentData entity);

    @Mapping(source = "enrollment", target = "enrollmentData")
    PaymentData toEntity(Payment domain);
}
