import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EjemploCardLayout {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Ejemplo CardLayout");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 300);

        // Crear el contenedor principal con CardLayout
        JPanel contenedor = new JPanel(new CardLayout());

        // Crear las tarjetas (paneles)
        JPanel tarjetaGestionDinero = new JPanel();
        tarjetaGestionDinero.add(new JLabel("Gestión de Dinero"));
        JButton btnVolver1 = new JButton("Volver");
        tarjetaGestionDinero.add(btnVolver1);

        JPanel tarjetaGestionTareas = new JPanel();
        tarjetaGestionTareas.add(new JLabel("Gestión de Tareas"));
        JButton btnVolver2 = new JButton("Volver");
        tarjetaGestionTareas.add(btnVolver2);

        // Agregar las tarjetas al contenedor
        contenedor.add(tarjetaGestionDinero, "DINERO");
        contenedor.add(tarjetaGestionTareas, "TAREAS");

        // Crear el menú principal
        JPanel menuPrincipal = new JPanel();
        JButton btnGestionDinero = new JButton("Ir a Gestión de Dinero");
        JButton btnGestionTareas = new JButton("Ir a Gestión de Tareas");
        menuPrincipal.add(btnGestionDinero);
        menuPrincipal.add(btnGestionTareas);

        contenedor.add(menuPrincipal, "MENU");

        // Obtener el CardLayout del contenedor
        CardLayout cardLayout = (CardLayout) contenedor.getLayout();

        // Agregar ActionListeners para cambiar de tarjeta
        btnGestionDinero.addActionListener(e -> cardLayout.show(contenedor, "DINERO"));
        btnGestionTareas.addActionListener(e -> cardLayout.show(contenedor, "TAREAS"));
        btnVolver1.addActionListener(e -> cardLayout.show(contenedor, "MENU"));
        btnVolver2.addActionListener(e -> cardLayout.show(contenedor, "MENU"));

        // Agregar el contenedor al JFrame
        ventana.add(contenedor);
        cardLayout.show(contenedor, "MENU"); // Mostrar la tarjeta inicial (menú)

        ventana.setVisible(true);
    }
}
