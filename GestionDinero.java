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

    private double pagarWifi; // se utilizara para pagar el wifi del hogar.
    

    GestionDinero(Double p_dineroIngresado,Double p_dineroExtraido, double p_dineroAlquiler, double p_dineroCelulares,double p_sueldo,double p_pagarWifi){
        this.setDineroIngresado(p_dineroIngresado);
        this.setDineroExtraido(p_dineroExtraido);
        this.setDineroAlquiler(p_dineroAlquiler);
        this.setDineroCelulares(p_dineroCelulares);
        this.setSueldoMensual(p_sueldo);
        this.setDineroInternet(p_pagarWifi);
    }

    GestionDinero(){
        this.setDineroIngresado(0.0);
        this.setDineroExtraido(0.0);
        this.setDineroAlquiler(0.0);
        this.setDineroCelulares(0.0);
        this.setDineroInternet(0.0);
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

    private void setDineroInternet(Double p_dineroWifi){
        this.pagarWifi = p_dineroWifi;
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

    public double getDineroInternet(){
        return this.pagarWifi;
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
        if (p_dinero <= this.getDineroIngresado() - this.getDineroExtraido() && this.montoTotal() != 0 && p_dinero > 0) {
        this.setDineroExtraido(this.getDineroExtraido() + p_dinero); // Agregar al total extraído
        JOptionPane.showMessageDialog(null, "Se Ha Extraído: $" + p_dinero + " Correctamente.");
        } else if(p_dinero <= this.getDineroIngresado() - this.getDineroExtraido() && this.montoTotal() != 0 && p_dinero < 0){
        JOptionPane.showMessageDialog(null, "No Se Puede Extraer Dinero Negativo!\n Intentelo Nuevamente.");
        }else if(p_dinero == 0){
            JOptionPane.showMessageDialog(null, "No Se Puede Extraer $0.\n intenta con otro saldo.");
        }else{
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
        if(p_nuevoPrecio > 0  && this.getDineroIngresado() >= 1){
        this.setDineroCelulares(this.getDineroCelular() + p_nuevoPrecio);
        this.extraerDinero(p_nuevoPrecio);
        }else if(this.getDineroIngresado() == 0){
            JOptionPane.showMessageDialog(null,"Primero Necesita ingresar dinero a la cuenta");
        }else if(p_nuevoPrecio == 0){
            JOptionPane.showMessageDialog(null,"No se puede ingresar un valor cero.\n intentelo nuevamente");
        }else{
            JOptionPane.showMessageDialog(null,"No se puede ingresar un valor negativo.\n intentelo nuevamente");
        }
        
    }

    /**
     * Metodo que suma o modifica el valor del precio ingresado por parametro para la cuenta de los
     * servicios del alquiler.
     */
    public void cuentaAlquiler(double p_nuevoPrecio){
        if(p_nuevoPrecio > 0  && this.getDineroIngresado() >= 1){
            this.setDineroAlquiler(this.getDineroAlquiler() + p_nuevoPrecio);
            this.extraerDinero(p_nuevoPrecio);
            }else if(this.getDineroIngresado() == 0){
                JOptionPane.showMessageDialog(null,"Primero Necesita ingresar dinero a la cuenta");
            }else if(p_nuevoPrecio == 0){
                JOptionPane.showMessageDialog(null,"No se puede ingresar un valor cero.\n intentelo nuevamente");
            }else{
                JOptionPane.showMessageDialog(null,"No se puede ingresar un valor negativo.\n intentelo nuevamente");
            }
        
    }
    /**
     * Metodo cuentaInternet, utilidad del metodo: determinar la cuenta del wifi que debo pagar al mes, siendo este modificable.
     * 
     * @param p_nuevoPrecio el precio a agregar o modificar de la cuenta.
     */
    public void cuentaInternet(double p_nuevoPrecio){
        if(p_nuevoPrecio > 0 && this.getDineroIngresado() >= 1){
            this.setDineroInternet(this.getDineroInternet() + p_nuevoPrecio);
            this.extraerDinero(p_nuevoPrecio);
        }else if(this.getDineroIngresado() == 0){
            JOptionPane.showMessageDialog(null,"Primero Necesita ingresar dinero a la cuenta");
        }else if(p_nuevoPrecio == 0){
            JOptionPane.showMessageDialog(null,"No se puede ingresar un valor cero.\n intentelo nuevamente");
        }else{
            JOptionPane.showMessageDialog(null,"No se puede ingresar un valor negativo.\n intentelo nuevamente");
        }
    }

    /**
     * Metodo que retorna la cantidad de dinero a pagar para las cuentas de alquiler y gastos telefonicos.
     * @return el precio total de servicios.
     */
    public double totalServiciosPagar(){
        return this.getDineroCelular() + this.getDineroAlquiler();
    }

    /**
     * Metodo que imprime las cuentas a pagar fijamente.
     */
    public void cuentasFijas(){
            JOptionPane.showMessageDialog(null,"---Cuentas Fijas A Pagar---\n"+"(1)-Alquiler: $" +
            this.getDineroAlquiler() + "\n" + "(2)-Celulares: $" + this.getDineroCelular() + "\n"+this.puedePagar());
    }
    
    

    /**
     * Metodo que retorna un mensaje tipo STRING que indica si puede pagar las cuentas en base al dinero ingresado
     * @return un mensaje
     */
    public String puedePagar(){
        String mensajePositivo = "Puede Pagar";
        String mensajeNegativo = "No Alcanza, Falta Dinero!";
        String mensajeNeutro = "Saldos Esperando a ser modificados!";
        
        if(this.montoTotal() >= this.totalServiciosPagar() && this.getDineroIngresado() != 0){
            return mensajePositivo;
            }else if(this.montoTotal() < this.totalServiciosPagar() && this.getDineroIngresado() != 0){
                return mensajeNegativo;
            }else{
                return mensajeNeutro;
            }
    }
    

}
