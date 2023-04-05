package com.system.data;

public class WindFarmData {
    private String num;
    private Integer diameter;
    private Integer height;
    private Integer blades;
    private Float power;
    private String wind_arrange;
    private Integer wind_speed;
    private Integer rotation_speed;
    private Integer in_wind_speed;
    private Integer out_wind_speed;
    private Float size;
    private Integer weight;

    public WindFarmData() {
    }

    public WindFarmData(String num, Integer diameter, Integer height, Integer blades, Float power, String wind_arrange, Integer wind_speed, Integer rotation_speed, Integer in_wind_speed, Integer out_wind_speed, Float size, Integer weight) {
        this.num = num;
        this.diameter = diameter;
        this.height = height;
        this.blades = blades;
        this.power = power;
        this.wind_arrange = wind_arrange;
        this.wind_speed = wind_speed;
        this.rotation_speed = rotation_speed;
        this.in_wind_speed = in_wind_speed;
        this.out_wind_speed = out_wind_speed;
        this.size = size;
        this.weight = weight;
    }

    public WindFarmData(String text, String new_diameter, String text1, String text2, String text3, String text4, String text5, String text6, String text7, String text8, String text9, String text10) {
        this.num = text;
        this.diameter = Integer.parseInt(new_diameter);
        this.height = Integer.parseInt(text1);
        this.blades = Integer.parseInt(text2);
        this.power = Float.parseFloat(text3);
        this.wind_arrange = text4;
        this.wind_speed = Integer.parseInt(text5);
        this.rotation_speed = Integer.parseInt(text6);
        this.in_wind_speed = Integer.parseInt(text7);
        this.out_wind_speed = Integer.parseInt(text8);
        this.size = Float.parseFloat(text9);
        this.weight = Integer.parseInt(text10);

    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Integer getDiameter() {
        return diameter;
    }

    public void setDiameter(Integer diameter) {
        this.diameter = diameter;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getBlades() {
        return blades;
    }

    public void setBlades(Integer blades) {
        this.blades = blades;
    }

    public Float getPower() {
        return power;
    }

    public void setPower(Float power) {
        this.power = power;
    }

    public String getWind_arrange() {
        return wind_arrange;
    }

    public void setWind_arrange(String wind_arrange) {
        this.wind_arrange = wind_arrange;
    }

    public Integer getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(Integer wind_speed) {
        this.wind_speed = wind_speed;
    }

    public Integer getRotation_speed() {
        return rotation_speed;
    }

    public void setRotation_speed(Integer rotation_speed) {
        this.rotation_speed = rotation_speed;
    }

    public Integer getIn_wind_speed() {
        return in_wind_speed;
    }

    public void setIn_wind_speed(Integer in_wind_speed) {
        this.in_wind_speed = in_wind_speed;
    }

    public Integer getOut_wind_speed() {
        return out_wind_speed;
    }

    public void setOut_wind_speed(Integer out_wind_speed) {
        this.out_wind_speed = out_wind_speed;
    }

    public Float getSize() {
        return size;
    }

    public void setSize(Float size) {
        this.size = size;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
