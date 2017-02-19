package com.fimelab.reman.pojo;

public class UserSessionInfo {
    private final String cuid;
    private final boolean logged, admin;

    public UserSessionInfo(String cuid, boolean logged) {
        this.cuid = cuid;
        this.logged = logged;
        this.admin = false;
    }

    public UserSessionInfo(String cuid, boolean logged, boolean admin) {
        this.cuid = cuid;
        this.logged = logged;
        this.admin = admin;
    }

    public String getCuid() {
        return cuid;
    }

    public boolean isLogged() {
        return logged;
    }

    public boolean isAdmin() {
        return admin;
    }
}
