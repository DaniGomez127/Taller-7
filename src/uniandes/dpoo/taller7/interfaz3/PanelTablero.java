package uniandes.dpoo.taller7.interfaz3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelTablero extends JPanel implements MouseListener {
    private boolean[][] tablero;
    private RoundRectangle2D[][] casillas;
    private int altoCasilla;
    private int anchoCasilla;

    public PanelTablero() {
        addMouseListener(this);
    }

    public void setTablero(boolean[][] tablero) {
        this.tablero = tablero;
        int tamano = tablero.length;
        casillas = new RoundRectangle2D[tamano][tamano];
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (tablero != null) {
            Graphics2D g2 = (Graphics2D) g;
            int tamano = tablero.length;
            altoCasilla = (getHeight() - (10 * (tamano + 1))) / tamano;
            anchoCasilla = (getWidth() - (10 * (tamano + 1))) / tamano;
            for (int fila = 0; fila < tamano; fila++) {
                for (int columna = 0; columna < tamano; columna++) {
                    int x = 10 + columna * (anchoCasilla + 10);
                    int y = 10 + fila * (altoCasilla + 10);
                    casillas[fila][columna] = new RoundRectangle2D.Double(x, y, anchoCasilla, altoCasilla, 20, 20);
                    if (tablero[fila][columna]) {
                        g2.setColor(Color.YELLOW);
                    } else {
                        g2.setColor(Color.GRAY);
                    }
                    g2.fill(casillas[fila][columna]);
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        int[] casilla = convertirCoordenadasACasilla(x, y);
        if (casillas[casilla[0]][casilla[1]].contains(x, y)) {
            tablero[casilla[0]][casilla[1]] = !tablero[casilla[0]][casilla[1]];
            repaint();
        }
    }

    private int[] convertirCoordenadasACasilla(int x, int y) {
        int fila = (y - 10) / (altoCasilla + 10);
        int columna = (x - 10) / (anchoCasilla + 10);
        return new int[]{fila, columna};
    }

    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}
