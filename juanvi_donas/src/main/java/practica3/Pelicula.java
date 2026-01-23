package practica3;

import practica3.enums.Genero;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Creamos la clase película
 * y definimos las variables
 */
public class Pelicula {

    private String codigo;
    private String titulo;
    private String director;
    private Genero genero;
    private LocalDate fechaEstreno;

    /**
     * Guardamos las variables ya definidas y hacemos
     * que el codigo se escriba siempre en mayúsculas
     *
     */

    public Pelicula (String codigo, String titulo, String director, Genero genero, LocalDate fechaEstreno) {
        this.codigo = codigo.toUpperCase();
        this.titulo = titulo;
        this.director = director;
        this.genero = genero;
        this.fechaEstreno = fechaEstreno;
    }

    /**
     * Creamos los getters & setters de cada variable
     *
     */

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDirector() {
        return director;
    }

    public Genero getGenero() {
        return genero;
    }

    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }

    /**
     * Usamos el equals para que el identificador sea único
     * y no se puedan repetir películas
     *
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pelicula)) return false;
        Pelicula pelicula = (Pelicula) o;
        return codigo.equals(pelicula.codigo);
    }

    /**
     * Pedimos que retorne el codigo de la pelicula
     * usando el hashcode
     *
     */

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}