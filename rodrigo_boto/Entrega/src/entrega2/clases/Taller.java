package entrega2.clases;

import entrega2.enums.TipoServicio;
import entrega2.enums.TipoVehiculo;
import entrega2.exception.VehiculoNoEncontrado;
import recursos.MyScanner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Clase Taller
 *
 * @author Rodrigo Boto
 * @version 1.0
 */

public class Taller {
    //Atributos privados
    private static final MyScanner sc = new MyScanner();
    private ArrayList <Vehiculo> vehiculos;
    private ArrayList <Servicio> catalogoServicios;
    private Map <Vehiculo, Servicio> servicios;

    //Constructor

    /**
     * Constructor principal de la clase Taller
     * Recoge los ArrayList y el Map creado de las clases Vehiculo y Servicio
     */

    public Taller() {
        vehiculos = new ArrayList <>();
        catalogoServicios = new ArrayList <>();
        servicios = new LinkedHashMap<>();
    }

    //Getters y Setters

    /**
     * Getter del ArrayList de Vehiculos
     *
     * @return lista de vehiculos
     */

    public ArrayList <Vehiculo> getVehiculos() {
        return vehiculos;
    }

    /**
     * Getter del ArrayList de Servicio
     *
     * @return lista de catalogoServicios
     */

    public ArrayList <Servicio> getCatalogoServicios() {
        return catalogoServicios;
    }

    /**
     * Getter del Map de Vehiculo y Servicio
     *
     * @return map "servicios" de Vehiculo y Servicio
     */

    public Map <Vehiculo, Servicio> getServicios() {
        return servicios;
    }

    /**
     * Setter del ArrayList de Vehiculo
     *
     * @param vehiculos establece los valores que va a tener cada vehículo
     */

