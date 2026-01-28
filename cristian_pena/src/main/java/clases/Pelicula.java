package clases;

import clases.enums.Genero;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 * Clase que representa un vehículo del taller.
 * Cada pelicula se identifica de forma única por su codigo.
 *
 * @author Alumno - Cristian_Peña

 */

public class Pelicula {
    private String codigo;
    private String titulo;
    private String director;
    private Genero genero;
    private LocalDate fechaEstreno;
    /**
     * Constructor con parámetros.
     *
     * @param codigo Matrícula de la pelicula.
     * @param titulo Titulo de la pelicula.
     * @param director Director de la pelicula.
     * @param genero genero de la pelicula.
     * @param fechaEstreno fecha de estreno de la pelicula.
     */

    public Pelicula(String codigo, String titulo, String director, Genero genero, LocalDate fechaEstreno) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.director = director;
        this.genero = genero;
        this.fechaEstreno = fechaEstreno;
    }
/**
 * Obtiene el codigo de la pelicula.
 *
 * @return codigo de la pelicula.
 */

    public String getCodigo() {
        return codigo;
    }
    /**
     * Establece el codigo de la pelicula.
     *
     * @param codigo nuevo codigo de la pelicula.
     */

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    /**
     * Obtiene el titulo de la pelicula.
     *
     * @return titulo de la pelicula.
     */
    public String getTitulo() {
        return titulo;
    }
    /**
     * Establece el titulo de la pelicula.
     *
     * @param titulo nuevo titulo de la pelicula.
     */

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    /**
     * Obtiene el director de la pelicula.
     *
     * @return director de la pelicula.
     */

    public String getDirector() {
        return director;
    }
    /**
     * Establece el director de la pelicula.
     *
     * @param director nuevo director de la pelicula.
     */
    public void setDirector(String director) {
        this.director = director;
    }
    /**
     * Obtiene el genero de la pelicula.
     *
     * @return genero de la pelicula.
     */
    public Genero getGenero() {
        return genero;
    }
    /**
     * Establece el genero de la pelicula.
     *
     * @param genero nuevo director de la pelicula.
     */
    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    /**
     * Obtiene la fecha de estreno de la pelicula.
     *
     * @return fecha_estreno de la pelicula.
     */
    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }
    /**
     * Establece la fecha de estreno de la pelicula.
     *
     * @param fechaEstreno de la pelicula.
     */

    public void setFechaEstreno(LocalDate fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }
    /**
     * Formatea la fecha de estreno con la fecha formateada
     * Lo estableca en modo YYYY-MM-DD
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        String fecha_formateada = fechaEstreno.format(formatter);
        return String.format("Pelicula: %10s | Titulo: %8s | Director: %8s | Genero: %10s | Fecha de estreno: %10s", codigo, titulo, director, genero, fecha_formateada);
    }
    /**
     * Compara esta pelicula con otro objeto.
     * Dos peliculas se consideran iguales si tienen el mismo codigo.
     *
     * @param obj objeto a comparar.
     * @return {@code true} si ambas peliculas son iguales; {@code false} en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Pelicula pelicula = (Pelicula) obj;
        return this.codigo != null ? this.codigo.equals(pelicula.getCodigo()) : pelicula.getCodigo() == null;
    }
    /**
     * Genera el código hash de la pelicula basado en el codigo.
     *
     * @return código hash de la pelicula.
     */
    @Override
    public int hashCode() {
        return codigo != null ? codigo.hashCode() : 0;
    }

}
