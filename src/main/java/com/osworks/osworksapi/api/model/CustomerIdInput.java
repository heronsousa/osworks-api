package com.osworks.osworksapi.api.model;

import javax.validation.constraints.NotNull;

public class CustomerIdInput {

    @NotNull
    private Long id;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}