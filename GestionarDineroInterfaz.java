
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//Archivos
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class GestionarDineroInterfaz extends JFrame{

    GestionDinero operaciones = new GestionDinero();

    JPanel panel = new JPanel();

    //Ubicacion del archivo
    File archivo = new File("C:/Users/Fabian/OneDrive/Escritorio/Proyecto_Gestion_De_Tareas/FileProjectWithData.txt");



    //Constructor
    GestionarDineroInterfaz(){
        
        this.inicializarVentana();
        this.inicializarComponentes();

    }

    public void inicializarVentana(){

        this.setTitle("Gestionar Dinero");
        this.setSize(900, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel.setLayout(new FlowLayout());
    }


    public void inicializarComponentes(){

        JPanel panelSecondImagen = new PanelSecondConImagen(new ImageIcon("C://Users//Fabian//OneDrive//Escritorio//Imagenes//panteraRosafoto2.jpg"));

        panelSecondImagen.setLayout(new BorderLayout());
        // Crear la etiqueta del título o encabezado del programa
        JLabel header2 = new JLabel("Opciones de Gestión de Dinero",JLabel.CENTER);
        header2.setFont(new Font("Arial", Font.BOLD, 20));
        header2.setForeground(Color.WHITE); // Texto en blanco para destacar
        panelSecondImagen.add(header2, BorderLayout.NORTH);

        //----------------------------------------------------------------------------------------

        // Panel para los botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelBotones.setOpaque(false); // Hacer el panel transparente para ver la imagen

        JButton btnAgregarDinero = new JButton("Agregar Dinero");
        JButton btnExtraerDinero = new JButton("Extraer Dinero");
        JButton btnMontoTotal = new JButton("Monto Total");
        JButton btnGastosAlquiler = new JButton("Gastos Alquiler");
        JButton btnGastosCelular = new JButton("Gastos Celular");
        JButton btnGastosInternet = new JButton("Gastos Internet");
        JButton btnGastosFijos = new JButton("Gastos FIJOS");
        JButton btnEXIT = new JButton("SALIR");
        

        // Ajustar tamaño preferido de los botones
        btnAgregarDinero.setPreferredSize(new Dimension(150, 30));
        btnExtraerDinero.setPreferredSize(new Dimension(150, 30));
        btnMontoTotal.setPreferredSize(new Dimension(150, 30));
        btnGastosAlquiler.setPreferredSize(new Dimension(150, 30));
        btnGastosCelular.setPreferredSize(new Dimension(150, 30));
        btnGastosInternet.setPreferredSize(new Dimension(150, 30));
        btnGastosFijos.setPreferredSize(new Dimension(150, 30));
        btnEXIT.setPreferredSize(new Dimension(150, 30));

        //Eventos de los botones
        //------------------------------------------------------------------------------------------
        btnAgregarDinero.addActionListener(new ActionListener() {
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

        btnExtraerDinero.addActionListener(new ActionListener() {
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
        


        btnMontoTotal.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                operaciones.mostrarDineroActual();
            }
        });


        btnGastosAlquiler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String input = JOptionPane.showInputDialog("Ingrese El Costo De Alquiler A Modificar:");
                    if (input == null) return; // Cancelación
                    double p_costo = Double.parseDouble(input);
                    operaciones.cuentaAlquiler(p_costo);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.");
                }
            }
        });
        


        btnGastosCelular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String input = JOptionPane.showInputDialog("Ingrese El Costo De Celular A Modificar:");
                    if (input == null) return; // Cancelación
                    double p_costo = Double.parseDouble(input);
                    operaciones.cuentaCelular(p_costo);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.");
                }
            }
        });

        btnGastosInternet.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                double p_costo = Double.parseDouble(JOptionPane.showInputDialog("Ingrese El Costo De Internet A Modificar: "));
                operaciones.cuentaInternet(p_costo);
            }
        });


        btnGastosFijos.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                operaciones.cuentasFijas();
            }
        });

        btnEXIT.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();// Cierra solo la ventana actual
            }
        });

        //------------------------------------------------------------------------------------------
        panelBotones.add(btnAgregarDinero);
        panelBotones.add(btnExtraerDinero);
        panelBotones.add(btnMontoTotal);
        panelBotones.add(btnGastosAlquiler);
        panelBotones.add(btnGastosCelular);
        panelBotones.add(btnGastosInternet);
        panelBotones.add(btnGastosFijos);
        panelBotones.add(btnEXIT);

        // Agregar panel de botones al centro del panel principal
        panelSecondImagen.add(panelBotones, BorderLayout.CENTER);

        // Agregar panel segundo al JFrame
        this.add(panelSecondImagen);
    }

    public void fileManagement(){
        
        String nombreArchivo = "FileProjectWithData.txt";

         // Ruta del archivo
        File archivo = new File(nombreArchivo);

        try {
            // Verificar si el archivo existe, si no, crearlo
            if (!archivo.exists()) {
                boolean creado = archivo.createNewFile(); // Crear el archivo
                if (creado) {
                    System.out.println("Archivo creado en: " + archivo.getAbsolutePath());
                } else {
                    System.out.println("No se pudo crear el archivo.");
                }
            }

            // Crear el FileWriter en modo de adición (append)
            FileWriter writter = new FileWriter(archivo, true);

            // Escribir datos en el archivo
            writter.write("Este es un ejemplo de datos guardados.\n");
            writter.write("Puedes agregar más datos al archivo.\n");

            // Cerrar el FileWriter
            writter.close();

            System.out.println("Datos guardados exitosamente.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al trabajar con el archivo.");
            e.printStackTrace();
        }
    }

}
