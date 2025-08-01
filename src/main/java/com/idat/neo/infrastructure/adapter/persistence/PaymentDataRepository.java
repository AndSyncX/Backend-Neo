package com.idat.neo.infrastructure.adapter.persistence;

import com.idat.neo.infrastructure.adapter.entity.PaymentData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PaymentDataRepository extends JpaRepository<PaymentData, Long> {

    @Query("SELECT p FROM PaymentData p WHERE LOWER(p.status) = LOWER(:status)")
    Optional<PaymentData> findByStatus(String status);
}
