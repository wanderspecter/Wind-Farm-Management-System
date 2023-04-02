package com.system.data;

public class PowerData {
    private String cTime;
    private String cEfCode;
    private Float cValue;

    public PowerData(String cTime, String cEfCode, Float cValue) {
        this.cTime = cTime;
        this.cEfCode = cEfCode;
        this.cValue = cValue;
    }

    public PowerData() {
    }

    public String getcTime() {
        return cTime;
    }

    public void setcTime(String cTime) {
        this.cTime = cTime;
    }

    public String getcEfCode() {
        return cEfCode;
    }

    public void setcEfCode(String cEfCode) {
        this.cEfCode = cEfCode;
    }

    public Float getcValue() {
        return cValue;
    }

    public void setcValue(Float cValue) {
        this.cValue = cValue;
    }
}
