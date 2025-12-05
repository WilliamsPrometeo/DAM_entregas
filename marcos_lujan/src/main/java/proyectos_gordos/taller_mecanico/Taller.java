package proyectos_gordos.taller_mecanico;

import proyectos_gordos.enums.TipoServicio;
import proyectos_gordos.enums.TipoVehiculo;
import proyectos_gordos.exceptions.VehiculoNoEncontrado;
import proyectos_gordos.recursos.MyScanner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase Taller
 *
 * @author Alumno - Marcos Luján Miguel
 * @version 1.0
 */
public class Taller {

    private static final MyScanner sc = new MyScanner();

    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Servicio> catalogoServicios;
    private Map<Vehiculo, Servicio> trabajosRealizados;

    /**
     * Constructor vacío Taller con los ArrayList y HasMap correspondientes
     *
     */
    public Taller() {
        vehiculos = new ArrayList<>();
        catalogoServicios = new ArrayList<>();
        trabajosRealizados = new HashMap<>();
    }

    /**
     * Getter del atributo vehiculos
     *
     * @return los vehiculos registrados
     */
    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    /**
     * Setter del atributo vehículos
     *
     * @param vehiculos
     */
    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    /**
     * Getter del atributo catalo Servicios
     *
     * @return el catalago con todos los servicios
     */
    public ArrayList<Servicio> getCatalogoServicios() {
        return catalogoServicios;
    }

    /**
     * Seter del atributo catalogo servicios
     *
     * @param catalogoServicios
     */
    public void setCatalogoServicios(ArrayList<Servicio> catalogoServicios) {
        this.catalogoServicios = catalogoServicios;
    }

    /**
     * Getter del atributo trabajosRealizados
     *
     * @return los trabajos realizados
     */
    public Map<Vehiculo, Servicio> getTrabajosRealizados() {
        return trabajosRealizados;
    }

    /**
     * Setter del atributo trabajos realizados
     *
     * @param trabajosRealizados
     */
    public void setTrabajosRealizados(Map<Vehiculo, Servicio> trabajosRealizados) {
        this.trabajosRealizados = trabajosRealizados;
    }

    /**
     * Metodo registrarVehiculo, sirve para registrar los vehiculos en el concesionario
     */
    public void registrarVehiculo() {
        Vehiculo vehiculo = new Vehiculo();
        String modelo = sc.pideTexto("Introduce el modelo de tu vehiculo: ");

        String matricula;
        do {
            matricula = sc.pideTexto("Introduce la matricula de tu vehiculo: ");
            String mensaje = matricula.length() == 7 ? "Matricula correcta" : "La matricula ha de tener exactamente 7 caracteres";
            System.out.println(mensaje);
        } while (matricula.length() != 7);
        vehiculo.setMatricula(matricula);

        TipoVehiculo tipo = null;
        boolean correcto;
        do {
            correcto = true;
            int opcion_tipo = sc.pedirNumero("1. Turismo" +
                    "\n2. Furgoneta" +
                    "\n3. Camioneta" +
                    "\n4. Camion" +
                    "\n5. Motocicleta" +
                    "\nIntroduce la opcion del tipo de vehiculo: ");
            switch (opcion_tipo) {
                case 1:
                    tipo = TipoVehiculo.TURISMO;
                    break;
                case 2:
                    tipo = TipoVehiculo.FURGONETA;
                    break;
                case 3:
                    tipo = TipoVehiculo.CAMIONETA;
                    break;
                case 4:
                    tipo = TipoVehiculo.CAMION;
                    break;
                case 5:
                    tipo = TipoVehiculo.MOTOCICLETA;
                    break;
                default:
                    correcto = false;
                    System.out.println("Opcion no valida!");
                    break;
            }
        } while (!correcto);
        vehiculos.add(new Vehiculo(matricula, modelo, tipo));
    }

    /**
     * Metodo registrarServicio, selecciona el servicio que se requiere
     *
     * @return
     */
    public void registrarServicio() {

        String descripcion = sc.pideTexto("Introduce la descripcion de tu servicio: ");
        String mecanico = sc.pideTexto("Introduce el nombre del mecánico que deseas que te atienda: ");

        TipoServicio tipo = null;
        boolean correcto;
        do {
            correcto = true;
            int opcion_tipo = sc.pedirNumero("1. Electricidad" +
                    "\n2. Frenos" +
                    "\n3. Mantenimiento" +
                    "\n4. Pintura" +
                    "\n5. Cambio de aceite" +
                    "\n6. Cambio de tapicería" +
                    "\nIntroduce la opcion del tipo de servicio: ");

            switch (opcion_tipo) {
                case 1:
                    tipo = TipoServicio.ELECTRICIDAD;
                    break;
                case 2:
                    tipo = TipoServicio.FRENOS;
                    break;
                case 3:
                    tipo = TipoServicio.MANTENIMIENTO;
                    break;
                case 4:
                    tipo = TipoServicio.PINTURA;
                    break;
                case 5:
                    tipo = TipoServicio.CAMBIO_ACEITE;
                    break;
                case 6:
                    tipo = TipoServicio.CAMBIO_TAPICERIA;
                    break;
                default:
                    correcto = false;
                    System.out.println("Opcion no valida!");
                    break;
            }
        } while (!correcto);
        catalogoServicios.add(new Servicio(descripcion, mecanico, tipo));
    }

