package com.fimelab.reman.controller;

import com.fimelab.reman.utils.SoftwareManagement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * Created by jeremie on 20/02/17.
 */
@Path("/latest")
public class LatestPageController {

    @POST
    @Path("/archive")
    @Produces(MediaType.TEXT_HTML)
    public void archive(@Context HttpServletResponse response,
                        @FormParam("filename") String filename) throws IOException {
        SoftwareManagement.getInstance().archive(filename);
        response.sendRedirect("/latest_registered.jsp");
    }

    @POST
    @Path("/revalidate")
    @Produces(MediaType.TEXT_HTML)
    public void revalidate(@Context HttpServletResponse response,
                           @FormParam("filename") String filename) throws IOException {
        SoftwareManagement.getInstance().revalidate(filename);
        response.sendRedirect("/latest_registered.jsp");
    }

    @POST
    @Path("/remove")
    @Produces(MediaType.TEXT_HTML)
    public void remove(@Context HttpServletResponse response,
                       @FormParam("filename") String filename) throws IOException {
        SoftwareManagement.getInstance().remove(filename);
        response.sendRedirect("/latest_registered.jsp");
    }
}
