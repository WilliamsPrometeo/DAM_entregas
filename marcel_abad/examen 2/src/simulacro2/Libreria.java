package simulacro2;

import simulacro2.MyScanner;
import simulacro2.enums.Genero;
import simulacro2.exception.UserNotFound;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Clase que representa una librería que gestiona usuarios, libros disponibles y préstamos.
 * Permite registrar usuarios, registrar libros, prestar libros, filtrar por género y consultar préstamos.
 *
 * @author Nombre del Alumno
 * @version 1.0
 */
public class Libreria {

    /**
     * Escáner personalizado para leer datos desde entrada estándar.
     * Es {@code static final} para compartir la misma instancia en todas
     * las instancias de Libreria.
     */
    private static final MyScanner sc = new MyScanner();

    /** Lista de libros actualmente disponibles para prestar. */
    private ArrayList<Libro> disponibles;

    /** Mapa que asocia un usuario con el libro que tiene prestado. */
    private Map<Usuario, Libro> prestamos;

    /** Lista de usuarios registrados en la librería. */
    private ArrayList<Usuario> usuarios;

    /**
     * Constructor por defecto. Inicializa las colecciones vacías.
     */
    public Libreria() {
        // Lista de libros disponibles inicializada vacía.
        disponibles = new ArrayList<>();
        // Usamos LinkedHashMap para preservar el orden de inserción de prestamos.
        prestamos = new LinkedHashMap<>();
        // Lista de usuarios inicializada vacía.
        usuarios = new ArrayList<>();
    }

    /* ----------------- GETTERS Y SETTERS ----------------- */

    /**
     * Devuelve la lista de libros disponibles.
     * @return lista de libros disponibles
     */
    public ArrayList<Libro> getDisponibles() {
        return disponibles;
    }

    /**
     * Asigna una nueva lista de libros disponibles.
     * @param disponibles nueva lista de libros
     */
    public void setDisponibles(ArrayList<Libro> disponibles) {
        this.disponibles = disponibles;
    }

    /**
     * Devuelve el mapa de préstamos (Usuario -> Libro).
     * @return mapa de préstamos
     */
    public Map<Usuario, Libro> getPrestamos() {
        return prestamos;
    }

    /**
     * Asigna un nuevo mapa de préstamos.
     * @param prestamos nuevo mapa de préstamos
     */
    public void setPrestamos(Map<Usuario, Libro> prestamos) {
        this.prestamos = prestamos;
    }

    /**
     * Devuelve la lista de usuarios registrados.
     * @return lista de usuarios
     */
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * Asigna una nueva lista de usuarios.
     * @param usuarios nueva lista de usuarios
     */
    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    /* ----------------- OPERACIONES DE REGISTRO ----------------- */

    /**
     * Registra un nuevo usuario pidiendo nombre y DNI por consola.
     * Valida que el DNI tenga exactamente 9 caracteres.
     * El usuario se añade a la lista {@code usuarios}.
     */
    public void registrarUsuario() {
        // Creamos una instancia de Usuario (hereda de Persona en tu diseño).
        Persona usuario = new Usuario();

        // Pedimos el nombre al usuario por consola.
        usuario.setNombre(sc.pedirSoloMns("Introduce el nombre del usuario: "));

        // Variable para almacenar el DNI introducido.
        String dni;
        // Bucle que repite hasta que el DNI tenga longitud 9.
        do {
            dni = sc.pideTexto("Introduce el DNI del usuario: ");
            String mensaje = dni.length() == 9 ? "DNI correcto" : "El DNI tiene que tener exactamente 9 caracteres";
            System.out.println(mensaje);
        } while (dni.length() != 9);

        // Asignamos el DNI validado.
        usuario.setDni(dni);

        // Añadimos el nuevo usuario a la lista (hace cast a Usuario).
        usuarios.add((Usuario) usuario);

    }

    /**
     * Registra un nuevo libro pidiendo título, autor y género por consola.
     * Añade el libro creado a la lista {@code disponibles}.
     */
    public void registarLibro() {
        // Pedimos título y autor utilizando métodos del escáner.
        String titulo = sc.pedirSoloMns("Introduce la titulo del libro: ");
        String autor = sc.pedirSoloMns("Introduce el autor del libro: ");

        // Variable para guardar el género seleccionado.
        Genero genero = null;
        boolean correcto;
        // Bucle para pedir la opción de género hasta que sea válida.
        do {
            correcto = true;
            int opcion_genero = sc.pedirNumero2("1. Ficción" +
                    "\n2. No ficción" +
                    "\n3. Misterio" +
                    "\n4. Tecnico" +
                    "\n5. Romance" +
                    "\n6. Drama" +
                    "\nIntroduce la opción del genero: ");
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
                    genero = Genero.ROMANCE; // Observa: en el enum puede que el orden sea distinto
                    break;
                case 5:
                    genero = Genero.TECNICO;
                    break;
                case 6:
                    genero = Genero.DRAMA;
                    break;
                default:
                    // Opción no válida: repetimos el bucle.
                    correcto = false;
                    System.out.println("Opción no valida");
                    break;
            }
        } while (!correcto);

