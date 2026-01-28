package peliculas.clases;

import peliculas.enums.Genero;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase Pelicula
 * @author Adam Perez -Alumno
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
     * @param codigo Codigo unico que identifica la peli
     * @param titulo Autor de la pelicula en string
     * @param director String con el nombre del director
     * @param genero Enum genero de la pelicula
     * @param fechaEstrno LocalDate para la fecha de estreno de la peli
     */

    public Pelicula(String codigo, String titulo, String director, Genero genero, LocalDate fechaEstrno) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.director = director;
        this.genero = genero;
        this.fechaEstreno = fechaEstrno;
    }

    /**
     * Geter del atributo codigo
     * @return string con el codigo de la peli
     */

    public String getCodigo() {
        return codigo;
    }

    /**
     * Setter del atributo codigo
     * @param codigo string con el codigo de la peli
     */

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Geter del atributo titulo
     * @return string con el titulo de la peli
     */

    public String getTitulo() {
        return titulo;
    }

    /**
     * Setter del atributo titulo
     * @param titulo String con el titulo de la peli
     */

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Geter del atributo director
     * @return String con el nombre del director
     */

    public String getDirector() {
        return director;
    }

    /**
     * Setter del atributo director
     * @param director String con el nombre del director
     */

    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Geter del atributo genero
     * @return Enum con el genero de la peli
     */

    public Genero getGenero() {
        return genero;
    }

    /**
     * Setter del atributo genero
     * @param genero Enum con el genero de la peli
     */

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    /**
     * Geter del atributo fechaEstreno
     * @return Fecha formateada con la fecha de estreno de la peli
     */

    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }

    /**
     * Setter del atributo fechaEstreno
     * @param fechaEstreno Fecha formateada con la fecha de estreno de la peli
     */

    public void setFechaEstreno(LocalDate fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    /**
     * Metodo toString con la informacion de la pelicula
     * @return Texto formateado con la informacion de la pelicula
     */

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecha = fechaEstreno.format(dtf);

        return String.format("Codigo: %s%nPelicula: %s%nDirector: %s%nGenero: %s%nFecha de estreno: %s%n", this.getCodigo(), this.getTitulo(), this.getDirector(), this.getGenero(), fecha);
    }

    /**
     * Metodo equals de la clase pelicula
     * @param obj   the reference object with which to compare.
     * @return Si la pelicula que se pide es unica
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj ) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Pelicula pelicula = (Pelicula) obj;

        return this.codigo != null ? this.codigo.equals(pelicula.getCodigo()) : pelicula.getCodigo() == null;
    }

    /**
     * Metodo hashCode de la clase pelicula
     * @return Se asegura que cada pelicula tenga un identificador para el Map
     */

    @Override
    public int hashCode() {
        return codigo != null ? codigo.hashCode() : 0;
    }
}
