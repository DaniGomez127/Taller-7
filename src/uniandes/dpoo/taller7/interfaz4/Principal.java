package uniandes.dpoo.taller7.interfaz4;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.formdev.flatlaf.FlatLightLaf;
import uniandes.dpoo.taller7.modelo.Top10;
import uniandes.dpoo.taller7.modelo.Tablero;

public class Principal extends JFrame {
    private PanelSuperior panelSuperior;
    private PanelDerecha panelDerecha;
    private PanelInferior panelInferior;
    private PanelTablero panelTablero;
    private Top10 top10;
    private Tablero tablero;

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

        panelTablero = new PanelTablero(this);
        add(panelTablero, BorderLayout.CENTER);

        // Crear Top10
        top10 = new Top10();
        top10.cargarRecords(new File("data/top10.csv")); // Asegúrate de cargar los registros existentes

        // Añadir listeners
        panelDerecha.getBotonNuevo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nuevoTablero();
            }
        });

        panelDerecha.getBotonReiniciar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reiniciarTablero();
            }
        });

        panelDerecha.getBotonTop10().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarTop10();
            }
        });

        panelDerecha.getBotonCambiarJugador().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarJugador();
            }
        });

        // Agregar WindowListener para salvar el Top10 al cerrar la ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                salvarTop10();
            }
        });

        // Hacer la ventana visible
        setVisible(true);
    }

    public void jugar(int fila, int columna) {
        tablero.jugar(fila, columna);
        panelInferior.actualizarPEstado(tablero.darJugadas(), panelInferior.getCampoJugador().getText());
        if (tablero.tableroIluminado()) {
            int puntaje = tablero.calcularPuntaje();
            if (top10.esTop10(puntaje)) {
                String jugador = panelInferior.getCampoJugador().getText();
                if (jugador == null || jugador.isEmpty()) {
                    jugador = "Invitado";
                }
                top10.agregarRegistro(jugador, puntaje);
                mostrarTop10(); // Mostrar el Top10 cuando se gana
            }
            JOptionPane.showMessageDialog(this, "¡Felicidades! Has ganado.", "Juego Completado", JOptionPane.INFORMATION_MESSAGE);
            tablero = null;
        }
    }

    private void nuevoTablero() {
        int tamano = panelSuperior.getComboTamaño().getSelectedIndex() == 0 ? 3 : (panelSuperior.getComboTamaño().getSelectedIndex() == 1 ? 5 : 9);
        int dificultad = panelSuperior.getRadioFacil().isSelected() ? 5 : (panelSuperior.getRadioMedio().isSelected() ? 10 : 15);
        tablero = new Tablero(tamano);
        tablero.desordenar(dificultad);
        panelTablero.setTablero(tablero.darTablero());
        panelInferior.actualizarPEstado(0, panelInferior.getCampoJugador().getText());
    }

    private void reiniciarTablero() {
        if (tablero != null) {
            tablero.reiniciar();
            panelTablero.setTablero(tablero.darTablero());
            panelInferior.actualizarPEstado(0, panelInferior.getCampoJugador().getText());
        }
    }

    private void mostrarTop10() {
        Top10Dialog dialog = new Top10Dialog(this, top10);
        dialog.setVisible(true);
    }

    private void cambiarJugador() {
        String jugador = JOptionPane.showInputDialog(this, "Ingrese el nombre del jugador:", "Cambiar Jugador", JOptionPane.PLAIN_MESSAGE);
        if (jugador != null && !jugador.trim().isEmpty()) {
            panelInferior.actualizarPEstado(tablero != null ? tablero.darJugadas() : 0, jugador);
        }
    }

    private void salvarTop10() {
        try {
            top10.salvarRecords(new File("data/top10.csv"));
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FlatLightLaf.install();
        new Principal();
    }
}





