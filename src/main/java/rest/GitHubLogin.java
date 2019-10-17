package rest;

import kong.unirest.Unirest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.util.HashMap;
import java.util.Map;

@Path("github")
public class GitHubLogin {
    private static String githubID = System.getenv("GITHUB_CLIENT_ID");
    private static String githubSecret = System.getenv("GITHUB_CLIENT_SECRET");

    @GET
    @Path("login")
    public Response login(){
        String URI = "https://github.com/login/oauth/authorize?client_id=" + githubID;
        System.out.println(URI);
        return Response.seeOther(UriBuilder.fromUri(URI).build()).build();
    }

    @GET @Path("redirect")
    public String redirect(@QueryParam("code") String code){
        String response = Unirest.post("https://github.com/login/oauth/access_token")
                .queryString("client_id", githubID)
                .queryString("client_secret",githubSecret)
                .queryString("code",code)
                .asString().getBody();
        //Map response to Map
        String[] keyValues = response.split("&");
        Map<String, String> values = new HashMap<>();
        for (String KV: keyValues) {
            String[] split = KV.split("=");
            String value = split.length==1 ? "":split[1];
            values.put(split[0],value);
        }
        return values.get("access_token");
    }

}
