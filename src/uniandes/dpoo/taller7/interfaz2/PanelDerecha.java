package uniandes.dpoo.taller7.interfaz2;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelDerecha extends JPanel {
    private JButton botonNuevo;
    private JButton botonReiniciar;
    private JButton botonTop10;
    private JButton botonCambiarJugador;

    public PanelDerecha() {
        setLayout(new GridLayout(4, 1, 5, 5));

        botonNuevo = new JButton("NUEVO");
        botonReiniciar = new JButton("REINICIAR");
        botonTop10 = new JButton("TOP-10");
        botonCambiarJugador = new JButton("CAMBIAR JUGADOR");

        add(botonNuevo);
        add(botonReiniciar);
        add(botonTop10);
        add(botonCambiarJugador);
    }
}
