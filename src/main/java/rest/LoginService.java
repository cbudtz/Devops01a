package rest;

import data.LoginData;
import data.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoginService {

    @POST
    public String postLoginData(LoginData login){
        if (login!=null &&"brian".equals(login.getUsername()) && "kodeord".equals(login.getPassword())){
            return JWTHandler.generateJwtToken(new User(login.getUsername(), ""));
        }
        throw new NotAuthorizedException("forkert brugernavn/kodeord");
    }
    @POST@Path("tokentest")
    public User postToken(String token){
        User validate = JWTHandler.validate(token);
        return validate;
    }

}
