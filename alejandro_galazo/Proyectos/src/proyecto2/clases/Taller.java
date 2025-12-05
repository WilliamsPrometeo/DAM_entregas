package proyecto2.clases;


import proyecto2.recursos.MyScanner;
import proyecto2.enums.TipoServicio;
import proyecto2.enums.TipoVehiculo;
import proyecto2.exception.VehiculoNoEncontrado;

import java.sql.SQLData;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.LinkedHashMap;

/**
 * Clase taller
 *
 * @author Alumno-Alejandro
 * @version 1.0
 */
public class Taller {

    private static final MyScanner sc = new MyScanner();
    
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Servicio> catalogoServicios;
    Map<Vehiculo, Servicio> trabajosRealizados;

    /**
     * consructor principal de la clase Taller
     * se inicializan las listas de vehiculos y el catalogo de servicios
     * se inicializa el mapa de trabajos realizados
     */
    public Taller() {
        vehiculos = new ArrayList<>();
        catalogoServicios = new ArrayList<>();
        trabajosRealizados = new LinkedHashMap<>();
    }
    /**
     * Getter de la lista Vehiculo
     *
     * @return la lista de vehiculos guardados
     */
    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    /**
     * Setter de la lista vehiculo
     *
     * @param vehiculos estable el arraylist de vehiculos
     */
    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
    /**
     * Getter de la lista CatalogoServicios
     *
     * @return la lista CatalogoServicios
     */
    public ArrayList<Servicio> getCatalogoServicios() {
        return catalogoServicios;
    }
    /**
     * Setter de la lista catalogoServicios
     *
     * @param catalogoServicios estable la lista del catalogo
     */
    public void setCatalogoServicios(ArrayList<Servicio> catalogoServicios) {
        this.catalogoServicios = catalogoServicios;
    }

    public Map<Vehiculo, Servicio> getTrabajosRealizados() {
        return trabajosRealizados;
    }
    /**
     * Getter del mapa Trabajos Realizados
     *
     * @return los trabajos realizados en funcion de los servicios a los vehiculos
     */
    public void setTrabajosRealizados(Map<Vehiculo, Servicio> trabajosRealizados) {
        this.trabajosRealizados = trabajosRealizados;
    }
    
    
    public void registrarVehiculo() {
        Vehiculo vehiculoTaller = new Vehiculo();
        
        vehiculoTaller.setModelo(sc.pideTexto("introducir modelo"));
        String Matricula;
        do {
            Matricula = sc.pideTexto("introduce la matricula");
            String mensaje = Matricula.length() == 7 ? "Matricula correcta" : "La matricula debe tener 7 caracteres alfanuméricos";
            System.out.println(mensaje);

        } while (Matricula.length() != 7);
        vehiculoTaller.setMatricula(Matricula);

        vehiculos.add((Vehiculo) vehiculoTaller);
        
    }

    /**
     * Metodo:
     *
     */

    public void registrarServicio() {
        String descripcion= sc.pideTexto("introduce la descripcion del servicio");
        String mecanico= sc.pideTexto("introduce el nombre del mecanico");
        TipoServicio tipo = null;

        boolean correcto;

        do {
            correcto = true;
            int opcion_genero = sc.pedirNumero("1. MANTENIMIENTO" +
                    "\n2. CAMBIO DE ACEITE" +
                    "\n3. PINTURA" +
                    "\n4. FRENOS" +
                    "\n5. ELECTRICIDAD" +
                    "\n6. SORPRESA" +
                    "\nIntroduce genero");
            switch (opcion_genero) {
                case 1:
                    tipo = TipoServicio.MANTENIMIENTO;
                    break;
                case 2:
                    tipo = TipoServicio.CAMBIO_ACEITE;
                    break;
                case 3:
                    tipo = TipoServicio.PINTURA;
                    break;
                case 4:
                    tipo = TipoServicio.FRENOS;
                    break;
                case 5:
                    tipo = TipoServicio.ELECTRICIDAD;
                    break;
                case 6:
                    System.out.println("Hola caracola (si lees esto no se me ha ocurrido nada)");
                default:
                    correcto = false;
                    System.out.println("opcion incorrecta");
                    break;
            }
        } while (!correcto);
        vehiculos.add(new Vehiculo());
        
    }

    /**
     * Metodo:asignarServicio
     * lanza excepcion personalizada
     * registra fecha de los trabajos realizados
     */
    
