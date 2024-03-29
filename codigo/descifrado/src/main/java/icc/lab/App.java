package icc.lab;

import java.util.ArrayList;
import java.util.List;

import icc.lab.constantes.Constante;

/**
 * Clase que ejecuta un ejemplo de uso de la clase Secuencial
 *
 */
public class App {
   public static void main(String[] args) throws Exception {
        List<String> combinaciones = new ArrayList<>();
        Secuencial.generarCombinacionesRecursivo(Constante.ALFABETO, "", 4, combinaciones);
        if (!combinaciones.isEmpty()) {
            Secuencial.LOGGER.info(String.format("Combinaciones generadas: %d", combinaciones.size()));
        }
        for (int i = 0; i < combinaciones.size(); i++) {
            if (Cifrar.descifraC(Constante.LLAVE_HOLA, combinaciones.get(i))) {
                Secuencial.LOGGER.info(String.format("La contrasenna es: %s", combinaciones.get(i)));
                break;
            }
        }
    }
}
