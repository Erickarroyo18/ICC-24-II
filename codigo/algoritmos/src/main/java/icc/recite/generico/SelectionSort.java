package icc.recite.generico;

import java.util.logging.Logger;

/**
 * Clase que implementa el algoritmo de ordenación por selección (selection
 * sort)
 * usando tipos genéricos.
 * 
 * @author Erick Arroyo
 * @version 1.0
 */
public class SelectionSort {

    protected static final Logger LOGGER = Logger.getLogger(SelectionSort.class.getName());

    /**
     * Método que ordena un arreglo utilizando el algoritmo de ordenación por
     * selección.
     *
     * @param <T> El tipo de los elementos del arreglo, que debe implementar
     *            Comparable.
     * @param arr El arreglo genérico que se desea ordenar.
     */
    public static <T extends Comparable<T>> void selectionSort(T[] arr) {
        int n = arr.length;

        // Recorre cada posición en el arreglo para encontrar el valor mínimo
        for (int i = 0; i < n - 1; i++) {
            // Supone que el elemento actual es el menor
            int minIndex = i;

            // Recorre los elementos restantes para encontrar el menor
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j; // Encuentra un índice de valor mínimo
                }
            }

            // Intercambia el elemento menor encontrado con el primero de la sublista
            if (minIndex != i) {
                T temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }

    /**
     * Método principal para probar la función de ordenación por selección con
     * diferentes tipos de datos.
     *
     * @param args Argumentos de línea de comandos (no se utilizan en este
     *             programa).
     */
    public static void main(String[] args) {
        // Ejemplo de arreglo de enteros
        Integer[] intArray = { 64, 25, 12, 22, 11 };
        LOGGER.info("Arreglo original de enteros:");
        printArray(intArray);

        selectionSort(intArray);
        LOGGER.info("Arreglo ordenado de enteros:");
        printArray(intArray);

        // Ejemplo de arreglo de cadenas
        String[] strArray = { "manzana", "naranja", "uva", "banana", "pera" };
        LOGGER.info("\nArreglo original de cadenas:");
        printArray(strArray);

        selectionSort(strArray);
        LOGGER.info("Arreglo ordenado de cadenas:");
        printArray(strArray);
    }

    /**
     * Método auxiliar para imprimir el contenido de un arreglo.
     *
     * @param <T> El tipo de los elementos del arreglo.
     * @param arr El arreglo que se desea imprimir.
     */
    public static <T> void printArray(T[] arr) {
        for (T value : arr) {
            LOGGER.info(value + " ");
        }
        LOGGER.info("n");
    }
}
