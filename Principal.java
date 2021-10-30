package ProyectoFundamentos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cantipisos = scan.nextInt();
        int cantiespacios = scan.nextInt();
        int pisouser;
        int espaciouser;
        int numeroIngresado;
        int pisousuario;
        int espaciousuario;
        String placa;
        String marca;
        String color;
        int valor;
        String colorbusqueda;

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

                        Vehiculo nuevoVehiculo = new Vehiculo(placa, marca, color);
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

                        Vehiculo nuevoVehiculo = new Vehiculo(placa, marca, color, valor);
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
                default:
                    System.out.println("Comando incorrecto");

            }

        }

    }
}
