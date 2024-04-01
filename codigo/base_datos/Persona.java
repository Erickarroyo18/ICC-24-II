/**
 * Clase Persona que contiene los atributos y metodos de una persona
 * Simula los registros de una persona en una base de datos
 * @author Erick Arroyo
 * @version 1.0
 */
public class Persona {

    private String nombre;
    private int edad;
    private String sexo;
    private double peso;
    private double altura;

    /**
     * Constructor por defecto
     * 
     * @param nombre
     * @param edad
     * @param sexo
     */
    public Persona(String nombre, int edad, String sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.peso = 0;
        this.altura = 0;
    }

    /**
     * Constructor con todos los atributos
     * 
     * @param nombre
     * @param edad
     * @param sexo
     * @param peso
     * @param altura
     */
    public Persona(String nombre, int edad, String sexo, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
    }

    /**
     * Constructor por defecto
     */
    public String toString() {
        return "Nombre: " + this.nombre + "\nEdad: " + this.edad + "\nSexo: " + this.sexo + "\nPeso: " + this.peso
                + "\nAltura: " + this.altura;
    }

    /**
     * Metodo que modifica el valor del atributo nombre
     * 
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo que modifica el valor del atributo edad
     * 
     * @param edad
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Metodo que modifica el valor del atributo sexo
     * 
     * @param sexo
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * Metodo que modifica el valor del atributo peso
     * 
     * @param peso
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * Metodo que modifica el valor del atributo altura
     * 
     * @param altura
     */
    public void setAltura(double altura) {
        this.altura = altura;
    }

    /**
     * Metodo que retorna el valor del atributo nombre
     * 
     * @return String
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Metodo que retorna el valor del atributo edad
     * 
     * @return int
     */
    public int getEdad() {
        return this.edad;
    }

    /**
     * Metodo que retorna el valor del atributo sexo
     * 
     * @return String
     */
    public String getSexo() {
        return this.sexo;
    }

    /**
     * Metodo que retorna el valor del atributo peso
     * 
     * @return double
     */
    public double getPeso() {
        return this.peso;
    }

    /**
     * Metodo que retorna el valor del atributo altura
     * 
     * @return double
     */
    public double getAltura() {
        return this.altura;
    }
}