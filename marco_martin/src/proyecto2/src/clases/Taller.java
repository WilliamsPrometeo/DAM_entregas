package clases;

import enums.TipoServicio;
import enums.TipoVehiculo;
import recursos.MyScanner;
import recursos.VehiculoNoEncontrado;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Clase Taller
 *
 * @author Alumno- Marco Martín
 * @version 1.0
 */
public class Taller {
    private static final MyScanner sc = new MyScanner();
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Servicio> catalogoServicios;
    private Map<Vehiculo, Servicio> trabajosRealizados;

    /**
     * Constructor vacío de la clase Taller que inicializa todas las colecciones
     */
    public Taller() {
        vehiculos = new ArrayList<>();
        catalogoServicios = new ArrayList<>();
        trabajosRealizados = new LinkedHashMap<>();
    }
    /**
     * Getter de los vehiculos disponibles
     *
     * @return un array de vehiculos disponibles
     */
    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    /**
     * Setter de los libros disponibles
     *
     * @return un array de vehiculos disponibles
     */
    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
    /**
     * Getter de los servicios disponibles
     *
     * @return un array de servicios disponibles
     */
    public ArrayList<Servicio> getCatalogoServicios() {
        return catalogoServicios;
    }
    /**
     * Setter de los servicios disponibles
     *
     * @return un array de servicios disponibles
     */
    public void setCatalogoServicios(ArrayList<Servicio> catalogoServicios) {
        this.catalogoServicios = catalogoServicios;
    }
    /**
     * Getter de los trabajos disponibles
     *
     * @return un map de trabajos disponibles
     */
    public Map<Vehiculo, Servicio> getTrabajosRealizados() {
        return trabajosRealizados;
    }
    /**
     * Setter de los trabajos disponibles
     *
     * @return un map de trabajos disponibles
     */
    public void setTrabajosRealizados(Map<Vehiculo, Servicio> trabajosRealizados) {
        this.trabajosRealizados = trabajosRealizados;
    }

    /**
     * Metodo registrarVehiculo para registrar vehiculos
     */
    public void registrarVehiculo() {
        Vehiculo vehiculo;
        String modelo=sc.pedirSoloTexto("Introduzca el modelo del vehiculo: \n");
        String matricula;

        do {
            matricula = sc.pideTexto("Introduzca la matricula del vehiculo a registrar: \n");
            String mensaje = matricula.length() == 7 ? "matricula registrada con éxito" : "La matrícula debe tener 7 dígitos\n";
            System.out.println(mensaje);
        } while (matricula.length() != 7);

        TipoVehiculo tipoVehiculo = null;
        boolean correcto;
        do {
            correcto = true;
            int opcion = sc.pedirNumero("Introduce una opción de tipo de vehículo: \n" + "1. Turismo \n" + "2. Motocicleta \n" + "3. Furgoneta \n" + "4. Camion \n");
            switch (opcion) {
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
                    System.out.println("Opcion no valida");
            }
        } while (!correcto);
        System.out.println("Vehiculo registrado correctamente\n");
        vehiculos.add(new Vehiculo( matricula, tipoVehiculo, modelo));

    }

    /**
     * Metodo registrar servicio para registrar servicios
     */
    public void registrarServicio() {
        String descripcion = sc.pedirSoloTexto("Introduzca el descripcion del servicio: \n");
        String mecanico = sc.pedirSoloTexto("Introduzca el nombre mecanico del servicio: \n");
        TipoServicio tipoServicio = null;
        boolean correcto;
        do {
            correcto = true;
            int opcion = sc.pedirNumero("Introduzca una opción para el tipo de servicio del servicio: \n" + "1. Mantenimiento \n" + "2. Cambio de aceite \n" + "3. Pintura \n" + "4. Frenos \n" + "5. Electricidad \n");
            switch (opcion) {
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
                    tipoServicio = TipoServicio.FRENOS;
                    break;
                case 5:
                    tipoServicio = TipoServicio.ELECTRICIDAD;
                    break;
                default:
                    correcto = false;
                    System.out.println("Opcion no valida\n");
            }
        } while (!correcto);
        System.out.println("Servicio registrado correctamente\n");
        catalogoServicios.add(new Servicio(descripcion, mecanico, tipoServicio));
    }

