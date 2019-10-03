import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BSONObject;
import org.bson.Document;

import java.io.IOException;

public class DBHandler {
    static String mongoUrl ="mongodb://heroku_04nc01v9:ifnuds4dlqoh3vbjgcbarut2f2@ds229258.mlab.com:29258/heroku_04nc01v9?retryWrites=false";
    static String mongoDB = "heroku_04nc01v9";

    public static void main(String[] args) throws IOException {
        MongoClient mongoClient = MongoClients.create(mongoUrl);
        MongoDatabase database = mongoClient.getDatabase(mongoDB);
        MongoCollection<Document> test = database.getCollection("test");
        Document doc = new Document();
        doc.append("test","test");

        test.insertOne(doc);

    }




}
