package uniandes.dpoo.taller7.interfaz1;

import javax.swing.JFrame;

public class Principal extends JFrame {
    public Principal() {
        // Configurar el título de la ventana
        setTitle("Juego de LightsOut");

        // Configurar el tamaño por defecto de la ventana
        setSize(800, 600);

        // Configurar el comportamiento de cierre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Hacer la ventana visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Crear una instancia de la ventana principal
        new Principal();
    }
}


