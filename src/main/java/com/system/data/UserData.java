package com.system.data;

public class UserData {
    private String user;
    private String password;
    private Integer ifroot;

    public UserData() {
    }

    public UserData(String user, String password, Integer ifroot) {
        this.user = user;
        this.password = password;
        this.ifroot = ifroot;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIfroot() {
        return ifroot;
    }

    public void setIfroot(Integer ifroot) {
        this.ifroot = ifroot;
    }
}
