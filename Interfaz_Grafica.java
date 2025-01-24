
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;




public class Interfaz_Grafica extends JFrame{
    
    
    
    Interfaz_Grafica(){
        
        this.configuracionVentana();
        this.openFile();
        this.inicializarComponentes();

        

    }

    public void openFile(){
        OpenFiles newFile = new OpenFiles("C:\\Users\\Fabian\\OneDrive\\Escritorio\\Proyecto_Gestion_De_Tareas\\Primer-Proyecto-JAVA\\DataBaseProject\\DataFile.txt");
        newFile.createFile();
    }

    public void openFileSalary(String p_nameFile){
        String nameFile = p_nameFile;
        OpenFiles newFile = new OpenFiles("C:\\Users\\Fabian\\OneDrive\\Escritorio\\Proyecto_Gestion_De_Tareas\\Primer-Proyecto-JAVA\\DataBaseProject\\"+nameFile);
        newFile.createFile();
    }

    


    public void configuracionVentana(){
        this.setTitle("Sistema Administrador");
        this.setSize(340,400);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void inicializarComponentes() {
        // Panel personalizado para el fondo con imagen
        JPanel panelPrincipal = new PanelConImagen(new ImageIcon("C://Users//Fabian//OneDrive//Escritorio//Imagenes//panteraRosaFachero.jpg"));

        panelPrincipal.setLayout(new BorderLayout());

        // Crear la etiqueta del título o encabezado del programa
        JLabel header = new JLabel("Administrador K.I.N.S", JLabel.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 20));
        header.setForeground(Color.WHITE); // Texto en blanco para destacar
        panelPrincipal.add(header, BorderLayout.NORTH);

        // Panel para los botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelBotones.setOpaque(false); // Hacer el panel transparente para ver la imagen

        // Botones principales para acceder a cada sección
        JButton btnDinero = new JButton("Gestionar Dinero");
        JButton btnTareas = new JButton("Gestionar Tareas");
        JButton btnSalir = new JButton("Salir");

        // Ajustar tamaño preferido de los botones
        btnDinero.setPreferredSize(new Dimension(150, 30));
        btnTareas.setPreferredSize(new Dimension(150, 30));
        btnSalir.setPreferredSize(new Dimension(150, 30));

        // Agregar listeners para los botones
        btnDinero.addActionListener(e -> { //expresion lambda mas facil de leer y mas limpio. (mejor opcion que usar ActionPerformed).
            openFileSalary("SalaryFile.txt");
            new GestionarDineroInterfaz().setVisible(true);
        });
        

        btnTareas.addActionListener(new ActionListener() { // modificar al metodo del primer boton.
            @Override
            public void actionPerformed(ActionEvent e) {
                new GestionarTareasInterfaz().setVisible(true);
            }
        });

        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Salir del programa.
            }
        });


        // Agregar botones al panel de botones.
        panelBotones.add(btnDinero);
        panelBotones.add(btnTareas);
        panelBotones.add(btnSalir);

        // Agregar panel de botones al centro del panel principal.
        panelPrincipal.add(panelBotones, BorderLayout.CENTER);

        // Agregar panel principal al JFrame
        this.add(panelPrincipal);
    }

    


}
