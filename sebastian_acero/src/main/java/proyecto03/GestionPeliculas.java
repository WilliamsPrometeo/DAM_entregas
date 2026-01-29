package proyecto03;

import proyecto03.clases.Pelicula;
import proyecto03.enums.Genero;
import proyecto03.utilidades.MyScanner;
import proyecto03.utilidades.Utilidades;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GestionPeliculas {
    private static final MyScanner sc = new MyScanner();
    private static ArrayList<Pelicula> peliculas = new ArrayList<>();
    private static Map<Pelicula, Integer> visualizaciones = new HashMap<>();

    public static void main(String[] args) {
        menu();

    }

    public static void menu() {
        boolean exit;
        do {
            exit = false;
            int opcion = sc.pedirNumero("======Gestion Peliculas=======" +
                    "\n1. Resgitrar Pelicula" +
                    "\n2. Mostrar Peliculas" +
                    "\n3. Ver peliculas" +
                    "\n4. Mostrar estadistica de visualización" +
                    "\n5. Salir" +
                    "\nInserte la opcion que desee: ");

            switch (opcion) {
                case 1:
                    registrarPelicula();
                    break;
                case 2:
                    mostrarpeliculas();
                    break;
                case 3:
                    verPelicula();
                    break;
                case 4:
                    mostrarEstaditicas();
                    break;
                case 5:
                    System.out.println("Saliendo ...");
                    exit = true;
                    break;
                default:
                    System.out.println("opcion no valida!");
                    break;
            }
        } while (!exit);
    }

    public static void registrarPelicula() {
        String codigo;
        do {
            codigo = sc.pideTexto("Ingrese una codigo(letra y numeros)").toUpperCase();
        } while (!validarcodigo(codigo));
        String titulo = sc.pideTexto("Ingrese el titulo: ");
        String director = sc.pideTexto("Ingrese el director: ");
        Genero genero = Utilidades.pedirEnum(Genero.class, "Ingrese el genero: ");
        String fecha_estreno = sc.pideTexto("Ingrese el fecha de estreno: ");
        LocalDate fecha = LocalDate.parse(fecha_estreno);

        Pelicula pelicula = new Pelicula(codigo, titulo, director, genero, fecha);

        if ((visualizaciones.containsKey(pelicula))) {
            System.out.println("Pelicula ya existe!!!!");
            return;
        }

        peliculas.add(pelicula);
        System.out.println("La pelicula fue agregada exitosamente");

        int visualizaciones_pelicula = sc.pedirNumero("Ingrese el codigo de la peliculas: ");
        visualizaciones.put(pelicula, visualizaciones_pelicula);
    }

    public static boolean validarcodigo(String codigo) {

        String validadores = "^[A-Z]{3}[0-9]{2}$";

        if (!codigo.matches(validadores)) {
            System.out.println("El codigo introducido no es valido");
            return false;
        }
        return true;
    }

    public static void mostrarpeliculas() {
        if (!peliculas.isEmpty()) {
            for (Pelicula pelicula : peliculas) {
                System.out.println(pelicula);
                System.out.println("Nº peliculas: " + visualizaciones.get(pelicula));
                System.out.println("--------------------------------");
            }
        } else {
            System.out.println("No hay peliculas que mostrar");
        }
    }

    public static void gestionarPeliculas() {
        String codigo = sc.pedirSoloTexto("Ingrese codigo de la pelicula: ").toUpperCase();
        Pelicula pelicula = getPelicula(codigo);
        if (pelicula != null) {
            int nueva_pelicula = sc.pedirNumero("Ingrese nueva visualizacion: " + pelicula.getTitulo() + ": ");
            if (nueva_pelicula > 0) {
                visualizaciones.put(pelicula, nueva_pelicula);
                System.out.println("Peliculas actualizadas exitosamente");
            } else {
                System.out.println("No puede ser un numero negativo!!!");
            }
        } else {
            System.out.println("No hay peliculas que mostrar");
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

    public static void verPelicula(){
        String codigo = sc.pideTexto("Ingrese el codigo de la pelicula: ");
        Pelicula pelicula = getPelicula(codigo);
        if (pelicula != null) {
            visualizaciones.put(pelicula, visualizaciones.get(pelicula) - 1);
            registrarPelicula();
            System.out.println("Pelicula vista exitosamente");
        } else {
            System.out.println("Pelicula ya fue vista");
        }
    }

    public static void mostrarEstaditicas() {
        for (Pelicula v: visualizaciones.keySet()) {
            System.out.println("pelicula: " + v);
            System.out.println("estadistica: " + visualizaciones.get(v));

        }
    }

    public static void crearArchivoPelicula(Pelicula pelicula) {
        String ruta = System.getProperty("user.home") + "/Desktop/DAM/Proyectos/Peliculas/";
        if (comprobarDirectorio(ruta)) {
        LocalDateTime fecha = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        String fecha_formateada = formatter.format(fecha);
        File archivo = new File(ruta + pelicula.getCodigo() + "-" + fecha_formateada + ".txt");

        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try (FileWriter fw = new FileWriter(archivo)) {
            fw.write("------- VISUALIZACIÓN ------\n");
            fw.write("Fecha: " + formatter2.format(fecha) + "\n");
            fw.write("\tCodigo: " + pelicula.getCodigo() + "\n");
            fw.write("\tTitulo: " + pelicula.getTitulo() + "\n");
            fw.write("\tDirector: " + pelicula.getDirector() + "\n");
            fw.write("----------------------------");
        } catch (IOException e) {
            System.out.println("Error al crear el archivo" + e.getMessage());
        }
    } else {
        System.out.println("Algo ha fallado");
    }
}

public static void registrarPelicula(Pelicula pelicula) {
        String ruta = System.getProperty("user.home") + "/Desktop/DAM/Proyectos/Peliculas/";
        if (comprobarDirectorio(ruta)) {
            File archivo = new File(ruta + "historial_peliculas.txt");

            try (FileWriter fw = new FileWriter(archivo)) {
                fw.write("------- VISUALIZACIÓN ------\n");
                fw.write("Fecha: " + LocalDate.now() + "\n");
                fw.write("\tCodigo: " + pelicula.getCodigo() + "\n");
                fw.write("\tTitulo: " + pelicula.getTitulo() + "\n");
                fw.write("\tDirector: " + pelicula.getDirector() + "\n");
                fw.write("----------------------------");
            } catch (IOException e) {
                System.out.println("Error al crear el archivo" + e.getMessage());
            }
        } else {
            System.out.println("Algo ha fallado");
        }
    }

    private static boolean comprobarDirectorio(String ruta) {
        if (Utilidades.existDirectory(ruta)) {
            return true;
        } else {
            return Utilidades.crearDirectorio(ruta);
        }
    }
}


