package uniandes.dpoo.taller7.interfaz3;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Principal extends JFrame {
    private PanelSuperior panelSuperior;
    private PanelDerecha panelDerecha;
    private PanelInferior panelInferior;
    private PanelTablero panelTablero;

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
        panelSuperior = new PanelSuperior();
        add(panelSuperior, BorderLayout.NORTH);

        panelDerecha = new PanelDerecha();
        add(panelDerecha, BorderLayout.EAST);

        panelInferior = new PanelInferior();
        add(panelInferior, BorderLayout.SOUTH);

        panelTablero = new PanelTablero();
        add(panelTablero, BorderLayout.CENTER);

        // Hacer la ventana visible
        setVisible(true);
    }

    public void setTablero(boolean[][] tablero) {
        panelTablero.setTablero(tablero);
    }

    public static void main(String[] args) {
        // Crear una instancia de la ventana principal
        Principal ventana = new Principal();
        // Ejemplo de tablero
        boolean[][] tablero = new boolean[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                tablero[i][j] = true;
            }
        }
        ventana.setTablero(tablero);
    }
}


