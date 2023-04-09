package com.system.data;

public class RepData {
    private String time;
    private String code;
    private String status;
    private String message;

    public RepData(String time, String code, String status, String message) {
        this.time = time;
        this.code = code;
        this.status = status;
        this.message = message;

    }

    public RepData() {
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
