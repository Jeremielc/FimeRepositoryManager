package com.fimelab.reman.controller;

import com.fimelab.reman.utils.UserManagement;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;

@Path("/register")
public class RegisterPageController {

    public RegisterPageController() {

    }

    @POST
    @Path("/new")
    public Response registerNewUser(@FormParam("firstname") String firstname, @FormParam("lastname") String lastname, @FormParam("CUID") String cuid, @FormParam("team") String group, @FormParam("email") String mail, @FormParam("confirm_Password") String password) throws URISyntaxException {
        UserManagement um = new UserManagement();
        boolean success = um.registerNewUser(cuid.trim(), firstname.trim(), lastname.trim(), group.trim(), mail.trim(), password);

        if (success) {
            return Response.temporaryRedirect(new URI("/")).build();
        } else {
            return Response.status(500).build();
        }
    }
}
