package clases;

import enums.Genero;
import recursos.MyScanner;
import recursos.Utilidades;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class GestionPeliculas {

    private static final MyScanner sc = new MyScanner();
    private static ArrayList<Peliculas> pelicula = new ArrayList<>();
    private static Map<Peliculas, Integer> visualizaciones = new LinkedHashMap<>();

    public static void main(String[] args) {
        menu(); }

        public static void menu(){

            boolean exit;
            do{
                exit = false;
                int opcion = sc.pedirNumero2(
            "===== GESTIÓN DE PELÍCULAS =====" +
                    "\n1. Registrar película" +
                    "\n2. Mostrar películas" +
                    "\n3. Ver película" +
                    "\n4. Mostrar estadísticas de visualización" +
                    "\n5. Salir" +
                    "\nInserte la opcion que desee: ");

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
                    mostrarEstadisticas();
                    break;
                case 5:
                    System.out.println("Saliendo ....");
                    exit = true;
                    break;
                default:
                    System.out.println("Opcion no valida!");
                    break;
            }
        } while (!exit);
    }

    public static void registrarPelicula() {

        String codigo;

        do{
            codigo = sc.pideTexto("Introduce el codigo de la pelicula (3 Letras y 3 Numeros): ").toUpperCase();
        } while (!validarCodigo(codigo));

        String titulo = sc.pideTexto("Introduce el titulo del pelicula: ");
        String director = sc.pideTexto("Introduce el director de la pelicula: ");
        Genero genero = Utilidades.pedirEnum(Genero.class, "Introduce el genero de la pelicula: ");
        String fechaEstreno = sc.pideTexto("Introduce la fecha publicacion(YYYY-MM-DD): ");
        LocalDate fecha = LocalDate.parse(fechaEstreno);

        Peliculas peliculas = new Peliculas(codigo, titulo, director, genero, fecha);

        if (visualizaciones.containsKey(peliculas)) {

            System.out.println("La pelicula ya existe!");
            return;
        }

        pelicula.add(peliculas);
        visualizaciones.put(peliculas, 0);
            System.out.println("La pelicula ha sido agregada correctamente!");

        }

    public static boolean validarCodigo(String codigo) {

        String validadores = "[A-Z]{3}[0-9]{3}";

        if (!codigo.matches(validadores)) {
            System.out.println("El codigo de la pelicula no es valido!");
            return false;
        }
        return true;
    }

    public static void mostrarPelicula() {

        if (!pelicula.isEmpty()) {
            for (Peliculas peliculas : pelicula) {
                System.out.println(peliculas);
                System.out.println("------------------");
            }
        } else {
            System.out.println("La pelicula no ha sido encontrada.");
        }
    }

    public static void verPelicula() {

        String codigo = sc.pideTexto("Introduce el codigo de la pelicula: ").toUpperCase();
        Peliculas peliculas = getPeliculas(codigo);
        if (peliculas != null) {
            if (visualizaciones.containsKey(peliculas)) {
                int nueva_visualizacion = visualizaciones.get(peliculas)+1;
                visualizaciones.put(peliculas, nueva_visualizacion);
                System.out.println("La visualizacion se ha añadido correctamente!");
            }
        } else {
            System.out.println("La pelicula no ha sido encontrada.");
        }
        escrituraFichero(peliculas);
    }


    public static Peliculas getPeliculas(String codigo) {
        for (Peliculas peliculas : pelicula) {
            if (peliculas.getCodigo().equals(codigo)) {
                return peliculas;
            }
        }
        return null;
    }
    public static void mostrarEstadisticas () {

        for (Peliculas v : visualizaciones.keySet()) {
            System.out.println("Pelicula: " + v);
            System.out.println("Pelicula estadisticas: " + visualizaciones.get(v));
        }

    }

//        if (!pelicula.isEmpty()) {
//            for (Peliculas peliculas : pelicula) {
//                System.out.println(peliculas);
//                System.out.println("Visualizaciones: " + visualizaciones.get(peliculas));
//                System.out.println("----------------------");
//            }
//        } else {
//            System.out.println("No hay peliculas para mostrar");
//        }
//    }

    public static void escrituraFichero(Peliculas peliculas) {
        String ruta = System.getProperty("user.home") + "/Desktop/DAM/Proyectos/Peliculas/";

        if(comprobarDirectorio(ruta)) {
            File archivo = new File(ruta + "historial_peliculas.txt");

            try (FileWriter fw = new FileWriter(archivo,true)) {
                fw.write("----- VISUALIZACIÓN -----\n");
                fw.write("Fecha: " + LocalDateTime.now() + "\n");
                fw.write("\tCódigo: " + peliculas.getCodigo() +"\n" );
                fw.write("Título: " + peliculas.getTitulo() + "\n");
                fw.write("Director: " + peliculas.getDirector() + "\n");
                fw.write("------------------------");

            } catch (IOException e){
                System.out.println("Error al abrir el archivo: " + e.getMessage());
            }
        } else {
            System.out.println("El archivo no existe!");
        }
    }

    public static boolean comprobarDirectorio(String ruta) {

        if (Utilidades.existDirectory(ruta)) {
            return true;
        } else {
            // Si no existe, lo crea
            return Utilidades.crearDirectorio(ruta);
        }
    }


}

