package com.osworks.osworksapi.api.model;

import java.time.OffsetDateTime;

public class CommentModel {
    
    private Long id;
    private String description;
    private OffsetDateTime sendDate;

    public Object getId() {
        return this.id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OffsetDateTime getSendDate() {
        return this.sendDate;
    }

    public void setSendDate(OffsetDateTime sendDate) {
        this.sendDate = sendDate;
    }

}