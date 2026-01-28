package proyecto3.src.clases;


import proyecto3.src.clases.enums.Genero;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase que representa las caracteristicas de una pelicula.
 *
 * @author Carlos Suquilanda
 * @version 1.0
 */

public class Pelicula {
    private String codigo;
    private String titulo;
    private String director;
    private Genero genero;
    private LocalDate fecha_Estreno;

    /**
     * Constructor con parámetros.
     *
     * @param codigo Codigo que identifica a la pelicula.
     * @param titulo Titulo de la pelicula.
     * @param director Director que dirigio la pelicula.
     * @param genero Tipos de género de las peliculas.
     * @param fecha_Estreno Fecha de publicacion de la pelicula
     */

    public Pelicula(String codigo, String titulo, String director, Genero genero, LocalDate fecha_Estreno) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.director = director;
        this.genero = genero;
        this.fecha_Estreno = fecha_Estreno;
    }

    /**
     * Obtiene el codigo de identificación de la película.
     *
     * @return codigo de identificación.
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
     * Obtiene el título de la película.
     *
     * @return título de la pelicula.
     */

    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título de la pelicula.
     *
     * @param titulo nuevo titulo de la pelicula.
     */

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene el director de la película.
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
     * Obtiene el genero de la película.
     *
     * @return genero de la pelicula.
     */

    public Genero getGenero() {
        return genero;
    }

    /**
     * Establece el genero de la pelicula.
     *
     * @param genero nuevo género de la pelicula.
     */

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    /**
     * Obtiene la fecha de estreno de la película.
     *
     * @return fecha de estreno de la pelicula.
     */

    public LocalDate getFecha_Estreno() {
        return fecha_Estreno;
    }

    /**
     * Establece la fecha de estreno de la pelicula.
     *
     * @param fecha_Estreno nueva fecha de estreno de la pelicula.
     */

    public void setFecha_Estreno(LocalDate fecha_Estreno) {
        this.fecha_Estreno = fecha_Estreno;
    }

    /**
     * Devuelve una representación en forma de cadena de la pelicula.
     *
     * @return información de la pelicula formateada.
     */

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecha_formatada = fecha_Estreno.format(formatter);
        return String.format("| CODIGO: %s | TÍTULO: %s | DIRECTOR: %s | GENERO: %s | FECHA DE ESTRENO: %s | ", codigo, titulo, director, genero, fecha_formatada);
    }
    /**
     * Compara una pelicula con otra.
     * Dos peliculas se consideran iguales si tienen el mismo codigo.
     *
     * @param o objeto a comparar.
     * @return {@code true} si ambas peliculas son iguales; {@code false} en caso contrario.
     */


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Pelicula pelicula = (Pelicula) o;
        return this.codigo != null ? this.codigo.equals(pelicula.getCodigo()) : pelicula.codigo == null;
    }

    /**
     * Genera el código hash de la pelicula basado en su codigo.
     *
     * @return código hash de la pelicula.
     */

    @Override
    public int hashCode() {
        return codigo != null ? codigo.hashCode() : 0;
    }
}
