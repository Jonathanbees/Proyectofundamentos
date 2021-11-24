package ProyectoFundamentos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.io.*;

public class Principal {

    public static void main(String[] args) throws IOException  {
        
        Scanner scan = new Scanner(System.in);
        DateTimeFormatter dtf4 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        FileWriter ficherovehiculo = new FileWriter("Vehiculos-parqueados.txt");
        PrintWriter archivoprint = new PrintWriter(ficherovehiculo);
        System.out.println("Ingrese la cantidad de pisos del parqueadero: ");
        int cantipisos = scan.nextInt();
        System.out.println("Ingrese la cantidad de espacios del parqueadero: ");
        int cantiespacios = scan.nextInt();
        System.out.println("Ingrese el valor de parqueo por hora para las motos: ");
        long valormoto = scan.nextLong();
        System.out.println("Ingrese el valor de parqueo por hora par los carros: ");
        long valorcarro = scan.nextLong();
        
        
        int pisouser;
        int espaciouser;
        int numeroIngresado;
        int pisousuario;
        int espaciousuario;
        String placa;
        String marca;
        String color;
        int valor;
        String tipovehiculo;
        String colorbusqueda;
        String fechahora;
        int pisosensor;
        int espaciosensor;

        Vehiculo[][] vehiculos = new Vehiculo[cantipisos][cantiespacios];

        Sensor[][] sensores = new Sensor[cantipisos][cantiespacios];
        Sensor.sensores = sensores;
        Vehiculo.vehiculos = vehiculos;
        Vehiculo.tamaño = cantipisos * cantiespacios;

        for (int i = 0; i < Sensor.sensores.length; i++) {
            for (int j = 0; j < Sensor.sensores[i].length; j++) {
                Sensor sensor = new Sensor(0);
                Sensor.sensores[i][j] = sensor;
            }
        }
        boolean verdad = true;
        while (verdad) {
            System.out.println("Ingrese un número para consultar");
            numeroIngresado = scan.nextInt();

            switch (numeroIngresado) {
                case 0:
                    verdad = false;
                    System.out.println("Saliendo...");
                    break;
                case 1:
                    System.out.println(Sensor.sensorLibre(sensores));
                    break;
                case 2:
                    System.out.println("Ingrese el piso y espacio que desea parquear el vehículo");
                    System.out.println("Nota: el piso 1 es el espacio 0, el piso 2 es el espacio 1...");
                    pisouser = scan.nextInt();
                    espaciouser = scan.nextInt();

                    if (Sensor.sensores[pisouser][espaciouser].getEstado() == 0) {
                        System.out.println("Ingrese la placa del nuevo vehiculo: ");
                        placa = scan.next();

                        System.out.println("Ingrese la marca del nuevo vehiculo: ");
                        marca = scan.next();

                        System.out.println("Ingrese el color del nuevo vehiculo: ");
                        color = scan.next();
                        
                        System.out.println("Ingrese el tipo de vehiculo a parquear (moto o carro)");
                        tipovehiculo = scan.next();

                        Vehiculo nuevoVehiculo = new Vehiculo(placa, marca, color, tipovehiculo);
                        Vehiculo.vehiculos[pisouser][espaciouser] = nuevoVehiculo;
                        Sensor.sensores[pisouser][espaciouser].setEstado(1);

                    } else {
                        System.out.println("No se puede realizar la acción");
                    }
                    break;

                case 3:
                    System.out.println("Ingrese el piso y espacio que desea parquear el vehículo");
                    pisousuario = scan.nextInt();
                    espaciousuario = scan.nextInt();

                    if (Sensor.sensores[pisousuario][espaciousuario].getEstado() == 0) {
                        System.out.println("Ingrese la placa del nuevo vehiculo: ");
                        placa = scan.next();

                        System.out.println("Ingrese la marca del nuevo vehiculo: ");
                        marca = scan.next();

                        System.out.println("Ingrese el color del nuevo vehiculo: ");
                        color = scan.next();

                        System.out.println("Ingrese el valor del vehículo");
                        valor = scan.nextInt();
                        
                        System.out.println("Ingrese el tipo de vehiculo a parquear (moto o carro)");
                        tipovehiculo = scan.next();

                        Vehiculo nuevoVehiculo = new Vehiculo(placa, marca, color, valor, tipovehiculo);
                        Vehiculo.vehiculos[pisousuario][espaciousuario] = nuevoVehiculo;
                        Sensor.sensores[pisousuario][espaciousuario].setEstado(1);

                    } else {
                        System.out.println("No se puede realizar la acción");
                    }
                    break;

                case 5:
                    System.out.println("La cantidad de vehiculos son: " + Vehiculo.cantidadVehiculos(vehiculos));

                    break;

                case 4:
                    System.out.println(Vehiculo.toStringVehiculos());
                    break;

                case 6:
                    System.out.println("Ingrese el piso y espacio que desea consultar el estado del sensor");
                    pisousuario = scan.nextInt();
                    espaciousuario = scan.nextInt();
                    System.out.println("El estado del sensor es: " + Sensor.sensores[pisousuario][espaciousuario].getEstado());

                    break;

                case 7:
                    System.out.println(Sensor.sensoresEstado(sensores));
                    break;

                case 8:
                    colorbusqueda = scan.next();
                    for (int i = 0; i < Vehiculo.vehiculos.length; i++) {
                        for (int j = 0; j < Vehiculo.vehiculos[i].length; j++) {
                            if (Vehiculo.vehiculos[i][j] != null) {
                                String colorvehiculo = Vehiculo.vehiculos[i][j].getColor();
                                if (colorvehiculo.equalsIgnoreCase(colorbusqueda)) {
                                    System.out.println(Vehiculo.vehiculos[i][j].toString());
                                }
                            }
                        }
                    }
                    break;
                case 9:
                    ArrayList<Vehiculo> vehiculoslista = new ArrayList<Vehiculo>();
                    for (int i = 0; i < Vehiculo.vehiculos.length; i++) {
                        for (int j = 0; j < Vehiculo.vehiculos[i].length; j++) {
                            if (Vehiculo.vehiculos[i][j] != null) {
                                vehiculoslista.add(Vehiculo.vehiculos[i][j]);

                            }

                        }
                    }
                    Collections.sort(vehiculoslista, new Comparator<Vehiculo>() {
                        @Override
                        public int compare(final Vehiculo vehiculo1, final Vehiculo vehiculo2) {
                            if (vehiculo1.getValorComercial() > vehiculo2.getValorComercial()) {
                                return 1;
                            } else {
                                return -1;
                            }
                        }
                    });
                    for (int i = 0; i < vehiculoslista.size(); i++) {
                        Vehiculo vehiculo = vehiculoslista.get(i);
                        System.out.println(vehiculo.toString());
                    }
                    break;
                case 10:
                    System.out.println("Seleccione un piso y espacio en el que desea desactivar el sensor");
                    System.out.println("Piso: ");
                    pisosensor = scan.nextInt();
                    System.out.println("Espacio: ");
                    espaciosensor = scan.nextInt();
                    Sensor.sensores[pisosensor][espaciosensor].setEstado(0);

                    DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
                    LocalDateTime myDateObj1 = LocalDateTime.now();
                    String formattedDate1 = myDateObj1.format(dtf2);
                    String fechatempo = formattedDate1;
                     long diff = ChronoUnit.MINUTES.between(vehiculos[pisosensor][espaciosensor].getFecha(), myDateObj1);
                     System.out.println("Los minutos transcurridos son: "+diff + " para el vehiculo: "+ vehiculos[pisosensor][espaciosensor].getTipo());
                     
                     if(vehiculos[pisosensor][espaciosensor].getTipo().equals("Carro") || vehiculos[pisosensor][espaciosensor].getTipo().equals("carro")){
                         if(diff<=30){
                             System.out.println("Hay un descuento del 50% si el tiempo transcurrido es inferior o igual a 30 minutos");
                             long totalcarro = valorcarro/2;
                             System.out.println("El valor a pagar por el tiempo del carro parqueado es: "+ totalcarro);
                         }else{
                             long totalcarro = valorcarro*(diff/60);
                             System.out.println("El valor a pagar por el tiempo del carro parqueado es: "+ totalcarro);
                         }
                     } else if (vehiculos[pisosensor][espaciosensor].getTipo().equals("Moto") || vehiculos[pisosensor][espaciosensor].getTipo().equals("moto")){
                         if(diff<=30){
                             System.out.println("Solo habrá un descuento en el valor de parqueo si el tiempo transcurrido son 30 minutos o menos");
                             long totalmoto = valormoto/2;
                             System.out.println("El valor a pagar por el tiempo del carro parqueado es: "+ totalmoto);
                         }else{
                             long totalmoto = valormoto*(diff/60);
                             System.out.println("El valor a pagar por el tiempo del carro parqueado es: "+ totalmoto);
                         }
                     }
                    vehiculos[pisosensor][espaciosensor] = null;
                     break;
                case 11: 
                    archivoprint.println(Vehiculo.toStringVehiculos());
                    ficherovehiculo.close();
                    break;
                default:
                    System.out.println("Comando incorrecto");
                   
            }
        }
    }
}