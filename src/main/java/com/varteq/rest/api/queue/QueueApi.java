package com.varteq.rest.api.queue;

import com.varteq.rest.model.NameModel;
import com.varteq.rest.queue.QueueManager;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Path("/queue")
public class QueueApi {

    @POST
    @Path("/init")
    @Produces(MediaType.TEXT_PLAIN)
    public Response initializeQueue() {
        try {
            QueueManager.init();

            return Response
                    .status(Response.Status.OK)
                    .entity("Queue initialized")
                    .build();
        } catch (IllegalStateException e) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Queue is already initialized")
                    .build();
        }
    }

    @POST
    @Path("/add/{name}")
    public Response add(@PathParam("name") String name) {
        QueueManager.add(name);

        return Response
                .status(Response.Status.CREATED)
                .entity(String.format("Name %s was added", name))
                .build();
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getName() {
        NameModel nameModel = new NameModel();
        nameModel.setName(QueueManager.get());

        return Response
                .status(Response.Status.OK)
                .entity(nameModel)
                .build();
    }

    @GET
    @Path("/size")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSize() {
        Map<String, Object> size = new HashMap<>();
        size.put("size", QueueManager.getSize());

        return Response.status(Response.Status.OK)
                .entity(size)
                .build();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllNames() {
        Collection<String> allNames = QueueManager.getAll();

        return Response.status(Response.Status.OK)
                .entity(allNames)
                .build();
    }

    @DELETE
    @Path("/remove")
    public Response removeName() {
        QueueManager.poll();

        return Response
                .status(Response.Status.NO_CONTENT)
                .build();
    }
}
