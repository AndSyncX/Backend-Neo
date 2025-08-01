package com.idat.neo.infrastructure.adapter.repository;

import com.idat.neo.domain.model.Payment;
import com.idat.neo.domain.repository.PaymentRepository;
import com.idat.neo.entrypoints.exception.EntityNotFoundException;
import com.idat.neo.infrastructure.adapter.entity.PaymentData;
import com.idat.neo.infrastructure.adapter.mapper.PaymentMapper;
import com.idat.neo.infrastructure.adapter.persistence.PaymentDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PaymentRepositoryImpl implements PaymentRepository {

    private final PaymentDataRepository paymentDataRepository;
    private final PaymentMapper paymentMapper;

    @Override
    public List<Payment> findAll() {
        return paymentDataRepository.findAll()
                .stream()
                .map(paymentMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Payment> findById(Long id) {
        return paymentDataRepository.findById(id)
                .map(paymentMapper::toDomain);
    }

    @Override
    public Payment save(Payment payment, Long enrollmentId) {
        PaymentData entity = paymentMapper.toEntity(payment);
        PaymentData saved = paymentDataRepository.save(entity);
        return paymentMapper.toDomain(saved);
    }

    @Override
    public Payment update(Long id, Payment payment, Long enrollmentId) {
        PaymentData existing = paymentDataRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pago no encontrado con id " + id));

        existing.setType(payment.type());
        existing.setInstallmentNumber(payment.installmentNumber());
        existing.setAmount(payment.amount());
        existing.setDueDate(payment.dueDate());
        existing.setPaymentDate(payment.paymentDate());
        existing.setStatus(payment.status());
        existing.setPaymentMethod(payment.paymentMethod());
        existing.setNotes(payment.notes());

        PaymentData updated = paymentDataRepository.save(existing);
        return paymentMapper.toDomain(updated);
    }

    @Override
    public void deleteById(Long id) {
        PaymentData existing = paymentDataRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pago no encontrado con id " + id));
        paymentDataRepository.delete(existing);
    }
}
