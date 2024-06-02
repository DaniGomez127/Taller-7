package uniandes.dpoo.taller7.interfaz4;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelTablero extends JPanel implements MouseListener {
    private boolean[][] tablero;
    private RoundRectangle2D[][] casillas;
    private int[][] cantidades;
    private int altoCasilla;
    private int anchoCasilla;
    private Principal principal;
    private int ultima_fila;
    private int ultima_columna;
    private Image imagenLuz;

    public PanelTablero(Principal principal) {
        this.principal = principal;
        addMouseListener(this);
        try {
            imagenLuz = ImageIO.read(new File("data/luz.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setTablero(boolean[][] tablero) {
        this.tablero = tablero;
        int tamano = tablero.length;
        casillas = new RoundRectangle2D[tamano][tamano];
        cantidades = new int[tamano][tamano];
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

                    // Crear gradiente
                    Color color1 = tablero[fila][columna] ? Color.YELLOW : Color.DARK_GRAY;
                    Color color2 = tablero[fila][columna] ? new Color(255, 255, 204) : Color.BLACK;
                    Paint gradiente = new GradientPaint(x, y, color1, x + anchoCasilla, y + altoCasilla, color2);
                    g2.setPaint(gradiente);
                    g2.fill(casillas[fila][columna]);

                    // Dibujar borde
                    g2.setColor(Color.BLACK);
                    g2.draw(casillas[fila][columna]);

                    // Dibujar imagen
                    int imageWidth = (int) (anchoCasilla * 0.8);
                    int imageHeight = (int) (altoCasilla * 0.8);
                    int imageX = x + (anchoCasilla - imageWidth) / 2;
                    int imageY = y + (altoCasilla - imageHeight) / 2;
                    g2.drawImage(imagenLuz, imageX, imageY, imageWidth, imageHeight, null);

                    // Dibujar texto con el número de veces que se ha presionado la casilla
                    g2.setColor(Color.BLACK);
                    g2.drawString(String.valueOf(cantidades[fila][columna]), x + anchoCasilla - 20, y + altoCasilla - 10);
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int click_x = e.getX();
        int click_y = e.getY();
        int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
        cantidades[casilla[0]][casilla[1]]++;
        principal.jugar(casilla[0], casilla[1]);
        this.ultima_fila = casilla[0];
        this.ultima_columna = casilla[1];
        repaint();
    }

    private int[] convertirCoordenadasACasilla(int x, int y) {
        int ladoTablero = tablero.length;
        int altoPanelTablero = getHeight();
        int anchoPanelTablero = getWidth();

        int altoCasilla = altoPanelTablero / ladoTablero;
        int anchoCasilla = anchoPanelTablero / ladoTablero;
        int fila = (int) (y / altoCasilla);
        int columna = (int) (x / anchoCasilla);

        return new int[] { fila, columna };
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
