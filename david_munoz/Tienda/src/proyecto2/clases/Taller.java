package proyecto2.clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * En la clase Taller se implementan varios ArrayList para mostrar los vehiculos y el catálogo de los servicios
 * luego se realiza un hashMap con hashCode.Posteriormente se realizan varios public voids con souts integrados, para
 * especificar lo que piden los métodos.
 * Hecho por David Muñoz
 */
public class Taller {

    private static final MyScanner sc = new MyScanner();

    private ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
    private ArrayList<Taller> catalogoServicios = new ArrayList<Taller>();
    private Map<Vehiculo, Servicio> servicios = new HashMap<Vehiculo, Servicio>();

    public static boolean asignarServicio() {
        System.out.println("Matricula del Vehiculo");
        System.out.println("Buscar Vehiculo");
        System.out.println("Descripción del Servicio");
        return false;

    }

    public static void mostrarVehiculos() {
        System.out.println("Turismo");
        System.out.println("Motocicleta");
        System.out.println("Furgoneta");
        System.out.println("Camion");
    }

    public static void mostrarTrabajos() {
        System.out.println("Contenido del Map");
    }

    public static void buscarServicio() {
        System.out.println("Buscar Servicio");
        System.out.println("Buscar Vehiculo");

    }
}

