package com.boot.controller;

import com.boot.model.Payment;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class PaymentValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Payment.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {

        System.out.print("here");

        Payment payment = (Payment) obj;

        // Added this is an example to demo how the request body can be checked and validate, this ensures type is included
        if (payment.getType() == null) {
            errors.rejectValue("type", "Empty");
        }
    }

}