    public void setVehiculos(ArrayList <Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    /**
     * Setter del ArrayList de Servicio
     *
     * @param catalogoServicios establece los valores que va a tener cada servicio
     */

    public void setCatalogoServicios(ArrayList <Servicio> catalogoServicios) {
        this.catalogoServicios = catalogoServicios;
    }

    /**
     * Setter del Map de Vehiculo y Servicio
     *
     * @param servicios establece los valores que va a tener cada servicio (de Vehiculo y Servicio)
     */

    public void setServicios(Map <Vehiculo, Servicio> servicios) {
        this.servicios = servicios;
    }

    /**
     * Clase registrarVehiculo
     * Crea un vehículo y se pide por teclado sus atributos
     * Se comprueba si la matrícula está bien insertada
     * Pide al usuario que registre el tipo de su vehículo con la enumeración
     * Se guarda el vehículo
     */

    public void registrarVehiculo() {
        Vehiculo vehiculo = new Vehiculo();
        String modelo = (sc.pideTexto("Introduce el modelo del coche: "));
        String matricula;
        do{
            matricula = (sc.pideTexto("Introduce la matrícula del coche: "));
            String mensaje = matricula.length() == 7 ?  "Matrícula correcta" : "La matrícula tiene que tener exactamente 7 caracteres";
            System.out.println(mensaje);
        } while (matricula.length() != 7);
        vehiculo.setMatricula(matricula);

        TipoVehiculo tipoVehiculo = null;
        boolean correcto;
        do {
            correcto = true;
            int opcion_tipo = sc.pedirNumero("1. Turismo" +
                    "\n2. Motocicleta" +
                    "\n3. Furgoneta" +
                    "\n4. Camión" +
                    "\nIntroduce el tipo de vehículo: ");
            switch (opcion_tipo) {
                case 1:
                    tipoVehiculo = TipoVehiculo.TURISMO;
                    break;
                case 2:
                    tipoVehiculo= TipoVehiculo.MOTOCICLETA;
                    break;
                case 3:
                    tipoVehiculo= TipoVehiculo.FURGONETA;
                    break;
                case 4:
                    tipoVehiculo= TipoVehiculo.CAMION;
                    break;
                default:
                    correcto = false;
                    System.out.println("Opción no valida!");
                    break;
            }
        } while (!correcto);
        vehiculos.add(new Vehiculo(matricula, modelo, tipoVehiculo));
    }

    /**
     * Clase registrarServicio
     * Crea un servicio y pide sus atributos
     * Se comprueba que tipo de servicio quiere con un bucle usando switch
     * Se registra el servicio en catalogoServicios
     */

    public void registrarServicio() {
        Servicio servicio = new Servicio();
        String descripcion = (sc.pideTexto("Introduce la descripción del servicio: "));
        String mecanico = (sc.pideTexto("Introduce el nombre del mecánico: "));
        TipoServicio tipoServicio = null;
        boolean correcto;
        do {
            correcto = true;
            int opcion_servicio = sc.pedirNumero("1. Mantenimiento" +
                    "\n2. Cambio de aceite" +
                    "\n3. Pintura" +
                    "\n4. Frenos" +
                    "\n5. Electricidad " +
                    "\nIntroduce el tipo de mantenimiento:  ");
            switch (opcion_servicio) {
                case 1:
                    tipoServicio = TipoServicio.MANTENIMIENTO;
                    break;
                case 2:
                    tipoServicio= TipoServicio.CAMBIO_ACEITE;
                    break;
                case 3:
                    tipoServicio= TipoServicio.PINTURA;
                    break;
                case 4:
                    tipoServicio= TipoServicio.FRENOS;
                    break;
                case 5:
                    tipoServicio= TipoServicio.ELECTRICIDAD;
                    break;
                default:
                    correcto = false;
                    System.out.println("Opción no valida!");
                    break;
            }
        } while (!correcto);
        catalogoServicios.add(new Servicio(descripcion, mecanico, tipoServicio));
    }

    /**
     * Clase asignarServicio
     * Pide matrícula del coche y se inicializan las variables
     * Busca el vehículo por su matrícula para saber si coincide
     * Pide la descripción del servicio para ver si concuerda y formatea la hora
     * Si concuerda la matrícula y la descripción se realiza el servicio y muestra en pantalla el texto formateado
     */

    public String asignarServicio() {
        String matricula = sc.pideTexto("Introduce la matrícula del coche ");
        Servicio servicio = null;
        Vehiculo vehiculo;
        try {
            vehiculo = buscarVehiculo(matricula);
        } catch (VehiculoNoEncontrado e) {
            System.out.println(e.getMessage());
            vehiculo = null;
        }
        if (vehiculo != null) {
            if (mostrarVehiculo()) {
                String descripcion = sc.pideTexto("Introduce la descripción del servicio: ");
                servicio = buscarServicio(descripcion);
                if (servicio != null) {
                    vehiculos.remove(vehiculo);
                    servicios.put(vehiculo, servicio);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                    String fecha_formateada = LocalDateTime.now().format(formatter);
                    System.out.printf("Fecha del servicio: %s ", fecha_formateada, servicio.getDescripcion());
                } else {
                    System.out.println("No hay ningún vehículo con esa matrícula");
                }
            }
        }
        return (servicio != null && vehiculo != null) ? "Servicio realizado correctamente" : "No hay ningún servicio con esa descripción.";
    }

    /**
     * Clase mostrarVehiculo
     * Comprueba si hay vehículos en la lista, si los hay los muestra sino no
     * Si hay vehículos los muestra y da la opción al usuario de filtrar por tipo de vehículo
     */

    public boolean mostrarVehiculo() {
        if (!vehiculos.isEmpty()) {
            for (Vehiculo vehiculo : vehiculos) {
                System.out.println(vehiculo);
            }
            boolean correcto;
            do {
                char opcion = sc.pedirLetra("¿Quiere filtrar por tipo de vehículo? (S/N)");
                switch (opcion) {
                    case 'S':
                    case 's':
                        filtroVehiculo();
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
     * Clase filtroVehiculo
     * Clase auxiliar usada para pedir al usuario cuál es el tipo de vehículo
     * Esta clase se usa en otras
     * Si no coincide el tipo de vehículo lo dice, si coincide solo lo muestra de nuevo
     */

    public void filtroVehiculo() {
        TipoVehiculo tipoVehiculo = null;
        boolean correcto;
        do {
            correcto = true;
            int opcion_vehiculo = sc.pedirNumero("1. Turismo" +
                    "\n2. Motocicleta" +
                    "\n3. Furgoneta" +
                    "\n4. Camión" +
                    "\nIntroduce el tipo de vehículo: ");
            switch (opcion_vehiculo) {
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
                    System.out.println("Opción no valida!");
                    break;
            }
        } while (!correcto);
        for (Vehiculo vehiculo : vehiculos) {
            if (tipoVehiculo == vehiculo.getTipo()) {
                System.out.println(vehiculo);
            } if (tipoVehiculo != vehiculo.getTipo()) {
                System.out.println("No hay ese tipo");
            }
        }
    }

    /**
     * Clase mostrarTrabajos
     * Clase que muestra los servicios realizados usando el printf con texto formateado
     */

    public void mostrarTrabajos() {
        for (Vehiculo catalogoServicios : servicios.keySet()) {
            System.out.printf("Matrícula: %s, || Información del taller ||%s%n, ", catalogoServicios.getMatricula(), servicios.get(catalogoServicios));
        }
    }

    /**
     * Clase buscarVehiculo
     * Clase que busca vehículos por la matrícula
     * Tira una excepción si no coinciden las matrículas
     */

    public Vehiculo buscarVehiculo(String matricula) throws VehiculoNoEncontrado {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMatricula().equals(matricula)) {
                return vehiculo;
            }
        }
        throw new VehiculoNoEncontrado("Vehiculo no encontrado!");
    }

    /**
     * Clase buscarServicio
     * Clase qie busca el servicio a través de la descripción
     * Si coinciden las descripciones hace un return de servicio, si no, nada
     */

    public Servicio buscarServicio(String descripcion){
        for (Servicio servicio : catalogoServicios) {
            if (servicio.getDescripcion().equals(descripcion)) {
                return servicio;
            }
        }
        return null;
    }
}
//