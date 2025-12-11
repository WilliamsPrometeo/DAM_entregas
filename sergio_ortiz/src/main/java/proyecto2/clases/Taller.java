package recursos;

import clases.Servicio;
import clases.Vehiculo;

import static MyScanner.sc;


public class Taller {

    private static final MyScanner sc = new MyScanner();

    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Servicio> Catalogoservicios;
    Map<Vehiculo, Servicio> Trabajosrealizados;

    public Taller() {
        vehiculos = new ArrayList<>();
        Catalogoservicios = new ArrayList<>();
        Trabajosrealizados = new ArrayList<>();
    }

    public ArrayList<Vehiculo> getVehiculos() {
        ArrayList<Vehiculo> Vehiculos = new ArrayList<>();
        return Vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> disponibles) {
        this.vehiculos = Vehiculo;
    }

    public Map<Servicio, Vehiculo> get() {
        return (Map<Servicio, Vehiculo>) Trabajosrealizados;
    }

    public void setCatalogoservicios(Map<Servicio, Vehiculo> prestamos) {
        this.Catalogoservicios = Catalogoservicios;
    }

    public ArrayList<vehiculos> getUsuarios() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<vehiculos> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void registrarVehiculo {
        vehiculos = new Vehiculos();
        String Vehiculos.setModelo(sc.pedirSoloTexto("Introduce el modelo del vehiculo "));
        String Matricula = sc.pideTexto("Introduce la Matricula del vehiculo: ");
            String mensaje = Matricula.length() == 9 ? "Matricula correcta" : "La matricula tiene que tener 9 caracteres exactamente";
            System.out.println(mensaje);
        } while (matriculalength() != 9);
        Vehiculo.setmatricula(matricula);

        Vehiculo.add((Vehiculo) Vehiculo);
    }

    public void registrarServicio() {
        String servicio = sc.pideTexto("Introduce el tipo de servicio: ");
        Servicio servicio = null;
        boolean correcto;
        do {
            correcto = true;
            int opcion_servicio = sc.pedirNumero("1. MANTENIMIENTO" +
                    "\n2. CAMBIO_ACEITE" +
                    "\n3. PINTURA" +
                    "\n4. ELECTRICIDAD" +
                    "\n5. FRENOS" +
                    "\nIntroduce la opcion del servicio: ");
            switch (opcion_servicio) {
                case 1:
                    TipoServicio = TipoServicio.MANTENIMIENTO
                    break;
                case 2:
                    TipoServicio = TipoServicio.CAMBIO_ACEITE
                    break;
                case 3:
                    TipoServicio = TipoServicio.PINTURA
                    break;
                case 4:
                    TipoServicio = TipoServicio.ELECTRICIDAD
                    break;
                case 5:
                    TipoServicio = TipoServicio.FRENOS
                    break;
                default:
                    correcto = false;
                    System.out.println("Opcion no valida!");
                    break;
            }
        } while (!correcto);
        disponibles.add(new Taller(Vehiculo, Servicio,));
    }

    public String prestarLibro() {
        String dni = sc.pideTexto("Introduce el DNI del usuario: ");
        Usuario usuario;
        Libro libro = null;
        try {
            usuario = buscarUsuario(dni);

        } catch (UserNotFound e) {
            System.out.println(e.getMessage());
            usuario = null;
        }
        if (usuario != null) {
            if (mostarLibros()) {
                String titulo = sc.pideTexto("Introduce el titulo del libro: ");
                libro = buscarLibro(titulo);
                if (libro != null) {
                    disponibles.remove(libro);
                    prestamos.put(usuario, libro);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                    String fecha_formateada = LocalDateTime.now().format(formatter);
                    System.out.printf("Fecha de prestamo: %s del libro: %s", fecha_formateada, libro.getTitulo());
                } else {
                    System.out.println("No hay ningun libro con ese titulo disponible!");
                }
            }
        } else {
            System.out.println("No existe el usuario con ese DNI!");
        }
        return (usuario != null && libro != null) ? "Libro prestado correctamente" : "Error en el proceso.";
    }

    public boolean mostarLibros() {
        if (!disponibles.isEmpty()) {
            for (Libro libro : disponibles) {
                System.out.println(libro);
            }
            boolean correcto;
            do {
                char opcion = sc.pedirLetra("¿Quiere filtrar por Género? (S/N)");
                switch (opcion) {
                    case 'S':
                    case 's':
                        filtroGenero();
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
            System.out.println("No hay libros disponibles");
            return false;
        }
    }

    public void filtroGenero() {
        Genero genero = null;
        boolean correcto;
        do {
            correcto = true;
            int opcion_genero = sc.pedirNumero("1. Ficcion" +
                    "\n2. No ficcion" +
                    "\n3. Misterio" +
                    "\n4. Tecnico" +
                    "\n5. Romance" +
                    "\n6. Drama" +
                    "\nIntroduce la opcion del genero: ");
            switch (opcion_genero) {
                case 1:
                    genero = Genero.FICCION;
                    break;
                case 2:
                    genero = Genero.NO_FICCION;
                    break;
                case 3:
                    genero = Genero.MISTERIO;
                    break;
                case 4:
                    genero = Genero.TECNICO;
                    break;
                case 5:
                    genero = Genero.ROMANCE;
                    break;
                case 6:
                    genero = Genero.DRAMA;
                    break;
                default:
                    correcto = false;
                    System.out.println("Opcion no valida!");
                    break;
            }
        } while (!correcto);
        for (Libro libro : disponibles) {
            if (genero == libro.getGenero()) {
                System.out.println(libro);
            }
        }
    }

    public void mostarPrestamos() {
        for (Usuario user: prestamos.keySet()) {
            System.out.printf("Prestamo: Usuario: %s, Libro: %s", user.getNombre(), prestamos.get(user));
        }
    }

    public Usuario buscarUsuario(String dni) throws UserNotFound {
        for (Usuario usuario : usuarios) {
            if (usuario.getDni().equals(dni)) {
                return usuario;
            }
        }
        throw new UserNotFound("Usuario no encontrado");
    }

    public Libro buscarLibro(String titulo) {
        for (Libro libro : disponibles) {
            if (libro.getTitulo().equals(titulo)) {
                return libro;
            }
        }
        return null;
    }
}
