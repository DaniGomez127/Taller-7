package uniandes.dpoo.taller7.interfaz3;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelInferior extends JPanel {
    private JTextField campoJugadas;
    private JTextField campoJugador;

    public PanelInferior() {
        setLayout(new FlowLayout());

        add(new JLabel("Jugadas:"));

        campoJugadas = new JTextField("0", 5);
        campoJugadas.setEditable(false);
        add(campoJugadas);

        add(new JLabel("Jugador:"));

        campoJugador = new JTextField("", 10);
        add(campoJugador);
    }
}
