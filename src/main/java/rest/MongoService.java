package rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
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
    public void postTypedObject(User mongoDoc){
        System.out.println("object: " + mongoDoc);
        MorphiaHandler.getInstance().save(mongoDoc);
    }

    @GET
    public List<User> getTypedObject() {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        Query<User> query = MorphiaHandler.getInstance().createQuery(User.class);
        return query.asList();
    }

    @DELETE
    @Path("{id}")
    public void deleteTyped(@PathParam("id") String id) {
        System.out.println(id);
        Query<User> userQ = MorphiaHandler.getInstance().createQuery(User.class);
        userQ.criteria("_id").equal(new ObjectId(id));
        MorphiaHandler.getInstance().findAndDelete(userQ);
    }


}
