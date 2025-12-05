package proyecto2;

import proyecto2.enums.TipoServicio;
import proyecto2.enums.TipoVehiculo;
import proyecto2.exception.VehiculoNoEncontrado;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Clase que ejecuta la gran mayotia del programa, gestiona los tipos de vehiculos y tipo de servicios
 * @author Nombre del Alumno
 * @version 1.0
 */
public class Taller {

    private static final MyScanner sc = new MyScanner();

    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Servicio> catalogoServicios;
    private Map<Vehiculo, Servicio> trabajosRealizados;

    /**
     * Constructor por defecto. Inicializa las colecciones vacías.
     */

    public Taller() {

        vehiculos = new ArrayList<>();
        catalogoServicios = new ArrayList<>();
        trabajosRealizados = new HashMap<>();
    }

    /**
     * Devuelve la lista de vehiculos
     * @return lista de vehiculos
     */

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    /**
     * Asigna una nueva lista de vehiculos.
     * @param vehiculos nueva lista de libros
     */
    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
    /**
     * Devuelve la lista de servicios
     * @return lista de vehiculos
     */
    public ArrayList<Servicio> getCatalogoServicios() {
        return catalogoServicios;
    }
    /**
     * Asigna una nueva lista de servicios.
     * @param catalogoServicios nueva lista de servicios
     */

    public void setCatalogoServicios(ArrayList<Servicio> catalogoServicios) {
        this.catalogoServicios = catalogoServicios;
    }
    /**
     * Devuelve el mapa de préstamos
     * @return mapa de trabajos realizados
     */
    public Map<Vehiculo, Servicio> getTrabajosRealizados() {
        return trabajosRealizados;
    }
    /**
     * Asigna un nuevo mapa de servicios
     * @param trabajosRealizados nuevo mapa de usuarios
     */

    public void setTrabajosRealizados(Map<Vehiculo, Servicio> trabajosRealizados) {
        this.trabajosRealizados = trabajosRealizados;
    }

    /**
     * Metodo para registrar los vehiculos por consola
     */

    public void registrarVehiculo() {

        Vehiculo vehiculo = new Vehiculo();

        vehiculo.setModelo(sc.pedirSoloMns("Introduce el nombre del modelo: "));

        String matricula;

        do{
            matricula = sc.pideTexto("Introduce el numero de la matricula: ");
            String mensaje = matricula.length() == 7 ? "Matricula correcta" : "La matricula tiene que tener 7 caracteres exactamente";
            System.out.println(mensaje);
        } while(matricula.length() != 7);

        vehiculo.setMatricula(matricula);

        vehiculos.add(vehiculo);
        TipoServicio tipoServicio = null;
        boolean correcto;
        do{
            correcto = true;
            int opcion_tipoServicio = sc.pedirNumero2("1. Mantenimiento" +
                    "\n2. Cambio de aceite" +
                    "\n3. Pintura" +
                    "\n4. Frenos" +
                    "\n5. Electricidad" +
                    "\nIntroduce la opción del Servicio: ");

            switch (opcion_tipoServicio) {
                case 1:
                    tipoServicio = TipoServicio.MANTENIMIENTO;
                    break;
                case 2:
                    tipoServicio = TipoServicio.CAMBIO_ACEITE;
                    break;
                case 3:
                    tipoServicio = TipoServicio.PINTURA;
                    break;
                case 4:
                    tipoServicio =TipoServicio.FRENOS;
                    break;
                case 5:
                    tipoServicio =TipoServicio.ELECTRICIDAD;
                    break;
                default:
                    correcto = false;
                    System.out.println("Opción no valida");
                    break;
            }
        } while(!correcto);

    }

    /**
     * Metodo para registrar los servicios por consola
     */

    public void registrarServicio() {

        String descripcion = sc.pedirSoloMns("Introduce descripcion del servicio: ");
        String mecanico = sc.pedirSoloMns("Introduce el nombre de la mecanico: ");

        TipoServicio tipoServicio = null;
        boolean correcto;
        do{
            correcto = true;
            int opcion_tipoServicio = sc.pedirNumero2("1. Mantenimiento" +
                    "\n2. Cambio de aceite" +
                    "\n3. Pintura" +
                    "\n4. Frenos" +
                    "\n5. Electricidad" +
                    "\nIntroduce la opción del Servicio: ");

            switch (opcion_tipoServicio) {
                case 1:
                    tipoServicio = TipoServicio.MANTENIMIENTO;
                    break;
                    case 2:
                    tipoServicio = TipoServicio.CAMBIO_ACEITE;
                    break;
                    case 3:
                    tipoServicio = TipoServicio.PINTURA;
                    break;
                    case 4:
                    tipoServicio =TipoServicio.FRENOS;
                    break;
                    case 5:
                    tipoServicio =TipoServicio.ELECTRICIDAD;
                    break;
                    default:
                    correcto = false;
                    System.out.println("Opción no valida");
                    break;
            }
        } while(!correcto);

        catalogoServicios.add(new Servicio(descripcion, mecanico, tipoServicio));

    }

