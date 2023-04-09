package com.system.data;

public class WeatherData {

    private String C_TIME;
    private String C_EF_CODE;
    private Float C_WD_INST1;
    private Float C_WD_INST2;
    private Float C_WD_INST3;
    private Float C_WD_INST4;
    private Float C_WS_INST1;
    private Float C_WS_INST2;
    private Float C_WS_INST3;
    private Float C_WS_INST4;

    public WeatherData(String c_TIME, String c_EF_CODE, Float c_WD_INST1, Float c_WD_INST2, Float c_WD_INST3, Float c_WD_INST4, Float c_WS_INST1, Float c_WS_INST2, Float c_WS_INST3, Float c_WS_INST4) {
        C_TIME = c_TIME;
        C_EF_CODE = c_EF_CODE;
        C_WD_INST1 = c_WD_INST1;
        C_WD_INST2 = c_WD_INST2;
        C_WD_INST3 = c_WD_INST3;
        C_WD_INST4 = c_WD_INST4;
        C_WS_INST1 = c_WS_INST1;
        C_WS_INST2 = c_WS_INST2;
        C_WS_INST3 = c_WS_INST3;
        C_WS_INST4 = c_WS_INST4;
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

    public Float getC_WD_INST1() {
        return C_WD_INST1;
    }

    public void setC_WD_INST1(Float c_WD_INST1) {
        C_WD_INST1 = c_WD_INST1;
    }

    public Float getC_WD_INST2() {
        return C_WD_INST2;
    }

    public void setC_WD_INST2(Float c_WD_INST2) {
        C_WD_INST2 = c_WD_INST2;
    }

    public Float getC_WD_INST3() {
        return C_WD_INST3;
    }

    public void setC_WD_INST3(Float c_WD_INST3) {
        C_WD_INST3 = c_WD_INST3;
    }

    public Float getC_WD_INST4() {
        return C_WD_INST4;
    }

    public void setC_WD_INST4(Float c_WD_INST4) {
        C_WD_INST4 = c_WD_INST4;
    }

    public Float getC_WS_INST1() {
        return C_WS_INST1;
    }

    public void setC_WS_INST1(Float c_WS_INST1) {
        C_WS_INST1 = c_WS_INST1;
    }

    public Float getC_WS_INST2() {
        return C_WS_INST2;
    }

    public void setC_WS_INST2(Float c_WS_INST2) {
        C_WS_INST2 = c_WS_INST2;
    }

    public Float getC_WS_INST3() {
        return C_WS_INST3;
    }

    public void setC_WS_INST3(Float c_WS_INST3) {
        C_WS_INST3 = c_WS_INST3;
    }

    public Float getC_WS_INST4() {
        return C_WS_INST4;
    }

    public void setC_WS_INST4(Float c_WS_INST4) {
        C_WS_INST4 = c_WS_INST4;
    }

    public WeatherData() {
    }
}
