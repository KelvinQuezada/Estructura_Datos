/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bnara;
import java.util.Scanner;
import javax.swing.JTextArea;
/**
 *
 * @author petee
 */
import javax.swing.JTextArea;
// Comentarios para el código de OrdenamientoQuickSort

// Declaración de la clase OrdenamientoQuickSort
public class OrdenamientoQuickSort {
    // Método principal quickSort para ordenar el array mediante el algoritmo QuickSort
    public static void quickSort(int[] array, int inicio, int fin, JTextArea intercambiosTextArea) {
        // Verifica si hay más de un elemento en el array
        if (inicio < fin) {
            // Obtiene el índice del pivote después de realizar la partición
            int indicePivote = particion(array, inicio, fin, intercambiosTextArea);         
            // Llama recursivamente al quickSort para la sublista izquierda del pivote
            quickSort(array, inicio, indicePivote - 1, intercambiosTextArea);         
            // Llama recursivamente al quickSort para la sublista derecha del pivote
            quickSort(array, indicePivote + 1, fin, intercambiosTextArea);
        }
    }

    // Método para realizar la partición del array y devolver el índice del pivote
    public static int particion(int[] array, int inicio, int fin, JTextArea intercambiosTextArea) {
        // Elige el último elemento como pivote
        int pivote = array[fin];     
        // Inicializa el índice del elemento menor
        int i = inicio - 1;
        // Itera a través de la sublista
        for (int j = inicio; j < fin; j++) {
            // Compara cada elemento con el pivote
            if (array[j] < pivote) {
                // Incrementa el índice del elemento menor y realiza el intercambio
                i++;
                intercambiar(array, i, j, intercambiosTextArea);
            }
        }    
        // Coloca el pivote en su posición correcta después de la partición
        intercambiar(array, i + 1, fin, intercambiosTextArea);        
        // Devuelve el índice del pivote
        return i + 1;
    }

    // Método para intercambiar dos elementos en el array y mostrar el intercambio en el JTextArea
    public static void intercambiar(int[] array, int i, int j, JTextArea intercambiosTextArea) {
        // Realiza el intercambio de elementos en el array
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

        // Agrega la impresión del intercambio paso a paso en el JTextArea
        String intercambio = "Intercambio: " + array[i] + " <-> " + array[j] + "\n";
        intercambiosTextArea.append(intercambio);
    }
    
}
