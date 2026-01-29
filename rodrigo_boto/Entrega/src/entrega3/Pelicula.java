package entrega3;

import entrega3.enums.Genero;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *Clase Película con sus atributos
 * @author Rodrigo Boto Márquez
 * @version 1.0
 */

public class Pelicula {
    private String codigo;
    private String titulo;
    private String director;
    private Genero genero;
    private LocalDate fechaEstreno;

    /**
     * Constructor completo de Película
     * @param codigo
     * @param director
     * @param fechaEstreno
     * @param genero
     * @param titulo
     */


    public Pelicula(String codigo, String director, LocalDate fechaEstreno, Genero genero, String titulo) {
        this.codigo = codigo;
        this.director = director;
        this.fechaEstreno = fechaEstreno;
        this.genero = genero;
        this.titulo = titulo;
    }

    /**
     * Getter de código
     * @return
     */

    public String getCodigo() {
        return codigo;
    }

    /**
     * Setter de código
     * @param codigo
     */

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Getter de director
     * @return
     */

    public String getDirector() {
        return director;
    }

    /**
     * Setter de director
     * @param director
     */

    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Getter de fecha de estreno (con LocalDate)
     * @return
     */

    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }

    /**
     * Setter de fecha de estreno (con LocalDate también)
     * @param fechaEstreno
     */

    public void setFechaEstreno(LocalDate fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    /**
     * Getter de género
     * @return
     */

    public Genero getGenero() {
        return genero;
    }

    /**
     * Setter de género
     * @param genero
     */

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    /**
     * Getter de título
     * @return
     */

    public String getTitulo() {
        return titulo;
    }

    /**
     * Setter de título
     * @param titulo
     */

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Método override para formatear el texto que sale
     * @return
     */

    @Override
    public String toString() {
        DateTimeFormatter formatter  = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String fecha_formateada = fechaEstreno.format(formatter);
        return String.format("Código: %5s | Título: %5s | Director: %5s | Género: %S | Fecha de estreno: %10s", codigo, titulo, director, genero, fecha_formateada);
    }

    /**
     * Método para ver si son iguales dos cosas
     * @param obj   referencia con la que se compara
     * @return
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        entrega3.Pelicula libro = (entrega3.Pelicula) obj;
        return this.codigo != null ? this.codigo.equals(libro.getCodigo()) : libro.codigo == null;
    }

    /**
     *
     * @return
     */

    @Override
    public int hashCode() {
        return codigo != null ? codigo.hashCode() : 0;
    }
}
