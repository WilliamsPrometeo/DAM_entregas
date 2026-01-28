package practica03;

import recursos.MyScanner;
import recursos.Utilidades;
import segunda_evaluacion.libreria.clases.Libro;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GestionPeliculas {

    private static final MyScanner sc =  new MyScanner();
    private static ArrayList<Pelicula> peliculas = new ArrayList<>();
    private static Map<Pelicula, Integer> visualizaciones = new HashMap<>();

    public static void main(String[] args) {
        menu();
    }

    public static void menu (){
        boolean exit;
        do {
            exit = false;
            int opcion = sc.pedirNumero("===== GESTION DE PELICULAS =====" +
                    "\n1. Registrar Pelicula" +
                    "\n2. Mostrar peliculas" +
                    "\n3. Ver pelicula" +
                    "\n4. Mostrar estadistica de visualizacion" +
                    "\n5. Salir" +
                    "\nInserte la opcion que desee: ");
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
                    mostrarEstadistica();
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

    public static void registrarPelicula(){
        String codigo;
        do{
            codigo= sc.pideTexto("Introduce el codigo de la pelicula (3 letras y 5 numeros):");
        }while(!validarCodigo(codigo));
        String titulo = sc.pideTexto("Introduce el titulo de la pelicula: ");
        String director = sc.pideTexto("Introduce el director: ");
        Genero genero = Utilidades.pedirEnum(Genero.class, "Introduce el genero: ");
        String fechaEstreno = sc. pideTexto("Introduce el fecha de estreno (yyyy-mm-dd): ");
        LocalDate fecha = LocalDate.parse(fechaEstreno);

        Pelicula pelicula = new Pelicula(codigo, titulo, director, genero, fecha);

        if(visualizaciones.containsKey(pelicula)){
            System.out.println("La pelicula ya existe!");
            return;
        }

        peliculas.add(pelicula);
        System.out.println("La pelicula ha sido agregada corectamente!");

        int visualizaciones_pelicula = sc.pedirNumero("Introduce las visualizaciones: ");
        visualizaciones.put(pelicula, visualizaciones_pelicula);
    }

    public static boolean validarCodigo(String codigo){
        String validadores = "^[A-Z]{3}[0-9]{5}$";

        if(!codigo.matches(validadores)){
            System.out.println("El codigo de pelicula no es valido!. Ejemplo valido: ADP12345");
            return false;
        }
        return true;
    }

    public static void mostrarPeliculas(){
        if(!peliculas.isEmpty()){
            for(Pelicula pelicula : peliculas){
                System.out.println(pelicula);

            }
        }else {
            System.out.println("No hay peliculas que mostrar");
        }
    }

    public static void verPelicula() {
        String codigo = sc.pideTexto("Introduce el codigo de la pelicula:");
        Pelicula pelicula = getPelicula(codigo);
        if(pelicula != null){
            int nuevaVisualizacion = visualizaciones.get(pelicula);
            visualizaciones.put(pelicula, nuevaVisualizacion);
            System.out.println("Nuevo conteo de visualizaciones: " + nuevaVisualizacion);
        }else{
            System.out.println("El codigo de la pelicula no existe!");
        }
        String ruta = System.getProperty("user.home") + "/Desktop/DAM/Proyectos/Peliculas/";
        if (comprobarDirectorio(ruta)) {
            File archivo = new File(ruta + "historial_peliculas.txt");

            try (FileWriter fw = new FileWriter(archivo, true)) {

                fw.write("----- VISUALIZACION -----\n");
                fw.write("Fecha: " + LocalDate.now() + "\n");
                fw.write("\tCodigo: " + pelicula.getCodigo() + "\n");
                fw.write("\tTitulo: " + pelicula.getTitulo() + "\n");
                fw.write("\tDirector: " + pelicula.getDirector() + "\n");
                fw.write("-----------------------");

            } catch (IOException e) {
                System.out.println("Error al registrar el prestamo. " + e.getMessage());
            }
        } else {
            System.out.println("Algo ha fallado.");
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

    public static boolean comprobarDirectorio(String ruta){
        if(Utilidades.existDirectory(ruta)){
            return true;
        }else{
            return Utilidades.crearDirectorio(ruta);
        }
    }

    private static void mostrarEstadistica(){
        for (Pelicula pelicula : peliculas ) {
            System.out.println(pelicula.getTitulo());
        }
        for (Pelicula pelicula : visualizaciones.keySet()) {
            System.out.println("Visualizaciones: " + visualizaciones.get(pelicula));
        }
    }
}

