package taller_mecanico.clases;

import taller_mecanico.enums.TipoServicio;
import taller_mecanico.enums.TipoVehiculo;
import taller_mecanico.excepcion.VehiculoNoEncontrado;
import taller_mecanico.recursos.MyScanner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Clase Libreria
 *
 * @author Pablo Sanchez
 * @version 1.0
 */

public class Taller {

    private static final MyScanner sc = new MyScanner();

    private ArrayList<Vehiculo> vehiculos;
    private Map<Vehiculo, Servicio> trabajosRealizados;
    private ArrayList<Servicio> catalogoServicios;

    /**
     * Constructor vacio en el que se inicializan todas las colecciones
     */

    public Taller() {
        vehiculos = new ArrayList<>();
        trabajosRealizados = new LinkedHashMap<>();
        catalogoServicios = new ArrayList<>();
    }

    /**
     * Getter del atributo vehiculos
     *
     * @return libros disponibles
     */

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    /**
     * Setter del atribtuo vehiculos
     *
     * @param vehiculos que establece los vehiculos
     */

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    /**
     * Getter del atributo TrabajosRealizados
     *
     * @return libros disponibles
     */

    public Map<Vehiculo, Servicio> getTrabajosRealizados() {
        return trabajosRealizados;
    }

    /**
     * Setter del atribtuo catalogoServicios
     *
     * @param trabajosRealizados que establece los trabajos realizados
     */

    public void setTrabajosRealizados(Map<Vehiculo, Servicio> trabajosRealizados) {
        this.trabajosRealizados = trabajosRealizados;
    }

    /**
     * Getter del atributo CatalogoServicios
     *
     * @return libros disponibles
     */

    public ArrayList<Servicio> getCatalogoServicios() {
        return catalogoServicios;
    }

    /**
     * Setter del atribtuo catalogoServicios
     *
     * @param catalogoServicios que establece los servicios disponibles
     */

    public void setCatalogoServicios(ArrayList<Servicio> catalogoServicios) {
        this.catalogoServicios = catalogoServicios;
    }

    /**
     * Metodo registrarVehiculo
     *
     * @return crea un registro del vehiculo incluyendo el modelo y verificacion de matricula.
     */

    public void registrarVehiculo() {
        Vehiculo vehiculos = new Vehiculo();
        vehiculos.setModelo(sc.pedirSoloTexto("Introduce el modelo del vehiculo: "));
        String matricula;
        do {
            matricula = sc.pideTexto("Introduce la matricula del vehiculo: ");
            String mensaje = matricula.length() == 7 ? "Matricula correcta" : "La matricula tiene que tener exactamente 7 caracteres";
            System.out.println(mensaje);
        } while (matricula.length() != 7);
        vehiculos.setMatricula(matricula);

        vehiculos.add((Vehiculo) vehiculos);
    }

    /**
     * Metodo registrarServicio
     *
     * @return registra el servicio incluyendo descripcion, mecanico y servicio.
     */

    public void registrarServicio() {
        String descripcion = sc.pideTexto("Introduce la descripcion: ");
        String mecanico = sc.pideTexto("Introduce el mecanico: ");
        TipoServicio tipoServicio = null;
        boolean correcto;
        do {
            correcto = true;
            int servicio = sc.pedirNumero("1.Mantenimiento" +
                    "\n2. Cambio de aceite" +
                    "\n3. Electricidad" +
                    "\n4. Frenos" +
                    "\n5. Pintura" +
                    "\nSeleccione su opción");
            switch (servicio) {
                case 1:
                    tipoServicio = TipoServicio.MANTENIMIENTO;
                    break;
                case 2:
                    tipoServicio = TipoServicio.CAMBIO_ACEITE;
                    break;
                case 3:
                    tipoServicio = TipoServicio.ELECTRICIDAD;
                    break;
                case 4:
                    tipoServicio = TipoServicio.FRENOS;
                    break;
                case 5:
                    tipoServicio = TipoServicio.PINTURA;
                    break;
                default:
                    correcto = false;
                    System.out.println("Opción no valida");
                    break;
            }
        } while (!correcto);
        vehiculos.add(new Vehiculo(descripcion, mecanico, tipoServicio));
    }

    /**
     * Metodo asignarServicios
     *
     * @return sirve para poder asignar el servicio necesario al vehiculo.
     */

