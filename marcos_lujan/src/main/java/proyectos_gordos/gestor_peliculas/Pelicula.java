package proyectos_gordos.gestor_peliculas;

import proyectos_gordos.enums.Genero;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase Película
 *
 * @author Alumno - Marcos Luján Miguel
 * @version 1.0
 */

public class Pelicula {
    private String codigo;
    private String titulo;
    private String director;
    private Genero genero;
    private LocalDate fechaEstreno;

    /**
     * Constructor Pelicula
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
     * Constructor vacío Pelicula
     */

    public Pelicula() {
    }

    /**
     * Getter del atributo Codigo
     *
     * @return el código de identificación único de cada pelicula
     */

    public String getCodigo() {
        return codigo;
    }

    /**
     * Setter del atributo Codigo
     *
     * @param codigo
     */

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Getter del atributo Titulo
     *
     * @return el título de cada película
     */

    public String getTitulo() {
        return titulo;
    }

    /**
     * Setter del atributo tíutlo
     *
     * @param titulo
     */

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Getter del atributo autor
     *
     * @return el director que ha realizado cada pelicula
     */

    public String getDirector() {
        return director;
    }

    /**
     * Setter del atributo director
     *
     * @param director
     */

    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Getter del atributo (enum) género
     *
     * @return el género al que pertenece una pelicula
     */

    public Genero getGenero() {
        return genero;
    }

    /**
     * Setter del atributo (enum) género
     *
     * @param genero
     */

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    /**
     * Getter del atributo FechaEstereno
     *
     * @return la fecha que se estrena cada pelicula
     */
    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }

    /**
     * Setter del atributo FechaEstreno
     *
     * @param fechaEstreno
     */

    public void setFechaEstreno(LocalDate fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    /**
     * Metodo sobrescrito para mostrar datos sobre las peliculas
     * @return ID, TITULO, DIRECTOR, GENERO, FECHA_ESTRENO
     */

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecha_formateada = dtf.format(fechaEstreno);
        return String.format("ID: %10s | Titulo: %8s | Director: %8s | Genero: %10s | Fecha de estreno: %10s", codigo, titulo, director, genero, fecha_formateada);
    }

    /**
     * Metodo equals sobrescrito para comparar peliculas por su código único
     * @param obj   the reference object with which to compare.
     * @return si los objetos son o no la misma pelicula
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null && this.getClass() != obj.getClass()) return false;
        Pelicula pelicula = (Pelicula) obj;
        return this.getCodigo() != null ? this.getCodigo().equals(pelicula.getCodigo()) : pelicula.getCodigo() == null;
    }

    /**
     * Metodo hascode sobrescrito
     * @return código hash
     */

    @Override
    public int hashCode() {
        return codigo != null ? codigo.hashCode() : 0;
    }
}