    public String asignarServicio() throws VehiculoNoEncontrado {
        buscarServicio(sc.pideTexto("introduce el servicio a realizar"));
        String Matricula = sc.pideTexto("introduce la matricula del vehiculo");
        
        Servicio trabajos = null;
        Vehiculo vehiculoTaller = null;
        try {
            buscarVehiculo(Matricula);
        } catch (VehiculoNoEncontrado e) {
            System.out.println(e.getMessage());
            vehiculoTaller = null;

        }
        if (trabajos != null) {
            mostrarVehiculos();
            String titulo = sc.pideTexto("introduce el titulo del libro");
            buscarVehiculo(Matricula);
            if (vehiculoTaller != null) {
                vehiculos.remove(vehiculoTaller);
                trabajosRealizados.put(vehiculoTaller, trabajos);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String fecha_formateada = LocalDateTime.now().format(formatter);
                System.out.printf("Fecha de prestamo: %s del vehiculo: %s", fecha_formateada, vehiculoTaller.getMatricula());
            } else {
                System.out.println("no existe el vehiculp con esa matricula disponible");
            }
        }
        return (vehiculoTaller != null && vehiculoTaller != null) ? "libro prestado correctamente" : "error en el proceso";
    }

    /**
     * Metodo: mostrarVehiculos
     *muestra vehiculos e implementa metodo para filtrar por tipo de vehiculo
     */
    
    public void mostrarVehiculos() {
        if (vehiculos.isEmpty()) {
            for (Vehiculo libro : vehiculos) {
                System.out.println(libro);
            }
            boolean correcto;
            do{
                char opcion= sc.pedirLetra("¿quiere filtrar por tipo de vehiculo?");
                switch (opcion) {
                    case 's':
                    case 'S':
                        filtrarVehiculosPorTipo();
                        correcto = true;
                        break;
                    case 'n':
                    case 'N':
                        correcto = false;
                        break;
                    default:
                        correcto = false;
                        break;
                }
            }while (!correcto);

        }else {
            System.out.println("no hay libros disponibles");
        }
    }

    /**
     * Metodo: Filtrar por Tipo
     *menu switch con blucle do while para seleccionar el tipo de vehiculo que quiere buscar
     */

    public void filtrarVehiculosPorTipo(){
        TipoVehiculo vehiculo= null;
        boolean correcto;
        do {
            correcto = true;
            int opcion_genero = sc.pedirNumero("1. camion" +
                    "\n2. No turismo" +
                    "\n3. motocicleta" +
                    "\n4. furgoneta" +
                    "\nIntroduce tipo de vehiculo");
            switch (opcion_genero) {
                case 1:
                    vehiculo = TipoVehiculo.CAMION;
                    break;
                case 2:
                    vehiculo = TipoVehiculo.TURISMO;
                    break;
                case 3:
                    vehiculo = TipoVehiculo.MOTOCICLETA;
                    break;
                case 4:
                    vehiculo = TipoVehiculo.FURGONETA;
                    break;
                default:
                    correcto = false;
                    System.out.println("opcion incorrecta");
                    break;
            }
        } while (!correcto);
    }

    /**
     * Metodo: mostrarTrabajos
     *meutra los trabajos en curso con texto formateado
     */

    
    
    public void mostrarTrabajos() {
        for  (Servicio servicio : catalogoServicios) {
            System.out.printf("Modelo: %s", servicio.getDescripcion());
        }
    }

    /**
     * Metodo:buscarVehiculo
     *busca el vehiculo por su matricula, sino lanza execepcion de vehiculo no encontra¡do
     */
    
    public void buscarVehiculo(String matricula) throws VehiculoNoEncontrado{
        mostrarVehiculos();
        String opcion = sc.pideTexto("Ingrese la matricula: ");
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMatricula() == opcion)
                System.out.printf("Vehiculo encontrado con matricula: %s", opcion);
            return;

        }throw new VehiculoNoEncontrado("No existe un vehiculo con esa matricula registrado.");
        
    }

    /**
     * Metodo: buscarServicio
     *comprieba que el servicio requerido cuadre con la descripcion proporcionada
     */
    
    public String buscarServicio(String descripcion){
        for (Servicio servicio : catalogoServicios) {
            if (servicio.getDescripcion().equals(descripcion)) {
                return descripcion;
            }
        }
        return null;
    }
    
}
