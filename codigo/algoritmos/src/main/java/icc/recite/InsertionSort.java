package icc.recite;

import java.util.logging.Logger;

/**
 * Clase que implementa el algoritmo de ordenación por inserción (insertion
 * sort)
 * de forma iterativa.
 * 
 * @author Erick Arroyo
 * @version 1.1
 */
public class InsertionSort {

    protected static final Logger LOGGER = Logger.getLogger(InsertionSort.class.getName());

    /**
     * Método que ordena un arreglo utilizando el algoritmo de ordenación por
     * inserción.
     *
     * @param arr El arreglo que se desea ordenar.
     */
    public static void insertionSort(Integer[] arr) {
        // Recorre el arreglo comenzando desde el segundo elemento
        for (int i = 1; i < arr.length; i++) {
            // El valor que vamos a insertar en la parte ordenada
            int key = arr[i];
            int j = i - 1;

            // Mueve los elementos que son mayores que la clave hacia la derecha
            // para hacer espacio para la clave
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }

            // Coloca la clave en la posición correcta dentro de la parte ordenada
            arr[j + 1] = key;
        }
    }

    /**
     * Método principal para probar la función de ordenación por inserción.
     *
     * @param args Argumentos de línea de comandos (no se utilizan en este
     *             programa).
     */
    public static void main(String[] args) {
        // Arreglo de prueba para ordenación
        Integer[] array = { 12, 11, 13, 5, 6 };

        LOGGER.info("Arreglo original:");
        printArray(array);

        // Llama al método de ordenación por inserción
        insertionSort(array);

        LOGGER.info("Arreglo ordenado:");
        printArray(array);
    }

    /**
     * Método auxiliar para imprimir el contenido de un arreglo.
     *
     * @param arr El arreglo que se desea imprimir.
     */
    public static void printArray(Integer[] arr) {
        for (int value : arr) {
            LOGGER.info(value + " ");
        }
        LOGGER.info("\n");
    }
}
