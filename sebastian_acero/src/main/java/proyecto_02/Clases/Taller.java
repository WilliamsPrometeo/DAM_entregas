package proyecto_02.Clases;

import Simulacro.clases.Libro;
import Simulacro.exception.UserNotFound;
import ciudad.concesionario.MyScanner;
import proyecto_02.enums.TipoServicio;

import static ciudad.concesionario.Gestionconsesionario.sc;

public class Taller {
    private static final MyScanner sc = new MyScanner();

    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Servicio> catalogoServicios;
    private Map<Vehiculo, Servicio> trabajosRealizados;

    public Taller() {
        vehiculos = new ArrayList<>();
        catalogoServicios = new ArrayList<>();
        trabajosRealizados = new HashMap<>();
    }

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

    public void registrarVehiculo() {
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setModelo(sc.pedirSoloTexto("Introduce el modelo del vehiculo"));

        String matricula;
        do {
            matricula = sc.pideTexto("Introduce la matricula del vehiculo");
            String mensaje = matricula.length() == 7 && matricula.matches(".*[0-9].*") && matricula.matches(".*[A-Z].*") ? "Matricula correcta" : "La matricula debe tener exactamente 7 caracteres";
            System.out.println(mensaje);
        } while (matricula.length() != 9);
        vehiculo.setMatricula(matricula);

        vehiculos.add(vehiculo);

    }

    public void registrarServicio() {
        String descripcion = sc.pideTexto("Introduce la descripcion del servicio");
        String mecanico = sc.pedirSoloTexto("Introduce el nombre del mecanico");
        TipoServicio TipoServicio = null;
        boolean correcto;
        do {
            correcto = true;
            int Tiposervicio = sc.pedirNumero("1. Mantenimiento" +
                    "\n2. cambio_aceite" +
                    "\n3. pintura" +
                    "\n4. frenos" +
                    "\n5. electricidad" +
                    "\nIntroduce la opcion del Tipo de servicio: ");

            switch (TipoServicio) {
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
    }
}

public String asignarServicio(){
    String matricula = sc.pideTexto("Introduce la matricula del vehiculo");
    String descripcion = sc.pideTexto("Introduce la descripcion del servicio");
    Vehiculo vehiculo;
    Servicio servicio = null;
    try {
        vehiculo = buscarVehiculo(matricula);

    } catch (UserNotFound e) {
        System.out.println(e.getMessage());
        vehiculo = null;
    }

    if (vehiculo != null) {
        if (mostrarVehiculo()) {
            String vehiculo = sc.pideTexto("Introduce el nombre del vehiculo: ");
            vehiculo = mostrarVehiculo(titulo);
            if (vehiculo != null) {

                trabajosRealizados.put(vehiculo);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                String fecha_formateada = LocalDateTime.now().format(formatter);
                System.out.printf("Fecha de prestamo: %s del libro: %s", fecha_formateada, vehiculo.getMatricula());

            } else {
                System.out.println("No hay ningun libro con ese titulo disponible!");
            }
        }
    } else {
        System.out.println("No existe el usuario con ese DNI!");
    }
    return (vehiculo != null && vehiculo != null) ? "Libro prestado correctamente" : "Error en el proceso.";
}

public void filtroTipoVehiculo() {
    FiltroTipoVehiculo filtroTipoServicio = null;
    boolean correcto;
    do {
        correcto = true;

        int opcion_servicio = sc.pedirNumero("1. Mantenimiento" +
                "\n2. cambio_aceite" +
                "\n3. pintura" +
                "\n4. frenos" +
                "\n5. electricidad" +
                "\nIntroduce la opcion del Tipo de servicio: ");

        switch (TipoServicio) {
            case 1:
                FiltroTipoVehiculo = TipoServicio.MANTENIMIENTO;
                break;
            case 2:
                FiltroTipoVehiculo = TipoServicio.CAMBIO_ACEITE;
                break;
            case 3:
                FiltroTipoVehiculo = TipoServicio.PINTURA;
                break;
            case 4:
                FiltroTipoVehiculo = TipoServicio.FRENOS;
                break;
            case 5:
                FiltroTipoVehiculo = TipoServicio.ELECTRICIDAD;
                break;
            default:
                correcto = false;
                System.out.println("Opcion no valida!");
                break;
        }
    } while (!correcto);

}

public String mostrarVehiculo() {
    if (!registrados.isEmpty()) {
        for (Libro libro : registrados) {
            System.out.println(libro);
        }
        boolean correcto;
        do {
            char opcion = sc.pedirLetra("¿quiere filtrar por TipoVehiculo? (S/N)");
            switch (opcion) {
                case 's':
                case 'S':
                    filtroTipoVehiculo();
                    correcto = true;
                    break;
                case 'n':
                case 'N':
                    correcto = true;
                    break;
                default:
                    correcto = true;
                    break;
            }
        } while (!correcto);
        return true;
    } else {
        System.out.println("No hay libros disponibles");
        return false;
    }
}

public void mostrarTrabajos() {
    for (Vehiculo user: Trabajos.keySet()) {
        System.out.printf("Prestamos: Usuario: %s, Libro: %s", user.getNombre(), Trabajos.get(user));

    }
}
public Vehiculo buscarVehiculo(String matricula) throws UserNotFound {
    for (Vehiculo vehiculo : vehiculos) {
        if (vehiculo.getMatricula().equals(matricula)) {
            return new Vehiculo();
        }
    }

    throw new UserNotFound("Usuario no encontrado!");
}


public Servicio buscarServicio(String descripcion) {
    for (Servicio servicio : disponibles) {
        if (Servicio.getDescripcion().equals(descripcion)) {
            return servicio;
        }
    }
    return null;
}







