package com.boot.service;

import com.boot.model.Payment;
import com.boot.repository.PaymentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> list() {
        return paymentRepository.findAll();
    }

    public Payment get(String id) {
        return paymentRepository.findOne(id);
    }

    public Payment create(Payment payment) {
        // Generate id to ensure it's unique (do not allow user to generate id)
        payment.setId(UUID.randomUUID().toString());

        return paymentRepository.saveAndFlush(payment);
    }

    public Payment update(String id, Payment newPayment) {
        // Retrieve existing payment from db
        Payment existingPayment = paymentRepository.findOne(id);
        // Update existing payment properties
        BeanUtils.copyProperties(newPayment, existingPayment);
        // Save and return payment
        return paymentRepository.saveAndFlush(existingPayment);
    }

    public Payment delete(String id) {
        // Retrieve existing payment from db
        Payment existingPayment = paymentRepository.findOne(id);
        // Delete existing payment from db
        paymentRepository.delete(existingPayment);
        // return delete payment
        return existingPayment;
    }
}
