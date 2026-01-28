package peliculas.clases;

import gestion_tienda.logica.MyScanner;
import peliculas.enums.Genero;
import recursos.Utilidades;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class GestionPeliculas {
    private static ArrayList<Pelicula> peliculas = new ArrayList<>();
    private static Map<Pelicula, Integer> visualizaciones = new LinkedHashMap<>();
    private static final MyScanner sc = new MyScanner();

    static void main(String[] args) {
        menu();
    }

    public static void menu() {
        boolean exit;
        do {
            exit = false;
            int opcion = sc.pedirNumero("\n== GESTIÓN DE PELICULAS ==" +
                    "\n1. Registrar pelicula" +
                    "\n2. Mostrar peliculas" +
                    "\n3. Ver peliculas" +
                    "\n4. Mostrar estadísticas de visualización" +
                    "\n5. Salir" +
                    "\nElige opcion: ");

            switch (opcion) {
                case 1:
                    registrarPelicula();
                    break;
                case 2:
                    mostrarPeliculas();
                    break;
                case 3:
                    verPeliculas();
                    break;
                case 4:
                    mostrarEstadisticas();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    exit = true;
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (!exit);
    }

    public static void registrarPelicula() {
        String codigo;
        do {
            codigo = sc.pideTexto("Introduce el codigo de la pelicula: ").toUpperCase();
            for (Pelicula pelicula : peliculas) {
                if (codigo.equals(pelicula.getCodigo())) {
                    System.out.println("La pelicula ya existe");
                    return;
                }
            }
        } while (!validarCodigo(codigo));

        String titulo = sc.pideTexto("Introduce el titulo de la pelicula: ");
        String autor = sc.pideTexto("Introduce el autor de la pelicula: ");
        Genero genero = Utilidades.pedirEnum(Genero.class, "Introduce el genero de la pelicula: ");
        String fechaEstreno = sc.pideTexto("Introduce la fecha de estreno de la pelicula (YYYY-MM-DD): ");

        LocalDate fecha = LocalDate.parse(fechaEstreno);

        Pelicula pelicula = new Pelicula(codigo, titulo, autor, genero, fecha);

        peliculas.add(pelicula);
        if (!visualizaciones.containsKey(pelicula)) {
            visualizaciones.put(pelicula, 0);
        }
        System.out.println("Se agrego la pelicula exitosamente");

    }

    public static boolean validarCodigo(String codigo) {
        String validadores = "^[A-Z]{3}[0-9]{3}$";

        if (!codigo.matches(validadores)) {
            System.out.println("Codigo no valido, debe empezar con tres letras y terminar con 3 numeros");
            return false;
        }
        return true;
    }

    public static void mostrarPeliculas() {
        if (!peliculas.isEmpty()) {
            for (Pelicula pelicula : peliculas) {
                System.out.println(pelicula);
            }
        } else {
            System.out.println("No hay peliculas que mostrar\n");
        }
    }

    public static void verPeliculas() {
        if (!peliculas.isEmpty()) {
            String codigo = sc.pideTexto("Introduce el codigo de la pelicula: ");
            Pelicula pelicula = getPelicula(codigo);
            if (pelicula != null) {
                char opcion = sc.pedirLetra("Desea ver esa pelicula?: (S/s - N/n)");
                switch (opcion) {
                    case 'S':
                    case 's':
                        sumarVisualizacion(pelicula);
                        generarFichero(pelicula);
                        System.out.println("Pelicula visualizada exitosamente");
                        break;
                    case 'N':
                    case 'n':
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
            } else {
                System.out.println("Esa pelicula no esta registrada");
            }
        } else {
            System.out.println("No hay peliculas que ver");
        }
    }

    public static Pelicula getPelicula(String codigo) {
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getCodigo().equals(codigo.toUpperCase())) {
                return pelicula;
            }
        }
        return null;
    }

    public static void sumarVisualizacion(Pelicula pelicula) {
        if (visualizaciones.containsKey(pelicula)) {
            visualizaciones.put(pelicula, visualizaciones.get(pelicula) + 1);
        } else {
            System.out.println("No se encuentra esa pelicula");
        }

    }

    public static void generarFichero(Pelicula pelicula) {
        String ruta = System.getProperty("user.home") + "/Desktop/DAM/Proyectos/Peliculas/";
        if (comprobarDirectorio(ruta)) {
            File archivo = new File(ruta + "historial_peliculas.txt");
            try (FileWriter fw = new FileWriter(archivo, true)) {
                fw.write("\n---- VISUALIZACIÓN ----\n");
                fw.write("Fecha visualización: " + LocalDate.now() + "\n");
                fw.write("Código: " + pelicula.getCodigo() + "\n");
                fw.write("Título:  " + pelicula.getTitulo() + "\n");
                fw.write("Director:  " + pelicula.getDirector() + "\n");
                fw.write("--------------------");
            } catch (IOException messi) {
                System.out.println("Error al crear el archivo " + messi.getMessage());
            }
        } else {
            System.out.println("Ha ocurrido algo, reintentalo");
        }
    }

    public static void mostrarEstadisticas() {
        if (!visualizaciones.isEmpty()) {
            for (Map.Entry<Pelicula, Integer> e : visualizaciones.entrySet()) {
                Pelicula pelicula = e.getKey();
                Integer visualizacion = e.getValue();
                System.out.printf("%s → %d%n", pelicula.getTitulo(), visualizacion);
            }
        } else {
            System.out.println("No hay estadisticas que mostrar");
        }
    }

    public static boolean comprobarDirectorio(String ruta) {
        if (Utilidades.existeDirectorio(ruta)) {
            return true;
        } else {
            return Utilidades.crearDirectorio(ruta);
        }

    }
}



