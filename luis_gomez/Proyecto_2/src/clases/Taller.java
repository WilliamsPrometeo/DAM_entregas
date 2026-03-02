package clases;

import enums.TipoServicio;
import enums.TipoVehiculo;
import exceptions.VehiculoNoEncontrado;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase Taller
 *
 * @author Alumno - Luis
 * @version 1.0
 */
public class Taller {

    private final MyScanner sc = new MyScanner();

    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Servicio> catalogoServicios;
    private Map<Vehiculo, Servicio> trabajosRealizados;

    /**
     * Constructor principal de la clase Taller
     * Inicializamos los arraylist vehiculos y catalogoServicios juntos con el Map trabajosRealizados
     */
    public Taller() {
        vehiculos = new ArrayList<>();
        catalogoServicios = new ArrayList<>();
        trabajosRealizados = new HashMap<>();
    }

    /**
     * Metodo registrarVehiculo
     * Recoge por consola la matricula, modelo y tipo de un vehiculo y lo añade al arraylist de vehiculos
     */
    public void registrarVehiculo() {
        String matricula;
        boolean repetida;
        do {
            repetida = false;
            matricula = sc.pideTexto("Introduzca la matricula del vehiculo: ");
            String mensaje = matricula.length() == 7 ? "Matricula correcta" : "Error: la matricula tiene que tener exactamente 7 caracteres";
            System.out.println(mensaje);
            for (Vehiculo vehiculo : vehiculos) {
                if (vehiculo.getMatricula().equals(matricula)) {
                    repetida = true;
                    System.out.println("Error: la matricula ya existe");
                    break;
                }
            }
        } while (matricula.length() != 7 || repetida);
        String modelo = sc.pedirSoloTexto("Introduzca el modelo del vehiculo");
        TipoVehiculo tipo = null;
        boolean valido;
        do {
            valido = true;
            System.out.println("Introduzca el tipo de vehiculo:");
            int opcion = sc.pedirNumero("1. Turismo\n2. Motocicleta\n3. Furgoneta\n4. Camion\nOpcion: ");
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
                    System.out.println("Error: opcion no valida");
                    valido = false;
                    break;
            }
        } while (!valido);
        Vehiculo nuevoVehiculo = new Vehiculo(matricula, modelo, tipo);
        vehiculos.add(nuevoVehiculo);
    }

    /**
     * Merodo registrarServicio
     * Recoge por consola descripcion, nombre y tipo de un servicio y lo añade al arraylist de catalogoServicios
     */
    public void registrarServicio() {
        String descripcion = sc.pedirSoloTexto("Introduzca la descripcion del servicio");
        String mecanico = sc.pedirSoloTexto("Introduzca el nombre del mecanico");
        TipoServicio tipo = null;
        boolean valido;
        do {
            valido = true;
            System.out.println("Introduzca el tipo de servicio:");
            int opcion = sc.pedirNumero("1. Mantnimiento\n2. Cambio de aceite\n3. Pintura\n4. Frenos\n5. Electricidad\nOpcion: ");
            switch (opcion) {
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
                    System.out.println("Error: opcion no valida");
                    valido = false;
                    break;
            }
        } while (!valido);
        Servicio nuevoServicio = new Servicio(descripcion, mecanico, tipo);
        catalogoServicios.add(nuevoServicio);
    }

    /**
     * Metodo asignarServicio
     * Asigna un vehiculo a un servicio que el usuario introduce por consola
     * Si el arraylist de vehiculo o catalogoServicios esta vacio sale directamente de la funcion
     * Si no encuentra el vehiculo o el servicio introducido sale de la funcion
     *
     */
    public void asignarServicio() {
        if (vehiculos.isEmpty() || catalogoServicios.isEmpty()) {
            System.out.println("Error: actualmente no existen servicios o vehiculos suficientes para poder ser asignados");
            return;
        }
        String matricula = sc.pideTexto("Introduzca la matricula del vehiculo");
        Vehiculo vehiculo;
        try {
            vehiculo = buscarVehiculo(matricula);
        } catch (VehiculoNoEncontrado e) {
            System.out.println(e.getMessage());
            System.out.println("Devolviendo a la pagina principal ...");
            return;
        }
        String descripcion = sc.pedirSoloTexto("Introduzca el nombre del servicio");
        Servicio servicio = buscarServicio(descripcion);
        String mensaje = (servicio != null) ? "Servicio asignado" : "No existe el servicio";
        System.out.println(mensaje);
        if (servicio != null) {
            trabajosRealizados.put(vehiculo, servicio);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String fecha_formateada = LocalDateTime.now().format(dtf);
            System.out.printf("Fecha de asignacion de servivio %s del vehiculo: %s%n", fecha_formateada, vehiculo.getMatricula());
        }
    }

    /**
     * Metodo mostrarVehiculos
     * Muestra los vehiculos guardados en el arraylist vehiculos y pregunta si el usuario quiere filtrar por tipo de vehiculo
     * Si no hay vehiculos en el arraylist saca un mensaje de que no hay vehiculos y termina la funcion
     */
    public void mostrarVehiculos() {
        if (!vehiculos.isEmpty()) {
            for (Vehiculo vehiculo : vehiculos) {
                System.out.println(vehiculo);
            }
            boolean correcto;
            do {
                correcto = true;
                char opcion = sc.pedirLetra("Le gustaria filtrar por tipo de vehiculo (S/N): ");
                switch (opcion) {
                    case 'S':
                        filtrarPorTipoVehiculo();
                        break;
                    case 'N':
                        break;
                    default:
                        System.out.println("Error: opcion no valida");
                        correcto = false;
                        break;
                }
            } while (!correcto);
        } else {
            System.out.println("Error: no existen vehiculos registrados actualmente");
        }
    }

    /**
     * Metodo mostrarTrabajos
     * Muestra los trabajos guardados en el mapa trabajosRealizados
     * Si no habia guardados trabajosRealizados muestra un mensaje por pantalla y termina la funcion
     */
    public void mostrarTrabajos() {
        if (!trabajosRealizados.isEmpty()) {
            System.out.println("Servicios realizados:");
            for (Vehiculo vehiculo : trabajosRealizados.keySet()) {
                System.out.printf("[%s, %s]%n", vehiculo, trabajosRealizados.get(vehiculo));
            }
        } else {
            System.out.println("Error: no existen trabajos registrados actualmente");
        }
    }

    /**
     * Metodo buscarVehiculo
     *
     * @param matricula la matricula del vehiculo que vamos a buscar en el arraylist de vehiculos
     * @return el vehiculo con la matricula introducida
     * @throws VehiculoNoEncontrado si no encuentra un vehiculo con la matricula pasada
     */
    public Vehiculo buscarVehiculo(String matricula) throws VehiculoNoEncontrado {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMatricula().equals(matricula)) {
                return vehiculo;
            }
        }
        throw new VehiculoNoEncontrado("Error: vehiculo no encontrado");
    }

    /**
     * Metodo buscar servicio
     *
     * @param descripcion la descripcion del servicio que se busca en el arraylist de catalogoServicios
     * @return El servicio encontrado o null si no encuentra nignun servicio coincidente
     */
    public Servicio buscarServicio(String descripcion) {
        for (Servicio servicio : catalogoServicios) {
            if (servicio.getDescripcion().equals(descripcion)) {
                return servicio;
            }
        }
        return null;
    }

    /**
     * Metodo filtrarPorTipoVehiculo
     * Filtra los vehiculos en funcion de su tipo
     */
    public void filtrarPorTipoVehiculo() {
        TipoVehiculo tipo = null;
        boolean valido;
        do {
            valido = true;
            System.out.println("Introduzca por que tipo lo quiere filtrar:");
            int opcion = sc.pedirNumero("1. Turismo\n2. Motocicleta\n3. Furgoneta\n4. Camion\nOpcion: ");
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
                    System.out.println("Error: opcion no valida");
                    valido = false;
                    break;
            }
        } while (!valido);
        int contador = 0;
        for (Vehiculo vehiculo : vehiculos) {
            if (tipo == vehiculo.getTipo()) {
                System.out.println(vehiculo);
                contador++;
            }
        }
        if (contador == 0) {
            System.out.println("Error: no existen vehiculos de ese tipo registrados actualmente");
        }
    }
}
