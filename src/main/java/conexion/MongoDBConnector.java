package conexion;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
/**
 *
 * @author mond
 */
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 * Clase para gestionar la conexión con MongoDB.
 */
public class MongoDBConnector {

    private MongoClient mongoClient;  // Cliente MongoDB para la conexión
    private MongoDatabase database;   // Representa la base de datos MongoDB conectada

    /**
     * Constructor de la clase MongoDBConnector.
     *
     * @param connectionString Cadena de conexión a MongoDB.
     */
    public MongoDBConnector(String connectionString) {
        this.mongoClient = MongoClients.create(connectionString);
    }

    /**
     * Conecta a la base de datos MongoDB especificada.
     *
     * @param databaseName Nombre de la base de datos a la que se va a conectar.
     * @return Instancia de MongoDatabase para realizar operaciones en la base de datos.
     */
    public MongoDatabase connectToDatabase(String databaseName) {
        this.database = mongoClient.getDatabase(databaseName);
        return this.database;
    }

    /**
     * Cierra la conexión con MongoDB.
     */
    public void closeConnection() {
        this.mongoClient.close();
    }
}

