package proyecto_02.clases;

import ciudad.recursos.MyScanner;
import proyecto_02.enums.TipoServicio;
import proyecto_02.enums.TipoVehiculo;
import proyecto_02.exceptions.VehiculoNoEncontrado;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Clase principal que gestiona la lógica del taller
 * Permite registrar vehiculos, registrar servicios, asignar servicios, mostrar vehiculos y mostrar trabajos.
 */
public class Taller {

    private static final MyScanner sc = new MyScanner();

    private ArrayList<Vehiculo> vehiculos;

    private Map<Vehiculo, Servicio> trabajosRealizados;

    private ArrayList<Servicio> catalogoServicios;

    /**
     * Constructor que inicializa las estructuras necesarias; vehiculos, trabajos realizados y catalogo de servicios.
     */
    public Taller() {
        vehiculos = new ArrayList<>();
        trabajosRealizados = new LinkedHashMap<>();
        catalogoServicios = new ArrayList<>();
    }

    /**
     * Getter de la lista de vehiculos
     * @return Lista de vehiculos
     */
    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    /**
     * Setter de la lista de vehiculos
     * @param vehiculos de la lista de vehiculos
     */
    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    /**
     * Getter de la lista de trabajos
     * @return Lista de libros prestados
     */
    public Map<Vehiculo, Servicio> getTrabajosRealizados() {
        return trabajosRealizados;
    }

    /**
     * Setter de la lista de trabajos
     * @param trabajosRealizados de la lista de trabajos
     */
    public void setTrabajosRealizados(Map<Vehiculo, Servicio> trabajosRealizados) {
        this.trabajosRealizados = trabajosRealizados;
    }

    /**
     * Getter de la lista de servicios
     * @return Lista de servicios
     */
    public ArrayList<Servicio> getCatalogoServicios() {
        return catalogoServicios;
    }

    /**
     * Setter de la lista de servios
     * @param catalogoServicios de la lista servicios
     */
    public void setCatalogoServicios(ArrayList<Servicio> catalogoServicios) {
        this.catalogoServicios = catalogoServicios;
    }

    /**
     * Registra un nuevo vehículo pidiendo vehiculo y matrícula por consola
     * Valida que la matícula tenga exactamente 7 caracteres
     * Muestra las opciones disponibles y ejecuta la acción elegida por el usuario
     * El menú se repetirá hasta que el usuario introduzca una una opción correcta
     */
    public void registrarVehiculo() {

        Vehiculo vehiculo = new Vehiculo();

        String matricula;

        do {

            // Coprueba que el usuario introduzca números
            matricula = sc.pideTexto("Introduce la matrícula del vehículo: ");

            // Si el usuario introduce menos de 7 caracteres el bucle continua
            String mensaje = matricula.length() != 7 ? "La matrícula tiene que tener exactamente 7 caracteres." : "Matrícula correcta.";
            System.out.println(mensaje);

        } while (matricula.length() != 7);

        vehiculo.setMatricula(matricula);

        vehiculos.add(vehiculo);

        String modelo = sc.pideTexto("Introduce el modelo del vehículo: ");
        TipoVehiculo tipoVehiculo = null;

        boolean correcto;
        do {
            correcto = true;
            int opcion_tipo_vehiculo = sc.pedirNumero("1. Turismo" +
                    "\n2. Motocicleta" +
                    "\n3. Furgoneta" +
                    "\n4. Camión" +
                    "\nIntroduce la opción del tipo de vehiculo: ");

            switch (opcion_tipo_vehiculo) {
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
                    System.out.println("Opción no válida.");
                    correcto = false;
                    break;
            }

        } while (!correcto);
        vehiculos.add(new Vehiculo(matricula, modelo, tipoVehiculo));

    }

