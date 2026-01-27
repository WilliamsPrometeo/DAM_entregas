package proyecto3.recursos;

import recursos.MyScanner;

import java.io.File;

/**
 * Clase de utilidades con métodos estáticos reutilizables.
 * <p>
 * Esta clase agrupa operaciones comunes que se repiten en muchos programas:
 * impresión de colecciones, gestión de menús y selección de valores enum.
 * </p>
 * <p>
 * El objetivo es reducir código duplicado y simplificar los métodos main.
 * </p>
 *
 * <p><strong>Nota:</strong> Todos los métodos son estáticos, por lo que
 * no es necesario crear objetos de esta clase.</p>
 *
 * @author Profesor - Williams
 * @version 4.0
 */
    public class Utilidades {

    private static final MyScanner sc = new MyScanner();
    public static <E extends Enum<E>> E pedirEnum(
            Class<E> tipoEnum,
            String mensaje) {

        E[] valores = tipoEnum.getEnumConstants();
        int opcion;

        do {
            System.out.println(mensaje);
            for (int i = 0; i < valores.length; i++) {
                System.out.println((i + 1) + ". " + valores[i]);
            }
            opcion = sc.pedirNumero("Elige una opción: ");

        } while (opcion < 1 || opcion > valores.length);

        return valores[opcion - 1];
    }

    /**
     * Crea un directorio y todos los subdirectorios necesarios.
     *
     * @param ruta ruta del directorio a crear
     * @return {@code true} si se creó correctamente o ya existía,
     * {@code false} en caso de error
     */
    public static boolean crearDirectorio(String ruta) {
        return new File(ruta).mkdirs();
    }

    public static boolean existDirectory(String ruta) {
        File directorio = new File(ruta);
        return directorio.exists();
    }
}