        // Añadimos el nuevo libro a la lista de disponibles.
        disponibles.add(new Libro(titulo, autor, genero));

    }

    /* ----------------- OPERACIONES DE PRÉSTAMO ----------------- */

    /**
     * Realiza el préstamo de un libro a un usuario identificado por su DNI.
     *
     * El método busca el usuario por DNI (lanza UserNotFound si no existe),
     * muestra los libros disponibles y permite seleccionar un título. Si el
     * libro existe y está disponible se registra el préstamo en el mapa
     * {@code prestamos} y se elimina de {@code disponibles}.
     *
     * @return mensaje indicando éxito o fallo del proceso
     */
    public String prestarLibro() {
        // Pedimos el DNI del usuario.
        String dni = sc.pideTexto("Introduce la DNI del usuario: ");
        Usuario usuario;
        Libro libro = null;
        try {
            // Intentamos buscar el usuario; si no existe lanzará UserNotFound.
            usuario = buscarUsuario(dni);

        } catch (UserNotFound e) {
            // Capturamos la excepción y avisamos por consola.
            System.out.println("Usuario no encontrado");
            usuario = null;
        }
        // Si el usuario existe continuamos con la operación.
        if (usuario != null) {
            // Mostramos los libros disponibles; si hay al menos uno, continuar.
            if (mostrarLibros()) {
                // Pedimos el título del libro que desea el usuario.
                String titulo = sc.pedirSoloMns("Introduce el titulo del libro: ");
                // Buscamos el libro por título.
                libro = buscarLibro(titulo);
                if (libro != null) {
                    // Si el libro está disponible, lo quitamos de la lista de disponibles.
                    disponibles.remove(libro);
                    // Registramos el préstamo en el mapa usuario->libro.
                    prestamos.put(usuario, libro);
                    // Formateamos la fecha y la mostramos.
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                    String fecha_formateada = LocalDateTime.now().format(formatter);
                    System.out.printf("Fecha de prestamo: %s del libro %s ", fecha_formateada, libro.getTitulo());
                } else {
                    // No existe libro con ese título en disponibles.
                    System.out.println("No hay ningún libro con ese titulo disponible!");
                }
            }
        } else {
            // Usuario no encontrado: informamos.
            System.out.println("No existe Usuario con ese DNI!");
        }
        // Devolvemos mensaje según si el préstamo se completó correctamente.
        return (usuario != null && libro != null) ? "Libro prestado correctamente" : "Error en el proceso";
    }



    /**
     * Muestra por consola los libros disponibles y permite filtrar por género.
     *
     * @return {@code true} si había libros para mostrar (y se mostró el listado),
     *         {@code false} si no hay libros disponibles.
     */
    public boolean mostrarLibros(){
        // Atención: el bloque original contiene una condición invertida.
        // Aquí la corregimos: si la lista NO está vacía mostramos los libros.
        if (!disponibles.isEmpty()) {
            // Recorremos e imprimimos cada libro disponible.
            for (Libro libro : disponibles) {
                System.out.println(libro);
            }
            boolean correcto;
            // Preguntamos al usuario si desea filtrar por género.
            do {
                char opcion = sc.pedirLetra("¿Quiere filtrar por Género?");
                switch (opcion) {
                    case 's' :
                    case 'S':
                        filtroGenero();
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
            // No hay libros disponibles.
            System.out.println("No hay libros disponibles");
            return false;
        }
    }

    /**
     * Filtra e imprime los libros disponibles según el género elegido por consola.
     */
    public void filtroGenero(){
        Genero genero = null;
        boolean correcto;
        // Bucle para solicitar la opción de género hasta recibir una válida.
        do {
            correcto = true;
            int opcion_genero = sc.pedirNumero2("1. Ficción" +
                    "\n2. No ficción" +
                    "\n3. Misterio" +
                    "\n4. Tecnico" +
                    "\n5. Romance" +
                    "\n6. Drama" +
                    "\nIntroduce la opción del genero: ");
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
                    genero = Genero.ROMANCE;
                    break;
                case 5:
                    genero = Genero.TECNICO;
                    break;
                case 6:
                    genero = Genero.DRAMA;
                    break;
                default:
                    correcto = false;
                    System.out.println("Opción no valida");
                    break;
            }
        } while(!correcto);

        // Recorremos y mostramos sólo los libros que coinciden con el género.
        for (Libro libro : disponibles) {
            if (genero == libro.getGenero()) {
                System.out.println(libro);
            }
        }
    }

    /**
     * Muestra por consola todos los préstamos registrados (usuario y su libro).
     */
    public void mostrarPrestamos(){
        // Recorremos las claves del mapa (usuarios) e imprimimos la relación.
        for (Usuario user : prestamos.keySet()) {
            System.out.printf("Prestamo: Usuario: %s, Libro: %s", user.getNombre(), prestamos.get(user));
        }
    }

    /**
     * Busca y devuelve un usuario por su DNI dentro de la lista de usuarios.
     *
     * @param dni DNI del usuario a buscar
     * @return {@code Usuario} encontrado
     * @throws UserNotFound si no existe ningún usuario con ese DNI
     */
    public Usuario buscarUsuario(String dni) throws UserNotFound {
        // Recorremos la lista de usuarios y comparamos por DNI.
        for (Usuario usuario : usuarios) {
            if (usuario.getDni().equals(dni)) {
                return usuario;
            }
        }
        // Si no encontramos al usuario lanzamos excepción personalizada.
        throw new UserNotFound("Usuario no encontrado");
    }

    /**
     * Busca y devuelve un libro disponible por su título.
     *
     * @param titulo título del libro a buscar
     * @return {@code Libro} encontrado o {@code null} si no existe en disponibles
     */
    public Libro buscarLibro(String titulo)  {
        // Recorremos la lista de libros disponibles y comparamos títulos.
        for (Libro libro : disponibles) {
            if (libro.getTitulo().equals(titulo)) {
                return libro;
            }
        }
        // Si no lo encontramos devolvemos null.
        return null;
    }
}
