package com.boot.controller;

import com.boot.model.Payment;
import com.boot.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/payments")
public class PaymentsController {

    @Autowired
    private PaymentService paymentService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        // Set up custom validator, to check request body where appropriate
        binder.setValidator(new PaymentValidator());
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Payment> list() {
        return paymentService.list();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Payment create(@Valid @RequestBody Payment payment) {
        return paymentService.create(payment);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Payment get(@PathVariable String id) {
        return paymentService.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Payment update(@PathVariable String id, @Valid @RequestBody Payment payment) {
        return paymentService.update(id, payment);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Payment delete(@PathVariable String id) {
        return paymentService.delete(id);
    }

}
