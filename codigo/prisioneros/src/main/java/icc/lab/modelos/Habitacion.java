package icc.lab.modelos;

import java.util.logging.Logger;

/**
 * Clase que fungira como habitacion
 * Se sabe que existe un interruptor que nos dice
 * si el foco esta prendido o no
 * Se desconoce el estado inicial del foco (Usar un random, para que sea
 * pseudoaleatorio el estado inicial)
 * 
 * @author Erick Arroyo
 * @version 1.0
 */
public class Habitacion {
    private Boolean prendido;
    private static final Integer PRISIONEROS = 5;
    private static final Logger LOGGER = Logger.getLogger(Habitacion.class.getName());

    /**
     * Metodo Constructor
     * Aqui se define el como estara el foco inicialmente
     */
    public Habitacion() {
        this.prendido = false;
    }

    public boolean entraHabitacionSecuencial(Prisionero prisionero) {
        if (Boolean.TRUE.equals(prisionero.esVocero)) {
            if (Boolean.FALSE.equals(this.prendido)) {
                if (Boolean.FALSE.equals(prisionero.marcado)) {
                    ((Vocero) prisionero).setContador(((Vocero) prisionero).getContador() + 1);
                    this.prendido = true;
                    prisionero.marcado = true;
                } else {
                    this.prendido = true;
                    ((Vocero) prisionero).setContador(((Vocero) prisionero).getContador() + 1);
                }
            }
            LOGGER.info("Contador : " + ((Vocero) prisionero).getContador());
            if (((Vocero) prisionero).getContador().equals(PRISIONEROS)) {

                return true;
            }
        } else {
            if (Boolean.TRUE.equals(this.prendido) &&  (prisionero.marcado.equals(Boolean.FALSE))) {
                    this.prendido = false;
                    prisionero.marcado = true;
                
            }
        }
        LOGGER.info("Entro el prisionero: " + prisionero.getId());
        return false;
    }

    public Boolean getPrendido() {
        return prendido;
    }

    public void setPrendido(Boolean prendido) {
        this.prendido = prendido;
    }

}
