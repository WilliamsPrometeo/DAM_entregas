package programacion.proyecto_02.clases;

import programacion.proyecto_02.enums.TipoServicio;
import programacion.proyecto_02.enums.TipoVehiculo;
import programacion.proyecto_02.exceptions.VehiculoNoEncontrado;
import recursos.MyScanner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase Taller
 *
 * @author Alumno - Óscar Renilla
 * @version 1.0
 */
public class Taller {
    private static final MyScanner sc = new MyScanner();

    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Servicio> catalogoServicios;
    Map<Vehiculo, Servicio> trabajosRealizados;

    /**
     * Constructor principal de la clase Taller
     */
    public Taller() {
        vehiculos = new ArrayList<>();
        catalogoServicios = new ArrayList<>();
        trabajosRealizados = new HashMap<>();
    }

    /**
     * Getter del ArrayList de vehiculos
     *
     * @return vehiculos
     */
    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    /**
     * Setter del ArrayList de vehiculos
     *
     * @param vehiculos Los vehiculos
     */
    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    /***
     * Getter del ArrayList de catalogoServicios
     * @return catalogoServicios
     */
    public ArrayList<Servicio> getCatalogoServicios() {
        return catalogoServicios;
    }

    /**
     * Setter del ArrayList ctalogoServicios
     *
     * @param catalogoServicios Los Servicios
     */
    public void setCatalogoServicios(ArrayList<Servicio> catalogoServicios) {
        this.catalogoServicios = catalogoServicios;
    }

    /**
     * Getter del Map de trabajosRealizados
     *
     * @return trabajosRealizados
     */
    public Map<Vehiculo, Servicio> getTrabajosRealizados() {
        return trabajosRealizados;
    }

    /**
     * Setter del Map de trabajosRealizados
     *
     * @param trabajosRealizados Los trabajos realizados
     */
    public void setTrabajosRealizados(Map<Vehiculo, Servicio> trabajosRealizados) {
        this.trabajosRealizados = trabajosRealizados;
    }

    /**
     * Metodo para registrar vehículos
     */
    public void registrarVehiculo() {
        String matricula = null;
        TipoVehiculo tipoVehiculo = null;
        Vehiculo vehiculo = new Vehiculo(matricula, tipoVehiculo);
        do {
            matricula = sc.pideTexto("Introduce la matrícula del vehículo: ");
            String mensaje = matricula.length() == 7 ? "Matrícula correcta" : "La matrícula debe tener exactamente 7 caracteres";
            System.out.println(mensaje);
        } while (matricula.length() != 7);
        vehiculo.setMatricula(matricula);
        vehiculo.setModelo(sc.pedirSoloTexto("Introduce el modelo del vehículo: "));
        tipoVehiculo = null;
        boolean correcto;
        do {
            correcto = true;
            int opcion_genero = sc.pedirNumero("1. Turismo" +
                    "\n2. Motocicleta" +
                    "\n3. Furgoneta" +
                    "\n4. Camión" +
                    "\n5. Todoterreno" +
                    "\n6. VMP" +
                    "\nIntroduce el tipo de vehiculo: ");
            switch (opcion_genero) {
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
                case 5:
                    tipoVehiculo = TipoVehiculo.TODOTERRENO;
                    break;
                case 6:
                    tipoVehiculo = TipoVehiculo.VMP;
                    break;
                default:
                    correcto = false;
                    System.out.println("Opcion no valida!");
                    break;
            }
        } while (!correcto);

        vehiculos.add(new Vehiculo(matricula, tipoVehiculo));
    }

    /**
     * Metodo para registrar Servicios
     */
    public void registrarServicio() {
        Servicio servicio = new Servicio();
        String descripcion = sc.pideTexto("Introduce una descripción del motivo del servicio: ");
        String nombreMecanico = sc.pideTexto("Introduce el nombre del mecánico: ");
        TipoServicio tipoServicio = null;
        boolean correcto;
        do {
            correcto = true;
            int opcion_genero = sc.pedirNumero("1. Mantenimiento" +
                    "\n2. Cambio de aceite" +
                    "\n3. Pintura" +
                    "\n4. Frenos" +
                    "\n5. Electricidad" +
                    "\n6. Chapa" +
                    "\nIntroduce el tipo de servicio: ");
            switch (opcion_genero) {
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
                case 6:
                    tipoServicio = TipoServicio.CHAPA;
                    break;
                default:
                    correcto = false;
                    System.out.println("Opcion no valida!");
                    break;
            }
        } while (!correcto);
        catalogoServicios.add((Servicio) servicio);
    }

