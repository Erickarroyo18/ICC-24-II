/**
 * Clase que representa una base de datos
 * Simula las acciones de una base de datos (CRUD)
 * C = Create
 * R = Read
 * U = Update
 * D = Delete
 * 
 * @author Erick Arroyo
 * @version 1.0
 */
public class BaseDatos {
    private Persona[] personas;
    private String id;

    /**
     * Constructor de la clase BaseDatos
     * 
     * @param id
     * @param numPersonas
     */
    public BaseDatos(String id, int numPersonas) {
        this.id = id;
        this.personas = new Persona[numPersonas];
    }

    /**
     * Metodo que inserta una persona en la base de datos
     * 
     * @param persona
     * @return boolean
     */
    public boolean insertarPersona(Persona persona) {
        for (int i = 0; i < this.personas.length; i++) {
            if (this.personas[i] == null) {
                this.personas[i] = persona;
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo que modifica una persona en la base de datos
     * 
     * @param nombre
     * @return boolean
     */
    public boolean eliminarPersona(String nombre) {
        for (int i = 0; i < this.personas.length; i++) {
            if (this.personas[i] != null && this.personas[i].getNombre().equals(nombre)) {
                this.personas[i] = null;
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo que actualiza una persona en la base de datos
     * 
     * @param nombre
     * @param persona
     * @return boolean
     */
    public boolean actualizarPersona(String nombre, Persona persona) {
        for (int i = 0; i < this.personas.length; i++) {
            if (this.personas[i] != null && this.personas[i].getNombre().equals(nombre)) {
                this.personas[i] = persona;
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo que devuelve a las personas de la base de datos
     * Accion: Read
     * 
     * @return Persona[]
     */
    public Persona[] getPersonas() {
        return this.personas;
    }

    /**
     * Metodo que devuelve el id de la base de datos
     * 
     * @return String
     */
    public String getId() {
        return this.id;
    }

    /**
     * Metodo que modifica el valor del atributo id
     * 
     * @param id String
     */
    public void setId(String id) {
        this.id = id;
    }

}
