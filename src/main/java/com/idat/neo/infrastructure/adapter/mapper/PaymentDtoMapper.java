package com.idat.neo.infrastructure.adapter.mapper;

import com.idat.neo.domain.model.Payment;
import com.idat.neo.entrypoints.dto.PaymentRequestDTO;
import com.idat.neo.entrypoints.dto.PaymentResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaymentDtoMapper {

    Payment toDomain(PaymentRequestDTO dto);

    @Mapping(source = "enrollment.id", target = "enrollmentId")
    PaymentResponseDTO toDto(Payment payment);
}
