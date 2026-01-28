package proyecto03;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * La clase {@code Pelicula} representa una pelicula dentro del sistema
 * de gestiónPeliculas.
 * <p>
 * Contiene información básica como codigo, título, director,
 * género y fecha de estreno.
 * </p>
 *
 * @author Gabriel Maturana
 * @version 1.0
 * @since 1.0
 */

public class Pelicula {
    /** Código que identifica de forma única a las peliculas */
    private String codigo;
    /** Título de la pelicula */
    private String titulo;
    /** Director de la pelicula */
    private String director;
    /** Genero de la pelicula */
    private Genero genero;
    /** Fecha de estreno de la pelicula */
    private LocalDate fechaEstreno;

    static ArrayList<Pelicula> peliculas = new ArrayList<>();

    static Map<Pelicula, Integer> visualizaciones = new LinkedHashMap<>();
    /**
     * Constructor de la clase {@code Pelicula}.
     *
     * @param codigo código unico de la pelicula
     * @param titulo título de la pelicula
     * @param director director de la pelicula
     * @param genero género de la pelicula
     * @param fechaEstreno fecha de estreno de la pelicula
     */

    public Pelicula(String codigo, String titulo, String director, Genero genero, LocalDate fechaEstreno) {

        this.codigo = codigo;

        this.titulo = titulo;

        this.director = director;

        this.genero = genero;

        this.fechaEstreno = fechaEstreno;
    }

    public static ArrayList<Pelicula> getPeliculas() {
        return peliculas;
    }

    public static void setPeliculas(ArrayList<Pelicula> peliculas) {
        Pelicula.peliculas = peliculas;
    }

    public static Map<Pelicula, Integer> getVisualizaciones() {
        return visualizaciones;
    }

    public static void setVisualizaciones(Map<Pelicula, Integer> visualizaciones) {
        Pelicula.visualizaciones = visualizaciones;
    }

    public Pelicula() {

    }
    /**
     * Devuelve el codigo de la pelicula.
     *
     * @return codigo de la pelicula
     */
    public String getCodigo() {
        return codigo;
    }
    /**
     * Modifica el codigo de la pelicula.
     *
     * @param codigo nuevo codigo de la pelicula
     */

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    /**
     * Devuelve el título de la pelicula.
     *
     * @return título de la pelicula
     */

    public String getTitulo() {
        return titulo;
    }
    /**
     * Modifica el título de la pelicula.
     *
     * @param titulo nuevo título de la pelicula
     */

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    /**
     * Devuelve el director de la pelicula.
     *
     * @return director de la pelicula
     */

    public String getDirector() {
        return director;
    }
    /**
     * Modifica el director de la pelicula
     *
     * @param director nuevo director de la pelicula
     */

    public void setDirector(String director) {
        this.director = director;
    }
    /**
     * Devuelve el género de la pelicula.
     *
     * @return género de la pelicula
     */

    public Genero getGenero() {
        return genero;
    }
    /**
     * Modifica el género de la pelicula.
     *
     * @param genero nuevo género de la pelicula
     */

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    /**
     * Devuelve la fecha de estreno de la pelicula.
     *
     * @return fecha de estreno
     */

    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }
    /**
     * Modifica la fecha de estreno de la pelicula.
     *
     * @param fechaEstreno nueva fecha de estreno de la pelicyla
     */

    public void setFechaEstreno(LocalDate fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }


    /**
     * Devuelve una representación en texto de la pelicula,
     * mostrando todos sus datos formateados.
     *
     * @return cadena con la información de la pelicula
     */
    @Override
    public String toString() {
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
         String fecha_formateada = fechaEstreno.format(formatter);
        return String.format( "Fecha: %10s | Codigo: %10s| Titulo: %8s | Director: %8s" , fechaEstreno, codigo, titulo, director );
    }

    /**
     * Compara dos peliculas para determinar si son iguales.
     * <p>
     * Dos peliculas se consideran iguales si tienen el mismo codigo
     * </p>
     *
     * @param obj objeto a comparar
     * @return {@code true} si los codigos coinciden, {@code false} en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;

        Pelicula pelicula = (Pelicula) obj;

            return this.codigo != null
                    ? this.codigo.equals(pelicula.getCodigo())
                    : pelicula.getCodigo() == null;
    }
    /**
     * Devuelve el código hash de la pelicula.
     * <p>
     * El valor hash se calcula a partir del codigo
     * </p>
     *
     * @return valor hash de la pelicula
     */
    @Override
    public int hashCode() {
        return codigo != null ? codigo.hashCode() : 0;
    }
}




