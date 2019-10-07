package data;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import dev.morphia.Datastore;
import dev.morphia.Morphia;

import java.util.Set;

public class MorphiaHandler {
    private static MorphiaHandler instance = new MorphiaHandler();
    private final Datastore handler;

    private MorphiaHandler(){
        MongoClientURI uri = new MongoClientURI("mongodb://devops:" + MongoConnector.password+"@cluster0-shard-00-00-znd0l.mongodb.net:27017,cluster0-shard-00-01-znd0l.mongodb.net:27017,cluster0-shard-00-02-znd0l.mongodb.net:27017/admin?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin&retryWrites=true&w=majority");
        MongoClient mongoClient = new MongoClient(uri);
        Morphia m = new Morphia(Set.of(User.class));
        m.mapPackage("data"); //Alternate solution to above
        handler = m.createDatastore(mongoClient, "morphiaBase");
    }

    public static Datastore getInstance() {
        return instance.getHandler();
    }

    private Datastore getHandler() {
        return handler;
    }
}
