package icc.lab;

import java.util.List;
import java.util.logging.Logger;

/**
 * Clase que nos ayudara a generar combinaciones de letras para obtener la llave
 */
public class Secuencial {
    public static final Logger LOGGER = Logger.getLogger(Secuencial.class.getName());

    private Secuencial() {
        // contructor privado
    }

    public static void generarCombinacionesRecursivo(String alfabeto, String prefijo, int longitudRestante,
            List<String> resultado) {
        if (longitudRestante == 0) {
            String inicial = String.valueOf(prefijo.charAt(0)).toUpperCase();
            String cola = prefijo.substring(1);
            resultado.add(inicial + cola);
            return;
        }

        for (int i = 0; i < alfabeto.length(); i++) {
            char letra = alfabeto.charAt(i);
            generarCombinacionesRecursivo(alfabeto, prefijo + letra, longitudRestante - 1, resultado);
        }
    }

}
