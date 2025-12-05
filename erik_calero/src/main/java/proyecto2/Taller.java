package proyecto2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * inicializo los array de programa
 */
public class Taller {
    private static final MyScanner sc = new MyScanner();
    private ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    private ArrayList<Servicio> servicios = new ArrayList<>();
    private Map<Vehiculo, Servicio> trabajos_hechos = new LinkedHashMap<>();

    public Taller() {

    }

    public Taller(ArrayList<Servicio> servicios, ArrayList<Vehiculo> vehiculos, Map<Vehiculo, Servicio> trabajos_hechos) {
        this.servicios = servicios;
        this.vehiculos = vehiculos;
        this.trabajos_hechos = trabajos_hechos;
    }

    /**
     * creao la funcion registrar vehiculo en donde verifico el regsitro del vehiculo
     */
    public void registrarVehiculo() {
        Vehiculo vehiculo = new Vehiculo();
        String matricula;
        do {
            matricula = String.valueOf(MyScanner.pedirNumero("Ingrese matricula de vehiculo"));
            String mensaje = matricula.length() == 7 ? "matricula correcta" :"la matyricula debe terner 7 caracteres";
            System.out.println("mensaje: " + mensaje);
        } while (matricula.length() != 7);
        vehiculo.setMatricula(matricula);
        vehiculo.setModelo(sc.pedirSoloTexto("ingrese modelo de vehiculo"));
        vehiculo.setTipoVehiculo(sc.pideTexto("ingrese tipo de vehiculo"));
        vehiculos.add(vehiculo);
    }

    /**
     * registro el servicio por el cual el vehiculo va a optar
     */
    public void registrarServicio() {
        String descripcion = sc.pedirSoloTexto(("ingrese descripcion ")).toString();
        String mecanico = sc.pedirSoloTexto(("ingrese mecanico ")).toString();
        Tiposervicio tipo = null;
        int opcion;
        do {
            System.out.println("""
                    -------- MENÚ PRINCIPAL SERVICIOS --------
                    1. MANTENIMIETNO
                    2. CAMBIO_ACEITE,
                    3. PINTURA,
                    4. FRENOS,
                    5. ELECTRICIDAD
                    6. Salir
                    """);
            opcion = sc.pedirNumero("ingrese una opcion: ");
            switch (opcion) {
                case 1:
                    tipo = Tiposervicio.MANTENIMIETNO;
                    break;
                case 2:
                    tipo = Tiposervicio.CAMBIO_ACEITE;
                    break;
                case 3:
                    tipo = Tiposervicio.PINTURA;
                    break;
                case 4:
                    tipo = Tiposervicio.FRENOS;
                    break;
                case 5:
                    tipo = Tiposervicio.ELECTRICIDAD;
                    break;
                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 6);

    }

    /**asigno el vehiuclo agregado de cuaerdo los datos
     * realizo los diveros
     * @throws VehiculoNoEncontrado
     */
    public void asignarServicio() throws VehiculoNoEncontrado {
        String matricuausuario = sc.pedirSoloTexto(("ingrese matricula de usuario")).toString();
        if(buscarVehiculo(matricuausuario) !=null) {
            String descripcion = sc.pedirSoloTexto(("ingrese descripcion ")).toString();
            Servicio s = servicios.get(descripcion.hashCode());
            String correcto = s.getDescripcion() == descripcion ? "correcto" + trabajos_hechos + s.getFecha_vehiculo(): "incorrecto" ;
            s.setDescripcion(correcto);
        }
    }

    /**
     *muestro los vehicuos ingresados anteriormente
     * @return
     */

    public boolean mostrarVehiculos() {
        if (!vehiculos.isEmpty()) {
            for (Vehiculo vehiculo : vehiculos) {
                System.out.println(vehiculo);
            }
        }
        /**
         * verififico el tipo de filtro mediante el switch
         */
        boolean correcto=true;
        do {
            char opcion = sc.pedirLetra("quieres filtrat por tipo ");
            switch (opcion) {
                case 'S':
                case 's':
                    correcto = true;
                    filtratTipo();
                    break;
                case 'N':
                case 'n':
                    correcto = true;
                    break;

            }
        } while (!correcto);
        return true;
    }


    public void mostrarTrabajos() {
        for (Vehiculo vehiculo : trabajos_hechos.keySet()) {
            System.out.printf("matricula %s modelo %s tipo %s ", vehiculo.getMatricula(), vehiculo.getModelo(), vehiculo.getTipoVehiculo());
        }

    }

     public Vehiculo buscarVehiculo(String matricula) {
         for (Vehiculo vehiculo : vehiculos) {
             if (vehiculo.getMatricula().equals(matricula)) {
                 return vehiculo;
             }
         }
         return null;
     }



        public void buscarServicio () {
        for (Servicio servicio : servicios) {
            if(servicio.getDescripcion().equals(servicio.getDescripcion()));
        }

        }

    /**
     * aplico el filtro deseado al usuariuo
     */
        public void filtratTipo () {
            TipoVehiculo tipo = null;
            boolean correcto;
            int opcion;
            do {
                opcion = sc.pedirNumero("Ingrese tipo de servicio");
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
                        System.out.println("error de ingreso");
                }
            } while (opcion != 5);
            for (Vehiculo vehiculo : vehiculos) {
                if ((tipo.equals(vehiculo.getTipoVehiculo()))) ;
                System.out.println(tipo);

            }
        }

}



