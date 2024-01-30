package bnara;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author petee
 */
public class SecuencialSearch {
	// Este método toma un array y un valor a buscar y devuelve la posición
	// del valor buscado en el array o -1 si no se encuentra.
	public static int buscarSecuencial(int[] array, int valorBuscado) {
	    // Se utiliza un bucle for para recorrer el array.
	    for (int i = 0; i < array.length; i++) {
	        // Se verifica si el elemento actual es igual al valor buscado.
	        if (array[i] == valorBuscado) {
	            // Si se encuentra el valor, se devuelve la posición.
	            return i;
	        }
	    }
	    // Si el valor no se encuentra, se devuelve -1.
	    return -1;
	}
}