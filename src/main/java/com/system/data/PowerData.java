package com.system.data;

public class PowerData {
    private String C_TIME;
    private String C_EF_CODE;
    private Float C_VALUE;

    public PowerData(String C_TIME, String C_EF_CODE, Float C_VALUE) {
        this.C_TIME = C_TIME;
        this.C_EF_CODE = C_EF_CODE;
        this.C_VALUE = C_VALUE;
    }

    public PowerData() {
    }

    public String getC_TIME() {
        return C_TIME;
    }

    public void setC_TIME(String c_TIME) {
        this.C_TIME = c_TIME;
    }

    public String getC_EF_CODE() {
        return C_EF_CODE;
    }

    public void setC_EF_CODE(String c_EF_CODE) {
        this.C_EF_CODE = c_EF_CODE;
    }

    public Float getC_VALUE() {
        return C_VALUE;
    }

    public void setC_VALUE(Float c_VALUE) {
        this.C_VALUE = c_VALUE;
    }
}
