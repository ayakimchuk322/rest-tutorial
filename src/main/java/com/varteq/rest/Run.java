package com.varteq.rest;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

public class Run {

    public static void main(String[] args) throws Exception {
        Server jettyServer = new Server(9090);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        context.setContextPath("/");
        jettyServer.setHandler(context);

        ServletHolder jerseyServlet = context.addServlet(ServletContainer.class, "/rest/*");
        jerseyServlet.setInitOrder(1);
        jerseyServlet.setInitParameter(
                "jersey.config.server.provider.packages",
                "com.varteq.rest");

        jettyServer.start();
        jettyServer.join();
    }
}
