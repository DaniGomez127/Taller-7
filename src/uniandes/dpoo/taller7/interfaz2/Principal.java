package uniandes.dpoo.taller7.interfaz2;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Principal extends JFrame {
    public Principal() {
        // Configurar el título de la ventana
        setTitle("Juego de LightsOut");

        // Configurar el tamaño por defecto de la ventana
        setSize(800, 600);

        // Configurar el comportamiento de cierre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configurar el layout
        setLayout(new BorderLayout());

        // Crear e incluir los paneles
        PanelSuperior panelSuperior = new PanelSuperior();
        add(panelSuperior, BorderLayout.NORTH);

        PanelDerecha panelDerecha = new PanelDerecha();
        add(panelDerecha, BorderLayout.EAST);

        PanelInferior panelInferior = new PanelInferior();
        add(panelInferior, BorderLayout.SOUTH);

        // Hacer la ventana visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Crear una instancia de la ventana principal
        new Principal();
    }
}



