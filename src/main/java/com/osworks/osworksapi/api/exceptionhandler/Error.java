package com.osworks.osworksapi.api.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Error {

    private Integer status;
    private OffsetDateTime dateTime;
    private String title;
    private List<Input> inputs;

    public static class Input {
        private String name;
        private String message;

        public Input(String name, String message) {
            super();
            this.name = name;
            this.message = message;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public OffsetDateTime getDateTime() {
        return this.dateTime;
    }

    public void setDateTime(OffsetDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Input> getInputs() {
        return this.inputs;
    }

    public void setInputs(List<Input> input) {
        this.inputs = input;
    }
}