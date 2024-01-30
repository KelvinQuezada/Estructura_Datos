/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bnara;

/**
 *
 * @author petee
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class InterfazOrbuja extends JFrame {
    private JTextField nombreTextField;
    private JTextArea inputTextArea;
    private JTextArea intercambiosTextArea;
    private JTextArea outputTextArea;
    private JTable dataTable;
    private DefaultTableModel tableModel;
    private JTextField buscarTextField;
    private JTextArea resultadoBusquedaTextArea;

    public InterfazOrbuja() {
        setTitle("Principal");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierre al hacer clic en la "X"
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
         // Configuración del color de fondo en color celeste
        getContentPane().setBackground(Color.CYAN);

        // Creación y configuración de componentes gráficos
        JPanel panel = new JPanel(null);
        // Configuración del color de fondo en color celeste
        panel.setBackground(Color.CYAN);
        JLabel titleLabel = new JLabel("Registro de Estudiante"); // Etiqueta para el título
        titleLabel.setBounds(400,10, 400, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Estilo del título
        panel.add(titleLabel);
        
        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setBounds(10, 40, 100, 30);
        panel.add(nombreLabel);

        nombreTextField = new JTextField();
        nombreTextField.setBounds(120, 40, 150, 30);
        panel.add(nombreTextField);

        JLabel infoAria = new JLabel("Ingrese Notas");
        infoAria.setBounds(10, 80, 300, 30);
        panel.add(infoAria);

        inputTextArea = new JTextArea();
        JScrollPane inputScrollPane = new JScrollPane(inputTextArea);
        inputScrollPane.setBounds(10, 110, 350, 70);
        panel.add(inputScrollPane);

        JButton sortButton = new JButton("Ordenar");
        sortButton.setBounds(10, 200, 100, 30);
        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validarEntradaNumerica(inputTextArea.getText())) {
                    ordenarArray();
                } else {
                    mostrarMensaje("Ingrese solo números en el área de texto.");
                }
            }
        });
        panel.add(sortButton); 
        JLabel infoOrden = new JLabel("Notas en Cambio de Ordenados:");
        infoOrden.setBounds(10, 250, 300, 30);
        panel.add(infoOrden);

        intercambiosTextArea = new JTextArea();
        intercambiosTextArea.setEditable(false);
        JScrollPane intercambiosScrollPane = new JScrollPane(intercambiosTextArea);
        intercambiosScrollPane.setBounds(10, 280, 350, 100);
        panel.add(intercambiosScrollPane);

        JLabel infoArreglo = new JLabel("Notas Ordenadas Realizados:");
        infoArreglo.setBounds(10, 370, 300, 30);
        panel.add(infoArreglo);

        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);
        JScrollPane outputScrollPane = new JScrollPane(outputTextArea);
        outputScrollPane.setBounds(10, 400, 350, 50);
        panel.add(outputScrollPane);

        JButton guardarButton = new JButton("Guardar");
        guardarButton.setBounds(130, 200, 100, 30);
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarDatos();
            }
        });
        panel.add(guardarButton);

        JButton eliminarButton = new JButton("Eliminar");
        eliminarButton.setBounds(250, 200, 100, 30);
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarDatos();
            }
        });
        panel.add(eliminarButton);

        JLabel buscarLabel = new JLabel("Buscar:");
        buscarLabel.setBounds(10, 480, 50, 30);
        panel.add(buscarLabel);

        buscarTextField = new JTextField();
        buscarTextField.setBounds(70, 480, 100, 30);
        panel.add(buscarTextField);

        JButton buscarButton = new JButton("Buscar");
        buscarButton.setBounds(180, 480, 100, 30);
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarSecuencial();
            }
        });
        panel.add(buscarButton);
   
        resultadoBusquedaTextArea = new JTextArea();
        resultadoBusquedaTextArea.setEditable(false);
        JScrollPane resultadoBusquedaScrollPane = new JScrollPane(resultadoBusquedaTextArea);
        resultadoBusquedaScrollPane.setBounds(290, 480, 150, 30);
        panel.add(resultadoBusquedaScrollPane);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Información del Arreglo");
        tableModel.addColumn("Numero buscado");
        dataTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(dataTable);
        tableScrollPane.setBounds(400, 50, 430, 100);
        panel.add(tableScrollPane);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
    }
    private boolean validarEntradaNumerica(String entrada) {
        // Verificar si todos los caracteres son números o espacios
        return entrada.matches("^\\d+(\\s\\d+)*$");
        
    }
    // Método para mostrar un mensaje
    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
    
    private void guardarDatos() {
        // Obtener los datos de los campos
        String nombre = nombreTextField.getText();
        String arreglo = outputTextArea.getText();      
        // Realizar la búsqueda
        buscarSecuencial();
        // Obtener el valor buscado
        String valorBuscado = resultadoBusquedaTextArea.getText().replaceAll("\\D", ""); // Obtener solo los dígitos
        // Agregar datos a la tabla
        Vector<String> rowData = new Vector<>();
        rowData.add(nombre);
        rowData.add(arreglo);
        rowData.add(valorBuscado);
        tableModel.addRow(rowData);
        // Limpiar los campos después de guardar
        nombreTextField.setText("");
        inputTextArea.setText("");
        outputTextArea.setText("");
        buscarTextField.setText("");
        resultadoBusquedaTextArea.setText("");
        intercambiosTextArea.setText("");
    }

    private void eliminarDatos() {
        int selectedRow = dataTable.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.removeRow(selectedRow);
        }
    }

    // Reemplaza el método ordenarArray con el siguiente código
private void ordenarArray() {
    String inputText = inputTextArea.getText();
        String[] elementos = inputText.split(" ");
        int[] array = new int[elementos.length];
        for (int i = 0; i < elementos.length; i++) {
            array[i] = Integer.parseInt(elementos[i]);
        }
         // Llama al método de ordenamiento por burbuja con el JTextArea para mostrar intercambios
        OrdenamientoBurbuja.ordenarBurbuja(array, intercambiosTextArea);
        // Mostrar el array ordenado en el área de texto de salida
        StringBuilder outputText = new StringBuilder();
        for (int num : array) {
            outputText.append(num).append(" ");
        }
        outputTextArea.setText(outputText.toString());
    }

   


    
    private void buscarSecuencial() {
        String valorBuscar = buscarTextField.getText();
        if (!valorBuscar.isEmpty()) {
            int valorBuscado = Integer.parseInt(valorBuscar);
            int[] array = obtenerArrayOrdenado(); // Obtener el array ordenado

            // Utilizar la clase SecuencialSearch para realizar la búsqueda secuencial
            int indice = SecuencialSearch.buscarSecuencial(array, valorBuscado);

            // Mostrar el resultado de la búsqueda
            if (indice != -1) {
                resultadoBusquedaTextArea.setText("Encontrado en índice: " + indice);
                
            } else {
                resultadoBusquedaTextArea.setText("No encontrado");
            }
        } else {
            resultadoBusquedaTextArea.setText("Ingrese un valor para buscar");
        }
    }
    //metodo 
    private int[] obtenerArrayOrdenado() {
    String inputText = inputTextArea.getText();
    String[] elementos = inputText.split(" ");
    int[] array = new int[elementos.length];
    for (int i = 0; i < elementos.length; i++) {
        array[i] = Integer.parseInt(elementos[i]);
    }
    // Llama al método de ordenamiento por burbuja con el JTextArea para mostrar intercambios
    OrdenamientoBurbuja.ordenarBurbuja(array, intercambiosTextArea);
    return array;
}
    
  

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InterfazOrbuja().setVisible(true);
            }
        });
    }
}
