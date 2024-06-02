package uniandes.dpoo.taller7.interfaz4;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelInferior extends JPanel {
    private JLabel lJugadas;
    private JTextField campoJugadas;
    private JLabel lJugador;
    private JTextField campoJugador;

    public PanelInferior() {
        this.setLayout(new FlowLayout());
        this.setBackground(Color.LIGHT_GRAY);

        lJugadas = new JLabel("Jugadas: ");
        campoJugadas = new JTextField("0", 5);
        campoJugadas.setEditable(false);

        lJugador = new JLabel("Jugador: ");
        campoJugador = new JTextField("Invitado", 10);
        campoJugador.setEditable(false);

        this.add(lJugadas);
        this.add(campoJugadas);
        this.add(lJugador);
        this.add(campoJugador);
    }

    public void actualizarPEstado(int jugadas, String jugador) {
        campoJugadas.setText(Integer.toString(jugadas));
        campoJugador.setText(jugador);
    }

    public JTextField getCampoJugador() {
        return campoJugador;
    }

    public JTextField getCampoJugadas() {
        return campoJugadas;
    }
}

