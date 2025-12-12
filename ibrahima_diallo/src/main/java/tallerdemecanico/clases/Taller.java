package tallerdemecanico.clases;

import tallerdemecanico.enums.TipoServicio;
import tallerdemecanico.enums.TipoVehiculo;
import tallerdemecanico.exception.VehiculoNoEncontrado;
import tallerdemecanico.recursos.MyScanner;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
/**
 * Clase Persona
 *
 * @author Alumno - Ibra
 * @version 1.0
 */
public class Taller {
    private static final MyScanner sc = new MyScanner();
    /**
     * @param ArrayList<Vehiculo> vehiculos atributo heredado
     * @param private ArrayList<Servicio> catalogoServicios; atributo heredado
     * @param Map<Vehiculo, Servicio> trabajosRealizados     atributo heredado
     */
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Servicio> catalogoServicios;
    private Map<Vehiculo, Servicio> trabajosRealizados;

    public Taller() {
        vehiculos = new ArrayList<>();
        catalogoServicios = new ArrayList<>();
        trabajosRealizados = new LinkedHashMap<>();
    }

    /**
     * Importo Arraylist ,LinkedHashMap, Map
     * @return
     */

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public ArrayList<Servicio> getCatalogoServicios() {
        return catalogoServicios;
    }

    public void setCatalogoServicios(ArrayList<Servicio> catalogoServicios) {
        this.catalogoServicios = catalogoServicios;
    }

    public Map<Vehiculo, Servicio> getTrabajosRealizados() {
        return trabajosRealizados;
    }

    public void setTrabajosRealizados(Map<Vehiculo, Servicio> trabajosRealizados) {
        this.trabajosRealizados = trabajosRealizados;
    }

    /**
     * Inicio el metodo de registrar vehiculo donde se introduce el modelo , la matricula y por ultimo el tipo de vehiculo
     * de su clase enum.
     */
    public void registrarVehiculo() {
        Vehiculo vehiculo = new Vehiculo();
        String s = "Introduce el modelo: ";
        TipoVehiculo tipoVehiculo = null;
        boolean correcto = false;
        do {
            correcto = true;
            int opcion_tipovehiculo = sc.pedirNumero("1. Turismo" +
                    "\n2. Motocicleta" +
                    "\n3. Furgoneta" +
                    "\n4. Camion" +
                    "\nIntroduce la opcion del tipo de vehiculo: ");
            switch (opcion_tipovehiculo) {
                case 1:
                    tipoVehiculo = TipoVehiculo.MOTOCICLETA;
                    break;
                case 2:
                    tipoVehiculo = TipoVehiculo.CAMION;
                    break;
                case 3:
                    tipoVehiculo = TipoVehiculo.FURGONETA;
                    break;
                case 4:
                    tipoVehiculo = TipoVehiculo.CAMION;
                    break;
                default:
                    correcto = false;
                    System.out.println("Opcion no valida");
                    break;
            }
            String matricula;

            do {
                matricula = (" Introduce la matricula del vehiculo: ");
                String mensaje = matricula.length() == 7 ? "Matricula correcta" : "La Matricula tiene que ser de 7 caracteres";
                System.out.println(mensaje);

            } while (matricula.length() != 7);
            vehiculo.setMatricula(matricula);

            vehiculos.add(vehiculo);
        } while (!correcto);



    }
    public void asignarServicio() {
        Servicio servicio = new Servicio();
    }

    /**
     * Inicio el metodo de registrar servicios donde se introduce la descripcion , el mecanico y por ultimo el tipo de servicio que proviene de su clase enum
     * de su clase enum.
     */
    public void registrarServicio() {
        Servicio servicio = new Servicio();
        String descripcion = ("Introduce la descripcion del servicio: ");
        String mecanico = ("Introduce el nombre mecanico del servicio: ");
        TipoServicio tiposervicio = null;
        boolean correcto;
        do {
            correcto = true;
            int opcion_tiposervicio = sc.pedirNumero("1. Mantenimiento" +
                    "\n2. Cambio_Aceite " +
                    "\n3. Pintura" +
                    "\n4. Frenos" +
                    "\n5. Electricidad" +
                    "\nIntroduce la opcion del tipo de vehiculo: ");
            switch (opcion_tiposervicio) {
                case 1:
                    tiposervicio = TipoServicio.MANTENIMIENTO;
                    break;
                case 2:
                    tiposervicio = TipoServicio.CAMBIO_ACEITE;
                    break;
                case 3:
                    tiposervicio = TipoServicio.PINTURA;
                    break;
                case 4:
                    tiposervicio = TipoServicio.FRENOS;
                    break;
                case 5:
                    tiposervicio = TipoServicio.ELECTRICIDAD;
                    break;
                default:
                    correcto = false;
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (!correcto);

        catalogoServicios.add(servicio);


    }


    /**
     * Creo un metodo para filtrar los vehiculos
     */
    public void filtroTipoVehiculo() {
        TipoVehiculo tipoVehiculo = null;
        boolean correcto;
        do {
            correcto = true;
            int opcion_tipovehiculo = sc.pedirNumero("1. Turismo" +
                    "\n2. Motocicleta" +
                    "\n3. Furgoneta" +
                    "\n4. Camion" +
                    "\nIntroduce la opcion del tipo de vehiculo: ");
            switch (opcion_tipovehiculo) {
                case 1:
                    tipoVehiculo = TipoVehiculo.MOTOCICLETA;
                    break;
                case 2:
                    tipoVehiculo = TipoVehiculo.CAMION;
                    break;
                case 3:
                    tipoVehiculo = TipoVehiculo.FURGONETA;
                    break;
                case 4:
                    tipoVehiculo = TipoVehiculo.CAMION;
                    break;
                default:
                    correcto = false;
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (!correcto);

        }

    /**
     * metodo para buscar vehiculo a traves de la matricula
     * Si no existe te lanza un throws
     * @throws VehiculoNoEncontrado
     */
    public void buscarVehiculo() throws VehiculoNoEncontrado{
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMatricula().equals(vehiculo.getMatricula())) {
                return;
            }
        }
        throw new VehiculoNoEncontrado("No existe el vehiculo");
        }

    /**
     * Metodo para buscar servicio.
     */
    public void buscarServicio() throws VehiculoNoEncontrado {
        for (Servicio servicio : catalogoServicios) {
            if (servicio.getTipo().equals(catalogoServicios)) {
                return;
            }
        }

        }



    }

