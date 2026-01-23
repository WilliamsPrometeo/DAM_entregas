package programacion.proyecto_03.clases;

import programacion.proyecto_03.clases.enums.Genero;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase Pelicula
 * @author Alumno - Óscar
 * @version 1.0
 */
public class Pelicula {
    private String codigo;
    private String titulo;
    private String director;
    private Genero genero;
    private LocalDate fechaEstreno;

    /**
     * Constructorde la clase Pelicula
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
     * Getter del atributo codigo
     *
     * @return el código
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Seter del atributo codigo
     *
     * @param codigo establece el código
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Getter del atributo titulo
     *
     * @return el título
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Setter del atributo titulo
     *
     * @param titulo establece el título de la película
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Getter del atributo director
     *
     * @return el director
     */
    public String getDirector() {
        return director;
    }

    /**
     * Setter del atributo director
     *
     * @param director establede el nombre del director
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Getter ddel atributo genero
     *
     * @return el genero
     */
    public Genero getGenero() {
        return genero;
    }

    /**
     * Setter del atributo genero
     *
     * @param genero el género de la película
     */
    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    /**
     * Getter del atributo fechaEstreno
     *
     * @return la fecha delo estreno de la película
     */
    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }

    /**
     * Setter del atributo fechaEstreno
     *
     * @param fechaEstreno la fecha en la que se estrena la película
     */
    public void setFechaEstreno(LocalDate fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    /**
     * Metodo toString para mostrar los datos de la película
     *
     * @return texto formateado con los datos de la película
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        String fecha_formateada = fechaEstreno. format(formatter);
        return String.format("Película: Código: %6s | Título: %s | Director: %s | Genero: %s | Fecha de estreno: %s%n", codigo, titulo, director, genero, fechaEstreno, fecha_formateada);
    }

    /**
     * Compara esta película con otro objeto.
     * Dos películas se consideran iguales si tienen lel mismo código.
     *
     * @param obj objeto a comparar.
     * @return {@code true} si ambas películas son iguales; {@code false} en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Pelicula pelicula = (Pelicula) obj;
        return this.codigo != null ? this.codigo.equals(pelicula.getCodigo()) : pelicula.getCodigo() == null;
    }

    /**
     * Genera el código hash de la película basado en el código.
     *
     * @return código hash de la película.
     */
    @Override
    public int hashCode() {
        return codigo != null ? codigo.hashCode() : 0;
    }
}