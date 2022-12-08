package bd;

import com.mongodb.ConnectionString;

import com.mongodb.client.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {
    private static final String HOST = "localcluster0.cvfvre7.mongodb.net";
    
    private static final String DB_NAME = "bixim";

    private static MongoConnection uniqInstance;
    private static int mongoInstance = 1;

    private MongoClient mongo;
    private MongoDatabase db;
    private String username = "root";
    private String password = "root";

    private MongoConnection() {
        //construtor privado
    }

    //garante sempre uma unica instancia
    public static synchronized MongoConnection getInstance() {
        if (uniqInstance == null) {
            uniqInstance = new MongoConnection();
        }
        return uniqInstance;
    }

    //garante um unico objeto mongo
    public MongoDatabase getDB() {
        if (mongo == null) {
            try {
                            
            ConnectionString connectionString = new ConnectionString(String.format("mongodb+srv://%s:%s@%s/?retryWrites=true&w=majority", username, password, HOST));
            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(connectionString)
                    .build();
            MongoClient mongoClient = MongoClients.create(settings);
             db = mongoClient.getDatabase(DB_NAME);

               
                System.out.println("Mongo instance equals :> " + mongoInstance++);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return db;
    }   

    
}
