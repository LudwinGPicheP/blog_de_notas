package controlador;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import javax.swing.JOptionPane;
import modelo.Nota;
import modelo.NotaModel;
import org.bson.Document;
import org.bson.types.ObjectId;
import vista.*;

public class NotaController {

    private NotaModel notaModel;
    

    /**
     * Constructor de la clase NotaController.
     *
     * @param notaModel Modelo que maneja las operaciones relacionadas con las
     * notas.
     */
    public NotaController() {
        this.notaModel = new NotaModel();
    }

    /**
     * Procesa la creación de una nueva nota.
     *
     * @param titulo Título de la nueva nota.
     * @param contenido Contenido de la nueva nota.
     */
    public void crearNota(String titulo, String contenido) {
        Nota nuevaNota = new Nota(titulo, contenido);
        notaModel.crearNota(nuevaNota);
        JOptionPane.showMessageDialog(null, "Nota Creada con exito");
    }

    /**
     * Procesa la obtención de todas las notas y las muestra en la vista.
     */
    public void obtenerTodasNotas() {
        notaModel.obtenerTodasNotas();
    }

    /**
     * Procesa la actualización de una nota existente.
     *
     * @param id Identificador único de la nota que se actualizará.
     * @param nuevoTitulo Nuevo título de la nota.
     * @param nuevoContenido Nuevo contenido de la nota.
     */
    public void actualizarNota(String id, String nuevoTitulo, String nuevoContenido) {
        ObjectId objectId = new ObjectId(id);
        Nota notaActualizada = new Nota(nuevoTitulo, nuevoContenido);
        notaModel.actualizarNota(objectId, notaActualizada);
        JOptionPane.showMessageDialog(null, "Nota Actualizada exitosamente");
    }

    /**
     * Procesa la eliminación de una nota por su identificador único.
     *
     * @param id Identificador único de la nota que se eliminará.
     */
    public void eliminarNota(String id) {
        ObjectId objectId = new ObjectId(id);
        notaModel.eliminarNota(objectId);
        JOptionPane.showMessageDialog(null, "Nota eliminada exitosamente.");
    }

}