    /**
     * Metodo para asignar un servicio a un vehiculo
     */

    public String asignarServicio() {

        String matricula = sc.pideTexto("Introduce el numero de la matricula: ");
        Vehiculo vehiculo;
        Servicio servicio = null;
        try {
            vehiculo = buscarVehiculo(matricula);
        } catch (VehiculoNoEncontrado e) {
            System.out.println("Vehiculo no encontrado");
            vehiculo = null;
        }
        if (vehiculo != null) {
            if(mostrarTrabajos()){
                String descripcion  = sc.pedirSoloMns("Introduce el nombre del servicio que quieras usar: ");
                servicio = buscarServicio(descripcion);
                if (servicio != null) {
                    trabajosRealizados.put(vehiculo, servicio);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                    String fecha_formatada = LocalDateTime.now().format(formatter);
                    System.out.printf("Fecha del trabajo: %s", fecha_formatada);
                } else {
                    System.out.println("Servicio no encontrado");
                }
            }
        } else {
            System.out.println("No hay ningún coche con esa matricula!");
        }
        return (vehiculo != null && servicio != null) ? "Servicio asigando correctamente" : "Error en el proceso";
    }

    /**
     * Metodo para mostrar la lista de vehiculos
     */

    public boolean mostrarVehiculos() {
        if (!vehiculos.isEmpty()) {
            for (Vehiculo vehiculo : vehiculos) {
                System.out.println(vehiculo);
            }
            boolean correcto;
            do {
                char opcion = sc.pedirLetra("¿Quiere filtrar por Tipo de Vehiculo? SI (S/s) o No (N/n)");
                switch (opcion) {
                    case 's' :
                    case 'S':
                        filtroTipoVehiculo();
                        correcto = true;
                        break;
                    case 'n':
                    case 'N':
                        correcto = true;
                        break;
                    default:
                        correcto = false;
                        break;
                }
            } while (!correcto);
            return true;
        } else {
            System.out.println("No hay coches disponibles");
            return false;
            }
    }

    /**
     * Metodo ayudar a mostrar las vehiculos
     */

    public void filtroTipoVehiculo() {
        TipoVehiculo tipoVehiculo = null;
        boolean correcto;
        do {
            correcto = true;
            int opcion_tipoVehiculo = sc.pedirNumero2("1. Turismo" +
                    "\n2. Motocicleta" +
                    "\n3. Furgoneta" +
                    "\n4. Camion" +
                    "\nIntroduce la opción del vehiculo: ");
            switch (opcion_tipoVehiculo) {
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
                    System.out.println("Opción no valida");
                break;
            }
        } while (!correcto);

        for (Vehiculo vehiculo : vehiculos) {
            if (tipoVehiculo.equals(vehiculo.getTipoVehiculo())) {
                System.out.println(vehiculo);
            }
        }
    }
    /**
     * Metodo ayudar a mostrar los trabajos
     */

    public boolean mostrarTrabajos() {

        for (Vehiculo user : trabajosRealizados.keySet()) {
            System.out.printf("Trabajo: Vehiculo %s, Servicio %s " + user.getMatricula(), trabajosRealizados.get(user));
        }
        return false;
    }

    /**
     * Metodo para buscar los vehiculos
     */

    public Vehiculo buscarVehiculo(String matricula) throws VehiculoNoEncontrado {

        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMatricula().equals(matricula)) {
                return vehiculo;
            }
        }
        throw new VehiculoNoEncontrado("Vehiculo no encontrado");
    }
    /**
     * Metodo para buscar los servicios
     */
    public Servicio buscarServicio(String descripcion) {
        for (Servicio servicio : catalogoServicios) {
            if (servicio.getDescripcion().equals(descripcion)) {
                return servicio;
            }
        }
        return null;
    }






}
