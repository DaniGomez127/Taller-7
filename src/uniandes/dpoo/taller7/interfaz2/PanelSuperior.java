package uniandes.dpoo.taller7.interfaz2;

import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class PanelSuperior extends JPanel {
    private JComboBox<String> comboTama�o;
    private JRadioButton radioFacil;
    private JRadioButton radioMedio;
    private JRadioButton radioDificil;

    public PanelSuperior() {
        setLayout(new GridLayout(1, 6));

        add(new JLabel("Tama�o:"));

        comboTama�o = new JComboBox<>(new String[]{"3x3", "5x5", "9x9"});
        add(comboTama�o);

        add(new JLabel("Dificultad:"));

        radioFacil = new JRadioButton("F�cil");
        radioMedio = new JRadioButton("Medio");
        radioDificil = new JRadioButton("Dif�cil");

        ButtonGroup grupoDificultad = new ButtonGroup();
        grupoDificultad.add(radioFacil);
        grupoDificultad.add(radioMedio);
        grupoDificultad.add(radioDificil);

        add(radioFacil);
        add(radioMedio);
        add(radioDificil);
    }
}
