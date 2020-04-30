package com.osworks.osworksapi.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.osworks.osworksapi.domain.ValidationGroups;

@Entity
public class ServiceOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Valid      // Valida as propriedades da instancia
    @ConvertGroup(from = Default.class, to = ValidationGroups.CustomerId.class)     // Ao validar a instancia customer, vai validar apenas as propriedades q possuirem a anotação ValidationGroups.CustomerId
    @NotNull    // Verifica se possui a instancia customer
    @ManyToOne
    private Customer customer;
    
    @NotBlank
    private String description;
    
    @NotNull
    private BigDecimal price;

    @JsonProperty(access = Access.READ_ONLY)
    @Enumerated(EnumType.STRING)
    private ServiceOrderStatus status;
    
    @JsonProperty(access = Access.READ_ONLY)
    private OffsetDateTime openingDate;
    
    @JsonProperty(access = Access.READ_ONLY)
    private OffsetDateTime closingDate;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

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

    public ServiceOrderStatus getStatus() {
        return this.status;
    }

    public void setStatus(ServiceOrderStatus status) {
        this.status = status;
    }

    public OffsetDateTime getOpeningDate() {
        return this.openingDate;
    }

    public void setOpeningDate(OffsetDateTime openingDate) {
        this.openingDate = openingDate;
    }

    public OffsetDateTime getClosingDate() {
        return this.closingDate;
    }

    public void setClosingDate(OffsetDateTime closingDate) {
        this.closingDate = closingDate;
    };

}
    