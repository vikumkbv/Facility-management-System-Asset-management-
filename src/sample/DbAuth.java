package sample;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@SuppressWarnings("ALL")
public final class DbAuth {
    public static MongoClient mongoclient() {
        MongoClient mongoClient = null;
        try {
            mongoClient = new MongoClient(new ServerAddress("localhost", 27017));
        } catch (Exception e) {
            System.out.println(e);
        }
        return mongoClient;
    }
}
