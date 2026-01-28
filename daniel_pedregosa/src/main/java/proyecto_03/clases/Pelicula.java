package proyecto_03.clases;

import proyecto_03.enums.Genero;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase que representa una película del catálogo
 * Contiene un código único que identifica la película, título, director, género y fecha de estreno
 * @author A4Alumno05 - Pedregosa
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
     * @param codigo       identificador único de la película (alfanumérico en mayúsculas)
     * @param titulo       título de la película
     * @param director     nombre del director
     * @param genero       género de la película (enum Genero)
     * @param fechaEstreno fecha de estreno (LocalDate)
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
     * @return el código único de la película
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Setter del código de la película
     * @param codigo establece el código (debe ser único)
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Getter del título de la película
     * @return el título
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Setter del título de la película
     * @param titulo establece el título
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Getter del director
     * @return el nombre del director
     */
    public String getDirector() {
        return director;
    }

    /**
     * Setter del director
     * @param director establece el nombre del director
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Getter del género
     * @return el género (enum Genero)
     */
    public Genero getGenero() {
        return genero;
    }

    /**
     * Setter del género
     * @param genero establece el género de la película
     */
    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    /**
     * Getter de la fecha de estreno
     * @return fecha de estreno (LocalDate)
     */
    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }

    /**
     * Setter de la fecha de estreno
     * @param fechaEstreno establece la fecha de estreno
     */
    public void setFechaEstreno(LocalDate fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    /**
     * Método sobrescrito para mostrar los datos de la película
     * @return cadena con la info la película
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecha_formateada = fechaEstreno.format(formatter);
        return String.format("Película: %10s | Titulo: %s | Director: %s | Genero: %10s | Fecha Estreno: %10s", codigo, titulo, director, genero, fecha_formateada);
    }

    /**
     * Equals sobrescrito para comparar películas por su código único
     * @param obj objeto a comparar
     * @return si los objetos representan la misma película
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() == obj.getClass()) return false;
        Pelicula peliculas = (Pelicula) obj;
        return this.codigo != null ? this.codigo.equals(peliculas.getCodigo()) : peliculas.getCodigo() == null;
    }

    /**
     * HashCode sobrescrito
     * @return código hash
     */
    @Override
    public int hashCode() {
        return codigo != null ? codigo.hashCode() : 0;
    }
}