package gestion_peliculas.clases;

import gestion_peliculas.enums.Genero;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase Pelicula
 * @author Alumno - Ibrahima
 * @version 1.1
 **/

public class Pelicula {
    private String codigo;
    private String titulo;
    private String director;
    private Genero genero;
    private LocalDate fecha_estreno;

    /**
     * Constructor principal de la clase Pelicula
     * Inicializa el atributo de fecha_estreno con la fecha del momento del estreno
     * @param codigo   atributo heredado
     * @param titulo atributo heredado
     * @param director atributo heredado
     * @param genero atributo heredado
     */

    public Pelicula(String codigo, String titulo, String director, Genero genero, LocalDate fecha_estreno) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.director = director;
        this.genero = genero;
        this.fecha_estreno = fecha_estreno;
    }
    /**
     * Getter del atributo Codigo
     *
     * @return el Codigo de la pelicula
     */
    public String getCodigo() {
        return codigo;
    }
    /**
     * Setter del atribtuo Nombre
     *
     * @param codigo establece el Codigo de la pelicula
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    /**
     * Getter del atributo Titulo
     *
     * @return el Titulo de la pelicula
     */
    public String getTitulo() {
        return titulo;
    }
    /**
     * Setter del atribtuo titulo
     *
     * @param titulo establece el Titulo de la pelicula
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    /**
     * Getter del atributo Director
     *
     * @return el Director de la pelicula
     */
    public String getDirector() {
        return director;
    }
    /**
     * Setter del atribtuo director
     *
     * @param director estable el director de la pelicula
     */
    public void setDirector(String director) {
        this.director = director;
    }
    /**
     * Getter del atributo Genero
     *
     * @return el Genero de la pelicula
     */
    public Genero getGenero() {
        return genero;
    }
    /**
     * Setter del atribtuo genero
     *
     * @param  genero establece el genero de la pelicula
     */
    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    /**
     * Getter del atributo Fecha_estreno
     *
     * @return la Fecha_estreno de la pelicula
     */
    public LocalDate getFecha_estreno() {
        return fecha_estreno;
    }
    /**
     * Setter del atribtuo Fecha_estreno
     *
     * @param fecha_estreno establece la fecha de estreno de la pelicula
     */
    public void setFecha_estreno(LocalDate fecha_estreno) {
        this.fecha_estreno = fecha_estreno;
    }
    /**
     * Metodo toString para mostrar los datos de la pelicula
     *
     * @return texto formateado con los datos de la pelicula
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        String fecha_formateada = fecha_estreno.format(formatter);
        return String.format("Titulo: %8s | Director: %8s | Genero: %10s | Fecha de estreno: %10s ", codigo, titulo, director, genero, fecha_formateada);
    }
    /**
     * Compara esta pelicula con otro objeto.
     * Dos peliculas se consideran iguales si tienen el mismo codigo
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
     * Genera el código hash de la pelicula basado en la codigo.
     *
     * @return código hash de la pelicula.
     */
    @Override
    public int hashCode() {
        return codigo != null ? codigo.hashCode() : 0;
    }
}
