package proyecto2.clases;
/**
 * Clase Taller
 * Autor: Lobo
 * Version 1.0
 */
import recursos.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Taller {
    private static final MyScanner sc = new MyScanner(); // crea al MyScanner

    private ArrayList<Vehiculo> vehiculos; //se declaran los arraylist y el map respectivamente
    private ArrayList<Servicio> catalogoServicios;
    private Map<Vehiculo, Servicio> trabajosRealizados;

    public Taller() { //constructor
        vehiculos = new ArrayList<>();
        catalogoServicios = new ArrayList<>();
        trabajosRealizados = new LinkedHashMap<>();
    }

    //getters and setters
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

    //registrar vehichulo
    public void registrarVehiculo() {
        Vehiculo coche = new Vehiculo("Modelo", "Matricula", null); //datos del vehiculo al almacenarse
        coche.setModelo(sc.pedirSoloTexto("Introduce el modelo: "));
        String matricula;
        TipoVehiculo tipo = null;
        do {
            matricula = sc.pedirSoloTexto("Introduce el matricula: ");
            String mensaje = matricula.length() == 7 ? "La matricula es correcta" : "Error, asegurese de que la matricula tiene 7 caracteres"; // ? = if pero en una linea
            System.out.println(mensaje);
        } while (matricula.length() != 7); //mientras longitud no sea igual a 7 repite el do
        boolean correcto = true; //declaramos el boolean "correcto"
        do {
            correcto = true;
            int opcion_TV = sc.pedirNumero("1. Turismo" + //opcion tipo vehiculo menu switch, igual en todos los menus similares
                    "\n2. Motocicleta" +
                    "\n3. Furgoneta" +
                    "\n4. Camion" +
                    "\nIntroduce el tipo de vehiculo");
            switch (opcion_TV) {
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
                    System.out.println("Opcion no valida!");
                    break;
            }
        } while (!correcto);
        vehiculos.add((Vehiculo) coche); //añade vehiculos a arraylist
        vehiculos.add(new Vehiculo(Vehiculo.getModelo(), matricula, tipo)); //agrega por "Modelo"-"Matricula"-"Y el tipo"
    }
    public String registrarServicio() { //refistrasmo el servicio realizado
        String descripcion = sc.pedirSoloTexto("Introduce la descripcion del servicio: "); //scanner la descripcion del servicio
        String mecanico = sc.pedirSoloTexto("Introduce al mecanico del servicio: "); //scanner al mecanico
        TipoServicio TipoServicio = null; //Tipo servicio es enum por ende no se pide nada
        boolean correcto = true; //boooooooooooooooolean
        do {
            correcto = true;
            int opcion_servicio = sc.pedirNumero("1. Mantenimiento" + //menu de los tipos de servicio
                    "\n2. Cambio de Aceite" +
                    "\n3. Pintura" +
                    "\n4. Frenos" +
                    "\n5. Electricidad" +
                    "\nIntroduce el tipo de servicio");
            switch (opcion_servicio) {
                case 1:
                    TipoServicio = TipoServicio.MANTENIMIENTO;
                    break;
                case 2:
                    TipoServicio = TipoServicio.CAMBIO_ACEITE;
                    break;
                case 3:
                    TipoServicio = TipoServicio.PINTURA;
                    break;
                case 4:
                    TipoServicio = TipoServicio.FRENOS;
                    break;
                case 5:
                    TipoServicio = TipoServicio.ELECTRICIDAD;
                    break;
                default:
                    correcto = false;
                    System.out.println("Opcion no valida!");
                    break;
            }
        } while (!correcto);
        catalogoServicios.add(new Servicio(descripcion, mecanico, TipoServicio));
        return descripcion;
    }
    public String asignarServicio() throws VehiculoNoEncontrado { //se asigna el servicio a un vehiculo, en caso de que no exista lanza la excepcion propia
        String matricula = sc.pideTexto("Introduce la matricula: ");
        Vehiculo vehiculo = buscarVehiculo(matricula); //declaramos su existencia
        try {
            vehiculo = buscarVehiculo(matricula);

        } catch (VehiculoNoEncontrado e) { //como actuar en caso de error
            System.out.println(e.getMessage());
            vehiculo = null;
        }
        Servicio servicio = null;
        if (vehiculo != null) {
            mostrarTrabajos();
            String descripcion = sc.pideTexto("Introduce la descripcion del servicio: ");
            servicio = buscarServicio(descripcion);
            if (vehiculo != null) {
                catalogoServicios.remove(servicio);
                trabajosRealizados.put(vehiculo, servicio);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //la fecha y hora
                String fecha_formateada = LocalDateTime.now().format(formatter); // formateada
                System.out.printf("Fecha: %s del servicio: %s", fecha_formateada, servicio.getDescripcion()); //lo que se imprime por pantalla
            } else  {
                System.out.println("No existe el servicio");
            }
        } else  {
            System.out.println("No existe el coche con esa matricula");
        }
        return (vehiculo != null && servicio != null) ? "Servicio realizado" : "Error en el servicio"; // ? = if en una linea
    }


    public void filtrarTipoVehiculo(){ //filtro por tipo del enum
        TipoVehiculo TipoVehiculo = null;
        boolean correcto = true;
        do {
            correcto = true;
            int opcion_TV = sc.pedirNumero("1. Turismo" +
                    "\n2. Motocicleta" +
                    "\n3. Furgoneta" +
                    "\n4. Camion" +
                    "\n Introduce la opcion que desees");
            switch (opcion_TV) {
                case 1:
                    TipoVehiculo = TipoVehiculo.TURISMO;
                    break;
                case 2:
                    TipoVehiculo = TipoVehiculo.MOTOCICLETA;
                    break;
                case 3:
                    TipoVehiculo = TipoVehiculo.FURGONETA;
                    break;
                case 4:
                    TipoVehiculo = TipoVehiculo.CAMION;
                    break;
                default:
                    correcto = false;
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (!correcto);
        for (Vehiculo vehiculo : vehiculos) {
            if (TipoVehiculo == vehiculo.getTipoVehiculo()) {
                System.out.println(vehiculo); //si existen vehiculo con el filtrado se se imprime por pantalla
            }
        }
    }

    public Servicio buscarServicio(String descripcion) { //busca el servicio con ayuda de los getters de la clase Servicio
        for (Servicio servicio : catalogoServicios) {
            if (servicio.getDescripcion().equals(descripcion)) {
                return servicio;
            }
        }
        return null;
    }
    public void MostrarVehiculos() { //busca el vehiculo con ayuda de los getters de la clase Vehiculo
        if (!vehiculos.isEmpty()) {
            for (Vehiculo vehiculo : vehiculos) {
                System.out.println(vehiculo);
            }
            boolean correcto; //booooooooooooolean
            do {
                char opcion = sc.pedirLetra("¿Quieres filtrar por tipo? s/n"); //el filtro por tipo de vehiculo
                switch (opcion) {
                    case 's': //independientemente de si la S
                    case 'S': //Es mayuscula o minuscula
                        correcto = true;
                        break;
                    case 'n': // Aqui lo mismo
                    case 'N': // De arriba
                        correcto = true;
                        break;
                    default:
                        correcto = false;
                        break;
                }
            } while (!correcto);
        } else {
            System.out.println("No hay vehiculos disponibles");
        }
    }

    public void mostrarTrabajos() {
        for (Vehiculo vehiculo: trabajosRealizados.keySet()) {
            System.out.printf("Trabajos Realizados: Vehiculo: %s, Servicio: %s", vehiculo.getModelo(), trabajosRealizados.get(vehiculo));
        }
    }

    public Vehiculo buscarVehiculo(String matricula) throws VehiculoNoEncontrado {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMatricula().equals(matricula)) {
                return vehiculo;
            }
        }
        return null;
    }
}


