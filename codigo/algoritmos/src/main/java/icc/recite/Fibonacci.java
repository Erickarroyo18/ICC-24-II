package icc.recite;

import java.util.logging.Logger;

/**
 * Clase que implementa dos métodos para calcular el n-esimo número de la secuencia de Fibonacci,
 * uno de forma recursiva y otro de forma iterativa.
 * @author Erick Arroyo
 * @version 1.0
 */
public class Fibonacci {
    protected static final Logger LOGGER = Logger.getLogger(Fibonacci.class.getName());
    /**
     * Método que calcula el n-esimo número en la secuencia de Fibonacci utilizando recursión.
     *
     * @param n El índice de la secuencia que se quiere calcular.
     * @return El valor correspondiente al n-esimo número de Fibonacci.
     */
    public static int fibonacciRecursivo(int n) {
        // Caso base: si n es 0 o 1, simplemente devolvemos el valor de n
        if (n <= 1) {
            return n;
        } else {
            // Caso recursivo: sumamos los dos numeros anteriores en la secuencia
            return fibonacciRecursivo(n - 1) + fibonacciRecursivo(n - 2);
        }
    }

    /**
     * Método que calcula el n-esimo número en la secuencia de Fibonacci utilizando un enfoque iterativo.
     *
     * @param n El índice de la secuencia que se quiere calcular.
     * @return El valor correspondiente al n-ésimo número de Fibonacci.
     */
    public static int fibonacciIterativo(int n) {
        // Caso base: si n es 0 o 1, simplemente devolvemos el valor de n
        if (n <= 1) {
            return n;
        }

        // Inicializamos las primeras dos posiciones de la secuencia de Fibonacci
        int prev1 = 0, prev2 = 1, current = 0;

        // Bucle para calcular el n-esimo número
        for (int i = 2; i <= n; i++) {
            current = prev1 + prev2; // Calculamos el siguiente valor en la secuencia
            prev1 = prev2; // Actualizamos prev1 al valor anterior de prev2
            prev2 = current; // Actualizamos prev2 al valor recién calculado
        }

        // Devolvemos el valor final calculado
        return current;
    }

    /**
     * Método principal que prueba ambas implementaciones de Fibonacci.
     *
     * @param args Argumentos de línea de comandos (no se utilizan en este programa).
     */
    public static void main(String[] args) {
        // Cambia este valor para probar diferentes indices de la secuencia
        int numero = 10;

        // Prueba y muestra los resultados para ambos metodos
        LOGGER.info("Fibonacci recursivo para " + numero + ": " + fibonacciRecursivo(numero));
        LOGGER.info("Fibonacci iterativo para " + numero + ": " + fibonacciIterativo(numero));
    }
}

