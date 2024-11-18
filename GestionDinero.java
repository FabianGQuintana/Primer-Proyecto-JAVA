import javax.swing.JOptionPane;

/**
 * Inicialmente este proyecto estara pensando en una interfaz grafica en la cual tenga como seleccion principal 2 botones.
 * El primer boton sea "DINERO", en la cual se centre en la gestion y administracion de ingreso y egresos de plata . 
 * el segundo boton sea "Tareas" en la cual se centre en la gestion y administracion de tareas a realizar .
 * 
 * @author Quintana Gustavo Fabian.
 * @version v1.
 */
public class GestionDinero{

    private double dineroIngresado,dineroExtraido,sueldo;

    private double dineroAlquiler; // se utilizara para pagar los servicios del alquiler.(agua,luz,expensas,extras).
    
    private double pagarCelulares; // Se utilizara para pagar los servicios telefonicos.
    

    GestionDinero(Double p_dineroIngresado,Double p_dineroExtraido, double p_dineroAlquiler, double p_dineroCelulares,double p_sueldo){
        this.setDineroIngresado(p_dineroIngresado);
        this.setDineroExtraido(p_dineroExtraido);
        this.setDineroAlquiler(p_dineroAlquiler);
        this.setDineroCelulares(p_dineroCelulares);
        this.setSueldoMensual(p_sueldo);
    }

    GestionDinero(){
        this.setDineroIngresado(0.0);
        this.setDineroExtraido(0.0);
        this.setDineroAlquiler(0.0);
        this.setDineroCelulares(0.0);
        this.setSueldoMensual(0.0);
    }

    //ACESSORS
    //Setters
    //---------------------------------
    private void setDineroIngresado(Double p_dineroIngresado){
        this.dineroIngresado = p_dineroIngresado;
    }

    private void setDineroExtraido(Double p_dineroExtraido){
        this.dineroExtraido = p_dineroExtraido;
    }

    private void setDineroAlquiler(Double p_dineroAlquiler){
        this.dineroAlquiler = p_dineroAlquiler;
    }

    private void setDineroCelulares(Double p_dineroCelular){
        this.pagarCelulares = p_dineroCelular;
    }

    private void setSueldoMensual(Double p_sueldo){
        this.sueldo = p_sueldo;
    }


    //---------------------------------
    //GETTERS
    public double getDineroIngresado(){
    return this.dineroIngresado;
    }

    public double getDineroExtraido(){
        return this.dineroExtraido;
    }

    public double getDineroAlquiler(){
        return this.dineroAlquiler;
    }

    public double getDineroCelular(){
        return this.pagarCelulares;
    }

    public double getSueldoMensual(){
        return this.sueldo;
    }

    //---------------------------------
/**
 * Metodo para agregar o actualizar el dinero desde el metodo setter a partir del valor recibido por parametro.
 * @param p_dinero el dinero a ingresar o agregar.
 */
    public void agregarDinero(double p_dinero){
        if(p_dinero > 0){
        this.setDineroIngresado(this.getDineroIngresado() + p_dinero);
        JOptionPane.showMessageDialog(null,"Se Ha Ingresado: $"+p_dinero+" A La Cuenta");
        }else{
        JOptionPane.showMessageDialog(null,"No se puede ingresar un valor negativo");
        }
    
    }

    /**
     * Metodo para quitar o extraer el dinero que recibe como valor mediante el parametro
     * @param p_dinero el dinero a extraer .
     */
    public void extraerDinero(double p_dinero) {
        if (p_dinero <= this.getDineroIngresado() - this.getDineroExtraido()) {
        this.setDineroExtraido(this.getDineroExtraido() + p_dinero); // Agregar al total extraído
        JOptionPane.showMessageDialog(null, "Se Ha Extraído: $" + p_dinero + " Correctamente.");
        } else {
        JOptionPane.showMessageDialog(null, "No Hay Suficiente Dinero En La Cuenta Para Extraer.");
        }
    }
    

    /**
     * Metodo que retorna el monto total.
     * @return el monto total.
     */
    public double montoTotal(){
        return this.getDineroIngresado() - this.getDineroExtraido();
    }

    /**
     * Metodo que muestre el dinero actual con una little leyenda.
     */
    public void mostrarDineroActual(){
        JOptionPane.showMessageDialog(null,
        "------------------\n"+"Su Monto Actual Es: "+this.montoTotal()+"\n------------------");
    }

    /**
     * Metodo que suma o modifica el precio a pagar en servicios telefonicos.
     * @param p_nuevoPrecio el precio nuevo a modificar  o sumar en la cuenta.
     */
    public void cuentaCelular(double p_nuevoPrecio){
        this.setDineroCelulares(this.getDineroCelular() + p_nuevoPrecio);
        this.extraerDinero(p_nuevoPrecio);
    }

    /**
     * Metodo que suma o modifica el valor del precio ingresado por parametro para la cuenta de los
     * servicios del alquiler.
     */
    public void cuentaAlquiler(double p_nuevoPrecio){
        this.setDineroAlquiler(this.getDineroAlquiler() + p_nuevoPrecio);
        this.extraerDinero(p_nuevoPrecio);
    }

    /**
     * Metodo que retorna la cantidad de dinero a pagar para las cuentas de alquiler y gastos telefonicos.
     * @return el precio total de servicios.
     */
    public double totalServiciosPagar(){
        return this.getDineroCelular() + this.getDineroAlquiler();
    }

    //public void modificarSueldo()

    /**
     * Metodo que imprime las cuentas a pagar fijamente.
     */
    public void cuentasFijas(){
            //String mensaje = "---Cuentas Fijas A Pagar---\n\n" +
            //"(1)-Alquiler: $" + this.getDineroAlquiler() + "\n" +
            //"(2)-Celulares: $" + this.getDineroCelular() + "\n";
            //JOptionPane.showMessageDialog(null, mensaje+this.puedePagar());
            JOptionPane.showMessageDialog(null,"---Cuentas Fijas A Pagar---\\n"+"(1)-Alquiler: $" +
            this.getDineroAlquiler() + "\n" + "(2)-Celulares: $" + this.getDineroCelular() + "\n"+this.puedePagar());
    }
    
    public String puedePagar(){
        String mensajePositivo = "Puede Pagar";
        String mensajeNegativo = "No Alcanza, Falta Dinero!";
        
        if(this.montoTotal() >= this.totalServiciosPagar() && this.getDineroIngresado() != 0){
            return mensajePositivo;
            }else{
                return mensajeNegativo;
            }
    }
    

}
