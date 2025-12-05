package proyecto_02.clases;

import proyecto_02.enums.TipoServicio;
import proyecto_02.enums.TipoVehiculo;
import proyecto_02.exception.VehiculoNoEncontrado;
import recursos.MyScanner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Clase Taller para gestionar Vehiculo y Servicio
 * @author - Alvaro Cotumba
 * @version 1.0
 */
public class Taller {
    private static final MyScanner sc = new MyScanner();

    private ArrayList<Vehiculo> vehiculos;
    private Map<Vehiculo, Servicio> trabajosRealizados;
    private ArrayList<Servicio> catalogoServicios;
    private Vehiculo[] Vehiculos;

    /**
     * Constructor principal de la clase Taller
     * Inicializa las colecciones para vehiculos, trabajos realizados y el catalogo de servicios
     */
    public Taller() {
    vehiculos = new ArrayList<Vehiculo>();
    trabajosRealizados = new LinkedHashMap<Vehiculo, Servicio>();
    catalogoServicios = new ArrayList<>();
    }

    /**
     *Getter del atributo Vehiculos
     * @return la lista de vehiculos disponibles
     */
    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    /**
     * Setter del atributo vehiculos
     * @param vehiculos establece la lista de vehiculos disponibles
     */
    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
    /**
     * Getter del atributo TrabajosRealizados
     * @return el mapa de TrabajosRealizados (Vehiculo -> Servicio)
     */
    public Map<Vehiculo, Servicio> getTrabajosRealizados() {
        return trabajosRealizados;
    }
    /**
     * Setter del atributo TrabajosRealizados
     * @param trabajosRealizados establece el mapa de trabajosRealizados
     */
    public void setTrabajosRealizados(Map<Vehiculo, Servicio> trabajosRealizados) {
        this.trabajosRealizados = trabajosRealizados;
    }
    /**
     * Getter del atributo CatalogoServicios
     * @return la lista de catalogoServicios
     */
    public ArrayList<Servicio> getCatalogoServicios() {
        return catalogoServicios;
    }

    /**
     * Setter del atributo CatalogoServicios
     * @param catalogoServicios establece la lista de catalogoServicios
     */

