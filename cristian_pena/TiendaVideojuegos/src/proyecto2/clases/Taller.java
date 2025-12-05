package proyecto2.clases;

import enums.TipoServicio;
import enums.TipoVehiculo;
import exception.VehiculoNoEncontrado;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 * Clase Servicio
 *
 * @author Alumno - Cristian Peña

 */

public class Taller {
    private static final MyScanner sc = new MyScanner();

    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Servicio> servicios;
    private Map<Vehiculo, Servicio> trabajosRealizados;
    /**
     * Constructor vacio de la clase Taller
     * Se inicializa la lista de vehiculos
     * Se inicializa la lista de servicios
     * Se inicializa el mapa de trabajosRealizados
     */
    public Taller() {
        vehiculos = new ArrayList<>();
        servicios = new ArrayList<>();
        trabajosRealizados = new HashMap<>();
    }
    /**
     * Getter del atributo vehiculos
     *
     * @return la lista de vehiculos del taller
     */

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    /**
     * Setter del atributo vehiculos
     *
     * @param vehiculos establece la lista de vehiculos del taller
     */
    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
    /**
     * Getter del atributo servicios
     *
     * @return la lista de servicios del taller
     */

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }
    /**
     * Setter del atributo servicios
     *
     * @param servicios establece la lista de vehiculos del taller
     */

    public void setServicios(ArrayList<Servicio> servicios) {
        this.servicios = servicios;
    }

    public Map<Vehiculo, Servicio> getTrabajosRealizados() {
        return trabajosRealizados;
    }

    public void setTrabajosRealizados(Map<Vehiculo, Servicio> trabajosRealizados) {
        this.trabajosRealizados = trabajosRealizados;
    }
    /**
     * Metodo para registrar un Vehículo a la lista de Vehículos del taller
     *
     */

    public void registrarVehiculo() {
        String matricula;
        do {
            matricula = sc.pideTexto("Introduzca la matricula: ");
            String mensaje = matricula.length() == 7 ? "Matricula correcta" : "La matricula debe tener 7 caracteres";
            System.out.println(mensaje);
        } while (matricula.length() != 7);
        String modelo = sc.pideTexto("Ingrese la modelo del vehiculo");
        TipoVehiculo tipo = null;
        boolean correcto;
        do {
            correcto = true;
            int opcion_vehiculo = sc.pedirNumero("1. Turismo" +
                    "\n2. Motocicleta" +
                    "\n3. Furgoneta" +
                    "\n4. Camion" +
                    "\nIntroduce el tipo de vehiculo: ");
            switch (opcion_vehiculo) {
                case 1:
                    tipo = TipoVehiculo.TURISMO;
                    break;
                case 2:
                    tipo = TipoVehiculo.MOTOCICLETA;
                    break;
                case 3:
                    tipo = TipoVehiculo.FURGONETA;
                    break;
                case 4:
                    tipo = TipoVehiculo.CAMION;
                    break;
                default:
                    correcto = false;
                    System.out.println("Opcion no valida!");
                    break;
            }
        } while (!correcto);
        vehiculos.add(new Vehiculo(matricula, modelo, tipo));
    }
    /**
     * Metodo para añadir un Servicio a la lista de Servicios
     *
     */
    public void registrarServicio() {
        String descripcion = sc.pideTexto("Introduzca la descripcion del servicio: ");
        String mecanico = sc.pideTexto("Introduzca el nombre del mecanico: ");
        TipoServicio tipo = null;
        boolean correcto;
        do {
            correcto = true;
            int opcion_servicio = sc.pedirNumero("\n1. Mantenimiento" +
                    "\n2. Cambio de aceite" +
                    "\n3. Pintura" +
                    "\n4. Frenos" +
                    "\n5. Electricidad: " +
                    "\nIntroduzca el tipo de servicio : ");
            switch (opcion_servicio) {
                case 1:
                    tipo = TipoServicio.MANTENIMIENTO;
                    break;
                case 2:
                    tipo = TipoServicio.CAMBIO_ACEITE;
                    break;
                case 3:
                    tipo = TipoServicio.PINTURA;
                    break;
                case 4:
                    tipo = TipoServicio.FRENOS;
                    break;
                    case 5:
                        tipo = TipoServicio.ELECTRICIDAD;
                default:
                    correcto = false;
                    System.out.println("Opcion no valida!");
                    break;
            }
        } while (!correcto);
        servicios.add(new Servicio(descripcion, mecanico, tipo));
    }
    /**
     * Metodo para asignar un Vehículo  y un servicio
     *
     * vehiculo y servicio asignados
     */
    public void asignarServicio(){
        String matricula = sc.pideTexto("Introduzca la matricula del vehiculo: ");
        Vehiculo vehiculo;
        Servicio servicio = null;
        try {
            vehiculo = buscarVehiculo(matricula);

        } catch (VehiculoNoEncontrado e) {
            System.out.println(e.getMessage());
            vehiculo = null;
        }
        if (vehiculo != null) {
            if (mostrarTrabajos()) {
                String titulo = sc.pideTexto("Introduce la descripción del servicio: ");
                servicio = buscarServicio(servicio.getDescripcion());
                if (servicio != null) {
                    trabajosRealizados.put(vehiculo, servicio);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                    String fecha_formateada = LocalDateTime.now().format(formatter);
                    System.out.printf("Fecha de asignacion: %s del servicio: %s", fecha_formateada, servicio.getDescripcion());
                } else {
                    System.out.println("No hay ningun trabajo con esa descripcion !");
                }
            }
        } else {
            System.out.println("No existe ningun vehiculo con esa matricula !");
        }
        registrarServicio();
        registrarVehiculo();
        System.out.println("Servicio registrado!");
    }
    /**
     * Metodo para mostrar la lista de vehiculos
     *
     * Mostrar lista de vehiculos
     */
    public boolean mostrarVehiculos(){
        if (!vehiculos.isEmpty()) {
            for (Vehiculo vehiculo : vehiculos) {
                System.out.println(vehiculo);
            }
            boolean correcto;
            do {
                char opcion = sc.pedirLetra("¿Quiere filtrar por Tipo de Vehiculo? (S/N)");
                switch (opcion) {
                    case 'S':
                    case 's':
                        filtroVehiculo();
                        correcto = true;
                        break;
                    case 'N':
                    case 'n':
                        correcto = true;
                        break;
                    default:
                        correcto = false;
                        break;
                }
            } while (!correcto);
            return true;
        } else {
            System.out.println("No hay vehiculos disponibles");
            return false;
        }
    }
    /**
     * Metodo para filtrar por tipo de vehiculo
     *
     *
     */
    public void filtroVehiculo() {
        TipoVehiculo tipo = null;
        boolean correcto;
        do {
            correcto = true;
            int opcion_vehiculo = sc.pedirNumero("1. Turismo" +
                    "\n2. Motocicleta" +
                    "\n3. Furgoneta" +
                    "\n4. Camion" +
                    "\nIntroduce el tipo de vehiculo: ");
            switch (opcion_vehiculo) {
                case 1:
                    tipo = TipoVehiculo.TURISMO;
                    break;
                case 2:
                    tipo = TipoVehiculo.MOTOCICLETA;
                    break;
                case 3:
                    tipo = TipoVehiculo.FURGONETA;
                    break;
                case 4:
                    tipo = TipoVehiculo.CAMION;
                    break;
                default:
                    correcto = false;
                    System.out.println("Opcion no valida!");
                    break;
            }
        } while (!correcto);
        for (Vehiculo vehiculo : vehiculos) {
            if (tipo == vehiculo.getTipo()) {
                System.out.println(vehiculo);
            }
        }
    }
    /**
     * Metodo para mostrar los trabajos del la lista de Servicios
     *
     *  servicio añadido
     */
    public boolean mostrarTrabajos(){
        for (Map.Entry<Vehiculo, Servicio> e : trabajosRealizados.entrySet()) {
            Vehiculo vehiculo = e.getKey();
            Servicio servicio = e.getValue();
            System.out.printf("%s, %s%n", vehiculo, servicio);
        }
        return false;
    }
    /**
     * Metodo para buscar vehiculos por matricula
     * Lanza una excepcion si el vehiculo no está
     *
     * return del atributo vehiculo
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
     * Metodo para buscar servicios por descripcion
     *
     *
     * return del atributo servicio
     */

    public Servicio buscarServicio(String descripcion) {
        for (Servicio servicio : servicios) {
            if (servicio.getDescripcion().equals(descripcion)){
            return servicio;
            }
        }
        registrarServicio();
        return null;

    }

}
