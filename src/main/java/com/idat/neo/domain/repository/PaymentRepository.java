package com.idat.neo.domain.repository;

import com.idat.neo.domain.model.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository {
    List<Payment> findAll();
    Optional<Payment> findById(Long id);
    Payment save(Payment payment, Long enrollmentId);
    Payment update(Long id, Payment payment, Long enrollmentId);
    void deleteById(Long id);
}
