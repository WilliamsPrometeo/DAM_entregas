package proyecto2.clases;

import proyecto2.enums.TipoServicio;
import proyecto2.enums.TipoVehiculo;
import proyecto2.exception.VehiculoNoEncontrado;
import proyecto2.myscanner.MyScanner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Taller {
    /***
     *Scanner personalizado
     *
     **/
    private static final MyScanner scanner = new MyScanner();

    /***
     * @param vehiculos Arraylist de vehiculos
     * @param servicios Arraylist de servicios
     * @param trabajosRealizados Arraylist de trabajos realizados
     *
     **/

    private ArrayList <Vehiculo> vehiculos;
    private ArrayList <Servicio> servicios;
    private Map <Vehiculo, Servicio> trabajosRealizados;

    public Taller() {
        vehiculos = new ArrayList<>();
        servicios = new ArrayList<>();
        trabajosRealizados = new LinkedHashMap<>();
    }
    /***
     *Getter de Vehiculos
     * @return La lista de Vehiculos
     **/

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    /***
     *Setter de Vehiculos
     * @param vehiculos sirve para crear la lista de vehiculos
     **/
    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
    /***
     *Getter de Servicios
     * @return servicios  Devuelve la lista de los servicios
     *
     **/

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }
    /***
     *Setter de tipo servicio
     * @param servicios Para ingresar datos en la arraylist
     **/
    public void setServicios(ArrayList<Servicio> servicios) {
        this.servicios = servicios;
    }
    /***
     *Getter de trabajos realizados
     * @return los trabajos realizados del cliente
     **/
    public Map<Vehiculo, Servicio> getTrabajosRealizados() {
        return trabajosRealizados;
    }
    /***
     *Setter de tipo servicio
     * @param trabajosRealizados Para ingresar los trabajos realizados
     **/
    public void setTrabajosRealizados(Map<Vehiculo, Servicio> trabajosRealizados) {
        this.trabajosRealizados = trabajosRealizados;
    }
    /***
     * @return Es para que el cliente pueda registrar su vehiculo
     **/
    public void registrarVehiculo() {

        Vehiculo vehiculo = new Vehiculo();
        String modelo = scanner.pideTexto("Introduce el modelo del vehiculo");
        String matricula;
        TipoVehiculo tipoVehiculo = null;
        do {
            matricula = (scanner.pideTexto("Introduce la matricula"));
            String mensaje = matricula.length() == 7 ? "Matricula valida" : "Debe tener 7 caracteres";
            System.out.println(mensaje);

        }while (matricula.length() != 7);
        vehiculo.setMatricula(matricula);
        boolean correcto;
        do {
            correcto = true;
            int opcion_tipo = scanner.pedirNumero(" Introduce el tipo de vehiculo \n1. Turismo \n 2. Motocicleta \n 3. Furgoneta \n 4. Camion");

            switch (opcion_tipo) {
                case 1:
                    tipoVehiculo = TipoVehiculo.TURISMO;
                    break;

                case 2:
                    tipoVehiculo = TipoVehiculo.MOTOCICLETA;
                        break;

                case 3:
                    tipoVehiculo = TipoVehiculo.FURGONETA;
                        break;

                case 4:
                    tipoVehiculo = TipoVehiculo.CAMION;
                        break;

                default:
                    correcto = false;
                    System.out.println("Introduce una opcion valida");
                    break;
            }
        }while (!correcto);
        vehiculos.add(new Vehiculo());
    }
    /***
     * @return Es para elegir el servicio que se quiere realizar
     **/
    public void registrarServicio() {

        String descripcion = scanner.pideTexto("Introduce la descripcion");
        String mecanico = scanner.pideTexto("Introduce el nombre del mecanico");
        TipoVehiculo tipoVehiculo = null;
        boolean correcto;
        do {
            correcto = true;
            int opcion_tipo = scanner.pedirNumero(" 1.MANTENIMIENTO,\n" +
                    "   2. CAMBIO_ACEITE,\n" +
                    "   3. PINTURA,\n" +
                    "   4. FRENOS,\n" +
                    "   5. ELECTRICIDAD");

            switch (opcion_tipo) {

                case 1:
                    TipoServicio tipoServicio = TipoServicio.MANTENIMIENTO;
                    break;
                case 2:
                    TipoServicio tipoServicio1 = TipoServicio.CAMBIO_ACEITE;
                        break;
                case 3:
                    TipoServicio tipoServicio2 = TipoServicio.PINTURA;
                            break;
                case 4:
                    TipoServicio tipoServicio3 = TipoServicio.FRENOS;
                            break;
                case 5:
                    tipoServicio = TipoServicio.ELECTRICIDAD;
                    break;
                default:
                    correcto = false;
                    System.out.println("Introduce una opcion valida");
                    break;

            }
        }while (!correcto);
        servicios.add(new Servicio());

    }
    /***
     *
     * @return Asigna el servicio que elige el cliente
     **/
    public void asignarServicio() {

    String matricula = scanner.pideTexto("Introduce la matricula");
    Vehiculo vehiculo = null;
    try {
       buscarVehiculo(matricula);
    }catch (VehiculoNoEncontrado e) {
        System.out.println(e.getMessage());
        vehiculo = null;
    }
    String descripcion = scanner.pideTexto("Introduce la descripcion del servicio");
        buscarServicio(descripcion);
    if (descripcion != null) {
        System.out.println("Servicio encontrado");
        Servicio put = trabajosRealizados.put(vehiculo, new Servicio());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String fecha = LocalDateTime.now().format(dtf);
        System.out.println("Fecha: " + fecha);
    }else  {
        System.out.println("Servicio no encontrado");
    }



    }
    /***
     * @return Muestra el Arraylist de vehiculo
     **/
    public void mostrarVehiculos() {
        for (Vehiculo vehiculo : vehiculos) {
            System.out.printf("Matricula: %s, Modelo: %s, Tipo: %s", vehiculo.getMatricula(), vehiculo.getModelo(), vehiculo.getTipovehi());
        }
    }
    /***
     * @return Muestra la lista de trabajos realizados
     **/
    public void mostrarTrabajos() {
        for (Vehiculo servicio : trabajosRealizados.keySet()) {
            System.out.printf("Matricula: %s, ",  servicio.getMatricula());

        }
    }
    /***
     * @return Busca en la arraylist el vehiculo a encontrar
     **/
    public void buscarVehiculo(String matricula) throws VehiculoNoEncontrado {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMatricula().equals(matricula)) {
                return;
            }
        }
        throw new VehiculoNoEncontrado("Vehiculo no encontrado");

    }
    /***
     * @return Busca en la arraylist el servicio que queremos
     **/

    public void buscarServicio(String descripcion) {
        for (Servicio servicio : servicios) {
            if (servicio.getDescripcion().equals(descripcion)) {
                return;
            }
        }
    }
}
