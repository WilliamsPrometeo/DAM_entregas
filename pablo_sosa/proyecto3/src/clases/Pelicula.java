package clases;

import clases.Pelicula;
import recursos.Genero;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Creamos la clase Pelicula que representa una película del catálogo con los siguientes atributos:
 * String codigo` *(identificador único)*
 * String titulo`
 * String director`
 * Genero genero` *(enum)*
 * LocalDate fechaEstreno`
 *
 * El atributo `codigo` identificará de forma única a cada película.
 * @author Pablo Sosa
 * @version 1.0
 */


/**
 * Ponemos los atributos
 */
public class Pelicula {
    private String codigo;
    private String titulo;
    private String director;
    private Genero genero;
    private LocalDate fechaEstreno;

    /**
     * Creamos un constructor con todos los atributos
     */

    public Pelicula(String codigo, String titulo, String director, Genero genero, LocalDate fechaEstreno) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.director = director;
        this.genero = genero;
        this.fechaEstreno = fechaEstreno;
    }

    /**
     * Creamos los getters y setters
     */

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
     * Override para pasar a String
     */

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        String fecha_formateada = fechaEstreno.format(formatter);
        return String.format("CÓDIGO: %10s | TITULO: %8s | DIRECTOR: %10s | Fecha de estreno: %10s", codigo, titulo, director, fecha_formateada);
    }

    /**
     * Utilizo el metodo equals
     */

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof Pelicula)) return false;
        Pelicula peli = (Pelicula) o;
        return codigo.equals(peli.codigo);
    }


    @Override
    public int hashCode() {
        return Objects.hash(codigo, titulo, director, genero, fechaEstreno);
    }





}

