package com.fimelab.reman.pojo;

public class UserSessionInfo {
    private final String cuid;
    private final boolean logged;

    public UserSessionInfo(String cuid, boolean logged) {
        this.cuid = cuid;
        this.logged = logged;
    }

    public String getCuid() {
        return cuid;
    }

    public boolean isLogged() {
        return logged;
    }
}
