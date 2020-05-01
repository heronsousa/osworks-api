package com.osworks.osworksapi.api.model;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ServiceOrderInput {

    @NotBlank
    private String description;

    @NotNull
    private BigDecimal price;
    
    @Valid      // Valida as propriedades da instancia
    @NotNull
    private CustomerIdInput customer;

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public CustomerIdInput getCustomer() {
        return this.customer;
    }

    public void setCustomerId(CustomerIdInput customer) {
        this.customer = customer;
    }

}