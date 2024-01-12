package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.bson.types.ObjectId;

/**
 *
 * @author mond
 */
public class Nota {

    private ObjectId id;             // Identificador único de la nota
    private String titulo;           // Título de la nota
    private String contenido;        // Contenido de la nota
    private String fecha_creacion;   // Fecha de creación de la nota

    /**
     * Constructor de la clase Nota.
     *
     * @param titulo    Título de la nota.
     * @param contenido Contenido de la nota.
     */
    public Nota(String titulo, String contenido) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.fecha_creacion = getCurrentDate();
    }

    /**
     * Obtiene el identificador único de la nota.
     *
     * @return Identificador único de la nota.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Obtiene el título de la nota.
     *
     * @return Título de la nota.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título de la nota.
     *
     * @param titulo Nuevo título de la nota.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene el contenido de la nota.
     *
     * @return Contenido de la nota.
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * Establece el contenido de la nota.
     *
     * @param contenido Nuevo contenido de la nota.
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    /**
     * Obtiene la fecha de creación de la nota en formato de cadena.
     *
     * @return Fecha de creación de la nota en formato de cadena.
     */
    public String getFechaCreacion() {
        return fecha_creacion;
    }

    /**
     * Método privado para obtener la fecha actual en formato de cadena.
     *
     * @return Fecha actual en formato de cadena.
     */
    private String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
        /*
        SimpleDateFormat: Esta clase se utiliza para formatear fechas según un 
        patrón específico. 
        En tu caso, has especificado el patrón "yyyy-MM-dd HH:mm:ss", que 
        representa el año, mes, día, hora, minuto y segundo.

        Date: La clase Date se utiliza para obtener la fecha y hora actuales.

        dateFormat.format(date): Se utiliza el objeto dateFormat para formatear la fecha 
        obtenida a partir de date según el patrón especificado. El resultado es 
        devuelto como una cadena.
        
        */
    }
}
