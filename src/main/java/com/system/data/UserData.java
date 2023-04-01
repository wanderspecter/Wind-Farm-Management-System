package com.system.data;

public class UserData {
    private Integer id;
    private String user;
    private String password;
    private Integer ifRoot;

    public UserData(Integer id, String user, String password, Integer ifRoot) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.ifRoot = ifRoot;
    }


}
