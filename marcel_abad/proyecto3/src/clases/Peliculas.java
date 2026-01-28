package clases;
import enums.Genero;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * La clase {@code Peliculas} representa un pelicula dentro del sistema
 * de gestión de una peliculas.
 * @author Marcel Abad Vilà
 * @version 1.0
 */
public class Peliculas {

    private String codigo;
    private String titulo;
    private String director;
    private Genero genero;
    private LocalDate fechaEstreno;

    /**Constructor de la clase Peliculas
     * @param codigo de la pelicula
     * @param titulo de la pelicula
     * @param director de la pelicula
     * @param genero de la pelicula
     * @param fechaEstreno de la pelicula
     */

    public Peliculas(String codigo, String titulo, String director, Genero genero, LocalDate fechaEstreno){

        this.codigo = codigo;
        this.titulo = titulo;
        this.director = director;
        this.genero = genero;
        this.fechaEstreno = fechaEstreno;
    }

    /**
     * Devuelve el de  codigo la pelicula
     * @return codigo
     */

    public String getCodigo() {
        return codigo;
    }

    /**
     * Modifica el codigo de la pelicula
     * @param codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Devuelve el Titulo de la pelicula
     * @return titulo
     */

    public String getTitulo() {
        return titulo;
    }
    /**
     * Modifica de titulo la pelicula
     * @param titulo
     */

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    /**
     * Devuelve el  Director de la pelicula
     * @return director
     */

    public String getDirector() {
        return director;
    }
    /**
     * Modifica el director de la pelicula
     * @param director
     */

    public void setDirector(String director) {
        this.director = director;
    }
    /**
     * Devuelve el genero de la pelicula
     * @return genero
     */
    public Genero getGenero() {
        return genero;
    }
    /**
     * Modifica el genero de la pelicula
     * @param genero
     */

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    /**
     * Devuelve la fecha de la pelicula
     * @return fecha
     */
    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }
    /**
     * Modifica la fecha de la pelicula
     * @param fechaEstreno
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

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");

        String fecha_formateada = fechaEstreno.format(formatter);

        return String.format (
               "Codigo:  %10s | Titulo: %8s | Director: %8s | Genero: %10s | Fecha de estreno: %10s" ,
                codigo, titulo, director, genero, fecha_formateada
        );
    }

    /**
     * Compara dos peliculas para determinar si son iguales.
     * Dos peliculas se consideran iguales si tienen el mismo ISBN.
     * @param obj objeto a comparar
     * @return {@code true} si los codigos coinciden, {@code false} en caso contrario
     */

    public boolean equals(Object obj){

        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Peliculas peliculas = (Peliculas) obj;
        return this.codigo != null
                ? this.codigo.equals(peliculas.getCodigo())
                : peliculas.getCodigo() == null;
    }

    /**
     * Devuelve el código hash de la pelicula.
     * El valor hash se calcula a partir de la pelicula.
     * @return valor hash de la pelicula
     */

    @Override
    public int hashCode() {

        return codigo != null ? codigo.hashCode() : 0;
    }
}
