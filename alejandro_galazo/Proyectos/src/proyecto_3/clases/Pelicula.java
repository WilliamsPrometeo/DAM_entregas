package proyecto_3.clases;

import proyecto_3.enums.Genero;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase película
 *
 * @author A4Alumno08
 * @version 1.0
 */
    public class Pelicula {
        private String codigo;
        private String titulo;
        private String director;
        Genero genero;
        private LocalDate fechaEstreno;

    /**
     * Constructor con parámetros
     *
     * @param codigo Códido único identificador de cada película
     * @param titulo Título de la película
     * @param director Nombre del direcor
     * @param genero Género de la película
     * @param fecha_publicacion Fecha en la que fue estrenada
     */

        public Pelicula(String codigo, String titulo, String director, Genero genero, LocalDate fecha_publicacion) {
            this.codigo = codigo;
            this.titulo = titulo;
            this.director = director;
            this.genero = genero;
            this.fechaEstreno = fecha_publicacion;
        }

        /**
         * Obtiene el código de la pelicula
         * @return codigo pelicula
         */

        public String getCodigo() {
            return codigo;
        }

    /**
     * Establece el codigo de la pelicula
     * @param codigo nuevo codigo de la pelicula
     */

    public void setCodigo(String codigo) {
            this.codigo = codigo;
        }

    /**
     * Obtiene el titulo de la pelicula
     * @return titulo pelicula
     */

    public String getTitulo() {
            return titulo;
        }

    /**
     * establece el titulo de la pelicula
     * @param titulo nombre de la nueva pelicula
     */

    public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

    /**
     * Obtiene el director de la película
     * @return director pelicula
     */

    public String getDirector() {
            return director;
        }

    /**
     * Establece el director de la pelicula
     * @param director nuevo nombre del director de la pelicula
     */

    public void setDirector(String director) {
            this.director = director;
        }

    /**
     * obtiene el genero de la pelicula
     * @return genero pelicula
     */

    public Genero getGenero() {
            return genero;
        }

    /**
     * Establece el genero de la pelicula
     * @param genero nuevo genero de la pelicula
     */

    public void setGenero(Genero genero) {
            this.genero = genero;
        }

    /**
     * obtiene la fecha de estreno de la pelicula
     * @return fecha de estreno
     */

    public LocalDate getFechaEstreno() {
            return fechaEstreno;
        }

    /**
     * Establece la fecha de estreno de la pelicula
     * @param fechaEstreno nueva fecha de estreno de la pelicula
     */

    public void setFechaEstreno(LocalDate fechaEstreno) {
            this.fechaEstreno = fechaEstreno;
        }

        @Override
        public String toString() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
            String fecha_formateada = fechaEstreno.format(formatter);
            return String.format("Pelicula: %10s | Director: %8s | Genero: %10s | Fecha de estreno: %10s", codigo, titulo, director, genero, fecha_formateada);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || this.getClass() != obj.getClass()) return false;
            proyecto_3.clases.Pelicula pelicula = (proyecto_3.clases.Pelicula) obj;
            return this.codigo != null ? this.codigo.equals(pelicula.getCodigo()) : pelicula.getCodigo() == null;
        }

        @Override
        public int hashCode() {
            return codigo != null ? codigo.hashCode() : 0;
        }
    }

