import javax.swing.SwingUtilities;

public class Ejecutable {
    
    public static void main(String[] args) {
        // Crear y mostrar la interfaz gráfica
        SwingUtilities.invokeLater(() -> {
            Interfaz_Grafica interfazPrincipal = new Interfaz_Grafica();

            interfazPrincipal.setVisible(true);

        });
    }

}
