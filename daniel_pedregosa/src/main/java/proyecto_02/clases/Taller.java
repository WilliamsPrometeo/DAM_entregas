package proyecto_02.clases;

import Proyecto_01.Scanner.MyScanner;
import proyecto_02.enums.TipoServicio;
import proyecto_02.enums.TipoVehiculo;
import proyecto_02.exceptions.VehiculoNoEncontrado;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * clase nucleo del proyecto
 * @author A4Alumno05 - Pedregosa
 * @version 1.0
 */
public class Taller {
    private static final MyScanner sc = new MyScanner();

    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Servicio> servicios;
    private Map<Vehiculo, Servicio> trabajosRealizados;

    /**
     * constructor principal del Taller
     */
    public Taller() {
        vehiculos = new ArrayList<>();
        servicios = new ArrayList<>();
        trabajosRealizados = new LinkedHashMap<>();
    }

    /**
     * getter del ArrayList Vehiculos
     * @return Vehiculos
     */
    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    /**
     * setter del ArrayList Vehiculos
     * @param vehiculos establece el ArrayList
     */
    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    /**
     * getter del ArrayList Servicios
     * @return Servicios
     */
    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    /**
     * setter del ArrayList Servicios
     * @param servicios esteblece el ArrayList
     */
    public void setServicios(ArrayList<Servicio> servicios) {
        this.servicios = servicios;
    }

    /**
     * getter del ArrayList TrabajosRealizados
     * @return TrabajosRealidos
     */
    public Map<Vehiculo, Servicio> getTrabajosRealizados() {
        return trabajosRealizados;
    }

    /**
     * setter del ArrayList TrabajosRealizados
     * @param trabajosRealizados establece los TrabajosRealizados
     */
    public void setTrabajosRealizados(Map<Vehiculo, Servicio> trabajosRealizados) {
        this.trabajosRealizados = trabajosRealizados;
    }

    /**
     * Metodo para registrar Vehiculos
     */
    public void registrarVehiculo() {
        String matricula;

        do {
            matricula = sc.pideTexto("la matricula del coche, cual es?: ");
            String mensaje = matricula.length() == 7 ? "Me lo apunto" : "La matrícula debe tener 7 caracteres";
            System.out.println(mensaje);
        } while (matricula.length() != 7);

        String modelo = sc.pideTexto("y que modelo es?: ");

        TipoVehiculo tipo = null;
        boolean correcto;

        do {
            correcto = true;
            int opc_tipo = sc.pedirNumero("1. Turismo" +
                    "\n2. Motocicleta" +
                    "\n3. Furgoneta" +
                    "\n4. Camion" +
                    "\n5. todoterreno" +
                    "\n6. Caravana" +
                    "\n7. Carrito de Bebe" +
                    "\n8. Bici" +
                    "\n9. Chino Tirando de un Carro (CTC)" +
                    "\nElige: ");
            switch (opc_tipo) {
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
                case 5:
                    tipo = TipoVehiculo.TODOTERRENO;
                    break;
                case 6:
                    tipo = TipoVehiculo.CARAVANA;
                    break;
                case 7:
                    tipo = TipoVehiculo.CARRITO_DE_BEBE;
                    break;
                case 8:
                    tipo = TipoVehiculo.BICI;
                    break;
                case 9:
                    tipo = TipoVehiculo.CHINO_TIRANDO_DE_UN_CARRO;
                    break;
                default:
                    correcto = false;
                    System.out.println("Si tuvieses alguna neurona mas, a lo mejor te acercarias al nivel de las piedras; \nOpción no valida");
                    break;
            }
        } while (!correcto);

        // Crear el vehículo con el constructor (sin usar setMatricula estático)
        vehiculos.add(new Vehiculo(matricula, modelo, tipo));
    }

    /**
     * metodo para registrar servicios a su respectivo vehiculo
     */
    public void registrarServicio() {
        String descripcion = sc.pideTexto("Cual es el servicio a registrar?: ");
        String mecanico = sc.pideTexto("de los mecanicos, cual te hara el trabajito?: ");
        TipoServicio tipo = null;
        boolean correcto;

        do {
            correcto = true;
            int opc_servicio = sc.pedirNumero("1. Mantenimiento" +
                    "\n2. Cambio de Aceite" +
                    "\n3. Pintura" +
                    "\n4. Frenos" +
                    "\n5. Electricidad" +
                    "\nElige: ");
            switch (opc_servicio) {
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
                    System.out.println("Si buscabas una opcion de final feliz, no la hay, lo siento; \nPrueba otra vez");
                    break;
            }
        } while (!correcto);
        Servicio servicio = new Servicio(descripcion, mecanico, tipo);
        this.servicios.add(servicio);
    }

