package rest;

import data.LoginData;
import data.User;
import io.prometheus.client.Counter;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoginService {
    public final static Counter attemptCounter = Counter.build().name("loginAttempts").help("Total Login Attempts").register();
    public final static Counter failCounter = Counter.build().name("loginFails").help("Total Failed Attempts").register();


    @POST
    public String postLoginData(LoginData login){
        attemptCounter.inc();
        if (login!=null &&"brian".equals(login.getUsername()) && "kodeord".equals(login.getPassword())){
            failCounter.inc();
            return JWTHandler.generateJwtToken(new User(login.getUsername(), ""));
        }
        throw new NotAuthorizedException("forkert brugernavn/kodeord");
    }
    @POST @Path("tokentest")
    public User postToken(String token){
        User validate = JWTHandler.validate(token);
        return validate;
    }

}
