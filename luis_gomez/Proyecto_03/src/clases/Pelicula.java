package clases;

import clases.enums.Genero;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase Pelicula
 *
 * @author Alumnoo - Luis
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
     * @param codigo el codigo de la pelicula
     * @param titulo el titulo de la pelicula
     * @param director el director de la pelicula
     * @param genero enumeracion para establecer el genero de la pelicula
     * @param fechaEstreno la fecha de estreno de la pelicula
     */
    public Pelicula(String codigo, String titulo, String director, Genero genero, LocalDate fechaEstreno) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.director = director;
        this.genero = genero;
        this.fechaEstreno = fechaEstreno;
    }

    /**
     * Getter del atributo codigo
     *
     * @return el codigo de la pelicula
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Setter del atributo codigo
     *
     * @param codigo establece el codigo de la pelicula
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Getter del atributo titulo
     *
     * @return el titulo de la pelicula
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Setter del atributo titulo
     *
     * @param titulo establece el titulo de la pelicula
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Getter del atributo director
     *
     * @return el director de la pelicula
     */
    public String getDirector() {
        return director;
    }

    /**
     * Setter del atributo director
     *
     * @param director establece el director de la pelicula
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Getter del atributo genero
     *
     * @return el genero de la pelicula
     */
    public Genero getGenero() {
        return genero;
    }

    /**
     * Setter del atributo genero
     *
     * @param genero establece el genero de la pelicula
     */
    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    /**
     * Getter del atributo fechaEstreno
     *
     * @return la fecha de estreno de la pelicula
     */
    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }

    /**
     * Setter del atributo fechaEstreno
     *
     * @param fechaEstreno establece la fecha de estreno de la pelicula
     */
    public void setFechaEstreno(LocalDate fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    /**
     * Metodo toString para mostrar los datos de la Pelicula
     *
     * @return texto formateado con los datos de la Pelicula
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecha_formateada  = fechaEstreno.format(formatter);
        return String.format("Pelicula: %6s | Titulo: %10s | Director: %10s | Genero: %15s | Fecha de estreno: %10s", codigo, titulo, director, genero, fecha_formateada);
    }

    /**
     * Metodo equals para comprobar si otro objeto es igual a Pelicula
     *
     * @param o el objeto de referencia con  el que compararlo
     * @return verdadero si son iguales los objetos,
     * falso si el objeto es null o las clases son distintas,
     * el codigo si los dos codigos son iguales y null si el codigo es null
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Pelicula p = (Pelicula) o;
        return this.codigo != null ? this.codigo.equals(p.getCodigo()) : p.getCodigo() == null;
    }

    /**
     * Metodo hashCode para poder utilizar pelicula en un hashmap
     *
     * @return el codigo en hascode si es distinto de nulo o 0 si es nulo
     */
    @Override
    public int hashCode() {
        return codigo != null ? codigo.hashCode() : 0;
    }
}
