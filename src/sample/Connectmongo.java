package sample;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Connectmongo {
    MongoClient client;
    MongoDatabase database;
    MongoCollection<Document> loginCollection;

    Connectmongo(){
        client = new MongoClient("Localhost",27017);
        database = client.getDatabase("cw3pp1");
        loginCollection = database.getCollection("logindata");
    }
}
