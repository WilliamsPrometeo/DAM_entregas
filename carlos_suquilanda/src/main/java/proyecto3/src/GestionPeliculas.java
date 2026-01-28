package proyecto3.src;



import proyecto3.src.clases.Pelicula;
import proyecto3.src.clases.enums.Genero;
import proyecto3.src.recursos.MyScanner;
import proyecto3.src.recursos.Utilidades;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class GestionPeliculas {
    private static final MyScanner sc = new MyScanner();
    private static ArrayList<Pelicula> peliculas = new ArrayList<>();
    private static Map<Pelicula, Integer> visuzalizaciones = new LinkedHashMap<>();
    public GestionPeliculas() {}

    public static void main(String[] args) {menu();}

    public static void menu() {
        boolean salir;
        do {
            salir = false;
            int opcion =sc.pedirNumero("========== GESTION DE PELÍCULAS ===========" +
                    "\n 1. Registrar Película" +
                    "\n 2. Mostrar Película" +
                    "\n 3. Ver Película" +
                    "\n 4. Mostrar estadísticas de visualización" +
                    "\n 5. Salir" +
                    "\n 👉 OPCIÓN: ");
            switch (opcion) {
                case 1:
                    registrarPelicula();
                    break;
                case 2:
                    mostrarPeliculas();
                    break;
                case 3:
                    verPelicula();
                    break;
                case 4:
                    mostrarPeliculas();
                    break;
                case 5:
                    System.out.println("Saliendo del programa ...");
                    salir = true;
                    break;
                default:
                    System.out.println("❌ Opción no valida!");
            }

        } while (!salir);
    }

    public static void registrarPelicula() {
        String codigo;
        do {
            codigo= sc.pideTexto("Introduzca el codigo de la pelicula (5 números y 2 letras): ").toUpperCase();
        } while (!verificarCodigo(codigo));
        String titulo = sc.pideTexto("Titulo: ");
        String director = sc.pideTexto("Director: ");
        Genero genero = Utilidades.pedirEnum(Genero.class,"Genero:");
        String fecha_Estreno= sc.pideTexto("Fecha Estreno (YYYY-MM-DD): ");
        LocalDate fecha = LocalDate.parse(fecha_Estreno);

        Pelicula pelicula = new Pelicula(codigo,titulo,director,genero,fecha);

        if (peliculas.contains(pelicula)){
            System.out.println("El película ya existe!");
            return;
        }

        peliculas.add(pelicula);
        System.out.println("La película se ha registrado correctamente!");

        visuzalizaciones.put(pelicula,0);

    }

    public static boolean verificarCodigo(String codigo) {

        String veriicaciones = "^[0-9]{5}[A-Z]{2}$";

        if (!codigo.matches(veriicaciones)) {
            System.out.println("El codigo es incorrecto. (EJEMPLO VALIDO: 12345CO");
            return false;
        }
        return true;
    }

    public static void mostrarPeliculas() {
        if (!peliculas.isEmpty()){
            for (Pelicula pelicula : peliculas) {
                System.out.print(pelicula);
                System.out.println("NÚMERO DE VISUALIZACIONES: " + visuzalizaciones.get(pelicula));;
            }
        } else {
            System.out.println("No hay películas que mostrar");
        }
    }

    public static void verPelicula() {
        String codigo = sc.pideTexto("Codigo de la pelicula que desea ver: ");
        Pelicula pelicula = getPelicula(codigo);
        if (pelicula != null){
            visuzalizaciones.put(pelicula,+1);
            System.out.println("Película vista correctamente!");
        }

    }

    public static Pelicula getPelicula(String codigo) {
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getCodigo().equals(codigo)) {
                return pelicula;
            }
        }
        return null;
    }

    public static void crearRegistroVisualizacion (Pelicula pelicula) {
        String ruta = System.getProperty("user.home") + "/Descktop/DAM/Proyectos/Peliculas/";
        if (verificarDirectorio(ruta)) {
            File archivo = new File(ruta + "historial_peliculas.txt");

            try (FileWriter fw = new FileWriter(archivo, true)) {

                fw.write("----- VISUALIZACIÓN -----");
                fw.write("Fecha: " + LocalDate.now() + "\n");
                fw.write("Código: " + pelicula.getCodigo() + "\n");
                fw.write("Título: " + pelicula.getTitulo() + "\n");
                fw.write("Director: " + pelicula.getDirector() + "\n");
                fw.write("------------------------");

            } catch (IOException e) {
                System.out.println("Error al visualizar la película" + e.getMessage());
            }

        } else  {
            System.out.println("Algo ha fallado!");
        }
    }

    public static boolean verificarDirectorio(String ruta) {
        if (Utilidades.existeArchivo(ruta)) {
            return true;
        } else  {
            return Utilidades.crearDirectorio(ruta);
        }
    }

    public static void mostrarEstadisticas() {
        for (Map.Entry<Pelicula,Integer> e : visuzalizaciones.entrySet()) {
            Pelicula pelicula = e.getKey();
            System.out.printf("%s");

        }

    }
}
