import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OpenFiles {

    private String nameFile;

    //Constructor para la creacion de archivos.
    public OpenFiles(String nameFile) {
        this.setNameFile(nameFile);
    }

    //Accesors
    public void setNameFile(String nameFile) {
        if (nameFile == null || nameFile.isBlank()) {
            throw new IllegalArgumentException("El nombre del archivo no puede ser nulo o vacío.");
        }
        this.nameFile = nameFile;
    }

    public String getNameFile() {
        return this.nameFile;
    }

    //Metodos

    //Metodo para la creacion de archivos.
    public void createFile() {
        File archivo = new File(this.getNameFile());

        try (PrintWriter salida = new PrintWriter(new FileWriter(archivo,true))) { //try-with-resources: Maneja automáticamente el cierre del PrintWriter.
            System.out.println("Archivo creado exitosamente: " + archivo.getAbsolutePath());
        } catch (FileNotFoundException e) {
            System.err.println("Error al crear el archivo: " + e.getMessage());
        } catch(IOException e){
            System.err.println("Error al crear el archivo: " + e.getMessage());
        }
    }

    // Método para escribir en el archivo
    public void writeToFile(String content) {
        File archivo = new File(this.getNameFile());

        try (PrintWriter salida = new PrintWriter(new FileWriter(archivo, true))) {  // Modo append
            salida.println(content); // Escribe la línea en el archivo
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    //Metodo que sobreescribe el metodo toString con una leyenda.
    @Override
    public String toString(){
        return "-----------------------------------------------";
    }

    // Método para obtener la fecha actual en el formato deseado
    public String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // Formato deseado
        Date date = new Date(); // Obtiene la fecha actual
        return sdf.format(date); // Devuelve la fecha en formato String
    }


}
