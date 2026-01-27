package proyecto_03.GestionPeliculas.clases;

import proyecto_03.GestionPeliculas.clases.enums.Genero;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Representa una Pelicula en la biblioteca.
 *
 * @author Alumno - Alvaro Cotumba
 * @version 1.0
 */
public class Pelicula {
    public static String codigo;
    private static String titulo;
    private static String director;
    private Genero genero;
    private LocalDate fechaEstreno;

    /**
     * Constructor de la pelicula.
     *
     * @param codigo Codigo del Pelicula.
     * @param titulo Título del Pelicula.
     * @param director Director de la Pelicula.
     * @param genero Género del Pelicula.
     * @param fechaEstreno Fecha de estreno.
     */
    public Pelicula(String codigo, String titulo, String director, Genero genero, LocalDate fechaEstreno) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.director = director;
        this.genero = genero;
        this.fechaEstreno = fechaEstreno;
    }

    /**
     * Obtiene el Codigo.
     *
     * @return Codigo del Pelicula.
     */
    public static String getCodigo() {
        return codigo;
    }

    /**
     * Establece el Codigo.
     *
     * @param codigo Nuevo Codigo.
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Obtiene el título.
     *
     * @return Título del Pelicula.
     */
    public static String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título.
     *
     * @param titulo Nuevo título.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene el autor.
     *
     * @return Director de la Pelicula.
     */
    public static String getDirector() {
        return director;
    }

    /**
     * Establece el autor.
     *
     * @param director Nuevo autor.
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Obtiene el género.
     *
     * @return Género del Pelicula.
     */
    public Genero getGenero() {
        return genero;
    }

    /**
     * Establece el género.
     *
     * @param genero Nuevo género.
     */
    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    /**
     * Obtiene la fecha de publicación.
     *
     * @return Fecha de publicación.
     */
    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }

    /**
     * Establece la fecha de publicación.
     *
     * @param fechaEstreno Nueva fecha de publicación.
     */
    public void setFechaEstreno(LocalDate fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    /**
     * Representación en texto del Pelicula.
     *
     * @return String con información del Pelicula.
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        String fecha_formateada = fechaEstreno.format(formatter);
        return String.format("Pelicula: %10s | Titulo: %8s | Director: %8s | Genero: %10s | Fecha de estreno: %10s", codigo, titulo, director, genero, fecha_formateada);
    }

    /**
     * Compara si dos Peliculas son iguales por Codigo.
     *
     * @param obj Objeto a comparar.
     * @return true si son iguales, false si no.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Pelicula pelicula = (Pelicula) obj;
        return this.codigo != null ? this.codigo.equals(Pelicula.getCodigo()) : Pelicula.getCodigo() == null;
    }

    /**
     * Genera código hash basado en Codigo.
     *
     * @return Código hash.
     */
    @Override
    public int hashCode() {
        return codigo != null ? codigo.hashCode() : 0;
    }
}