    /**
     * Metodo asignarServicio para asignar un servicio a un vehiculo
     * @return un ternario que devuelve el servicio asignado o no, dependiendo de si la matricula y el servicio existen
     */
    public String asignarServicio() {
        Vehiculo vehiculo;
        Servicio servicio = null;
        String matricula = sc.pideTexto("Introduzca la matricula del vehículo: \n");
        try {
            vehiculo = buscarVehiculo(matricula);
        } catch (VehiculoNoEncontrado e) {
            System.out.println(e.getMessage());
            vehiculo = null;
        }
        if (vehiculo != null) {
            if (!catalogoServicios.isEmpty()) {
                String descripcion = sc.pedirSoloTexto("Introduzca el descripcion del servicio: \n");
                servicio = buscarServicio(descripcion);
                if (servicio != null) {
                    trabajosRealizados.put(vehiculo, servicio);
                    DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                    String fecha_formateada = LocalDateTime.now().format(formato2);
                    System.out.printf("Has solicitado el servicio: %s en la fecha: %s \n", servicio.getDescripcion(), fecha_formateada);
                }
            } else {
                System.out.println("No existen servicios\n");
            }
        }

        return (vehiculo != null && servicio != null) ? "Servicio asignado con éxito\n" : "ERROR\n";
    }

    /**
     * Metodo filtrarVehiculo para filtrar vehiculos por el tipo de vehiculo
     */
    public void filtrarVehiculo() {
        TipoVehiculo tipoVehiculo = null;
        boolean correcto;
        do {
            correcto = true;
            int opcion = sc.pedirNumero("Introduce una opción de tipo de vehículo: \n" + "1. Turismo \n" + "2. Motocicleta \n" + "3. Furgoneta \n" + "4. Camion \n");
            switch (opcion) {
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
                    System.out.println("Opcion no valida\n");
            }
        } while (!correcto);
        for (Vehiculo vehiculo : vehiculos) {
            if (tipoVehiculo == vehiculo.getTipoVehiculo()) {
                System.out.println(vehiculo);
            }
        }
    }

    /**
     * Metodo mostrarVehiculos para mostrar los vehiculos
     */
    public void mostrarVehiculos() {
        if (!vehiculos.isEmpty()) {
            for (Vehiculo vehiculo : vehiculos) {
                System.out.println(vehiculo);
            }
            boolean correcto;
            do {
                char opcion = sc.pedirLetra("¿Quiere filtrar por tipo de vehiculo? S/N (Sí/no)\n");
                switch (opcion) {
                    case 's':
                    case 'S':
                        filtrarVehiculo();
                        correcto = true;
                        break;
                    case 'n':
                    case 'N':
                        correcto = true;
                        break;
                    default:
                        correcto = false;
                        System.out.println("Opcion no valida\n");
                }
            } while (!correcto);
        } else {
            System.out.println("No existe el vehiculo\n");
        }
    }

    /**
     * Metodo mostrarTrabajos para mostrar trabajos
     */
    public void mostrarTrabajos() {
        if (trabajosRealizados.isEmpty()) {
            System.out.println("No hay trabajos realizados\n");
        } else {
            for (Vehiculo vehiculo : trabajosRealizados.keySet()) {
                System.out.printf("Trabajo:\n Vehiculo: %s Servicio: %s\n ", vehiculo.getTipoVehiculo(), trabajosRealizados.get(vehiculo));
            }
        }
    }

    /**
     * Metodo para buscar vehiculos dentro del array
     * @param matricula
     * @return el vehiculo seleccionado por la matricula
     * @throws VehiculoNoEncontrado
     */
    public Vehiculo buscarVehiculo(String matricula) throws VehiculoNoEncontrado {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMatricula().equals(matricula)) {
                return vehiculo;
            }
        }
        throw new VehiculoNoEncontrado("Vehiculo no encontrado\n");
    }

    /**
     * metodo para buscar servicios
     * @param descripcion
     * @return el servicio que coincide con la descripcion
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
