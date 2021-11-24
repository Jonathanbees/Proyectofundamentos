
package ProyectoFundamentos;

public class Moto extends Vehiculo {
    private String tipoVehiculo;

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }
    
    public Moto() {
    }

    public Moto(String placa, String marca, String color, String tipoVehiculo) {
        super(placa, marca, color, tipoVehiculo);
        this.tipoVehiculo = tipoVehiculo;
    }

    public Moto(String placa, String marca, String color, int valor, String tipoVehiculo) {
        super(placa, marca, color, valor, tipoVehiculo);
        this.tipoVehiculo = tipoVehiculo;
        
    }
    public static String imprimirmoto(){
        String mensaje = "";
        mensaje = mensaje + "moto";
        return mensaje;
    }
    
}
