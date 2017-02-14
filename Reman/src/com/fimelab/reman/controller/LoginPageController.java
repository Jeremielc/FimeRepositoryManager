package com.fimelab.reman.controller;

import com.fimelab.reman.database.DbManagement;
import com.fimelab.reman.database.MySqlDbManagement;
import com.fimelab.reman.utils.UserManagement;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

@Path("/user")
public class LoginPageController {
    //password is received.
    //password is hashed. -> SHA 256
    //cuid || firstname || lastname || mail -> SHA 256
    //passHash = SHA256(password) XOR SHA256(cuid || firstname || lastname || mail);

    //select cuid, firstname, lastname, mail from USERS join CREDENTIALS on USERS.uid = CREDENTIALS.uid;

    //private static HashMap<String, Boolean> users = new HashMap<String, Boolean>();


    public LoginPageController() {

    }

    @POST
    @Path("/login")
    @Produces(MediaType.TEXT_PLAIN)
    public Response login(@FormParam("username") String username, @FormParam("password") String password) throws URISyntaxException {
        UserManagement um = new UserManagement();
        boolean loggedIn = um.verify(username, password);

        System.out.println("User is logged in : " + loggedIn);

        if (loggedIn) {
            //users.put(username, true);
            return Response.temporaryRedirect(new URI("/")).build();
        } else {
            return Response.status(406).build();
        }
    }

    @Path("/disconnect")
    @Produces(MediaType.TEXT_PLAIN)
    public Response disconnect() {
        /*
        users.remove(username);
         */

        return Response.status(200).build();
    }
}
