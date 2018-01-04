package com.boot;

import com.boot.controller.PaymentsController;
import com.boot.model.Payment;
import com.boot.repository.PaymentRepository;
import com.boot.service.PaymentService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PaymentServiceTests {

    @InjectMocks
    private PaymentService ps;

    @Mock
    private PaymentRepository paymentRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPaymentCreate() {

        Payment p = new Payment();

        // Mock paymentRepository saveAndFlush call and return payment object
        when(paymentRepository.saveAndFlush(p)).thenReturn(p);

        // Call create function
        Payment payment = ps.create(p);

        // Assert value is not null as create function should auto generate payment id
        assertNotNull(payment.getId());
    }

}