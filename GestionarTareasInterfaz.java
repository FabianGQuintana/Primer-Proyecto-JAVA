import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



class GestionarTareasInterfaz extends JFrame {
    public GestionarTareasInterfaz() {
        this.setTitle("Gestionar Tareas");
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel label = new JLabel("Opciones de Gestión de Tareas");
        panel.add(label);

        JButton btnOpcion1 = new JButton("Opción 1");
        JButton btnOpcion2 = new JButton("Opción 2");

        panel.add(btnOpcion1);
        panel.add(btnOpcion2);

        this.add(panel);
    }
}
