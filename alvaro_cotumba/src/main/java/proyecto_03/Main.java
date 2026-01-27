package proyecto_03;

import recursos.MyScanner;
import recursos.Utilidades;

import java.io.*;

/**
 * Clase principal con métodos de utilidad para archivos.
 *
 * @author Alumno - Alvaro Cotumba
 * @version 1.0
 */
public class Main {

    private static final MyScanner sc = new MyScanner();
    private static final String RUTA = "proyect0_03/datos/";

    /**
     * Metodo principal que prueba la creación de directorios.
     *
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {

        String escritorio = "C:\\Users\\alvaro\\Desktop\\Proyectos\\Peliculas";

        System.out.println(Utilidades.crearDirectorio(escritorio) ?  "Directorio creado correctamente" : "Error en la creación del directorio");
    }

    /**
     * Pide un mensaje al usuario.
     *
     * @return Mensaje introducido.
     */
    public static String pedirDatos() {
        return sc.pideTexto("Ingrese el mensaje que desee enviar: ");
    }

    /**
     * Cuenta las letras en un archivo.
     *
     * @param ruta Nombre del archivo.
     * @return Número de letras o -1 si hay error.
     */
    public static int contarCaracteres(String ruta) {
        int contador = 0;

        try (FileReader fr = new FileReader(RUTA + ruta)) {

            int caracter;
            while ((caracter = fr.read()) != -1) {
                if (Character.isLetter(caracter)) {
                    contador++;
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
            return -1;
        }

        return contador;
    }

}