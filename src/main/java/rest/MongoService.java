package rest;


import com.fasterxml.jackson.databind.JsonNode;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import java.util.Date;

@Path("hello")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MongoService {
    //Mongo Connection - Refactor
    private static String mongoUrl ="mongodb://heroku_04nc01v9:ifnuds4dlqoh3vbjgcbarut2f2@ds229258.mlab.com:29258/heroku_04nc01v9?retryWrites=false";
    private static String mongoDB = "heroku_04nc01v9";
    private static MongoClient mongoClient = MongoClients.create(mongoUrl);
    private static MongoDatabase database = mongoClient.getDatabase(mongoDB);

    @GET
    public String getHello(){
        return "Hello Service!: " + new Date();
    }

    @POST
    public void postDocument(Document someObject){
        System.out.println(someObject);

        MongoCollection<Document> test = database.getCollection("hello");
        test.insertOne(someObject);

    }
}
