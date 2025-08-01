package com.idat.neo.domain.service;

import com.idat.neo.domain.model.Payment;

import java.util.List;

public interface PaymentService {

    List<Payment> findAll();

    Payment findById(Long id);

    Payment findByStatus(String status);

    Payment save(Payment payment, Long enrollmentId);

    Payment update(Long id, Payment payment, Long enrollmentId);

    void deleteById(Long id);
}
