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

public class InterfazQuicksor extends JFrame {
    //creamos los JTextField, JTable, DefaultTableModel
    private JTextField nombreTextField;
    private JTextArea intercambiosTextArea;
    private JTextArea inputTextArea;
    private JTextArea outputTextArea;
    private JTable dataTable;
    private DefaultTableModel tableModel;
    
    private JTextField buscarTextField;
    private JTextArea resultadoBusquedaTextArea;
    
//creamos el constructor
 public InterfazQuicksor() {
        // Configuramos el JFrame
    	setTitle("Registro Estudiante");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Creamos y configuramos componentes gráficos
        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(255, 182, 193));  // Color rosado

        JLabel tituloLabel = new JLabel("Registro Estudiante");
        tituloLabel.setBounds(10, 10, 200, 30);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(tituloLabel);


        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setBounds(10, 50, 100, 30);
        panel.add(nombreLabel);

        nombreTextField = new JTextField();
        nombreTextField.setBounds(120, 50, 240, 30);
        panel.add(nombreTextField);    

        JLabel infoAria = new JLabel("Ingrese el dinero que ingresó toda la semana");
        infoAria.setBounds(10, 90, 300, 30);
        panel.add(infoAria);

        inputTextArea = new JTextArea();
        JScrollPane inputScrollPane = new JScrollPane(inputTextArea);
        inputScrollPane.setBounds(10, 130, 350, 50);
        panel.add(inputScrollPane);

        JButton sortButton = new JButton("Ordenar");
        sortButton.setBounds(10, 210, 100, 30);
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

        JLabel infoOrden = new JLabel("Información de Pasos Ordenados:");
        infoOrden.setBounds(10, 240, 300, 30);
        panel.add(infoOrden);
        
        intercambiosTextArea = new JTextArea();
        intercambiosTextArea.setEditable(false);
        JScrollPane intercambiosScrollPane = new JScrollPane(intercambiosTextArea);
        intercambiosScrollPane.setBounds(10, 270, 350, 100);
        panel.add(intercambiosScrollPane);

        JLabel infoArreglo = new JLabel("Ingresos Realizados:");
        infoArreglo.setBounds(10, 410, 300, 30);
        panel.add(infoArreglo);

        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);
        JScrollPane outputScrollPane = new JScrollPane(outputTextArea);
        outputScrollPane.setBounds(10, 440, 350, 50);
        panel.add(outputScrollPane);
   
        // JButton para guardar
        JButton guardarButton = new JButton("Guardar");
        guardarButton.setBounds(130, 210, 100, 30);
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarDatos();
            }
        });
        panel.add(guardarButton);
        
        
        

        // JButton para eliminar
        JButton eliminarButton = new JButton("Eliminar");
        eliminarButton.setBounds(250, 210, 100, 30);
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarDatos();
            }
        });
        panel.add(eliminarButton);

        
        // JButton para buscar con método secuencial
        JLabel buscarLabel = new JLabel("Buscar:");
        buscarLabel.setBounds(10, 500, 50, 30);
        panel.add(buscarLabel);

        buscarTextField = new JTextField();
        buscarTextField.setBounds(70, 500, 100, 30);
        panel.add(buscarTextField);

        JButton buscarButton = new JButton("Buscar");
        buscarButton.setBounds(180, 500, 100, 30);
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                busquedaBinariaResultado(null);
            }
        });
        panel.add(buscarButton);

        resultadoBusquedaTextArea = new JTextArea();
        resultadoBusquedaTextArea.setEditable(false);
        JScrollPane resultadoBusquedaScrollPane = new JScrollPane(resultadoBusquedaTextArea);
        resultadoBusquedaScrollPane.setBounds(290, 500, 150, 30);
        panel.add(resultadoBusquedaScrollPane);
        
        // Configuramos la JTable
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Información del Arreglo");
        tableModel.addColumn("Rango Buscado");
        dataTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(dataTable);
        tableScrollPane.setBounds(400, 50, 430, 100);
        panel.add(tableScrollPane);       
        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
    }
    
    private void guardarDatos() {
        // Obtener los datos de los campos
        String nombre = nombreTextField.getText();
        String arreglo = outputTextArea.getText();
        // Realizar la búsqueda
        busquedaBinariaResultado(null);
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

    // Método para validar si la entrada es numérica
    private boolean validarEntradaNumerica(String entrada) {
        // Verificar si todos los caracteres son números o espacios
        return entrada.matches("^\\d+(\\s\\d+)*$");
    }

    // Método para mostrar un mensaje
    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
    
    // Método para ordenar el array utilizando el algoritmo QuickSort
    private void ordenarArray() {
        // Obtener el texto de entrada del área de texto
        String inputText = inputTextArea.getText();
        // Dividir el texto en elementos separados por espacio
        String[] elementos = inputText.split(" ");
        // Crear un array de enteros y convertir cada elemento del texto a entero
        int[] array = new int[elementos.length];
        for (int i = 0; i < elementos.length; i++) {
            array[i] = Integer.parseInt(elementos[i]);
        }
        // Llamar al método QuickSort para ordenar el array
        OrdenamientoQuickSort.quickSort(array, 0, array.length - 1, intercambiosTextArea);
        // Construir una cadena con los elementos ordenados y mostrarla en el área de texto de salida
        StringBuilder outputText = new StringBuilder();
        for (int num : array) {
            outputText.append(num).append(" ");
        }
        outputTextArea.setText(outputText.toString());
    }
    
   // Método para obtener el array ordenado
    private int[] obtenerArrayOrdenado() {
        // Obtener el texto de entrada del área de texto
        String inputText = inputTextArea.getText();
        // Dividir el texto en elementos separados por espacio
        String[] elementos = inputText.split(" ");
        // Crear un array de enteros y convertir cada elemento del texto a entero
        int[] array = new int[elementos.length];
        for (int i = 0; i < elementos.length; i++) {
            array[i] = Integer.parseInt(elementos[i]);
        }
        // Llamar al método QuickSort para ordenar el array
        OrdenamientoQuickSort.quickSort(array, 0, array.length - 1, intercambiosTextArea);
        return array;
    }
    
     private void busquedaBinariaResultado(ActionEvent e) {
        // Comienza el manejo del evento del botón de búsqueda
        // Verifica si la entrada en el campo de búsqueda es numérica
        if (validarEntradaNumerica(buscarTextField.getText())) {
            // Convierte la entrada a un entero
            int valorBuscado = Integer.parseInt(buscarTextField.getText());
            // Obtiene un array ordenado para realizar la búsqueda binaria
            int[] arrayOrdenado = obtenerArrayOrdenado();
            // Utiliza la clase BusquedaBinaria para realizar la búsqueda binaria
            int resultadoBusqueda = BusquedaBinaria.buscar(arrayOrdenado, valorBuscado);
            // Verifica el resultado de la búsqueda
            if (resultadoBusqueda != -1) {
                // Muestra la posición si el valor es encontrado
                resultadoBusquedaTextArea.setText("Encontrado en la posición: " + resultadoBusqueda);
            } else {
                // Muestra un mensaje si el valor no es encontrado en el array ordenado
                resultadoBusquedaTextArea.setText("No encontrado en el array ordenado.");
            }
        } else {
            // Muestra un mensaje de error si la entrada no es numérica
            mostrarMensaje("Ingrese solo números en el campo de búsqueda.");
        }
    }
     
     
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InterfazQuicksor().setVisible(true);
            }
        });
    }
    
}
