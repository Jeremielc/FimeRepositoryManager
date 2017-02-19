package com.fimelab.reman.controller;

import com.fimelab.reman.pojo.UserSessionInfo;
import com.fimelab.reman.utils.UserManagement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;

@Path("/register")
public class RegisterPageController {

    public static HashMap<HttpSession, UserSessionInfo> sessions = new HashMap<>();

    public RegisterPageController() {

    }

    @POST
    @Path("/new")
    public void registerNewUser(@Context HttpServletRequest request,
                                @Context HttpServletResponse response,
                                @FormParam("firstname") String firstname,
                                @FormParam("lastname") String lastname,
                                @FormParam("CUID") String cuid,
                                @FormParam("team") String group,
                                @FormParam("email") String mail,
                                @FormParam("confirm_Password") String password) throws URISyntaxException, IOException {
        HttpSession session = request.getSession();

        boolean success = UserManagement.getInstance().registerNewUser(cuid.trim(), firstname.trim(), lastname.trim(), group.trim(), mail.trim(), password);
        session.setAttribute("CUID", cuid);

        if (success) {
            sessions.put(session, new UserSessionInfo((String) session.getAttribute("CUID"), true, UserManagement.getInstance().userIsAdmin(cuid)));
            response.sendRedirect("/index_registered.jsp");
        } else {
            response.sendError(500);
        }
    }

    @POST
    @Path("/login")
    public void login(@Context HttpServletRequest request,
                      @Context HttpServletResponse response,
                      @FormParam("CUID") String cuid,
                      @FormParam("password") String password) throws URISyntaxException, IOException {
        HttpSession session = request.getSession();

        boolean success = UserManagement.getInstance().verify(cuid, password);
        session.setAttribute("CUID", cuid);

        if (success) {
            sessions.put(session, new UserSessionInfo((String) session.getAttribute("CUID"), true, UserManagement.getInstance().userIsAdmin(cuid)));
            response.sendRedirect("/index_registered.jsp");
        } else {
            response.sendError(500);
        }
    }

    @POST
    @Path("/disconnect")
    public void disconnect(@Context HttpServletRequest request,
                           @Context HttpServletResponse response) throws URISyntaxException, IOException {
        sessions.remove(request.getSession());
        response.sendRedirect("/index.jsp");
    }
}
