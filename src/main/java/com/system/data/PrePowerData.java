package com.system.data;

public class PrePowerData {
    private String C_TIME;
    private String C_EF_CODE;
    private Float C_VALUE;

    public PrePowerData(String c_time, String c_farm_id) {
        C_TIME = c_time;
        C_EF_CODE = c_farm_id;
    }

    public PrePowerData(String c_TIME, String c_EF_CODE, Float c_VALUE) {
        C_TIME = c_TIME;
        C_EF_CODE = c_EF_CODE;
        C_VALUE = c_VALUE;
    }


    public String getC_TIME() {
        return C_TIME;
    }

    public void setC_TIME(String c_TIME) {
        C_TIME = c_TIME;
    }

    public String getC_EF_CODE() {
        return C_EF_CODE;
    }

    public void setC_EF_CODE(String c_EF_CODE) {
        C_EF_CODE = c_EF_CODE;
    }

    public Float getC_VALUE() {
        return C_VALUE;
    }

    public void setC_VALUE(Float c_VALUE) {
        C_VALUE = c_VALUE;
    }
}
