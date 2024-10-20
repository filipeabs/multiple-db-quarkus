package dev.filipeabs.rest;

import org.eclipse.microprofile.openapi.annotations.enums.ParameterIn;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameters;
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
    @Parameters(
        @Parameter(name = "whichDb" 
        , description = "which Db to use" 
        , required = true 
        , in = ParameterIn.PATH
        , schema = @Schema(enumeration = {"first", "second"})
        )
    )
    public Response listAllfromDb(@PathParam("whichDb") String db) {
        Object dbValuesList = dbService.listarTodos(db);
        return Response.status(Response.Status.OK).entity(dbValuesList).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/insert/{whichDb}")
    @Parameters(
        @Parameter(name = "whichDb" 
        , description = "which Db to use" 
        , required = true 
        , in = ParameterIn.PATH
        , schema = @Schema(enumeration = {"first", "second"})
        )
    )
    public Response insertIntoDb(@PathParam("whichDb") String db, String insertItem) {
        dbService.inserir(db, insertItem);
        return Response.status(Response.Status.OK).build();
    }

    @POST
    @Path("/migrate/{one}/to/{two}")
    @Parameters({
        @Parameter(name = "one" 
        , description = "which first Db to use" 
        , required = true 
        , in = ParameterIn.PATH
        , schema = @Schema(enumeration = {"first", "second"})
        ),
        @Parameter(name = "two" 
        , description = "which next Db to use" 
        , required = true 
        , in = ParameterIn.PATH
        , schema = @Schema(enumeration = {"first", "second"})
        )
    })
    public Response migrateOneDbToAnotherDb(@PathParam("one") String dbFirst, @PathParam("two") String dbSecond) {
        Object secondDbValuesList = dbService.migrarUmDbParaOutroDb(dbFirst, dbSecond);
        return Response.status(Response.Status.OK).entity(secondDbValuesList).build();
    }
}
