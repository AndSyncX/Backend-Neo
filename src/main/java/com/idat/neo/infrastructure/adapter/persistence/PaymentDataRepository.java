package com.idat.neo.infrastructure.adapter.persistence;

import com.idat.neo.infrastructure.adapter.entity.PaymentData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDataRepository extends JpaRepository<PaymentData, Long> {
}
