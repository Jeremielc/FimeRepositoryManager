package com.fimelab.reman.controller;

import com.fimelab.reman.database.DbManagement;
import com.fimelab.reman.database.MySqlDbManagement;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginPageController {
    public String username;
    public String password;

    //pass word is received.
    //password is hashed. -> SHA 256
    //cuid || firstname || lastname || mail -> SHA 256
    //passHash = SHA256(password) XOR SHA256(cuid || firstname || lastname || mail);

    //select cuid, firstname, lastname, mail from USERS join CREDENTIALS on USERS.uid = CREDENTIALS.uid;


    public LoginPageController() {

    }

    public void login() {
        String username = "HRNS9487";
        try {
            DbManagement dbMan = DbManagement.getInstance();
            dbMan.setDelegate(new MySqlDbManagement());

            dbMan.connection(MySqlDbManagement.dbName);

            ResultSet res = dbMan.query("select * from CREDENTIALS where cuid = \"" + username + "\";");

            while (res.next()) {
                String passHash = res.getString("passHash");
                System.out.println(passHash);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
