package rest;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import data.MongoConnector;
import data.MorphiaHandler;
import data.User;
import dev.morphia.Datastore;
import dev.morphia.Morphia;
import dev.morphia.query.Query;
import org.bson.Document;
import org.bson.types.ObjectId;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Path("mongo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MongoService {
    @POST
    @Path("{collection}")
    public void postRandomObjects(@PathParam("collection") String collection, User mongoDoc){
        System.out.println("Pathname: "+ collection + ", object: " + mongoDoc);
        MorphiaHandler.getInstance().save(mongoDoc);
    }

    @GET
    @Path("{collection}")
    public List<User> getRandomDocuments(@PathParam("collection") String collection) {
        Query<User> query = MorphiaHandler.getInstance().createQuery(User.class);
        return query.asList();
    }

    @DELETE
    @Path("{collection}")
    public void deleteRandomDocuments(@PathParam("collection") String collection, Document doc) {
        ObjectId objectId=  doc.getObjectId("_id");
        System.out.println(objectId.toHexString());
    }


}
