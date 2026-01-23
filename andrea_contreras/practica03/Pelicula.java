package practica03;

import segunda_evaluacion.libreria.clases.Libro;
import practica03.Genero;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase Pelicula
 *
 * @author Alumna - Andrea
 * @version 1.0
 */

public class Pelicula {
    private String codigo;
    private String titulo;
    private String director;
    private Genero genero;
    private LocalDate fechaEstreno;

    /**
     * Constructor Principal de la clase Pelicula
     * @param codigo Identificador de la pelicula
     * @param titulo titulo de la pelicula
     * @param director director de la pelicula
     * @param genero Enumeracion de los tipos de genero de las peliculas
     * @param fechaEstreno fecha de estreno
     */

    public Pelicula(String codigo, String titulo, String director, Genero genero, LocalDate fechaEstreno) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.director = director;
        this.genero = genero;
        this.fechaEstreno = fechaEstreno;
    }

    /**
     * Getter del atributo Codigo
     * @return Codigo
     */

    public String getCodigo() {
        return codigo;
    }

    /**
     * Setter del atributo Codigo
     * @param codigo
     */

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Getter del atributo Titulo
     * @return Titulo
     */

    public String getTitulo() {
        return titulo;
    }

    /**
     * Setter del atributo Titulo
     * @param titulo
     */

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Getter del atributo Director
     * @return Director
     */

    public String getDirector() {
        return director;
    }

    /**
     * Setter del atributo Director
     * @param director
     */

    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Getter del atributo Genero
     * @return Genero
     */

    public Genero getGenero() {
        return genero;
    }

    /**
     * Setter del atributo Genero
     * @param genero
     */

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    /**
     * Getter del atributo fechaEstreno
     * @return fechaEstereno
     */

    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }

    /**
     * Setter del atributo fechaEstreno
     * @param fechaEstreno
     */

    public void setFechaEstreno(LocalDate fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    /**
     * Metodo formateado para mostrar los datos de las peliculas
     *
     * @return datos de las peliculas
     */

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        String fecha_formateada = fechaEstreno.format(formatter);
        return String.format("Pelicula: %10s | Titulo: %10s | Director: %8s | Genero: %10s | Fecha estreno: %10s", codigo, titulo, director, genero, fechaEstreno);
    }

    /**

     *Compara este objeto con otro.*
     *@param "Object" objeto a comparar con este.
     *@return true si los codigos tienen los mismos valores y false en caso contrario.
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Pelicula pelicula = (Pelicula) obj;
        return this.codigo != null ? this.codigo.equals(pelicula.getCodigo()) : pelicula.getCodigo() == null;
    }

    /**
     *Devuelve el código hash del codigo
     *@return retorna el codigo
     */

    @Override
    public int hashCode() {
        return codigo != null ? codigo.hashCode() : 0;
    }
}
