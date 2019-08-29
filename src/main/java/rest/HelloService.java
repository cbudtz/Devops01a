package rest;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.Date;

@Path("hello")
public class HelloService {
    @GET
    public String getHello(){
        return "Hello Service!: " + new Date();
    }
}
