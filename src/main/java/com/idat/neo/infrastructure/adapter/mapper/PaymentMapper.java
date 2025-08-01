package com.idat.neo.infrastructure.adapter.mapper;

import com.idat.neo.domain.model.Payment;
import com.idat.neo.infrastructure.adapter.entity.PaymentData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    @Mapping(source = "EnrollmentData", target = "Enrollment")
    Payment toDomain(PaymentData entity);

    @Mapping(source = "Enrollment", target = "EnrollmentData")
    PaymentData toEntity(Payment domain);
}
