package com.fimelab.reman.controller;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/test")
public class TestController {

    public TestController() {

    }

    @Produces("text/plain")
    public String test() {
        return "TEST";
    }

    @Path("hello")
    @Produces("text/plain")
    public String hello() {
        return "Hello World !";
    }
}
