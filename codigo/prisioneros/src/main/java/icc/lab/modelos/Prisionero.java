package icc.lab.modelos;

/**
 * Clase que modela un prisioner
 * 
 * @version 1.0
 * @author Erick Arroyo
 */
public class Prisionero {
    protected Integer id;
    protected Boolean esVocero;
    protected Boolean marcado;
    protected Integer contadorInterno;

    /**
     * Metodo constructor para generar un prisionero
     * 
     * @param id       El identificador del prisionero
     * @param esVocero true si es Vocero false en otro caso
     * @param marcado  true si ya paso
     */
    public Prisionero(Integer id, Boolean esVocero, Boolean marcado) {
        this.id = id;
        this.esVocero = esVocero;
        this.marcado = marcado;
        this.contadorInterno = 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getEsVocero() {
        return esVocero;
    }

    public void setEsVocero(Boolean esVocero) {
        this.esVocero = esVocero;
    }

    public Boolean getMarcado() {
        return marcado;
    }

    public void setMarcado(Boolean marcado) {
        this.marcado = marcado;
    }

    @Override
    public String toString() {
        return "Prisionero [id=" + id + ", esVocero=" + esVocero + ", marcado=" + marcado + "]";
    }

}
