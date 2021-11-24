package ProyectoFundamentos;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Vehiculo {
    private String placa; 
    private String marca;
    private String color;
    private int valorComercial;
    public static Vehiculo vehiculos[][];
    public static int cantidad = 0;
    public static int tamaño;
    private String tipo;
    private LocalDateTime fecha;
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
    LocalDateTime myDateObj = LocalDateTime.now();
    String formattedDate = myDateObj.format(dtf);

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getValorComercial() {
        return valorComercial;
    }

    public void setValorComercial(int valorComercial) {
        this.valorComercial = valorComercial;
    }

    public static int getCantidad() {
        return cantidad;
    }

    public static void setCantidad(int cantidad) {
        Vehiculo.cantidad = cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
    
    
    public Vehiculo(){
        
    }
    public Vehiculo(String p, String m, String c, String t){
        this.placa= p;
        this.marca = m;
        this.color = c;
        this.tipo = t;
        this.fecha = myDateObj;
    }
    public Vehiculo(String p, String m, String c, int v, String t){
    this.placa= p;
    this.marca = m;
    this.color = c;
    this.valorComercial = v;
    this.tipo = t;
    cantidad = cantidad + 1;
    this.fecha = myDateObj;
    }

    public static String toString(Vehiculo vehiculo) {
        return "Vehiculo{" + "placa=" + vehiculo.placa + ", marca=" + vehiculo.marca + ", color=" + vehiculo.color + ", valorComercial=" + vehiculo.valorComercial +", Tipo de Vehiculo: " +vehiculo.tipo +", Fecha de parqueo: " +vehiculo.fecha.format(dtf) + "}";
    }
    public static String toStringVehiculos(){
        String res = "";
        for(int i = 0; i<vehiculos.length; i++ ){
            for(int j = 0; j<vehiculos[i].length; j++){
                if(vehiculos[i][j]!= null){
                    res = res + toString(vehiculos[i][j]) + " ";
                }
            }
        }
        return res;
    }
    
    public static int cantidadVehiculos(Vehiculo vehiculos[][]){
        int c = 0;
        for(int i = 0; i<vehiculos.length; i++ ){
            for(int j = 0; j<vehiculos[i].length; j++){
                if(vehiculos[i][j]!= null){
                    c++;
                }
            }
        }
        return c;
    }
    public String toString() {
        return "Vehiculo{" + "placa=" + this.placa + ", marca=" + this.marca + ", color=" + this.color + ", valorComercial=" + this.valorComercial +", Tipo de vehiculo: "+this.tipo +"Fecha y hora de ingreso: "+this.fecha+'}';
    }
    
}