    /**
     * Metodo asignarServicio
     * @throws VehiculoNoEncontrado
     */
    public void asignarServicio()  {
        try {
            String matricula = sc.pideTexto("Introduce la matricula del vehiculo: ");
            Vehiculo vehiculo = buscarVehiculo(matricula);

            if (vehiculo != null) {
                System.out.println("\nServicio disponibles!");
                for (int i = 0; i < catalogoServicios.size(); i++) {
                    System.out.println((i +1)+ ". " + catalogoServicios.get(i).getDescripcion());
                }
                int opcion_servicio = sc.pedirNumero("Introduce la opcion del servicio: ");

                if(opcion_servicio > 0 && opcion_servicio <= catalogoServicios.size()) {
                    Servicio servicio = catalogoServicios.get(opcion_servicio - 1);
                    trabajosRealizados.put(vehiculo, servicio);
                    System.out.println("Servicio asignado!");
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                    String fechaFormateada = LocalDateTime.now().format(dtf);
                    System.out.printf("Fecha de servicio: %s\n", fechaFormateada, vehiculo);
                } else {
                    throw new VehiculoNoEncontrado("Opcion de servicio no valida!");
                }
            }else {
                throw new VehiculoNoEncontrado("No existe el vehiculo");
            }
        }catch (VehiculoNoEncontrado e) {
            System.out.println("Errorcito...."+ e.getMessage());
        }

    }

    /**
     * Metodo mostrar vehiculos
     *
     * @return los vehiculos registrados
     */
    public boolean mostrarVehiculos() {
        if (!vehiculos.isEmpty()) {
            for (Vehiculo carro : vehiculos) {
                System.out.println(carro);
            }
            boolean correcto;
            do {
                char opcion = sc.pedirLetra("¿Quiere filtrar por Tipo de vehiculo? (S/N)");
                switch (opcion) {
                    case 'S':
                    case 's':
                        filtrarVehiculos();
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
     * Metodo filtrar vehiculos sirve para hacer un filtrado respecto a los vehiculos
     *
     */
    public void filtrarVehiculos() {
        TipoVehiculo tipo = null;
        boolean correcto;
        do {
            correcto = true;
            int opcion_tipo = sc.pedirNumero("1. Turismo" +
                    "\n2. Furgoneta" +
                    "\n3. Camioneta" +
                    "\n4. Camion" +
                    "\n5. Motocicleta" +
                    "\nIntroduce la opcion del tipo de vehiculo: ");
            switch (opcion_tipo) {
                case 1:
                    tipo = TipoVehiculo.TURISMO;
                    break;
                case 2:
                    tipo = TipoVehiculo.FURGONETA;
                    break;
                case 3:
                    tipo = TipoVehiculo.CAMIONETA;
                    break;
                case 4:
                    tipo = TipoVehiculo.CAMION;
                    break;
                case 5:
                    tipo = TipoVehiculo.MOTOCICLETA;
                    break;
                default:
                    correcto = false;
                    System.out.println("Opcion no valida!");
                    break;
            }
        } while (!correcto);
        for (Vehiculo libro : vehiculos) {
            if (tipo == libro.getTipo()) {
                System.out.println(libro);
            }
        }
    }

    /**
     * Metodo mostrar trabajos
     *
     * @return los trabajos
     */
    public void mostrarTrabajos() {
        if (!trabajosRealizados.isEmpty()) {
            for (Vehiculo vehiculo : trabajosRealizados.keySet()) {
                Servicio servicio = trabajosRealizados.get(vehiculo);
                System.out.printf("Trabajos realizados: %nVehiculo: %s, Servicio: %s", vehiculo, servicio);
            }
        } else {
            System.out.println("No hay trabajos realizados");
        }

    }


    /**
     * Metodo buscarVehiculo sirve para buscar vehiculos
     *
     * @param matricula
     * @throws VehiculoNoEncontrado
     */
    public Vehiculo buscarVehiculo(String matricula) throws VehiculoNoEncontrado {
        for (Vehiculo carro : vehiculos) {
            if (carro.getMatricula().equals(matricula)) {
                return carro;
            }
        }
        throw new VehiculoNoEncontrado("Usuario no encontrado");
    }

    /**
     * Metodo buscarServicio sirve para buscar servicios
     *
     * @param descripcion
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
