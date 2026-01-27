import clases.GestionPelicula;
import recursos.Utilidades;
import clases.Pelicula;

    public static void main(String[] args) {

        // Ruta base del usuario
        String home = System.getProperty("user.home");

        // Carpeta de trabajo en el escritorio
        String rutaTrabajo = home + "/Desktop/DAM/";

        // Crear directorio si no existe
        if (Utilidades.crearDirectorio(rutaTrabajo)) {
            System.out.println("Directorio de trabajo listo");
        } else {
            System.out.println("No se pudo crear el directorio o ya existe");
        }

        // Lanzar el programa principal
        GestionPelicula.menu();
    }