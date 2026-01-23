package practica_3.src.clases;

import clases.Pelicula;
import enums.Genero;
import recursos.MyScanner;
import recursos.Utilidades;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GestionPeliculas {

    static ArrayList<Pelicula> peliculas = new ArrayList<>();
    static Map<Pelicula, Integer> visualizaciones = new HashMap<>();
    static MyScanner sc = new MyScanner();

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = sc.pedirNumero("Elige una opción:");

            switch (opcion) {
                case 1 -> registrarPelicula();
                case 2 -> mostrarPeliculas();
                case 3 -> verPelicula();
                case 4 -> mostrarEstadisticas();
                case 5 -> System.out.println("Saliendo....");
                default -> System.out.println("Opción incorrecta.Vuelva a intentarlo....");
            }
        } while (opcion != 5);
    }

    public static void mostrarMenu() {
        System.out.println("\n===== GESTIÓN DE PELÍCULAS =====");
        System.out.println("1. 📋Registrar película");
        System.out.println("2. 👁️Mostrar películas");
        System.out.println("3. 🧐Ver película");
        System.out.println("4. 📊Mostrar estadísticas de visualización");
        System.out.println("5. 🔚Salir");
        System.out.println("\n Introduzca la opción que desee: ");
    }

    public static void registrarPelicula() {

        String codigo;
        do {
            codigo = sc.pideTexto("Introduce el código de la película debe de tener TRES LETRAS MAYUSCULAS Y DOS NUMEROS: ").toUpperCase();
        } while (!validarCodigo(codigo));

        for (Pelicula p : peliculas) {
            if (p.getCodigo().equals(codigo)) {
                System.out.println("La película ya existe.");
                return;
            }
        }

        String titulo = sc.pideTexto("Inserte el título:");
        String director = sc.pedirSoloTexto("Inserte el director:");

        Genero genero = Utilidades.pedirEnum(
                Genero.class,
                "Introduce el género:"
        );

        String fechaTexto = sc.pideTexto("Fecha estreno (YYYY-MM-DD): ");
        LocalDate fechaEstreno = LocalDate.parse(fechaTexto);

        Pelicula pelicula = new Pelicula(
                codigo, titulo, director, genero, fechaEstreno
        );

        peliculas.add(pelicula);
        visualizaciones.put(pelicula, 0);

        System.out.println("✅Película registrada correctamente.");
    }

    public static boolean validarCodigo(String codigo) {
        String validadores = "^[A-Z]{3}[0-9]{2}$";

        if (codigo.matches(validadores)) {
            System.out.println("CODIGO INVALIDO. Ejemplo valido: DPR18");
            return false;
        }
        return true;
    }

    public static void mostrarPeliculas() {
        if (peliculas.isEmpty()) {
            System.out.println("❌No hay películas registradas.");
        } else {
            for (Pelicula p : peliculas) {
                System.out.println(p + " | Visualizaciones: " + visualizaciones.get(p));
            }
        }
    }

    public static void verPelicula() {
        String codigo = sc.pideTexto("Código de la película:").toUpperCase();

        for (Pelicula p : peliculas) {
            if (p.getCodigo().equals(codigo)) {
                visualizaciones.put(p, visualizaciones.get(p) + 1);
                registrarFichero(p);
                System.out.println("✅Visualización registrada de manera correcta.");
                return;
            }
        }

        System.out.println("❌Película no encontrada.");
    }

    public static void mostrarEstadisticas() {
        Utilidades.imprimirMap(visualizaciones);
    }

    public static void registrarFichero(Pelicula p) {

        String ruta = System.getProperty("user.home")
                + "/Desktop/DAM/Proyectos/Peliculas";

        Utilidades.crearDirectorio(ruta);

        File fichero = new File(ruta, "historial_peliculas.txt");
        if (comprobarDirectorio(ruta)) { try (FileWriter fw = new FileWriter(fichero, true)) {
            fw.write("----- VISUALIZACIÓN -----\n");
            fw.write("Fecha: " + LocalDate.now() + "\n");
            fw.write("Libro:\n");
            fw.write("\t Código: " + p.getCodigo() + "\n");
            fw.write("\t Título: " + p.getTitulo() + "\n");
            fw.write("\t Director: " + p.getDirector() + "\n");
            fw.write("------------------------\n");
        } catch (IOException e) {
            System.out.println("⚠️Error al escribir el archivo." + e.getMessage());
        }


        } else {
            System.out.println("ALGO A FALLADO!");

        }

    }

    public static boolean comprobarDirectorio(String ruta) {
        if (Utilidades.existeDirectorio(ruta)) {
            return true;
        } else {
            return Utilidades.existeDirectorio(ruta);
        }
    }

}
