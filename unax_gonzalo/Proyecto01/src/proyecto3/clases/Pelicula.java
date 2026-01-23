package proyecto3.clases;

import proyecto3.recursos.Genero;
import java.time.LocalDate;
import java.util.Objects;

/**
 * @author Unax
 * @version 1.0
 * Clase Pelicula que crea el constructor y los atributos
 * de la pelicula
 * crea el tostring con el formato y los getters & setters
 */

public class Pelicula {
    private String codigo;
    private String titulo;
    private String director;
    private Genero genero;
    private LocalDate fechaEstreno;

    /**
     * Constructor vacio de pelicula
     */

    public Pelicula(String codigo, String titulo, Genero genero, String director, LocalDate fechaEstreno) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.genero = genero;
        this.director = director;
        this.fechaEstreno = fechaEstreno;
    }

    /**
     * Getters & Setters
     * @return
     */

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(LocalDate fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    /**
     * equals y hashCode, sobrescritos teniendo en cuenta únicamente el código de la película
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pelicula pelicula = (Pelicula) o;
        return Objects.equals(codigo, pelicula.codigo); //solo codigo porque si no solo tira si todo coincide
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }


    /**
     * toString para referenciar la salida del formato de pelicula
     * @return
     */
    @Override
    public String toString() {
        return "Pelicula[" +
                "codigo='" + codigo + '\'' +
                ", titulo='" + titulo + '\'' +
                ", director='" + director + '\'' +
                ", genero=" + genero +
                ", fechaEstreno=" + fechaEstreno +
                ']';
    }
}
