
/**
 * Esto es la clase de peliculas.
 * @author David Muñoz Martín
 * @version 1.0
 */

/** @param Lo que he hecho es emplear geters y setters, los cuales te van devolviendo los métodos.
 *
 */

/** @param Y he usado el override para poner distintas cosas como el Hashcode, el dateformatter,etcetera
 *
 */
package practica3.src.clases;

import enums.Genero;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pelicula {
    private String titulo;
    private Genero genero;
    private String director;
    private String codigo;
    private LocalDate fechaEstreno;


    public Pelicula( String codigo, String titulo, String director, Genero genero, LocalDate fechaEstreno) {
    this.titulo = titulo;
    this.genero = genero;
    this.director = director;
    this.codigo = codigo;
    this.fechaEstreno = fechaEstreno;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(LocalDate fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecha_formateada = fechaEstreno.format(formatter);
        return String.format("Pelicula: %10s - Titulo: %8s - Director %8s - Genero: %10s Fecha de estreno: %10s ",codigo,director,genero, titulo, fecha_formateada);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pelicula pelicula = (Pelicula) o;
        return this.codigo != null ? codigo.equals(pelicula.codigo) : pelicula.codigo == null;
    }

    /** @return Explica lo que devuelve un método.
     *
     *
     */
    @Override
    public int hashCode() {
        return codigo != null ? codigo.hashCode() : 0;
    }
}


