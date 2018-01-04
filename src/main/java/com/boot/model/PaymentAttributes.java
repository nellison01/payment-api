package com.boot.model;

import javax.persistence.Embeddable;

@Embeddable
public class PaymentAttributes {

    private Double amount;

    private String currency;

    private String processingDate;

    public PaymentAttributes() { }

    public PaymentAttributes(Double amount, String currency, String processingDate) {
        this.amount = amount;
        this.currency = currency;
        this.processingDate = processingDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getProcessingDate() {
        return processingDate;
    }

    public void setProcessingDate(String processingDate) {
        this.processingDate = processingDate;
    }
}
