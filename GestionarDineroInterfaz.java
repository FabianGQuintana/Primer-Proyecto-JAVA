
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GestionarDineroInterfaz extends JFrame{

    private GestionDinero operaciones = new GestionDinero();


    JPanel panel = new JPanel();

    GestionarDineroInterfaz(){

        this.inicializarVentana();
        this.componentesLabel();
        this.componentesBotones();

        this.add(panel);

    }

    public void inicializarVentana(){

        this.setTitle("Gestionar Dinero");
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel.setLayout(new FlowLayout());
    }

    public void componentesLabel(){

        JLabel label = new JLabel("Opciones de Gestión de Dinero");
        panel.add(label);
    }

    public void componentesBotones(){

        JButton btnOpcion1 = new JButton("Agregar Dinero");
        JButton btnOpcion2 = new JButton("Extraer Dinero");
        JButton btnOpcion3 = new JButton("Monto Total");
        JButton btnOpcion4 = new JButton("Gastos Alquiler");
        JButton btnOpcion5 = new JButton("Gastos Celular");
        JButton btnOpcion6 = new JButton("Gastos FIJOS");
        JButton btnOpcion7 = new JButton("SALIR");

        //Eventos de los botones
        //------------------------------------------------------------------------------------------
        btnOpcion1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    double p_dinero = Double.parseDouble(JOptionPane.showInputDialog("Ingrese El Valor A Agregar: "));
                    
                    operaciones.agregarDinero(p_dinero);
                    
                    }catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.");
                    }
                }
        });

        btnOpcion2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String input = JOptionPane.showInputDialog("Ingrese El Valor A Extraer:");
                    if (input == null) return; // Cancelación
                    double p_dinero = Double.parseDouble(input);
                    operaciones.extraerDinero(p_dinero);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.");
                }
            }
        });
        


        btnOpcion3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                operaciones.mostrarDineroActual();
            }
        });


        btnOpcion4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                double p_costo = Double.parseDouble(JOptionPane.showInputDialog("Ingrese El Costo De Alquiler A Modificar: "));
                operaciones.cuentaAlquiler(p_costo);
            }
        });


        btnOpcion5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                double p_costo = Double.parseDouble(JOptionPane.showInputDialog("Ingrese El Costo De Celular A Modificar: "));
                operaciones.cuentaCelular(p_costo);
                operaciones.puedePagar();
            }
        });


        btnOpcion6.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                operaciones.cuentasFijas();
            }
        });

        btnOpcion7.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();// Cierra solo la ventana actual
            }
        });

        //------------------------------------------------------------------------------------------
        panel.add(btnOpcion1);
        panel.add(btnOpcion2);
        panel.add(btnOpcion3);
        panel.add(btnOpcion4);
        panel.add(btnOpcion5);
        panel.add(btnOpcion6);
        panel.add(btnOpcion7);
    }

    

}
