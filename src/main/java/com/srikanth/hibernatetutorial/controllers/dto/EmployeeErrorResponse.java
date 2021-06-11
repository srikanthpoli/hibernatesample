package com.srikanth.hibernatetutorial.controllers.dto;

import java.sql.Timestamp;

public class EmployeeErrorResponse {
    private String error;
    private Timestamp timestamp;
    private int status;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public EmployeeErrorResponse(String error, Timestamp timestamp, int status) {
        this.error = error;
        this.timestamp = timestamp;
        this.status = status;
    }

    public EmployeeErrorResponse() {
    }
}