    /**
     * Metodo para asignar vehículos
     */
    public String asignarServicio() {
        String matricula = sc.pideTexto("Introduce la matrícula del vehículo: ");
        Vehiculo vehiculo;
        Servicio servicio = null;
        try {
            vehiculo = buscarVehiculo(matricula);

        } catch (VehiculoNoEncontrado e) {
            System.out.println(e.getMessage());
            vehiculo = null;
        }
        if (vehiculo != null) {
            mostrarTrabajos();
            String titulo = sc.pideTexto("Introduce una descripción del servicio: ");
            servicio = buscarServicio(titulo);
            if (servicio != null) {
                catalogoServicios.remove(servicio);
                trabajosRealizados.put(vehiculo, servicio);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                String fecha_formateada = LocalDateTime.now().format(formatter);
                System.out.printf("Fecha del trabajo: %s del servicio: %s", fecha_formateada, servicio.getDescripcion());
            } else {
                System.out.println("No hay ningun servicio con esa descripción disponible!");
            }

        } else {
            System.out.println("No existe un vehículo con esa matrícula!");
        }
        return (vehiculo != null && servicio != null) ? "Servicio asignado correctamente" : "Error en el proceso.";
    }

    /**
     * Metodo para mostrar vehículos
     */
    public boolean mostrarVehiculos() {
        if (!vehiculos.isEmpty()) {
            for (Vehiculo vehiculo : vehiculos) {
                System.out.println(vehiculo);
            }
            boolean correcto;
            do {
                char opcion = sc.pedirLetra("¿Quiere filtrar por el tipo de vehículo? (S/N)");
                switch (opcion) {
                    case 'S':
                    case 's':
                        filtroTipoVehiculo();
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
            System.out.println("No hay vehículos disponibles");
            return false;
        }
    }

    /**
     * Metodo para filtrar por tipo de vehículo
     */
    public void filtroTipoVehiculo() {
        TipoVehiculo tipoVehiculo = null;
        boolean correcto;
        do {
            correcto = true;
            int opcion_genero = sc.pedirNumero("1. Turismo" +
                    "\n2. Motocicleta" +
                    "\n3. Furgoneta" +
                    "\n4. Camión" +
                    "\n5. Todoterreno" +
                    "\n6. VMP" +
                    "\nIntroduce el tipo de vehiculo: ");
            switch (opcion_genero) {
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
                case 5:
                    tipoVehiculo = TipoVehiculo.TODOTERRENO;
                    break;
                case 6:
                    tipoVehiculo = TipoVehiculo.VMP;
                    break;
                default:
                    correcto = false;
                    System.out.println("Opcion no valida!");
                    break;
            }
        } while (!correcto);
        for (Vehiculo vehiculo : vehiculos) {
            if (tipoVehiculo == vehiculo.getTipoVehiculo()) {
                System.out.println(vehiculo);
            }
        }
    }

    /**
     * Metodo para mostrar los trabajos
     */
    public boolean mostrarTrabajos() {
        if (trabajosRealizados.isEmpty()) {
            System.out.println("No hay trabajos que mostrar");
            return false;
        }
        for (Vehiculo vehiculo : trabajosRealizados.keySet()) {
            Servicio servicio = trabajosRealizados.get(vehiculo);
            System.out.printf(
                    "Trabajo: Matrícula del vehículo: %s, Trabajo realizado: %s", vehiculo.getMatricula(), servicio.getDescripcion()
            );
        }
        return true;
    }

    /**
     * Metodo para buscar vehículos por matrícula
     */
    public Vehiculo buscarVehiculo(String matricula) throws VehiculoNoEncontrado {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMatricula().equals(matricula)) {
                return vehiculo;
            }
        }
        throw new VehiculoNoEncontrado("Vehículo no encontrado");
    }

    /**
     * Metodo para buscar servicios
     */
    public Servicio buscarServicio(String descripcion) {
        for (Servicio servicio : catalogoServicios) {
            if (servicio.getDescripcion().equals(servicio)) {
                return servicio;
            }
        }
        return null;
    }
}
