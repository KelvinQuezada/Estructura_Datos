package bnara;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal extends JFrame {

    public MenuPrincipal() {
        setTitle("Menu Principal de Estudiante");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear panel con fondo amarillo
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setBackground(Color.YELLOW);

        // Crear label
        JLabel label = new JLabel("Menu de Registro de Estudiante");
        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setForeground(Color.BLUE);

        // Crear botones
        JButton btnBurbuja = new JButton("Burbuja");
        JButton btnQuickSort = new JButton("QuickSort"); // Agregado el botón QuickSort

        // Agregar ActionListener a los botones
        btnBurbuja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para el método de burbuja
                new InterfazOrbuja().setVisible(true);
            }
        });

        btnQuickSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir la interfaz de QuickSort al hacer clic en el botón QuickSort
                new InterfazQuicksor().setVisible(true);
            }
        });

        // Agregar label y botones al panel
        panel.add(label);
        panel.add(btnBurbuja);
        panel.add(btnQuickSort); // Agregado el botón QuickSort

        // Agregar panel al JFrame
        add(panel);

        // Hacer visible la interfaz
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MenuPrincipal();
            }
        });
    }
}
