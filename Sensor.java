package ProyectoFundamentos;


public class Sensor {
    private int estado = 0;
    public static Sensor[][] sensores;
    public Sensor (){
        
    }
    
    public Sensor(int e){
        this.estado = e;
    }

    public String toString() {
        return "Sensor{" + "estado=" + estado + '}';
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public static Sensor[][] getSensores() {
        return sensores;
    }

    public static void setSensores(Sensor[][] sensores) {
        Sensor.sensores = sensores;
    }
    
    public static String sensorLibre(Sensor sensores[][]){
        String info = "";
        for(int i = 0; i<sensores.length; i++ ){
            for(int j = 0; j<sensores[i].length; j++){
                if(sensores[i][j] != null && sensores[i][j].getEstado() == 0 ){
                String mensaje = " piso: " + i + " espacio: " + j;
                info =  info + mensaje;
                }
            }
        }
        return info;
    }
    
    public static String sensoresEstado(Sensor sensores[][]){
            String info = "";
        for(int i = 0; i<sensores.length; i++ ){
            for(int j = 0; j<sensores[i].length; j++){
                 if(sensores[i][j] != null){
                String mensaje = " piso: " + i + " espacio: " + j + sensores[i][j].getEstado() + " ";
                info =  info + mensaje;
                }
            }
        }
        return info;
    }
    
    
}
