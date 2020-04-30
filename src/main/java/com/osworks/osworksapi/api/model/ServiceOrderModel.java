package com.osworks.osworksapi.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.osworks.osworksapi.domain.model.Customer;
import com.osworks.osworksapi.domain.model.ServiceOrderStatus;

public class ServiceOrderModel {

    private Long id;
    private Customer customer;
    private String description;
    private BigDecimal price;
    private ServiceOrderStatus status;
    private OffsetDateTime openingDate;
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
	}

    

}