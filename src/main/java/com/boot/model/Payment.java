package com.boot.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Payment {

    @Id
    private String id;

    @NotNull
    private Type type;

    @NotNull
    private Integer version;

    @NotNull
    private String orgId;

    @Embedded
    private PaymentAttributes attributes;

    public Payment() { }

    public Payment(String id, Type type, Integer version, String orgId, PaymentAttributes attributes) {
        this.id = id;
        this.type = type;
        this.version = version;
        this.orgId = orgId;
        this.attributes = attributes;
    }

    public String getId() { return id; }

    public void setId(String id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public PaymentAttributes getAttributes() {
        return attributes;
    }

    public enum Type {
        PAYMENT
    }
}
