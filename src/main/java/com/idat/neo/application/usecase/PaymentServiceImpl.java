package com.idat.neo.application.usecase;

import com.idat.neo.domain.model.Payment;
import com.idat.neo.domain.repository.PaymentRepository;
import com.idat.neo.domain.service.PaymentService;
import com.idat.neo.entrypoints.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment findById(Long id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pago no encontrado con id " + id));
    }

    @Override
    public Payment save(Payment payment, Long enrollmentId) {
        return paymentRepository.save(payment, enrollmentId);
    }

    @Override
    public Payment update(Long id, Payment payment, Long enrollmentId) {
        Payment existing = findById(id);

        Payment updatePayment = new Payment(
                existing.id(),
                payment.enrollment(),
                payment.type(),
                payment.installmentNumber(),
                payment.amount(),
                payment.dueDate(),
                payment.paymentDate(),
                payment.status(),
                payment.paymentMethod(),
                payment.notes()
        );

        return paymentRepository.update(id, payment, enrollmentId);
    }

    @Override
    public void deleteById(Long id) {
        paymentRepository.deleteById(id);
    }
}
