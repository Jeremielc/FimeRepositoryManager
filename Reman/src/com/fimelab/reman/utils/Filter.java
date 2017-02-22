package com.fimelab.reman.utils;

import com.fimelab.reman.controller.RegisterPageController;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Filter implements javax.servlet.Filter {
    private FilterConfig filterConfig;

    public Filter() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response =(HttpServletResponse) servletResponse;

        if (request.getRequestURI().contains("_registered")) {
            if (request.getRequestURI().contains("upload")) {
                if (RegisterPageController.sessions.get(request.getSession()) == null || !RegisterPageController.sessions.get(request.getSession()).isAdmin()) {
                    response.sendRedirect("/index.jsp");
                }
            } else {
                if (RegisterPageController.sessions.get(request.getSession()) == null) {
                    response.sendRedirect("/index.jsp");
                    return;
                }
            }
        }

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }
}