    /**
     * metodo para asignar servicios, junto con la exception en caso de que no haya vehiculos, lanzando la exception personalizada si no se detectan vehiculos
     */
    public void asignarServicios() {
        try {
            String matricula = sc.pideTexto("Cual es la matricula del vehiculo afortunado que va a recibir el tratamiento?: ");
            Vehiculo vehiculo = buscarVehiculo(matricula);

            if (vehiculo != null) {
                System.out.println("\nServicios disponibles:");
                for (int i = 0; i < servicios.size(); i++) {
                    System.out.println((i + 1) + ". " + servicios.get(i).getDescripcion());
                }

                int opc_servicio = sc.pedirNumero("Selecciona el número del servicio: ");

                if (opc_servicio > 0 && opc_servicio <= servicios.size()) {
                    Servicio servicio = servicios.get(opc_servicio - 1);
                    trabajosRealizados.put(vehiculo, servicio);
                    System.out.println("Servicio asignado correctamente.");
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                    String fechaFormateada = LocalDateTime.now().format(formatter);
                    System.out.printf("Fecha de Servicio: %s al vehiculo: %s%n", fechaFormateada, vehiculo);
                } else {
                    throw new VehiculoNoEncontrado("Opción de servicio no válida.");
                }
            } else {
                throw new VehiculoNoEncontrado("Vehiculo no encontrado.");
            }
        } catch (VehiculoNoEncontrado e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Metodo para buscar los vehiculos y filtrarlos por su tipo
     * @return la lista de vehiculos
     */
    public boolean mostrarVehiculos() {

        if (!vehiculos.isEmpty()) {
            for (Vehiculo vehiculo : vehiculos) {
                System.out.println(vehiculo);
            }
            boolean correcto;

            do {
                char opcion = sc.pedirLetra("Le apeteceria al caballero filtrar los vehiculos segun su tipo? (S/N): ");
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
            System.out.println("Nos han robado los coches, si el tuyo estaba entre ellos, va a ser mejor que nos denuncies...");
            return false;
        }
    }

    /**
     * metodo de filtrado de vehiculos
     */
    public void filtroTipoVehiculo() {
        TipoVehiculo tipo = null;
        boolean correcto;
        do {
            correcto = true;
            int opc_tipo = sc.pedirNumero("1. Turismo" +
                    "\n2. Motocicleta" +
                    "\n3. Furgoneta" +
                    "\n4. Camion" +
                    "\n5. todoterreno" +
                    "\n6. Caravana" +
                    "\n7. Carrito de Bebe" +
                    "\n8. Bici" +
                    "\n9. Chino Tirando de un Carro (CTC)" +
                    "\nElige: ");
            switch (opc_tipo) {
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
                case 5:
                    tipo = TipoVehiculo.TODOTERRENO;
                    break;
                case 6:
                    tipo = TipoVehiculo.CARAVANA;
                    break;
                case 7:
                    tipo = TipoVehiculo.CARRITO_DE_BEBE;
                    break;
                case 8:
                    tipo = TipoVehiculo.BICI;
                    break;
                case 9:
                    tipo = TipoVehiculo.CHINO_TIRANDO_DE_UN_CARRO;
                    break;
                default:
                    correcto = false;
                    System.out.println("Si tuvieses alguna neurona mas, a lo mejor te acercarias al nivel de las piedras; \nOpción no valida");
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
     * metodo para mostrar los trabajos realizados
     */
    public void mostrarTrabajos() {
        if (!trabajosRealizados.isEmpty()) {
            for (Vehiculo vehiculo : trabajosRealizados.keySet()) {
                Servicio servicio = trabajosRealizados.get(vehiculo);
                System.out.printf("Trabajo Realizado: %nVehiculo: %s%nCon el Siguiente Servicio: %s%n%n", vehiculo, servicio);
            }
        } else {
            System.out.println("No hay trabajos realizados.");
        }
    }

    /**
     * metodo para buscar el vehiculo por su matricula
     * @param Matricula el valor pasado al metodo
     * @return el vehiculo buscado
     */
    public Vehiculo buscarVehiculo(String Matricula) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMatricula().equals(Matricula)) {
                return vehiculo;
            }
        }
        return null;
    }

    /**
     * metodo para buscar el servicio segun su descripcion
     * @param Descripcion parametro pasado para buscar
     * @return el servicio buscado
     */
    public Servicio buscarServicio(String Descripcion) {
        for (Servicio servicio : servicios) {
            if (servicio.getDescripcion().equals(Descripcion)) {
                return servicio;
            }
        }
        return null;
    }
}
