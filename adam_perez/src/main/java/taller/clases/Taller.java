package clases;

import recursos.MyScanner;
import recursos.TipoServicio;
import recursos.TipoVehiculo;
import recursos.VehiculoNoEncontrado;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Clase Taller
 *
 * @author Adam Perez -Alumno
 * @version 1.0
 */

public class Taller {
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Servicio> catalogoServicios;
    private Map<Vehiculo, Servicio> trabajosRealizados;
    private final MyScanner sc = new MyScanner();

    /**
     * Constructor principal vacio de la clase Taller, se incializan las colecciones
     */

    public Taller() {
        vehiculos = new ArrayList<>();
        catalogoServicios = new ArrayList<>();
        trabajosRealizados = new LinkedHashMap<Vehiculo, Servicio>();
    }

    /**
     * Metodo para registrar vehiculos
     */

    public void registrarVehiculo() {
        TipoVehiculo tipo = null;
        String matricula = sc.pideTexto("Introduce la matricula del vehiculo: ");
        String modelo = sc.pideTexto("Introduce el modelo del vehiculo: ");
        boolean correcto = true;

        while (matricula.length() != 7) {
            if (matricula.length() != 7) {
                System.out.println("La matricula no es valida, minimo 7 caracteres");
            } else {
                System.out.println("Matricula correcta");
            }
        }

        do {
            int opcion = sc.pedirNumero("Cual es el tipo del vehiculo: \n" +
                    "1. Turismo\n" +
                    "2. Motocicleta\n" +
                    "3. Furgoneta\n" +
                    "4. Camion\n" +
                    "Opcion: ");
            switch (opcion) {
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
                    System.out.println("Esa opcion no es valida");
                    break;
            }
        } while (!correcto);

        Vehiculo vehiculo = new Vehiculo(matricula, modelo, tipo);
        vehiculos.add(vehiculo);

    }

    /**
     * Metodo para registrar servicios
     */

    public void registrarServicio() {
        String descripcion = sc.pideTexto("Introduce una breve descripcion del servicio: ");
        String mecanico = sc.pideTexto("Introduce el nombre del mecanico del servicio: ");
        TipoServicio tipoServicio = null;
        boolean correcto = true;

        do {
            int opcion = sc.pedirNumero("Cual es el tipo de servicio:\n" +
                    "1. Mantenimiento\n" +
                    "2. Cambio de aceite\n" +
                    "3. Pintura\n" +
                    "4. Frenos\n" +
                    "5. Electricidad\n" +
                    "Opcion: ");
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
                    System.out.println("Ese servicio no existe");
                    break;
            }
        } while (!correcto);

        catalogoServicios.add(new Servicio(descripcion, mecanico, tipoServicio));
    }

    /**
     * Metodo para asignar un servicio a un vehiculo
     */

    public void asignarSevicio() {
        Servicio servicio;
        Vehiculo vehiculo;
        String mensaje;

        String matricula = sc.pideTexto("Introduce la matricula del vehiculo: ");

        try {
            vehiculo = buscarVehiculo(matricula);
        } catch (VehiculoNoEncontrado e) {
            System.out.println("Vehiculo no encontrado");
            vehiculo = null;
        }

        if (vehiculo != null) {
            String descripcion = sc.pideTexto("Introduce la descripcion del servicio: ");
            servicio = buscarServicio(descripcion);
            mensaje = servicio != null ? "Servicio encontrado" : "Servicio no encontrado";
            System.out.println(mensaje);
            if (servicio != null) {
                trabajosRealizados.put(vehiculo, servicio);
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                String fecha_formateada = LocalDateTime.now().format(dtf);
                System.out.printf("Fecha del servicio: %s del vehiculo: %s\n", fecha_formateada, vehiculo);
            } else {
                System.out.println("Servicio no encontrado");
            }
        } else {
            System.out.println("Vehiculo no encontrado");
        }
    }

    /**
     * Metodo para buscar un vehiculo
     *
     * @param matricula String con la matricula del vehiculo
     * @return La matricula del vehiculo
     */

    public Vehiculo buscarVehiculo(String matricula) throws VehiculoNoEncontrado {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMatricula().equals(matricula)) {
                System.out.println("Vehiculo encontrado");
                return vehiculo;
            }
        }
        throw new VehiculoNoEncontrado("No se encontro un vehiculo");
    }

    /**
     * Metodo para buscar un servicio
     *
     * @param descipcion String con la descripcion del servicio
     * @return un servicio
     */

    public Servicio buscarServicio(String descipcion) {
        for (Servicio servicio : catalogoServicios) {
            if (servicio.getDescripcion().equals(descipcion)) {
                return servicio;
            }
        }
        return null;
    }

    /**
     * Metodo para mostrar servicios
     */

    public void mostrarServicios() {
        for (Servicio servicio : catalogoServicios) {
            System.out.println(servicio);
        }
    }

    /**
     * Metodo para mostrar vehiculos
     */

    public void mostrarVehiculos() {
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo);
        }

        boolean correcto = true;

        do {
            int filtro = sc.pedirLetra("Quires filtrar por top de vehiculo? (S = si / N = no)");
            switch (filtro) {
                case 'S':
                case 's':
                    filtrarVehiculos();
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
    }

    /**
     * Metodo para filtrar vehiculos por tipo
     */

    public void filtrarVehiculos() {
        boolean correcto = true;
        TipoVehiculo tipoVehiculo = null;
        do {
            int opcion = sc.pedirNumero("Cual es el tipo del vehiculo: \n" +
                    "1. Turismo\n" +
                    "2. Motocicleta\n" +
                    "3. Furgoneta\n" +
                    "4. Camion\n" +
                    "Opcion: ");
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
                    System.out.println("Esa opcion no es valida");
                    break;
            }
        } while (!correcto);

        for (Vehiculo vehiculo : vehiculos) {
            if (tipoVehiculo == vehiculo.getTipo()) {
                System.out.println(vehiculo);
            }
        }
    }
}
