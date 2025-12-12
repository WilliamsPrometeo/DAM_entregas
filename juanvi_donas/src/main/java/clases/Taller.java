package clases;

import proyecto02.clases.enums.TipoServicio;
import proyecto02.clases.enums.TipoVehiculo;
import proyecto02.clases.exception.VehiculoNoEncontrado;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Aquí empiezo a estructurar la clase Taller
 * Es la clase más importante y donde he metido todos los metodos y las especificaciones.
 */

public class Taller {
    private static final MyScanner sc = new MyScanner();

    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Servicio> catalogoServicios;
    private Map<Vehiculo, Servicio> trabajosRealizados;

    /**
     * Creo la clase Taller en la que añado los ArrayList y el Map.
     * Seguidamente creo todos los métodos y les doy su funcionalidad.
     */

    public Taller() {
        vehiculos = new ArrayList<>();
        catalogoServicios = new ArrayList<>();
        trabajosRealizados = new LinkedHashMap<>();
    }

    public ArrayList<Vehiculo> registrarVehiculo() {
        return vehiculos;
    }

    public ArrayList<Servicio> registrarServicio() {
        this.catalogoServicios = catalogoServicios;
        return null;
    }

    public String asignarServicio(Servicio servicio) {
        this.catalogoServicios.add(servicio);
        return null;
    }

    public boolean mostrarVehiculos() {
        this.vehiculos = vehiculos;
        return false;
    }

    public void mostrarTrabajos() {
        this.trabajosRealizados = trabajosRealizados;
        String descripcion = null;
        String matricula = null;
        System.out.printf("Trabajos realizados: \n" +
                "Servicios: %s \n" +
                "Vehiculos: %s \n", buscarServicio(descripcion), buscarVehiculo(matricula)) ;

    }

    public ArrayList<Vehiculo> buscarVehiculo() {
        return vehiculos;
    }

    public ArrayList<Servicio> buscarServicio() {
        return catalogoServicios;
    }

    /**
     * Hago que pida al usuario una matrícula para que añada el coche al Taller.
     * @param vehiculo
     */

    public String registrarVehiculo(Vehiculo vehiculo) {
        Vehiculo vehiculonuevo = new Vehiculo();
        vehiculo.setMatricula(sc.pideTexto("Introduce la matrícula del coche: "));
        String matricula = sc.pideTexto(vehiculo.getMatricula());
        do {
            matricula = sc.pideTexto("Introduce la matrícula del coche: ");
            String mensaje = matricula.length() == 7 ? "Matrícula correcta" : "La matrícula tiene que tener exactamente 7 caracteres";
            System.out.println(mensaje);
        } while (matricula.length() != 7);
        vehiculo.setMatricula(matricula);
        return vehiculo.getMatricula();
    }

    /**
     * Aquí le hago que elija el tipo de servicio que quiere mediante el Enum TipoServicio y depende de lo que elija el usuario entra en el switch.
     * @param servicio
     */

    public void registrarServicio(Servicio servicio) {
        Servicio servicionuevo = new Servicio();
        String descripcion = sc.pideTexto("Introduce la descripción del servicio: ");
        String mecanico = sc.pideTexto("Introduce el nombre del mecánico: ");
        TipoServicio tipo = null;
        boolean correcto;
        do {
            correcto = true;
            int opcion_tipo = sc.pedirNumero("1. MANTENIMIENTO" +
                    "\n2. CAMBIO DE ACEITE" +
                    "\n3. PINTURA" +
                    "\n4. FRENOS" +
                    "\n5. ELECTRICIDAD" +
                    "\nIntroduce el tipo de servicio: ");
            switch (opcion_tipo) {
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
                    break;
                default:
                    correcto = false;
                    System.out.println("Opcion no valida!");
                    break;
            }
        } while (!correcto);
        Servicio.add(new Servicio(descripcion, mecanico, tipo));
    }

    /**
     * Aquí le asigna el servicio elegido antes al vehículo que quieras, poniendo la matrícula del vehículo.
     * Si el vehículo no exite te suelta la exception que he creado "VehiculoNoEncontrado".
     * @return
     */

    public String asignarServicio() {
        String matricula = sc.pideTexto("Introduce la matrícula del coche: ");
        String vehiculo;

        try {
            vehiculo = String.valueOf(registrarVehiculo());

        } catch (VehiculoNoEncontrado e) {
            System.out.println(e.getMessage());
            vehiculo = null;
        }
        if (vehiculo != null) {
            if (mostrarVehiculos()) {
                String descripcion = sc.pideTexto("Introduce la descripción del servicio: ");
                vehiculo = String.valueOf(buscarVehiculo(matricula));
                if (vehiculo != null) {
                    vehiculos.remove(vehiculo);
                    Vehiculo.put(vehiculo, catalogoServicios);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                    String fecha_formateada = LocalDateTime.now().format(formatter);
                    System.out.printf("Fecha de servicio: %s del vehículo: %s", fecha_formateada, vehiculo);
                } else {
                    System.out.println("No hay ningun servicio con esa descripción!");
                }
            }
        } else {
            System.out.println("No existe un coche con esa matricula!");
        }
        return (vehiculo != null && catalogoServicios != null) ? "Servicio dado al vehículo correctamente" : "Error en el proceso.";
    }

    /**
     * Creo el método mostrarVehículo con un booleano y le digo que si vehículos está vacío y si lo está le muestro que no hay servicios de ningún vehículo y si no entra en el do while y empieza el bucle.
     * @return
     */

    public boolean mostrarVehiculo() {
        if (!vehiculos.isEmpty()) {
            for (Vehiculo vehiculo : vehiculos) {
                System.out.println(vehiculo);
            }
            boolean correcto;
            do {
                char opcion = sc.pedirLetra("¿Quiere filtrar por Tipo? (S/N)");
                switch (opcion) {
                    case 'S':
                    case 's':
                        filtroTipo();
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
            System.out.println("No hay servicios disponibles");
            return false;
        }
    }

    /**
     * Aquí he creado el filtroTipo para que pueda filtrar por el tipo de vehículo a través del enum TipoVehiculo.
     */

    public void filtroTipo() {
        TipoVehiculo tipoVehiculo = null;
        boolean correcto;
        do {
            correcto = true;
            int opcion_tipo = sc.pedirNumero("1. TURISMO" +
                    "\n2. MOTOCICLETA" +
                    "\n3. FURGONETA" +
                    "\n4. CAMIÓN" +
                    "\nIntroduce la opcion del tipo: ");
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
                    System.out.println("Opcion no valida!");
                    break;
            }
        } while (!correcto);
        for (Vehiculo vehiculo : vehiculos) {
            if (tipoVehiculo == Vehiculo.getTipo) {
                System.out.println(vehiculo);
            }
        }
    }

    /**
     * Muestro el vehículo que quiere buscar el usuario a través de la matrícula que ponga y si no concuerda con ningún vehículo, suelto la exception.
     * @param matricula
     * @return
     * @throws VehiculoNoEncontrado
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
     * Básicamente lo mismo que en el anterior método pero est vez no le suelto la excepiton, simplemente busca el servicio a través de la descripción
     * @param descripcion
     * @return
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