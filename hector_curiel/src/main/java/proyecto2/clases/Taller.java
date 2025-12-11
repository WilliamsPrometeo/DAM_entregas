package proyecto2.clases;

import enums.TipoServicio;
import enums.TipoVehiculo;
import exeptions.VehiculoNoEncontrado;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Clase principal que gestiona vehículos, servicios y trabajos.
 * @autor Hector Curiel Hérnandez
 */
public class Taller {

    private static final MyScanner sc = new MyScanner();

    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Servicio> catalogoServicios;
    private Map<Vehiculo, Servicio> trabajosRealizados;

    public Taller() {
        vehiculos = new ArrayList<>();
        catalogoServicios = new ArrayList<>();
        trabajosRealizados = new LinkedHashMap<>();
    }

    /**
     * Pide la matricula y evalua si no no tiene los 7 caracteres bien   con el metodo "registrar vehiculo"
     * @Param matricula
     * @return error
     */

    public void registrarVehiculo() {
        String matricula;
        do {
            matricula = sc.pideTexto("Introduce matrícula (7 caracteres alfanuméricos): ").toUpperCase();
            if (!matricula.matches("[A-Z0-9]{7}")) {
                System.out.println("Error: matrícula inválida.");
                matricula = "";
            }
        } while (matricula.isEmpty());

        String modelo = sc.pideTexto("Introduce el modelo: ");
        /**
         *Pide el tipo de vehiculo y registra el vehiculo.add
         * @see Tipo
         */

        TipoVehiculo tipo = null;
        boolean correcto;
        do {
            correcto = true;
            int opc = sc.pedirNumero("""
                    Selecciona tipo:
                    1. TURISMO
                    2. MOTOCICLETA
                    3. FURGONETA
                    4. CAMION
                    Opción: """);

            switch (opc) {
                case 1 -> tipo = TipoVehiculo.TURISMO;
                case 2 -> tipo = TipoVehiculo.MOTOCICLETA;
                case 3 -> tipo = TipoVehiculo.FURGONETA;
                case 4 -> tipo = TipoVehiculo.CAMION;
                default -> {
                    System.out.println("Opción inválida");
                    correcto = false;
                }
            }
        } while (!correcto);

        vehiculos.add(new Vehiculo(matricula, modelo, tipo));
        System.out.println("Vehículo registrado.\n");
    }

    /**
     *Pide al usuario que comente la descipcion con "registrarServicio"
     * @Param descripcion
     * @Param mecanico
     */

    public void registrarServicio() {
        String descripcion = sc.pideTexto("Introduce la descripción: ");
        String mecanico = sc.pedirSoloTexto("Introduce el nombre del mecánico: ");

        TipoServicio tipo = null;
        boolean correcto;
        do {
            correcto = true;
            int opc = sc.pedirNumero(""" 
                    Selecciona servicio:
                    1. MANTENIMIENTO
                    2. CAMBIO_ACEITE
                    3. PINTURA
                    4. FRENOS
                    5. ELECTRICIDAD
                    Opción: """);

            switch (opc) {
                case 1 -> tipo = TipoServicio.MANTENIMIENTO;
                case 2 -> tipo = TipoServicio.CAMBIO_ACEITE;
                case 3 -> tipo = TipoServicio.PINTURA;
                case 4 -> tipo = TipoServicio.FRENOS;
                case 5 -> tipo = TipoServicio.ELECTRICIDAD;
                default -> {
                    correcto = false;
                    System.out.println("Opción inválida");
                }
            }
        } while (!correcto);

        catalogoServicios.add(new Servicio(descripcion, mecanico, tipo));
        System.out.println("Servicio registrado.\n");
    }

    /**
     * @throws  VehiculoNoEncontrado
     * @exception null
     */


    public void asignarServicio() throws VehiculoNoEncontrado {
        String matricula = sc.pideTexto("Introduce la matrícula del vehículo: ").toUpperCase();
        Vehiculo v = buscarVehiculo(matricula);

        String descripcion = sc.pideTexto("Introduce descripción del servicio: ");
        Servicio s = buscarServicio(descripcion);

        String mensaje = (s != null)
                ? "Servicio encontrado y asignado."
                : "Servicio no encontrado.";
        System.out.println(mensaje);

        if (s != null) {
            trabajosRealizados.put(v, s);

            DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String fecha = LocalDateTime.now().format(f);

            System.out.printf("Trabajo realizado el %s — Vehículo %s — Servicio: %s%n", fecha, v.getMatricula(), s.getDescripcion());
        }
    }

    /**
     * Opcion para mostrar vehiculo "mostrarVehículo"
     *
     */

    public void mostrarVehiculos() {
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehículos.\n");
            return;
        }

        vehiculos.forEach(System.out::println);

        boolean correcto;
        do {
            char opcion = sc.pedirLetra("¿Filtrar por tipo? (S/N): ");
            switch (opcion) {
                case 'S', 's': {
                    Tipo();
                    correcto = true;
                }
                case 'N', 'n':
                    correcto = true;
                default:
                    correcto = false;
            }
        } while (!correcto);
    }


    private void Tipo() {
        TipoVehiculo tipo = null;
        boolean ok;

        do {
            ok = true;
            int op = sc.pedirNumero("""
                    Tipo:
                    1. TURISMO
                    2. MOTOCICLETA
                    3. FURGONETA
                    4. CAMION
                    Opción: """);

            switch (op) {
                case 1 -> tipo = TipoVehiculo.TURISMO;
                case 2 -> tipo = TipoVehiculo.MOTOCICLETA;
                case 3 -> tipo = TipoVehiculo.FURGONETA;
                case 4 -> tipo = TipoVehiculo.CAMION;
                default -> {
                    ok = false;
                    System.out.println("Opción inválida");
                }
            }
        } while (!ok);

        for (Vehiculo v : vehiculos) {
            if (v.getTipo() == tipo) {
                System.out.println(v);
            }
        }
    }

    /**
     * Muestra trabajos con "mostrarTrabajos"
     *
     */

    public void mostrarTrabajos() {
        if (trabajosRealizados.isEmpty()) {
            System.out.println("No hay trabajos.\n");
            return;
        }

        System.out.println("--- Trabajos Realizados ---");

        for (Map.Entry<Vehiculo, Servicio> e : trabajosRealizados.entrySet()) {
            Vehiculo v = e.getKey();
            Servicio s = e.getValue();

            System.out.printf("Vehículo: %s | Matrícula: %s | Servicio: %s | Mecánico: %s%n",
                    v.getModelo(), v.getMatricula(), s.getDescripcion(), s.getMecanico());
        }
    }

    /**
     *
     * @param matricula
     * @return vehiculo
     * @throws VehiculoNoEncontrado
     */


    public Vehiculo buscarVehiculo(String matricula) throws VehiculoNoEncontrado {
        for (Vehiculo v : vehiculos) {
            if (v.getMatricula().equalsIgnoreCase(matricula)) {
                return v;
            }
        }
        throw new VehiculoNoEncontrado("Vehículo NO encontrado: " + matricula);
    }

    /**
     *
     * @param descripcion
     * @return servicio
     */


    public Servicio buscarServicio(String descripcion) {
        for (Servicio s : catalogoServicios) {
            if (s.getDescripcion().equalsIgnoreCase(descripcion)) {
                return s;
            }
        }
        return null;
    }
}

