/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bnara;

/**
 *
 * @author petee
 */
import java.util.Arrays;
import javax.swing.JTextArea;

public class OrdenamientoBurbuja {
    public static void ordenarBurbuja(int[] array, JTextArea intercambiosTextArea) {
        int n = array.length;
        boolean intercambio;

        for (int i = 0; i < n - 1; i++) {
            intercambio = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Intercambiar elementos
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    intercambio = true;

                    // Mostrar intercambios en el JTextArea
                    intercambiosTextArea.append(Arrays.toString(array) + "\n");
                }
            }

            // Si no hubo intercambios, el array ya está ordenado
            if (!intercambio) {
                break;
            }
        }
    }
}
