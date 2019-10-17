package data;

import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.function.Consumer;

    public class MongoConnector {
        public static String username = System.getenv("DEVOPSMONGOUSER");
        public static String password = System.getenv("DEVOPSMONGOPASS");
        private static String dbName = "test";
        private static MongoClient client;

        public static MongoClient getclient() {
            if (client==null) {
                client = MongoClients.create("mongodb+srv://" + username + ":" + password + "@cluster0-znd0l.mongodb.net/admin?retryWrites=true&w=majority");
            }
            return client;
        }

    public static void main(String[] args) {
        MongoDatabase test = MongoConnector.getclient().getDatabase(dbName);
        System.out.println("Connected to " + test.getName());
        Document doc = new Document("name","Brian");
        MongoCollection<Document> brugere = test.getCollection("brugere");
        brugere.insertOne(doc);
        brugere.find().forEach((Consumer<Document>) System.out::println); // Same as:
   /*   try (MongoCursor<Document> cursor = brugere.find().iterator()) {
            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }
        } */


    }
}