    /**
     * Registra un nuevo servicio pidiendo
     * Muestra las opciones disponibles y ejecuta la acción elegida por el usuario
     * El menú se repetirá hasta que el usuario introduzca una una opción correcta
     */
    public void registrarServicio() {
        String descripcion = sc.pideTexto("Describe el problema del vehículo: ");
        String mecanico = sc.pedirSoloTexto("Introduce el nombre del mecánico: ");
        TipoServicio tipoServicio = null;

        boolean correcto;
        do {
            correcto = true;
            int opcion_tipo_servicio = sc.pedirNumero("1. Mantenimiento" +
                    "\n2. Cambio de aceite" +
                    "\n3. Pintura" +
                    "\n4. Frenos" +
                    "\n5. Electicidad" +
                    "\nIntroduce la opción del servicio que necesite: ");

            switch (opcion_tipo_servicio) {
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
                    System.out.println("Opción no válida.");
                    correcto = false;
                    break;
            }

        } while (!correcto);
        catalogoServicios.add(new Servicio(descripcion, mecanico, tipoServicio));

    }

    /**
     * Registra un nuevo servicio pidiendo
     * Muestra las opciones disponibles y ejecuta la acción elegida por el usuario
     * El menú se repetirá hasta que el usuario introduzca una una opción correcta
     */
    public void asignarServicio() {
        String matricula = sc.pideTexto("Introduce la matricula del vehículo: ");
        Vehiculo vehiculo = null;
        Servicio servicio = null;
        try {
            vehiculo = buscarVehiculo(matricula);

        } catch (VehiculoNoEncontrado e) {
            System.out.println(e.getMessage());
        }
        if (vehiculo != null) {
            if (mostrarVehiculos()) {
                mostrarVehiculos();
                String descripcion = sc.pideTexto("Introduce descripción: ");
                servicio = buscarServicio(descripcion);
                if (servicio != null) {
                    catalogoServicios.remove(vehiculo);
                    trabajosRealizados.put(vehiculo, servicio);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                    String fecha_formateada = LocalDateTime.now().format(formatter);
                    System.out.printf("Fecha de registro: %s del vehículo: %s", fecha_formateada, vehiculo.getMatricula());
                } else {
                    System.out.println("No hay ningún vehiculo con esa descripcion.");
                }
            }
        } else {
            System.out.println("No existe ningún vehículo con esa matrícula.");
        }

    }

    /**
     * Muestra las opciones disponibles y ejecuta la acción elegida por el usuario
     * El menú se repetirá hasta que el usuario introduzca una una opción correcta
     */
    public boolean mostrarVehiculos() {
        if (!vehiculos.isEmpty()) {
            for (Vehiculo vehiculo : vehiculos) {
                System.out.println(vehiculo);
            }
            boolean correcto;
            do {
                char opcion = sc.pedirLetra("¿Quiere filtrar por tipo de vehículo? (S/N)");
                switch (opcion) {
                    case 's':
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
            System.out.println("No hay disponibles en la lista.");
            return false;
        }
    }

    /**
     * Muestra los trabajos
     */
    public void mostrarTrabajos() {
        for (Vehiculo user : trabajosRealizados.keySet()) {
            System.out.printf("Trabajos: Vehículos: %s, Matrícula: %s", user.getMatricula(), trabajosRealizados.get(user));
        }
    }

    /**
     * Filtra los tipos de vehículos
     */
    public void filtroTipoVehiculo() {
        TipoVehiculo tipoVehiculo = null;
        boolean correcto;
        do {
            correcto = true;
            int opcion_tipo_vehiculo = sc.pedirNumero("1. Turismo" +
                    "\n2. Motocicleta" +
                    "\n3. Furgoneta" +
                    "\n4. Camión" +
                    "\nIntroduce la opción del tipo de vehiculo: ");

            switch (opcion_tipo_vehiculo) {
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
                    System.out.println("Opción no válida.");
                    correcto = false;
                    break;
            }

        } while (!correcto);
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println("Opción no válida.");
            if (tipoVehiculo == vehiculo.getTipoVehiculo()) {
                System.out.println(vehiculo);
            }

        }
    }

    /**
     * Busca vehículos por matrícula y compara
     */
    public Vehiculo buscarVehiculo(String matricula) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMatricula().equals(matricula)) {
                return vehiculo;
            }
        }
        throw new VehiculoNoEncontrado("Vehículo no encontrado");
    }

    /**
     * Busca servicios y compara
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

