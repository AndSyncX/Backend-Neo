package com.idat.neo.infrastructure.adapter.mapper;

import com.idat.neo.domain.model.Payment;
import com.idat.neo.infrastructure.adapter.entity.PaymentData;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    Payment toDomain(PaymentData entity);

    PaymentData toEntity(Payment domain);
}
