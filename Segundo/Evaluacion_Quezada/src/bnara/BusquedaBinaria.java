/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bnara;

/**
 *
 * @author petee
 */

// Declaración de la clase BusquedaBinaria
public class BusquedaBinaria {
    // Método estático para realizar la búsqueda binaria en un array
    public static int buscar(int[] array, int valorBuscado) {
        // Inicialización de los índices izquierda y derecha para la búsqueda binaria
        int izquierda = 0;
        int derecha = array.length - 1;
        // Bucle mientras el índice izquierdo sea menor o igual al índice derecho
        while (izquierda <= derecha) {
            // Cálculo del índice medio para la búsqueda binaria
            int medio = izquierda + (derecha - izquierda) / 2;
           // Verificación si el valor en la posición media es igual al valor buscado
            if (array[medio] == valorBuscado) {
                // Si es igual, se retorna el índice medio como resultado de la búsqueda
                return medio;
            }
           // Si el valor en la posición media es menor que el valor buscado
            if (array[medio] < valorBuscado) {
                // Se actualiza el índice izquierdo para buscar en la mitad derecha del array
                izquierda = medio + 1;
            } else {
                // Si el valor en la posición media es mayor que el valor buscado
                // Se actualiza el índice derecho para buscar en la mitad izquierda del array
                derecha = medio - 1;
            }
        }
        // Si no se encuentra el valor buscado, se retorna -1
        return -1;
    }
}
