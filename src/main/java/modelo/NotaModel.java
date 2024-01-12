package modelo;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 * Clase que gestiona las operaciones relacionadas con las notas en la base de datos MongoDB.
 * 
 * @author mond
 */
public class NotaModel {

    private MongoCollection<Document> notaCollection;

    /**
     * Constructor de la clase NotaModel.
     *
     * @param database Base de datos MongoDB a la que se conectará.
     */
    public NotaModel(MongoDatabase database) {
        this.notaCollection = database.getCollection("nota");
    }

    /**
     * Crea una nueva nota en la base de datos.
     *
     * @param nota La nota que se va a crear.
     */
    public void crearNota(Nota nota) {
        Document doc = new Document("titulo", nota.getTitulo())
                .append("Contenido", nota.getContenido())
                .append("Fecha_creacion", nota.getFechaCreacion());
        notaCollection.insertOne(doc);
    }

    /**
     * Obtiene todas las notas almacenadas en la base de datos.
     *
     * @return Una colección de notas.
     */
    public FindIterable<Document> obtenerTodasNotas() {
        return notaCollection.find();
    }

    /**
     * Obtiene una nota por su identificador único.
     *
     * @param id Identificador único de la nota.
     * @return La nota correspondiente al identificador proporcionado.
     */
    public Document obtenerNotaPorId(ObjectId id) {
        return notaCollection.find(new Document("_id", id)).first();
    }

    /**
     * Actualiza una nota existente en la base de datos.
     *
     * @param id   Identificador único de la nota que se actualizará.
     * @param nota La nueva información de la nota.
     */
    public void actualizarNota(ObjectId id, Nota nota) {
        Document updateDoc = new Document("$set", new Document("titulo", nota.getTitulo())
                .append("contenido", nota.getContenido()));
        notaCollection.updateOne(new Document("_id",id),updateDoc);
    }

    /**
     * Elimina una nota por su identificador único.
     *
     * @param id Identificador único de la nota que se eliminará.
     */
    public void eliminarNota(ObjectId id){
        notaCollection.deleteOne(new Document("_id",id));
    }
}
