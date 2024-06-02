package uniandes.dpoo.taller7.interfaz4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;

import uniandes.dpoo.taller7.modelo.RegistroTop10;
import uniandes.dpoo.taller7.modelo.Top10;

@SuppressWarnings("serial")
public class Top10Dialog extends JDialog {
    private Top10 top10;

    public Top10Dialog(Principal principal, Top10 top10) {
        super(principal, "Top 10", true);
        this.top10 = top10;

        setLayout(new BorderLayout());

        DefaultListModel<RegistroTop10> listModel = new DefaultListModel<>();
        for (RegistroTop10 registro : top10.darRegistros()) {
            listModel.addElement(registro);
        }

        JList<RegistroTop10> list = new JList<>(listModel);
        list.setCellRenderer(new Top10CellRenderer());
        JScrollPane scrollPane = new JScrollPane(list);
        add(scrollPane, BorderLayout.CENTER);

        setSize(300, 400);
        setLocationRelativeTo(principal);
    }

    private class Top10CellRenderer extends JPanel implements ListCellRenderer<RegistroTop10> {
        private JLabel lblPosicion;
        private JLabel lblNombre;
        private JLabel lblPuntaje;

        public Top10CellRenderer() {
            setLayout(new BorderLayout());
            lblPosicion = new JLabel();
            lblNombre = new JLabel();
            lblPuntaje = new JLabel();

            lblPosicion.setFont(new Font("Arial", Font.BOLD, 16));
            lblNombre.setFont(new Font("Arial", Font.BOLD, 16));
            lblPuntaje.setFont(new Font("Arial", Font.BOLD, 16));

            add(lblPosicion, BorderLayout.WEST);
            add(lblNombre, BorderLayout.CENTER);
            add(lblPuntaje, BorderLayout.EAST);
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends RegistroTop10> list, RegistroTop10 value, int index, boolean isSelected, boolean cellHasFocus) {
            lblPosicion.setText((index + 1) + " ");
            lblNombre.setText(value.darNombre());
            lblPuntaje.setText(" " + value.darPuntos());

            if (isSelected) {
                setBackground(list.getSelectionBackground());
                lblPosicion.setForeground(list.getSelectionForeground());
                lblNombre.setForeground(list.getSelectionForeground());
                lblPuntaje.setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                lblPosicion.setForeground(list.getForeground());
                lblNombre.setForeground(list.getForeground());
                lblPuntaje.setForeground(list.getForeground());
            }

            switch (index) {
                case 0:
                    lblPosicion.setForeground(Color.GREEN);
                    lblNombre.setForeground(Color.GREEN);
                    lblPuntaje.setForeground(Color.GREEN);
                    break;
                case 1:
                    lblPosicion.setForeground(Color.ORANGE);
                    lblNombre.setForeground(Color.ORANGE);
                    lblPuntaje.setForeground(Color.ORANGE);
                    break;
                case 2:
                    lblPosicion.setForeground(Color.RED);
                    lblNombre.setForeground(Color.RED);
                    lblPuntaje.setForeground(Color.RED);
                    break;
                default:
                    lblPosicion.setForeground(Color.BLACK);
                    lblNombre.setForeground(Color.BLACK);
                    lblPuntaje.setForeground(Color.BLACK);
                    break;
            }

            return this;
        }
    }
}
