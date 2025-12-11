package proyecto2.clases;

import clases.MyScanner;
import clases.Servicio;
import clases.Vehiculo;
import enums.TipoServicio;
import enums.TipoVehiculo;
import exceptions.VehiculoNotFound;

import java.util.ArrayList;

public class Taller {

    /**
     *  Aqui inicializamos las listas que usaremos en nuetsro programa
     */

    private static final MyScanner sc = new MyScanner();
    private ArrayList<Vehiculo> Listavehiculos;
    private ArrayList<Servicio> ListaServicios;

    public Taller() {
        Listavehiculos = new ArrayList<>();
        ListaServicios = new ArrayList<>();
    }
    /**
     *  Apartir de aqui crearemos cada una de las clases que se usaran en el codigo
     */

    /**
     * registrar vehiculo nos ayuda a que el usuario registre un vehiculo con su matricula, modelo y tipo de vehiculo,
     * y despues el vehiculo se guarda en Listavehiculos para tenerlo registrado y usarlo cuando sea necesario
     */


    public void registrarVehiculo() {
        String matricula;
        Vehiculo vehiculo = new Vehiculo();
        do {
            matricula = sc.pideTexto("Introduzca la matricula: ");
            String mensaje = matricula.length() == 7 ? "Matricula correcta" : "Matricula incorrecta, recuerda que debe tener 7 caracteres";
            System.out.println(mensaje);
            vehiculo.setMatricula(matricula);
        } while (matricula.length() != 7);

        String modelo = sc.pideTexto("Introduzca el modelo del Vehículo: ");

        /**
         *
         */

        TipoVehiculo tipoVehiculo = null;
        boolean correcto;
        do {
            correcto = true;
            int opcion_tipoVehiculo = sc.pedirNumero("Introduzca el tipo de vehiculo: \n" +
                    "1. TURISMO\n" +
                    "2.MOTOCICLETA\n" +
                    "3.FURGONETA\n" +
                    "4.CAMION");
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
                    System.out.println("Opcion no valida");
                    break;
            }

        } while (!correcto);

        Listavehiculos.add(new Vehiculo(matricula, modelo, tipoVehiculo));

        /**
         * Por otro lado aqui se registraran los tipos de servicio que hay y se les añadiran su descripcion y el mecanico
         * que llevara el caso.Pedimos al usuario esos valores y los guardamos en otra lista
         */

    }

    public void registrarServicio() {
        String descripcion = sc.pideTexto("Introduzca la descripción del servicio: ");
        String mecanico = sc.pedirSoloTexto("Introduzca el nombre del mecánico: ");

        TipoServicio tipoServicio = null;
        boolean correcto;
        do {
            correcto = true;
            int opcion_tipoMantenimiento = sc.pedirNumero("Introduzca el tipo de Servicio: \n" +
                    "1. MANTENIMIENTO\n" +
                    "2.CAMBIO_ACEITE\n" +
                    "3.PINTURA\n" +
                    "4.FRENOS\n" +
                    "5.ELECTRICIDAD\n" +
                    "OPCIÓN: ");
            switch (opcion_tipoMantenimiento) {
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
                    System.out.println("Opcion no valida");
                    break;
            }

        } while (!correcto);

        ListaServicios.add(new Servicio(descripcion, mecanico, tipoServicio));

    }

    public void asignarServicio() {

        /**
         * Aqui recorreremos la lista y mostraremos los vehiculos que tengamos en ella y daremos la opcion de
         * filtrar por tipos de vehiculos
         */

    }

    public void mostrarVehiculos() {
        for (Vehiculo vehiculo : Listavehiculos) {
            System.out.println(Listavehiculos);
        }
    }

    /**
     * Este es el filtro, donde pedimos al usuario por que tipo de vehiculo quiere filtrar y luego recorremnos la lista de vehiculos
     * y los vehiculos que coincidan en tipoVehiculos los enseñamos por pantallas, el resto no
     */

    public void filtroTipoVehiculo() {
        TipoVehiculo tipoVehiculo = null;
        boolean correcto;
        do {
            correcto = true;
            int opcion = sc.pedirNumero("Introduzca el tipo de vehiculo: " +
                    "1. TURISMO\n" +
                    "2.MOTOCICLETA\n" +
                    "3.FURGONETA\n" +
                    "4.CAMION");
            switch (opcion) {
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
                    System.out.println("Opcion no valida");
                    break;

            }
        } while (!correcto);
        for (Vehiculo vehiculo : Listavehiculos) {
            if ( tipoVehiculo == vehiculo.getTipoVehiculo() {
                System.out.println(vehiculo);
            }
        }
    }

    public void mostrarTrabajos() {

    }

    /**
     * Aqui le peidmos al usuario que nos diga la amtricula del vehiculo que quiere buscar y recorremnos la lista.
     * En caso de que el vehiculo no este le soltamos una expcion personalizada donde le comunicamos al usuario que ese
     * vehiculo no existe registrado
     *
     * @param matricula
     * @return
     * @throws VehiculoNotFound
     */

    public Vehiculo buscarVehiculo(String matricula) throws VehiculoNotFound {
        for (Vehiculo vehiculo : Listavehiculos) {
            if (vehiculo.getMatricula().equals(matricula)) {
                return vehiculo;
            }
        }
        throw new VehiculoNotFound("Vehiculo no encontrado");
    }

    public void buscarServicio() {
        for (Servicio servicio : ListaServicios) {

        }
    }
}
