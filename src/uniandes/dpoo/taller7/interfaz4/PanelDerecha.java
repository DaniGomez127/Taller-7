package uniandes.dpoo.taller7.interfaz4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelDerecha extends JPanel implements ActionListener {
    private JButton botonNuevo;
    private JButton botonReiniciar;
    private JButton botonTop10;
    private JButton botonCambiarJugador;

    public PanelDerecha() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(72, 156, 225));

        botonNuevo = new JButton("NUEVO");
        botonReiniciar = new JButton("REINICIAR");
        botonTop10 = new JButton("TOP-10");
        botonCambiarJugador = new JButton("CAMBIAR JUGADOR");

        Dimension buttonSize = new Dimension(200, 40);
        botonNuevo.setPreferredSize(buttonSize);
        botonNuevo.setMaximumSize(buttonSize);
        botonNuevo.setMinimumSize(buttonSize);

        botonReiniciar.setPreferredSize(buttonSize);
        botonReiniciar.setMaximumSize(buttonSize);
        botonReiniciar.setMinimumSize(buttonSize);

        botonTop10.setPreferredSize(buttonSize);
        botonTop10.setMaximumSize(buttonSize);
        botonTop10.setMinimumSize(buttonSize);

        botonCambiarJugador.setPreferredSize(buttonSize);
        botonCambiarJugador.setMaximumSize(buttonSize);
        botonCambiarJugador.setMinimumSize(buttonSize);

        botonNuevo.addActionListener(this);
        botonReiniciar.addActionListener(this);
        botonTop10.addActionListener(this);
        botonCambiarJugador.addActionListener(this);

        add(Box.createVerticalGlue());
        add(botonNuevo);
        add(Box.createVerticalStrut(10));
        add(botonReiniciar);
        add(Box.createVerticalStrut(10));
        add(botonTop10);
        add(Box.createVerticalStrut(10));
        add(botonCambiarJugador);
        add(Box.createVerticalGlue());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if (comando.equals("NUEVO")) {
            // acción para el botón NUEVO
        } else if (comando.equals("REINICIAR")) {
            // acción para el botón REINICIAR
        } else if (comando.equals("TOP-10")) {
            // acción para el botón TOP-10
        } else if (comando.equals("CAMBIAR JUGADOR")) {
            // acción para el botón CAMBIAR JUGADOR
        }
    }

    public JButton getBotonNuevo() {
        return botonNuevo;
    }

    public JButton getBotonReiniciar() {
        return botonReiniciar;
    }

    public JButton getBotonTop10() {
        return botonTop10;
    }

    public JButton getBotonCambiarJugador() {
        return botonCambiarJugador;
    }
}

