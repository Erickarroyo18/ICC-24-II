package icc.lab.modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class Carcel {
    private List<Prisionero> celdas;
    private Habitacion habitacion;
    private static final Logger LOGGER = Logger.getLogger(Carcel.class.getName());

    public Carcel() {
        this.celdas = new ArrayList<>();
        this.habitacion = new Habitacion();
    }

    public void resolverProblema() {
        Random r = new Random(1234);
        for (int i = 0; i < 5; i++) {
            if (i == 0) {
                this.celdas.add(new Vocero(i, true, false));
            } else {
                this.celdas.add(new Prisionero(i, false, false));
            }
        }
        while (true) {
            int indice = r.nextInt(5);
            Prisionero p = this.celdas.get(indice);
            boolean termina = this.habitacion.entraHabitacionSecuencial(p);
            if (termina) {
                LOGGER.info("Ganamos");
                break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

    }
}
