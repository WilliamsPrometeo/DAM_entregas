package proyecto3.clases;

import proyecto3.enums.Genero;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase Pelicula
 *
 * @author Alumno- Marco Martin
 * @version 1.0
 */

public class Pelicula {
    private String codigo;
    private String titulo;
    private String director;
    private Genero genero;
    private LocalDate fechaEstreno;

    /**
     * Constructor principal de la clase Pelicula
     *
     * @param codigo
     * @param titulo
     * @param director
     * @param genero
     * @param fechaEstreno
     */
    public Pelicula(String codigo, String titulo, String director, Genero genero, LocalDate fechaEstreno) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.director = director;
        this.genero = genero;
        this.fechaEstreno = fechaEstreno;
    }

    /**
     * Getter del código de la película
     *
     * @return el código de la película
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Setter del código de la película
     *
     * @return el código de la película
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Getter del título de la película
     *
     * @return el título de la película
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Setter del título de la película
     *
     * @return el título de la película
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Getter del director de la película
     *
     * @return el director de la película
     */
    public String getDirector() {
        return director;
    }

    /**
     * Setter del director de la película
     *
     * @return el director de la película
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Getter del género de la película
     *
     * @return el género de la película
     */
    public Genero getGenero() {
        return genero;
    }

    /**
     * Setter del género de la película
     *
     * @return el género de la película
     */
    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    /**
     * Getter de la fecha de estreno de la película
     *
     * @return la fecha de estreno de la película
     */
    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }

    /**
     * Setter de la fecha de estreno de la película
     *
     * @return la fecha de estreno de la película
     */
    public void setFechaEstreno(LocalDate fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    /**
     * Metodo toString para mostrar los datos de la película formateados
     * @return los datos de la película formateados
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        String fecha_formateada = fechaEstreno.format(formatter);
        return String.format("Película:  %s %n Título: %s %n Director: %s %n Género: %s %n Fecha de estreno: %s %n", codigo, titulo, director, genero, fecha_formateada);
    }

    /**
     * Metodo hashCode para que el mapa identifique correctamente la clave
     *
     * @return la clave del mapa, siendo 0 si el valor es null
     */
    public int hashCode() {
        return this.codigo != null ? this.codigo.hashCode() : 0;
    }

    /**
     * Metodo equals para que el mapa identifique correctamente la clave
     *
     * @return el valor de la clave del mapa
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pelicula pelicula = (Pelicula) o;
        return this.codigo != null
                ? this.codigo.equals(pelicula.codigo)
                : pelicula.codigo == null;
    }

}
