package com.fimelab.reman.controller;

import com.fimelab.reman.utils.UserManagement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

@Path("/register")
public class RegisterPageController {

    public static HashMap<HttpSession, Boolean> sessions = new HashMap<>();

    public RegisterPageController() {

    }

    @POST
    @Path("/new")
    public Response registerNewUser(@Context HttpServletRequest request, @FormParam("firstname") String firstname, @FormParam("lastname") String lastname, @FormParam("CUID") String cuid, @FormParam("team") String group, @FormParam("email") String mail, @FormParam("confirm_Password") String password) throws URISyntaxException {
        HttpSession session = request.getSession();

        boolean success = UserManagement.getInstance().registerNewUser(cuid.trim(), firstname.trim(), lastname.trim(), group.trim(), mail.trim(), password);
        session.setAttribute("CUID", cuid);

        if (success) {
            sessions.put(session, true);
            return Response.temporaryRedirect(new URI("/index_registered.jsp")).build();
        } else {
            return Response.status(500).build();
        }
    }

    @POST
    @Path("/login")
    public Response login(@Context HttpServletRequest request, @FormParam("CUID") String cuid, @FormParam("password") String password) throws URISyntaxException {
        HttpSession session = request.getSession();

        boolean success = UserManagement.getInstance().verify(cuid, password);
        session.setAttribute("CUID", cuid);

        if (success) {
            sessions.put(session, true);
            return Response.temporaryRedirect(new URI("/index_registered.jsp")).build();
        } else {
            return Response.status(406).build();
        }
    }

    @POST
    @Path("/disconnect")
    public Response disconnect(@Context HttpServletRequest request) throws URISyntaxException {
        sessions.remove(request.getSession());
        return Response.temporaryRedirect(new URI("/index.jsp")).build();
    }
}
