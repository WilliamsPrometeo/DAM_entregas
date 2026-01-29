package proyectos_gordos;

import proyectos_gordos.enums.Genero;
import proyectos_gordos.gestor_peliculas.Pelicula;
import proyectos_gordos.recursos.MyScanner;
import proyectos_gordos.recursos.Utilidades;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;


public class GestionPeliculas {

    public static final MyScanner sc = new MyScanner();
    public static final ArrayList<Pelicula> peliculas = new ArrayList<>();
    private static final Map<Pelicula, Integer> peliculas_map = new LinkedHashMap<>();


    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        boolean exit;
        do {
            exit = false;
            int opcion = sc.pedirNumero("######### GESTOR DE PELÍCULAS PLAYDEDE ##########" +
                    "\n1. Registrar película" +
                    "\n2. Mostrar película" +
                    "\n3. Ver película" +
                    "\n4. Mostrar estadísticas de visualizaciones" +
                    "\n5. Salir" +
                    "\nSeleccione la opción que desee: ");
            switch (opcion) {
                case 1:
                    registrarPelicula();
                    break;
                case 2:
                    mostrarPelicula();
                    break;
                case 3:
                    verPelicula();
                    break;
                case 4:
                    mostrarVisualizacion();
                    break;
                case 5:
                    System.out.println("Saliendo del gestor. Buenos días, buenas tardes, buenas noches.");
                    exit = true;
                    break;
                default:
                    System.out.println("Opción introducida no valida");
                    break;
            }

        } while (!exit);
    }

    public static void registrarPelicula() {
        String codigo;
        do {
            codigo = sc.pideTexto("Introduce cuatro letras y cuatro números").toUpperCase();
        } while (!validarCodigo(codigo));
        String titulo = sc.pideTexto("Introduce el título de la película: ");
        String director = sc.pideTexto("Introduce el director: ");
        Genero genero = Utilidades.pedirEnum(Genero.class, "Introduce el genero: ");
        String fechaEstreno = sc.pideTexto("Introduce la fecha de estreno (YYYY-MM-DD): ");
        LocalDate fecha = LocalDate.parse(fechaEstreno);

        Pelicula pelicula = new Pelicula(codigo, titulo, director, genero, fecha);

        if (peliculas_map.containsKey(pelicula)) {
            System.out.println("Esta pelicula ya la tenemos, gracias");
            return;
        }
        peliculas.add(pelicula);
        System.out.println("Has agregado una pelicula correctamente");

        peliculas_map.put(pelicula, 0);




    }

    public static boolean validarCodigo(String codigo) {
        String caracteres = "^[A-Z]{4}[0-9]{4}$";
        if (!codigo.matches(caracteres)) {
            System.out.println("Código de la pelicula no válido. Ejemplo válido: AAAA0123");
            return false;
        }
        return true;
    }

    public static void mostrarPelicula() {
        if (!peliculas.isEmpty()) {
            for (Pelicula pelicula : peliculas) {
                System.out.println(pelicula);
                System.out.println("visualizaciones: " + peliculas_map.get(pelicula));
                System.out.println("---------------------------");
            }
        } else {
            System.out.println("No hay películas que mostrar!!!");
        }
    }

    public static Pelicula getPelicula(String codigo) {
        for (Pelicula libro : peliculas) {
            if (libro.getCodigo().equals(codigo)) {
                return libro;
            }
        }
        return null;
    }


    public static void verPelicula() {
        String codigo = sc.pideTexto("Introduce el codigo: ").toUpperCase();
        Pelicula pelicula = getPelicula(codigo);
        if (pelicula != null) {
            System.out.println("nº de visualizaciones: ");
            peliculas_map.put(pelicula, peliculas_map.get(pelicula) + 1);
            registrarVisualizacion(pelicula);
            System.out.println(peliculas_map.get(pelicula));
        } else {
            System.out.println("La pelicula con este código no existe.");
        }
    }

//    public static void crearArchivoVisualizacion(Pelicula pelicula) {
//        String ruta = System.getProperty("user.home") + "/Desktop/DAM/Proyectos/Peliculas/";
//        if (comprobarDirectorio(ruta)) {
//            LocalDateTime fecha = LocalDateTime.now();
//            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
//            String fecha_formateada = dtf.format(fecha);
//            File archivo = new File(ruta + pelicula.getCodigo() + "-" + fecha_formateada + ".txt");
//
//            DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
//
//            try (FileWriter fw = new FileWriter(archivo)) {
//
//                fw.write("------Visualizacion-----\n");
//                fw.write("Fecha prestamo:" + dtf2.format(fecha) + "\n");
//                fw.write("Pelicula:\n");
//                fw.write("\tCódigo: " + pelicula.getCodigo() + "\n");
//                fw.write("\tTitulo: " + pelicula.getTitulo() + "\n");
//                fw.write("\tDirector: " + pelicula.getDirector() + "\n");
//                fw.write("------------------------");
//            } catch (IOException e) {
//                System.out.println("Error al escribir el archivo" + e.getMessage());
//            }
//        } else {
//            System.out.println("Algo a fallado. SOCORRO AYUDA!!!!");
//        }
//    }


    public static void registrarVisualizacion(Pelicula pelicula) {
        String ruta = System.getProperty("user.home") + "/Desktop/DAM/Proyectos/Peliculas/";
        if (comprobarDirectorio(ruta)) {
            File archivo = new File(ruta + "Historial_peliculas.txt");

            try (FileWriter fw = new FileWriter(archivo, true)) {

                fw.write("------Visualizacion-----\n");
                fw.write("Fecha visualizacion:" + LocalDateTime.now() + "\n");
                fw.write("\tPelicula:\n");
                fw.write("\tCódigo: " + pelicula.getCodigo() + "\n");
                fw.write("\tTitulo: " + pelicula.getTitulo() + "\n");
                fw.write("\tDirector: " + pelicula.getDirector() + "\n");
                fw.write("------------------------");
            } catch (IOException e) {
                System.out.println("Error al escribir el archivo" + e.getMessage());
            }

        } else {
            System.out.println("Algo a fallado. SOCORRO AYUDA!!!!");
        }
    }

    public static boolean comprobarDirectorio(String ruta) {
        if (Utilidades.existDirectory(ruta)) {
            return true;
        } else {
            return Utilidades.crearDirectorio(ruta);
        }

    }

    public static void mostrarVisualizacion() {

        for (Map.Entry<Pelicula, Integer> entry : peliculas_map.entrySet()) {
            System.out.println(entry.getKey() + "\tvisualizaciones: " + entry.getValue());
        }
    }

}
