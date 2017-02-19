package com.fimelab.reman.utils;

import com.fimelab.reman.database.DbManagement;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserManagement {

    private static UserManagement instance = new UserManagement();

    private UserManagement() {

    }

    public static UserManagement getInstance() {
        return UserManagement.instance;
    }

    public boolean registerNewUser(String cuid, String firstname, String lastname, String group, String mail, String password) {
        boolean success = true;

        try {
            boolean alreadyInDatabase = false;
            //ToDo Verifier qu'un utilisateur ne rentre pas un cuid existant.

            int nbResult;
            ResultSet res = DbManagement.getInstance().query("SELECT * FROM USERS WHERE mail = '" + mail + "';");
            while (res.next()) {
                alreadyInDatabase = true;
            }

            if (!alreadyInDatabase) {
                byte[] concatenatedPart, passwordPart;
                byte[] saltedHash;

                try {
                    MessageDigest md = MessageDigest.getInstance("SHA-256");
                    concatenatedPart = md.digest((cuid + firstname + lastname + mail).getBytes(StandardCharsets.UTF_8));
                    passwordPart = md.digest(password.getBytes(StandardCharsets.UTF_8));

                    saltedHash = new byte[concatenatedPart.length];
                    for (int i = 0; i < concatenatedPart.length; i++) {
                        saltedHash[i] = (byte) (concatenatedPart[i] ^ passwordPart[i]);
                    }

                    String hashToStore = "";
                    for (byte b : saltedHash) {
                        hashToStore += String.format("%02x", b);
                    }

                    DbManagement.getInstance().update("INSERT INTO `USERS`(`firstname`, `lastname`, `grp`, `role`, `mail`)" +
                            "VALUES ('" + firstname + "', '" + lastname + "', '" + group + "', 'User', '" + mail + "');");

                    int uid = -1;
                    nbResult = 0;
                    res = DbManagement.getInstance().query("SELECT * FROM USERS WHERE mail = '" + mail + "';");
                    while (res.next()) {
                        uid = Integer.parseInt(res.getString("uid"));
                        nbResult++;
                    }

                    if (nbResult == 1) {
                        DbManagement.getInstance().update("INSERT INTO `CREDENTIALS`(`uid`, `cuid`, `passHash`)" +
                                "VALUES (" + uid + ", '" + cuid + "', '" + hashToStore + "');");
                    } else {
                        System.err.println("There is more than one user with this email address. Database compromised.");
                        success = false;
                    }
                } catch (NoSuchAlgorithmException | SQLException ex) {
                    ex.printStackTrace(System.err);
                    success = false;
                }
            } else {
                System.err.println("There is more than one user with this email address. Database compromised.");
                success = false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            success = false;
        }

        return success;
    }

    public boolean removeUser(String cuid) {
        try {
            boolean alreadyInDatabase = false;
            int nbResult, uid = -1;
            ResultSet res = DbManagement.getInstance().query("SELECT * FROM CREDENTIALS WHERE cuid = '" + cuid + "';");
            while (res.next()) {
                alreadyInDatabase = true;
                uid = res.getInt("uid");
            }

            if (alreadyInDatabase) {
                DbManagement.getInstance().update("DELETE FROM CREDENTIALS WHERE uid = " + uid + ";");
                DbManagement.getInstance().update("DELETE FROM USERS WHERE uid = " + uid + ";");
            } else {
                System.err.println("There is no user with this uid in the database. Removal failed.");
            }

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            return false;
        }
    }

    public boolean verify(String cuid, String password) {
        boolean registeredUser = false;

        try {
            int uid = -1;
            String firstname = "", lastname = "", mail = "", passHash = "";

            ResultSet res = DbManagement.getInstance().query("SELECT * FROM CREDENTIALS WHERE cuid = '" + cuid + "';");
            while (res.next()) {
                uid = res.getInt("uid");
                passHash = res.getString("passHash");
            }

            res = DbManagement.getInstance().query("SELECT * FROM USERS WHERE uid = " + uid + ";");
            while (res.next()) {
                firstname = res.getString("firstname");
                lastname = res.getString("lastname");
                mail = res.getString("mail");
            }

            try {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] concatenatedPart = md.digest((cuid + firstname + lastname + mail).getBytes(StandardCharsets.UTF_8));
                byte[] passwordPart = md.digest(password.getBytes(StandardCharsets.UTF_8));

                byte[] saltedHash = new byte[concatenatedPart.length];
                for (int i = 0; i < concatenatedPart.length; i++) {
                    saltedHash[i] = (byte) (concatenatedPart[i] ^ passwordPart[i]);
                }

                String hashToCompare = "";
                for (byte b : saltedHash) {
                    hashToCompare += String.format("%02x", b);
                }

                registeredUser = passHash.endsWith(hashToCompare);

            } catch (NoSuchAlgorithmException ex) {
                ex.printStackTrace(System.err);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            System.err.println("Unable to verify credentials.");
        }

        return registeredUser;
    }
}