    public String asignarServicios() {
        String matriculate = sc.pideTexto("Introduce la matricula: ");
        Vehiculo vehiculo;
        Servicio servicio = null;
        try {
            vehiculo = buscarVehiculo(matriculate);
        } catch (VehiculoNoEncontrado e) {
            System.out.println(e.getMessage());
            vehiculo = null;
        }
        if (vehiculo != null) {
            if (!catalogoServicios.isEmpty()) {
                String descripcion = sc.pideTexto("Introduce descripcion: ");
                servicio = buscarservicio(descripcion);
                if (servicio != null) {
                    vehiculos.remove(vehiculo);
                    trabajosRealizados.put(vehiculo, servicio);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    String fecha_formateada = LocalDate.now().format(formatter);
                    System.out.printf("Servicio: %s del vehiculo %s " + fecha_formateada, servicio.getTipoServicio());
                } else {
                    System.out.println("No hay Servicio encontrado.");
                }
            }
        } else {
            System.out.println("No existe el vehiculo con esa matricula.");
        }
        return (vehiculo != null && servicio != null) ? "Servicio asignado correctamente" : "Error en el proceso";
    }

    /**
     * Metodo mostrarVehiculos
     *
     * @return te muestra los vehiculos de la arraylist, pudiendo filtrar por tipo de vehiculo
     */

    public boolean mostrarVehiculos () {
        if (!vehiculos.isEmpty()) {
            for (Vehiculo vehiculo : vehiculos) {
                System.out.println(vehiculo);
            }
            boolean correcto;
            do {
                char opcion = sc.pedirLetra("¿Quiere filtrar por tipo?");
                switch (opcion) {
                    case 's':
                    case 'S':
                        filtrotipo();
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
            System.out.println("No hay vehiculos disponibles");
            return false;
        }
    }

    /**
     * Metodo  filtrotipo
     * Realizado con enum
     *
     * @return realiza la filtración por tipo del metodo mostrarVehiculos.
     */

    public void filtrotipo() {
        TipoVehiculo tipoVehiculo = null;
        boolean correcto;
        do {
            correcto = true;
            int opcion_genero = sc.pedirNumero("1.Camion" +
                    "\n2. Furgoneta" +
                    "\n3. Turismo" +
                    "\n4. Motocicleta" +
                    "\nSeleccione su opción");
            switch (opcion_genero) {
                case 1:
                    tipoVehiculo = TipoVehiculo.CAMION;
                    break;
                case 2:
                    tipoVehiculo = TipoVehiculo.FURGONETA;
                    break;
                case 3:
                    tipoVehiculo = TipoVehiculo.TURISMO;
                    break;
                case 4:
                    tipoVehiculo = TipoVehiculo.MOTOCICLETA;
                    break;
                default:
                    correcto = false;
                    System.out.println("Opción no valida");
                    break;
            }
        } while (!correcto);
        for (Vehiculo vehiculo : vehiculos) {
            if (tipoVehiculo == vehiculo.getTipo()) {
                System.out.println(vehiculo);
            }
        }
    }

    /**
     * Metodo mostrarTrabajos
     *
     * @return muestra los trsbsjos realizados.
     */

    public void mostrarTrabajos() {
        for (Vehiculo vehiculo : trabajosRealizados.keySet()) {
            System.out.printf("Trabajo realizado: tipode vehiculo: %s, Servicio realizado: %s" +
                    "", vehiculo.getTipo(), trabajosRealizados.get(vehiculo));
        }
    }

    /**
     * Metodo buscarVehiculo
     *
     * @param matricula
     * @return busca un vehiculo por su matricula
     */

    public Vehiculo buscarVehiculo (String matricula) throws VehiculoNoEncontrado {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMatricula().equals(matricula)) {
                return vehiculo;
            }
        }
        throw new VehiculoNoEncontrado("Vehiculo no encontrado");
    }

    /**
     * Metodo buscarservicio
     *
     * @param descripcion
     * @return busca servicio por su descripcion para realizarlo en caso de que el cliente quiera.
     */

    public Servicio buscarservicio(String descripcion) {
        for (Servicio servicio : catalogoServicios) {
            if (servicio.getTipoServicio().equals(descripcion)) {
                return servicio;
            }
        }
        return null;
    }

}