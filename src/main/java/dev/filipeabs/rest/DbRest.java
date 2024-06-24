package dev.filipeabs.rest;

import java.util.ArrayList;

import dev.filipeabs.services.DbService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/")
@RequestScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DbRest {
    @Inject
    DbService dbService;

    @GET
    @Path("/list/{whichDb}")
    public Response listAllfromDb(@PathParam("whichDb") String db) {
        Object dbValuesList = dbService.listarTodos(db);
        return Response.status(Response.Status.OK).entity(dbValuesList).build();
    }

    @POST
    @Path("/migrate/{one}/to/{two}")
    public Response migrateOneDbToAnotherDb(@PathParam("one") String dbFirst, @PathParam("two") String dbSecond) {
        Object secondDbValuesList = dbService.migrarUmDbParaOutroDb(dbFirst, dbSecond);
        return Response.status(Response.Status.OK).entity(secondDbValuesList).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/insert/{whichDb}")
    public Response insertIntoDb(@PathParam("whichDb") String db, String insertItem) {
        dbService.inserir(db, insertItem);
        return Response.status(Response.Status.OK).build();
    }

}
