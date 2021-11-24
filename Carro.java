package ProyectoFundamentos;
public class Carro extends Vehiculo{
    private String tipovehiculo;

    public String getTipoVehiculo() {
        return tipovehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipovehiculo = tipoVehiculo;
    }

    public Carro() {
    }

    public Carro(String p, String m, String c, String tipovehiculo) {
        super(p, m, c, tipovehiculo);
        this.tipovehiculo = tipovehiculo;
    }

    public Carro(String p, String m, String c, int v, String tipovehiculo) {
        super(p, m, c, v, tipovehiculo);
        this.tipovehiculo = tipovehiculo;
    }
    
    
    public static String imprimircarro(){
        String mensaje = "";
        mensaje = mensaje + "Carro";
        return mensaje;
    }
}