    public void setCatalogoServicios(ArrayList<Servicio> catalogoServicios) {
        this.catalogoServicios = catalogoServicios;
    }
    /**
     * Metodo para registrar un nuevo vehiculo en el taller
     * Solicita la  matricula pero falta por solicitar más cosas no puestas por temas de tiempo y lo añade a la lista de vehiculos
     */
    public void registrarVehiculo() {
    Vehiculo vehiculo = new Vehiculo();
    vehiculo.setMatricula(sc.pideTexto("Introduce la matricula"));
        String matricula;
        do{
            matricula = sc.pideTexto("Introduce la matricula: ");
            String mensaje = matricula.length() == 7 ? "Matricula correcta" : "La matricula tiene que tener exactamente 7 caracteres";
            System.out.println(mensaje);
        }while (matricula.length() != 7);
        vehiculo.setMatricula(matricula);

        vehiculos.add((Vehiculo)vehiculo);


    }
    /**
     * Metodo para registrar un nuevo servicio en el taller
     * Solicita  matricula, descripcion y mecanico, y añade el servicio a la lista de vehiculos
     */
    public void registrarServicio(){
        String matricula = sc.pideTexto("Introduce la matricula: ");
        String descripcion = sc.pideTexto("Introduce la descripcion del coche: ");
        String mecanico = sc.pideTexto("Introduce al mecanico del coche: ");
        TipoServicio tipoServicio = null;
        boolean correcto;
        do {
            correcto = true;
            int opcion_tipoServicio = sc.pedirNumero("1. MANTENIMIENTO" +
                    "\n2. CAMBIO_ACEITE" +
                    "\n3. PINTURA" +
                    "\n4. FRENOS" +
                    "\n5. ELECTRICIDAD" +
                    "\nIntroduce la opcion del servicio: ");
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
                    tipoServicio = TipoServicio.FRENOS;
                    break;
                case 5:
                    tipoServicio = TipoServicio.ELECTRICIDAD;
                    break;
                default:
                    correcto = false;
                    System.out.println("Opcion no valida!");
                    break;
            }
        } while (!correcto);
        catalogoServicios.add(new Vehiculo(matricula,tipoServicio));
    }
    /**
     * Metodo para asignar un servicio un libro a un vehiculo
     * Solicita matricula del vehiculo y pero falta por solicitar más cosas no puestas por temas de tiempo y realiza el servicio si ambos existen
     * Muestra los vehiculos disponibles antes de solicitar la matricula
     * @return mensaje indicado si el servicio fue exitoso o hubo error
     */
    public String asignarServicio(){

    String matricula =sc.pideTexto("Introduce la matricula: ");
    Servicio vehiculo;
    Servicio servicio = null;
        try {
            vehiculo = buscarVehiculo(matricula);

        } catch (VehiculoNoEncontrado e) {
            System.out.println(e.getMessage());
            vehiculo = null;
        }
        if (vehiculo != null) {
            if (mostrarVehiculos()) {
                matricula = sc.pideTexto("Introduce la matricula del vehiculo: ");
                vehiculo = buscarServicio(matricula);
                if (servicio != null) {
                    vehiculos.remove(servicio);
                    trabajosRealizados.put((Vehiculo) vehiculo, servicio);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                    String fecha_formateada = LocalDateTime.now().format(formatter);
                    System.out.printf("Fecha de trabajo realizado: %s del vehiculo: %s", fecha_formateada, servicio.getMecanico());
                } else {
                    System.out.println("No hay ningun servicio con esa matricula disponible!");
                }
            }
        } else {
            System.out.println("No existe el vehiculo con esa matricula!");
        }
        return (vehiculo != null && servicio != null) ? "Servicio prestado correctamente" : "Error en el proceso.";
    }
    /**
     * Metodo para mostrar todos los vehiculos disponibles
     * Ofrece la opcion de filtrar por tipo de vehiculo
     * @return true si hay vehiculos disponibles y se muestran, false si no hay vehiculos disponibles
     */
    public boolean mostrarVehiculos() {
        if (!vehiculos.isEmpty()) {
            for (Vehiculo servicio : vehiculos) {
                System.out.println(servicio);
            }
            boolean correcto;
            do {
                char opcion = sc.pedirLetra("¿Quiere mostrar los vehiculos? (S/N)");
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
            System.out.println("No hay vehiculos disponibles");
            return false;
        }
    }
    /**
     * Metodo para filtrar y mostrar vehiculos por tipo de vehiculo
     * Solicita al usuario que seleccione un tipo y muestra los vehiculos correspondientes
     */
    public void filtroTipoVehiculo() {
        TipoVehiculo tipoVehiculo = null;
        boolean correcto;
        do {
            correcto = true;
            int opcion_tipoVehiculo = sc.pedirNumero("1. MANTENIMIENTO" +
                    "\n2. CAMBIO_ACEITE" +
                    "\n3. PINTURA" +
                    "\n4. FRENOS" +
                    "\n5. ELECTRICIDAD" +
                    "\nIntroduce la opcion del servicio: ");
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
                    System.out.println("Opcion no valida!");
                    break;
            }
        } while (!correcto);
        for (Vehiculo vehiculo  : Vehiculos) {
            if (tipoVehiculo == vehiculo.geTipoVehiculo()) {
                System.out.println(vehiculo);
            }
        }
    }
    /**
     * Metodo para mostrar todos los trabajos realizados
     * Muestra el nombre del servicio y el vehiculo puesto en servicio para cada servicio
     */
public void mostrarTrabajos() {
    for (Vehiculo vehiculo: trabajosRealizados.keySet()) {
        System.out.printf("Trabajos realizados: Vehiculo: %s, Servicio: %s", vehiculo.getMatricula(), trabajosRealizados.get(vehiculo));
    }
}
    /**
     * Metodo para buscar un usuario por matricula
     * @param matricula matricula del vehiculo a buscar
     * @return el vehiculo encontrado
     * @throws VehiculoNoEncontrado si no se encuentra ningun vehiculo con esa matricula
     */
    public Vehiculo buscarVehiculo(String matricula) throws VehiculoNoEncontrado {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMatricula().equals(vehiculo.getMatricula())) {
                return vehiculo;
            }
        }
        throw new VehiculoNoEncontrado("Vehiculo no encontrado");
    }

    /**
     * Metodo para buscar un vehiculo por matricula
     * @param matricula matricula del vehiculo a buscar
     * @return el vehiculo encontrado o null si no existe
     */
    public Servicio buscarServicio(String matricula) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMatricula().equals(matricula)) {
//                return matricula; no se , lo quite y ya no tengo el unico error que me ponia
            }
        }
        return null;
    }
}
