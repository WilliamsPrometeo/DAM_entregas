package proyecto_03.clases;

import proyecto_03.enums.Genero;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase que representa una película dentro del sistema GestionarPelicula
 * Contiene información básica: Código, Título, Director, Género y Fecha de estreno
 * @author Alumno - Sergio Navarro
 * @version 1.0
 */
public class Pelicula {
    private String codigo;
    private String titulo;
    private String director;
    private Genero genero;
    private LocalDate fecha_estreno;

    /**
     * Constructor con paramertros para crear una clase libro completa
     * @param codigo
     * @param titulo
     * @param director
     * @param genero
     * @param fecha_estreno
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
     * @return Devuelve el código de la película
     */
    public String getCodigo() {
        return codigo;
    }
    /**
     * Setter de la Matricula, asigna un código a una película
     * @param codigo Establece un código
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Getter del atributo Titulo
     * @return Devuelve el título de la película
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Setter del Modelo, asigna un título de la película
     * @param titulo Establece un título
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Getter del atributo Director
     * @return Devuelve el Director de la película
     */
    public String getDirector() {
        return director;
    }

    /**
     * Setter del director, asigna un director a la película
     * @param director Establece un director a la película
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Getter del atributo Genero
     * @return Devuelve el Director de la película
     */
    public Genero getGenero() {
        return genero;
    }

    /**
     * Setter del d, asigna un tipo de vehículo a un coche
     * @param genero Establece un género a la película
     */
    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    /**
     * Getter del atributo Fecha_esctreno
     * @return Devuelve la Fecha de estreno de la película
     */
    public LocalDate getFecha_estreno() {
        return fecha_estreno;
    }

    /**
     * Setter de la fecha de estreno, asigna una fecha de estreno a la película
     * @param fecha_estreno Establece una fecha de estreno a la película
     */
    public void setFecha_estreno(LocalDate fecha_estreno) {
        this.fecha_estreno = fecha_estreno;
    }

    /**
     * Metodo sobreescrito de la clase para mostrar los datos de la película
     * @return datos de la película
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("Película: %10s | Título: %8s | Director: %8s | Género: %s | Fecha de estreno: %s", this.codigo, this.titulo, this.director, this.genero, this.fecha_estreno);
    }

    /**
     * Determina si dos películas son iguales comparando su Código
     * @param obj Objeto a comparar
     * @return true si el código coincide, false en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Pelicula pelicula = (Pelicula) obj;
        return this.getCodigo() != null ? this.codigo.equals(pelicula.getCodigo()) : pelicula.getCodigo() == null;
    }


    /**
     * Calcula el hashCode usando el Código
     * Si equals compara Código, hashCode debe hacerse también con el Código
     * @return hash basado en la Código
     */
    @Override
    public int hashCode() {
        return codigo != null ? codigo.hashCode() : 0;
    }
}
