package rest;

import data.Giraffe;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Path("giraffes")
public class GiraffeService {
    List<Giraffe> giraffes = Arrays.asList(new Giraffe("Melman", 12.2), new Giraffe("Marius",0.0));

    @GET
    public List<Giraffe> getGiraffes(){
        return giraffes;
    }

    @GET
    @Path("query")
    public List<Giraffe> queryGiraffes(@QueryParam("name") String name) throws NoImplementationException {
        //No implementaion yet
        //throw new NoImplementationException("giraffe-queries not implemented, yet");
        throw new NotFoundException("No such Giraffe!");
    }
}
