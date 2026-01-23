package proyecto3.clases;
import proyecto3.recursos.*;
import proyecto3.recursos.Utilidades.*;

public class Main {

    public static void main(String[] args) {

        // Ruta base del usuario
        String home = System.getProperty("user.home");

        // Carpeta de trabajo en el escritorio
        String rutaTrabajo = home + "/Desktop/DAM/Proyectos/Peliculas/";

        // Crear directorio si no existe
        if (Utilidades.crearDirectorio(rutaTrabajo)) {
            System.out.println("Directorio de trabajo listo");
            GestionPeliculas.menu();
        } else {
            System.out.println("No se pudo crear el directorio o ya existe");

        // Lanzar el programa principal
        GestionPeliculas.menu();
        }
    }
}