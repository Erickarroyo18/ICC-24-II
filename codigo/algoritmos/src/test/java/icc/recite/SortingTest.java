package icc.recite;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Random;
import org.junit.jupiter.api.Test;
import icc.recite.generico.SelectionSort;

/**
 * Clase de prueba para los algoritmos de ordenación.
 * 
 * @author Erick Arroyo
 * @version 1.0
 * 
 */
public class SortingTest {
    private final Integer N = 1000;

    /**
     * Verifica si un arreglo de enteros esta ordenado de forma ascendente.
     *
     * @param arr El arreglo que se desea verificar.
     * @return true si el arreglo está ordenado de forma ascendente, false en caso
     *         contrario.
     */
    public static boolean isSortedAscending(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Genera un arreglo de enteros pseudoaleatorios.
     *
     * @param n El tamannio del arreglo.
     * @return Un arreglo de enteros con valores pseudoaleatorios.
     */
    public static Integer[] generateRandomArray(int n) {
        Random random = new Random();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(100);
        }

        return arr;
    }


    @Test
    public void testInsertionSort() {
        Integer[] arr = generateRandomArray(N);

        long startTime = System.nanoTime();
        InsertionSort.insertionSort(arr);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("InsertionSort duration: " + duration + " ns");
        assertTrue(isSortedAscending(arr));
    }

    @Test
    public void testSelectionSort() {
        Integer[] arr = generateRandomArray(N);

        long startTime = System.nanoTime();
        SelectionSort.selectionSort(arr);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("SelectionSort duration: " + duration + " ns");
       assertTrue(isSortedAscending(arr));
    }

    @Test
    public void compareSortDurations() {
        Integer[] arr = generateRandomArray(N);

        Integer[] arrForInsertionSort = arr.clone();
        long startTime = System.nanoTime();
        InsertionSort.insertionSort(arrForInsertionSort);
        long endTime = System.nanoTime();
        long insertionSortDuration = endTime - startTime;

        Integer[] arrForSelectionSort = arr.clone();
        startTime = System.nanoTime();
        SelectionSort.selectionSort(arrForSelectionSort);
        endTime = System.nanoTime();
        long selectionSortDuration = endTime - startTime;

        System.out.println("InsertionSort duration: " + insertionSortDuration + " ns");
        System.out.println("SelectionSort duration: " + selectionSortDuration + " ns");

        if (insertionSortDuration < selectionSortDuration) {
            System.out.println("InsertionSort mas rapido.");
        } else {
            System.out.println("SelectionSort mas rapido.");
        }

        assertArrayEquals(arrForInsertionSort, arrForSelectionSort);
    }
}
