package com.boot;

import com.boot.controller.PaymentsController;
import com.boot.model.Payment;
import com.boot.service.PaymentService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PaymentsControllerTests {

    @InjectMocks
    private PaymentsController pc;

    @Mock
    private PaymentService paymentService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPaymentsGet() {

        String paymentId = "9445bcf4-ca43-402d-9542-d39a7eb2a58a";
        Payment p = new Payment();
        p.setId(paymentId);

        // mock paymentService get call and return payment object previously created
        when(paymentService.get(paymentId)).thenReturn(p);

        // Payment Controller get call
        Payment payment = pc.get(paymentId);

        // Verify the get on the payment service was called
        verify(paymentService).get(paymentId);

        // Assert the id of the object returned
        assertEquals(paymentId, payment.getId());
    }

}