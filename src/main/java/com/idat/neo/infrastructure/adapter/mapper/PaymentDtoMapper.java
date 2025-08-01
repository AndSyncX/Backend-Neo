package com.idat.neo.infrastructure.adapter.mapper;

import com.idat.neo.domain.model.Payment;
import com.idat.neo.entrypoints.dto.PaymentRequestDTO;
import com.idat.neo.entrypoints.dto.PaymentResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentDtoMapper {
    
    Payment toDomain(PaymentRequestDTO dto);

    PaymentResponseDTO toDto(Payment payment);
}
