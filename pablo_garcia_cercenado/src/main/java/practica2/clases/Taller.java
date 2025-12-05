package practica2.clases;

import practica2.excepcion.VehiculoNoEncontrado;
import recursos.Miscanner;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Taller {

    /**
     * Introduccion de un scanner personalizado
     */
    private static final Miscanner sc = new Miscanner();

    /**
     * inicializar las listas y mapas que compondrán la clase Taller
     */
    private ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    private ArrayList<Servicio> catalogoServicios = new ArrayList<>();
    private Map<Vehiculo, Servicio> trabajosRealizados = new LinkedHashMap<>();

    /**
     * constructor vacio
     */
    public Taller() {
    }

    /**
     * constructor donde se inicializan los parametros de la clase Taller
     * @param vehiculos
     * @param catalogoServicios
     * @param trabajosRealizados
     */
    public Taller(ArrayList<Vehiculo> vehiculos, ArrayList<Servicio> catalogoServicios, Map<Vehiculo, Servicio> trabajosRealizados) {
        this.vehiculos = vehiculos;
        this.catalogoServicios = catalogoServicios;
        this.trabajosRealizados = trabajosRealizados;
    }

    /**
     * metodo para registrar nuevos vehiculos dentro del ArrayList vehiculos
     */
    public void registrarVehiculo() {

        String matricula;
        do {
            matricula = sc.pideTexto("Introduce la matricula de vehiculo: ");
            String mensaje = matricula.length() == 7 ? "Matricula correcta " : "La matricula tiene que tener exactamente 7 caracteres.";
            System.out.println(mensaje);
        } while (matricula.length() != 7);

        String modelo = sc.pideTexto("Introduce el modelo del vehiculo: ");
        String tipo = String.valueOf(sc.pedirsoloTexto("Introduce el tipo de vehiculo: "));

        vehiculos.add(new Vehiculo(matricula, modelo, tipo));
    }

    /**
     * metodo para registrar un servicio dentro de los que ofrece el taller
     */
    public void registrarServicio() {

        String descripcion = sc.pideTexto("Introduce la descripcion del servicio: ");
        String mecanico = sc.pideTexto("Introduce el nombre del mecanico: ");
        TipoServicio tipo = null;
        boolean correcto;
        do {
            int opcion_servicio = sc.pedirNumero("Introduce el tipo de servicio" +
                    "\n1. Mantenimiento" +
                    "\n2. Cambio de aceite" +
                    "\n3. Pintura" +
                    "\n4. Frenos" +
                    "\n5. Electricidad" +
                    "\n0. Salir");
            switch (opcion_servicio){
                case 1:
                    tipo = TipoServicio.MANTENIMIENTO;
                    correcto = true;
                    break;
                case 2:
                    tipo = TipoServicio.CAMBIO_ACEITE;
                    correcto = true;
                    break;
                case 3:
                    tipo = TipoServicio.PINTURA;
                    correcto = true;
                    break;
                case 4:
                    tipo = TipoServicio.FRENOS;
                    correcto = true;
                    break;
                case 5:
                    tipo = TipoServicio.ELECTRICIDAD;
                    correcto = true;
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    correcto = false;
                    break;
                default:
                    System.out.println("Opción inválida");
                    correcto = true;
                    break;
            }
        } while (!correcto);
        catalogoServicios.add(new Servicio(descripcion, mecanico, tipo));
    }

    /**
     * metodo que asigna un servicio al usuario si su matricula esta registrada y devuelve una excepcion en el caso contrario
     *
     * @throws VehiculoNoEncontrado
     */
    public void asignarServicio() throws VehiculoNoEncontrado {
        String matriculaUsuario = sc.pideTexto("Introduce la matricula de vehiculo: ");
        if (buscarVehiculo(matriculaUsuario) != null){
            String descripcion = sc.pedirsoloTexto("Introduce la descripcion del servicio: ");
            Servicio s = catalogoServicios.get(descripcion.hashCode());
            String correcto = s.getDescripcion() == descripcion ? "Correcto" + trabajosRealizados + s.getFecha_servicio(): "Incorrecto";
            System.out.println(correcto);
        } else {
            throw new VehiculoNoEncontrado("Vehiculo no encontrado");
        }
    }

    /**
     * metodo que muestra al usuario los vehiculos registrados, permitiendole filtrar por tipo de vehiculo
     *
     * @return
     */
    public boolean mostrarVehiculos() {
        if (!vehiculos.isEmpty()) {
            for (Vehiculo vehiculo1 : vehiculos) {
                System.out.println(vehiculo1);
            }
            boolean correcto;
            do {
                char opcion = sc.pedirLetra("¿Quiere filtrar por tipo? S/N");
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
            System.out.println("No hay vehiculos registrados");
            return false;
        }
    }

    /**
     * Metodo mostrarTabajos
     * Busca aquellos vehiculos que hayan sido parte de un servicio y devuelve su matricul, modelo y tipo
     */
    public void mostrarTrabajos() {
        for (Vehiculo vehiculo : trabajosRealizados.keySet()){
            System.out.printf("Matricula: %s Modelo: %s, Tipo: %s", vehiculo.getMatricula(), vehiculo.getModelo(),  vehiculo.getTipo());
        }
    }

    /**
     * metodo buscarVehiculo
     * Permite al usuario buscar un vehiculo registrado por su matricula
     * @param matricula
     * @return Vehiculo
     */
    public Vehiculo buscarVehiculo(String matricula) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMatricula().equals(matricula)) {
                return vehiculo;
            }
        }
        return null;
    }

    /**
     * metodo buscarVehiculo
     * Permite al usuario buscar un servicio de entre los que se ofrecen
     * @param descripcion
     * @return Servicio
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
     * metodo filtroTipo
     * Permite al usuario filtrar los tipos vehiculos ofrecidos para seleccionar el que mas se ajuste a sus necesidades
     */
    public void filtroTipo(){
        TipoVehiculo tipo = null;
        int opcion_servicio = sc.pedirNumero("Introduce el tipo del vehiculo" +
                "\n1. Turismo" +
                "\n2. Motocicleta" +
                "\n3. Furgoneta" +
                "\n4. Camion");
        boolean correcto;
        do {
            correcto = true;
            switch (opcion_servicio){
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
                    correcto = false;
                    System.out.println("Opción inválida");
                    break;
            }
        } while (!correcto);
        for (Vehiculo vehiculo : vehiculos) {
            if (tipo.equals(vehiculo.getTipo())) {
                System.out.println(tipo);
            }
        }
    }
}
