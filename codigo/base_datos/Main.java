/**
 * Clase Main que contiene el método main para probar la clase BaseDatos y
 * Persona.
 * Simula el uso de una base de datos con registros de personas.
 * 
 * @author Erick Arroyo
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        // Instanciando la clase BaseDatos
        BaseDatos bd1 = new BaseDatos("1", 10);
        BaseDatos bd2 = new BaseDatos("2", 10);
        // Instanciando la clase Persona
        Persona p1 = new Persona("Juan", 20, "M");
        Persona p2 = new Persona("Maria", 25, "F");
        Persona p3 = new Persona("Pedro", 30, "M");
        Persona p4 = new Persona("Ana", 35, "F");
        // Insertando personas en la base de datos
        bd1.insertarPersona(p1);
        bd1.insertarPersona(p2);
        bd2.insertarPersona(p3);
        bd2.insertarPersona(p4);
        // Imprimiendo la base de datos
        System.out.println("Base de datos 1");
        for (Persona p : bd1.getPersonas()) {
            if (p != null) {
                System.out.println(p);
            }
        }
        System.out.println("Base de datos 2");
        for (Persona p : bd2.getPersonas()) {
            if (p != null) {
                System.out.println(p);
            }
        }
        // Eliminando una persona de la base de datos
        bd1.eliminarPersona("Juan");
        // Actualizando una persona de la base de datos
        bd2.actualizarPersona("Pedro", new Persona("Pedro", 30, "M", 70, 1.70));
        // Imprimiendo la base de datos
        System.out.println("Base de datos 1");
        for (Persona p : bd1.getPersonas()) {
            if (p != null) {
                System.out.println(p);
            }
        }
        System.out.println("Base de datos 2");
        for (Persona p : bd2.getPersonas()) {
            if (p != null) {
                System.out.println(p);
            }
        }
    }
}
