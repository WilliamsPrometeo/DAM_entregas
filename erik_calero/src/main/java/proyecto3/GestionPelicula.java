package proyecto3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class GestionPelicula {
    private static final MyScanner sc = new MyScanner();
    private static ArrayList<Pelicula> peliculas = new ArrayList<>() ;
    private static Map<Pelicula, Integer> visualizaciones = new LinkedHashMap<>();

    static void main(String[] args){
        menu();
    }
    static void menu(){
        boolean exit;
        do {
            exit = false;
            int opcion = sc.pedirNumero("===== GESTION PELICULAS =====" +
                    "\n1. Registrar una pelicula" +
                    "\n2. Mostrar pelicula" +
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
                        estadisticas();
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
    static void registrarPelicula(){
        String codigoPelicula;
        do {
         codigoPelicula = sc.pideTexto("Ingrese codigo pelicula: ").toUpperCase();
        }while(!validarCodigo(codigoPelicula));

        String titulo =sc.pideTexto(("Ingrese titulo"));
        String autor =sc.pideTexto("Ingrese Director");
        Genero genero= Utilidades.pedirEnum(Genero.class, "ingrese genero");
        String fecha_publicacion = sc.pideTexto("Ingrese fecha de estreno (YYYY-MM-DD)");
        LocalDate fecha = LocalDate.parse(fecha_publicacion);

        Pelicula pelicula = new Pelicula(codigoPelicula,titulo,autor,fecha,genero);

        if(visualizaciones.containsKey(pelicula)) {
            System.out.println("El pelicula ya existe!");
            return;
        }
        peliculas.add(pelicula);
        System.out.println("La pelicula que ha ingresado ah  sido ingresado de manera adecuada!");

        int visualPelicula = 0;
        visualizaciones.put(pelicula,visualPelicula);

    }
    private static boolean validarCodigo(String codigoPelicula) throws CodigoInvalidException {
        String valiladores = "[A-Za-z0-9]+";
        if(codigoPelicula.length() != 7){
            throw  new CodigoInvalidException("El codigo de pelicula no es valido tiene que ocntener al menos 7 caracteres !");
        }
        if(!codigoPelicula.matches(valiladores)){
            System.out.println(" error al ingresar el codigo de acuerdo a los validadores");
            return false;
        }
        return true;
    }

    static void mostrarPelicula(){
        if (!peliculas.isEmpty()) {
            for (Pelicula pelicula : peliculas) {
                System.out.println(" INFORMACION PELICULA INGRESADO ");
                System.out.println(pelicula);
                System.out.println("------------------------");
            }
        } else {
            System.out.println("No hay peliculas  que mostrar.");
        }

    }
    static void verPelicula() {
        String codigoPelicula = sc.pideTexto("Ingrese codigo pelicula que quiere ver : ");
        Pelicula pelicula = getPelicula(codigoPelicula);
        if (pelicula != null) {
            int visualizaciuon_nueva = visualizaciones.get(pelicula) + 1;
            visualizaciones.put(pelicula, visualizaciuon_nueva);
            System.out.println("se presenta el nuevo conteo " + visualizaciuon_nueva);
        } else {
            System.out.println("no existe una pelicula con ese codigo ");
        }
        String ruta = System.getProperty("user.home") + "/Desktop/DAM/proyectos/peliculas/";
        if (comprobarDirectorio(ruta)) {
            File archivo = new File(ruta + "Historialelicula.txt");
            try (FileWriter fw = new FileWriter(archivo, true)) {
                fw.write(" registro de visualizaciones ");
                fw.write(" fecha de visualizacion " + LocalDate.now() + "\n");
                fw.write(" pelicula \n");
                fw.write(" titulo  " + pelicula.getTitulo() + "\n");
                fw.write("codigo " + pelicula.getCodigo() + "\n");
                fw.write("director " + pelicula.getDirector() + "\n");
                fw.write(" genero " + pelicula.getGenero() + "\n");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println(" error  ");
        }
    }
    public static boolean comprobarDirectorio(String ruta){
        if(!Utilidades.existDirectory(ruta)){
            return Utilidades.crearDirectorio(ruta);
        }else {
            return true;
        }
    }
    public static void estadisticas(){
        for(Pelicula pelicula : peliculas){
            System.out.println(pelicula.getTitulo());
        }
        for (Pelicula pelicula : visualizaciones.keySet()) {
            System.out.println("visualizaciones "+ visualizaciones.get(pelicula));
        }
    }
    public static Pelicula getPelicula(String codigoPelicula){
        for (Pelicula pelicula : peliculas) {
            if(pelicula.getCodigo().equals(codigoPelicula)){
                return pelicula;
            }
        }
        return null;
    }

}
