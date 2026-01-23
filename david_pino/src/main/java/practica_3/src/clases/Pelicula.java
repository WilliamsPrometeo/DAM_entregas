package practica_3.src.clases;

import enums.Genero;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase que representa la pelicula de una gestora de peliculas.
 * Cada vehiculo se registra de forma unica mediante su su codigo.
 *
 * @author David Pino
 * @version 1.0
 */

public class Pelicula {
    private String codigo;
    private String titulo;
    private String director;
    private Genero genero;
    private LocalDate fechaEstreno;

    /**
     * Constructor con parametros.
     *
     * @param codigo
     * @param titulo
     * @param director
     * @param genero
     * @param fechaEstreno
     */
    public Pelicula(String codigo, String titulo, String director,  Genero genero, LocalDate fechaEstreno) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.director = director;
        this.genero = genero;
        this.fechaEstreno = fechaEstreno;
    }

    /**
     * Obtiene el codigo de la pelicula
     *
     * @return codigo de la pelicula
     */

    public String getCodigo() {
        return codigo;
    }

    /**
     * Establece el codigo de la pelicula
     *
     * @param codigo nuevo codigo de la pelicula
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Obtiene el titulo de la pelicula
     *
     * @return eñ titulo de la matricula
     */

    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el titulo de la pelicula
     *
     * @param titulo nuevo titulo de la pelicula
     */

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene el director de la pelicula
     *
     * @return director de la pelicula
     */

    public String getDirector() {
        return director;
    }

    /**
     * Establece el director de la pelicula
     *
     * @param director nuevo director de la pelicula
     */

    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Obtiene el genero de la pelicula
     *
     * @return genero de la pelicula
     */

    public Genero getGenero() {
        return genero;
    }

    /**
     * Establece el genero de la pelicula
     *
     * @param genero nuevo genero de la pelicula
     */

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    /**
     * Obtiene la fecha de estreno de la pelicula
     *
     * @return la fecha de estreno de la pelicula
     */

    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }

    /**
     * Establece la fecha de estreno de la pelicula
     *
     * @param fechaEstreno nueva fecha de estreno de la pelicula
     */

    public void setFechaEstreno(LocalDate fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    /**
     * Devuelve una representación en forma de cadena de la pelicula
     *
     * @return información de la pelicula formateada
     */

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecha_formateada = fechaEstreno.format(formatter);
        return String.format("Pelicula: %10s | Titulo: %8s | Director: %8s | Genero: %10s | Fecha de estreno: %10s", codigo, titulo, director, genero, fecha_formateada);
    }

    /**
     * Compara la pelicula con otro objeto
     * dos peliculas se consideran la misma si tienen el mismo codigo
     *
     * @param obj  objeto a comparar.
     * @return {@code true} si ambas peliculas son iguales; {@code false} si es el caso contrario.
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pelicula pelicula = (Pelicula) obj;
        return this.codigo != null ? this.codigo.equals(pelicula.codigo) : pelicula.codigo == null;
    }

    /**
     * Genera el codigo hash de la pelicula basandose en el codigo de la pelicula
     *
     * @return codigo hash de la pelicula
     */

    @Override
    public int hashCode() {return codigo != null ? codigo.hashCode() : 0;}
}
