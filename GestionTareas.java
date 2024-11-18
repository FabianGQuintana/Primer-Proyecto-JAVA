import javax.swing.JOptionPane;

public class GestionTareas {
    private Byte tareas;
    private String nombreDeTarea,nombreDePersona;
    

    GestionTareas(Byte p_tareas,String p_nombreDeTarea,String p_nombreDePersona){
        this.setTareas(p_tareas);
        this.setNombreTareas(p_nombreDeTarea);
        this.setNombreDePersona(p_nombreDePersona);
    }

    //ACESSORS
    //Setters
    //---------------------------------
    private void setTareas(Byte p_tareas){
        this.tareas = p_tareas;
    }

    private void setNombreTareas(String p_nombreTareas){
        this.nombreDeTarea = p_nombreTareas;
    }

    private void setNombreDePersona(String p_nombreDePersona){
        this.nombreDePersona = p_nombreDePersona;
    }

    //---------------------------------

     //GETTERS
    public Byte getTareas(){
        return this.tareas;
    }

    public String getNombreTareas(){
        return this.nombreDeTarea;
    }

    public String getNombreDePersona(){
        return this.nombreDePersona;
    }

    public void ingresarTareasNuevas(){
        JOptionPane.showInputDialog("Cuantas Tareas Nuevas Desea Agregar?: ");

    }


}
