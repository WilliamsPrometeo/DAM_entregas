package practica02;

import clases.MyScanner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Taller {

    private static final MyScanner sc = new MyScanner();

    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Servicio> catalogoServicios;
    private Map<Vehiculo, Servicio> trabajosRealizados;

    /**
     * Constructor para inicializar las listas y el Mapa
     */

    public Taller() {
        vehiculos = new ArrayList<>();
        catalogoServicios = new ArrayList<>();
        trabajosRealizados = new LinkedHashMap<>();
    }

    /**
     *
     * @return Vehiculos
     */

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    /**
     *
     * @param vehiculos
     */

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    /**
     *
     * @return catalogoServicios
     */

    public ArrayList<Servicio> getCatalogoServicios() {
        return catalogoServicios;
    }

    /**
     *
     * @param catalogoServicios
     */

    public void setCatalogoServicios(ArrayList<Servicio> catalogoServicios) {
        this.catalogoServicios = catalogoServicios;
    }

    /**
     *
     * @return trabajosRealizados
     */

    public Map<Vehiculo, Servicio> getTrabajosRealizados() {
        return trabajosRealizados;
    }

    /**
     *
     * @param trabajosRealizados
     */

    public void setTrabajosRealizados(Map<Vehiculo, Servicio> trabajosRealizados) {
        this.trabajosRealizados = trabajosRealizados;
    }

    /**
     * Metodo para registrar Vehiculos
     */

    public void registarVehiculo() {

        Vehiculo vehiculo = new Vehiculo();
        String matricula;
        do {
            matricula = sc.pideTexto("Introduce la matricula: ");
            String mensaje = matricula.length() == 7 ? "Matricula correcta" : "La matricula tiene que tener 7 caracteres ";
            System.out.println(mensaje);

        } while (matricula.length() != 7);
        String modelo = sc.pideTexto("Introduce la modelo: ");
        String tipos = String.valueOf("Introduce el tipo de vehiculo: ");
        vehiculos.add(new Vehiculo(tipos, modelo, matricula));

    }

    /**
     * Metodo para registrar servicios
     */

    public void registarServicio() {
        String descripcion = sc.pideTexto("Introduce una descripcion: ");
        String nombre_mecanico = sc.pideTexto("Introduce el nombre del mecanico: ");
        TipoServicio tipos = null;
        boolean correcto;
        do {
            correcto = true;
            int opcion_servicio = sc.pedirNumero("1. Mantenimiento" +
                    "\n2. Cambio_Aceite" +
                    "\n3. Pintura" +
                    "\n4. Frenos" +
                    "\5. Electricidad" +
                    "\nIntroduce la opcion del servicio: ");

            switch (opcion_servicio) {
                case 1:
                    tipos = TipoServicio.MANTENIMIENTO;
                    break;
                case 2:
                    tipos = TipoServicio.CAMBIO_ACEITE;
                    break;
                case 3:
                    tipos = TipoServicio.PINTURA;
                    break;
                case 4:
                    tipos = TipoServicio.FRENOS;
                    break;
                case 5:
                    tipos = TipoServicio.ELECTRICIDAD;
                    break;
                default:
                    correcto = false;
                    System.out.println("Opcion no valida");
                    break;
            }

        } while (!correcto);
        catalogoServicios.add(new Servicio(descripcion, nombre_mecanico, tipos));
    }

    /**
     * Metodo para asignar los ervicios
     *
     * @throws VehiculoNoEncontrado excepcion
     */

    public void asignarServicio() throws VehiculoNoEncontrado {
        String matricula = sc.pideTexto("Introduce la matricula: ");
        try {
            if (buscarVehiculos(matricula) != null) {
                String descripcion = sc.pideTexto("Introduce la descripcion: ");
                Servicio servicio = catalogoServicios.get(descripcion.hashCode());
                String correcto = servicio.getDescripcion() == descripcion ? "Correcto" + trabajosRealizados + servicio.getFecha_alta() : "Incorrecto";
                System.out.println(correcto);
            }
        } catch (VehiculoNoEncontrado e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Metodo para mostrar los vehiculos
     *
     * @return
     */

    public boolean mostrarVehiculos() {
        if (!vehiculos.isEmpty()) {
            for (Vehiculo vehiculo : vehiculos) {
                System.out.println(vehiculo);
            }
            boolean correcto;
            do {
                char opcion = sc.pedirLetra("¿Quieres filtrar por TipoVehiculo? (S/N)");
                switch (opcion) {
                    case 's':
                    case 'S':
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
            System.out.println("No hay vehiculos");
            return false;
        }
    }

    /**
     * Metodo para filtrar los tipos de Vehiculo
     */

    public void filtarTipos() {
        TipoVehiculo tipos = null;
        boolean correcto;
        do {
            correcto = true;
            int opcion_servicio = sc.pedirNumero("1. TURISMO" +
                    "\n2. MOTOCICLETA" +
                    "\n3. FURGONETA" +
                    "\n4. CAMION" +
                    "\nIntroduce la opcion del servicio: ");

            switch (opcion_servicio) {
                case 1:
                    tipos = TipoVehiculo.TURISMO;
                    break;
                case 2:
                    tipos = TipoVehiculo.MOTOCICLETA;
                    break;
                case 3:
                    tipos = TipoVehiculo.FURGONETA;
                    break;
                case 4:
                    tipos = TipoVehiculo.CAMION;
                    break;
                default:
                    correcto = false;
                    System.out.println("Opcion no valida");
                    break;
            }

        } while (!correcto);
        for (Vehiculo vehiculo : vehiculos) {
            if (tipos.equals(vehiculo.getTipoVehiculo())) {
                System.out.println(vehiculo);
            }
        }
    }

    /**
     * Metodo para mostrar los tabajos
     */

    public void mostrarTrabajos() {
        for (Vehiculo vehiculo : trabajosRealizados.keySet()) {
            System.out.printf("Matricula: Modelo: %s, Tipos: %s", vehiculo.getMatricula(), vehiculo.getModelo(), vehiculo.getTipos());
        }

    }

    /**
     * Metodo para buscar Vehiculos
     *
     * @param matricula matricula
     * @return vehiculo
     * @throws VehiculoNoEncontrado excepcion
     */

    public Vehiculo buscarVehiculos(String matricula) throws VehiculoNoEncontrado {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMatricula().equals(matricula)) {
                return vehiculo;
            }
        }
        throw new VehiculoNoEncontrado("Vehiculo no encontrado");
    }

    /**
     * Metodo para buscar servicios
     *
     * @param descripcion descripcion vehiculo
     * @return servicio
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
