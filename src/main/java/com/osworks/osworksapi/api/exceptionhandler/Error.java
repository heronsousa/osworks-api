package com.osworks.osworksapi.api.exceptionhandler;

import java.time.LocalDateTime;

public class Error {

    private Integer status;
    private LocalDateTime dateTime;
    private String title;

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getDateTime() {
        return this.dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}