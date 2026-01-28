import proyecto03.Genero;
import proyecto03.MyScanner;
import proyecto03.Pelicula;
import proyecto03.Utilidades;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

static MyScanner sc = new MyScanner();
static ArrayList<Pelicula> peliculas = new ArrayList<>();
static Map<Pelicula, Integer> visualizaciones = new LinkedHashMap<>();
static Pelicula pelicula = new Pelicula();




public static void main(String[] args) {

    int opcion;
    do {
        System.out.println("\n--- Gestión Peliculas ---");
        System.out.println("1. Registrar Pelicula");
        System.out.println("2. Mostrar Pelicula");
        System.out.println("3. Ver Pelicula");
        System.out.println("4. Mostrar estadistica de visualizacion");
        System.out.println("5. Salir");
        opcion = sc.pedirNumero("Ingrese una opción: ");

        switch (opcion) {
            case 1:
                RegistrarPelicula();
                break;
            case 2:
                MostrarPeliculas();
                break;
            case 3:
                VerPeliculas();
                break;
            case 4:
                MostrarPeliculas();
                break;
            case 5:
                System.out.println("¡HASTA PRONTOO!");
                break;
            default:
                System.out.println(" Opción no válida. Intente nuevamente.");
        }

    } while (opcion != 5);
}


    public static void RegistrarPelicula() {

        String codigo;

        do {
            codigo = sc.pideTexto("Ingrese el codigo de la pelicula (3 letras y 3 numeros) : ").toUpperCase();
        } while (!validarCodigo(codigo));

        String titulo = sc.pideTexto("Introduce el titulo de la pelicula");
        String director = sc.pideTexto("Introduce el director de la pelicula");
        Genero genero = Utilidades.pedirEnum(Genero.class, sc.pideTexto("Digite cualquier tecla para continuar e introduce el genero: "));
        String fecha_publicacion = sc.pideTexto("Introduce el fecha de publicacion (YYYY-MM-DD)");
        LocalDate fecha_estreno = LocalDate.parse(fecha_publicacion);
        Pelicula pelicula = new Pelicula(codigo, titulo, director, genero, fecha_estreno );

        if (peliculas.contains(pelicula)) {
            System.out.println("La pelicula ya existe");
            return;
        }
        peliculas.add(pelicula);
        System.out.println("Pelicula añadida correctamente");
    }

    public static void MostrarPeliculas() {

        if (peliculas.isEmpty()) {
            System.out.println(" No hay peliculas registradas.");
        } else {
            System.out.println("\n Lista de peliculas:");
            for (Pelicula pelicula : peliculas) {
                System.out.println("-----------------------------------");
                System.out.println("Codigo: " + pelicula.getCodigo());
                System.out.println("Título: " + pelicula.getTitulo());
                System.out.println("Director: " + pelicula.getDirector());
                System.out.println("Genero: " + pelicula.getGenero());
                System.out.println("Fecha de estreno: " + pelicula.getFechaEstreno());
            }
            System.out.println("-----------------------------------");
        }
    }

    public static void VerPeliculas() {
        String codigo;
        do {
            codigo = sc.pideTexto("Ingrese el codigo de la pelicula : ").toUpperCase();
        }while (!validarCodigo(codigo));
        Pelicula pelicula = getPelicula(codigo);

        if (pelicula != null) {
            if (visualizaciones.containsKey(pelicula)) {
                visualizaciones.put(pelicula, visualizaciones.get(pelicula)+1);
            }


            registrarVisualizacion(pelicula);

            System.out.println("Visualizacion registrada correctamente");
        }
    }



    public static boolean validarCodigo(String isbn) {

    String validadores = "^[A-Z]{3}[0-9]{3}$";

    if (!isbn.matches(validadores)) {
        System.out.println("Codigo incorrecto. Ejemplo válido: ABC123");
        return false;
    }
    return true;
    }

public static Pelicula getPelicula(String codigo) {
    for (Pelicula pelicula : peliculas) {
        if (pelicula.getCodigo().equals(codigo)) {
            return pelicula; //
        }
    }
    return null;
}

public static void crearFichero(Pelicula pelicula) {

    String ruta = System.getProperty("user.home") + "/Desktop/DAM/Proyectos/Peliculas";

    if (comprobarDirectorio(ruta)) {

        LocalDateTime fecha = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyy");
        String fecha_formateada = formatter.format(fecha);

        File archivo = new File(ruta + pelicula.getCodigo() + fecha_formateada + ".txt");

        try (FileWriter fw = new FileWriter(archivo)) {

            fw.write("--------VISUALIZACION--------\n");
            fw.write("Fecha: " + LocalDateTime.now() + "\n");
            fw.write("\tCodigo: " + pelicula.getCodigo() + "\n");
            fw.write("\tTitulo: " + pelicula.getTitulo() + "\n");
            fw.write("\tDirector: " + pelicula.getDirector() + "\n");
            fw.write("----------------------");

        } catch (IOException e) {
            System.out.println("Error al escribir el archivo " + e.getMessage());
        }
    } else {
        System.out.println("El archivo no existe!");
    }
}
public static boolean comprobarDirectorio(String ruta) {


    if (Utilidades.existDirectory(ruta)) {
        return true;
    } else {

        return Utilidades.crearDirectorio(ruta);
    }
}

public static void registrarVisualizacion(Pelicula pelicula) {

    String ruta = System.getProperty("user.home") + "/Desktop/DAM/Proyectos/peliculas.txt/";


    if (comprobarDirectorio(ruta)) {

        File archivo = new File(ruta + "historial_peliculas.txt");


        try (FileWriter fw = new FileWriter(archivo, true)) {

            fw.write("--------VISUALIZACION--------\n");
            fw.write("Fecha: " + LocalDateTime.now() + "\n");
            fw.write("\tCodigo: " + pelicula.getCodigo() + "\n");
            fw.write("\tTitulo: " + pelicula.getTitulo() + "\n");
            fw.write("\tDirector: " + pelicula.getDirector() + "\n");
            fw.write("----------------------");

        } catch (IOException e) {
            System.out.println("Error al escribir el archivo " + e.getMessage());
        }
    } else {
        System.out.println("El archivo no existe!");
    }
}

public static void mostrarVisualizacion(Pelicula pelicula) {

    for (Pelicula v : visualizaciones.keySet()) {
        System.out.println("Pelicula: " + v);
    }
}






