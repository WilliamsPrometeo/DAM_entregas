package simulacro2; // Indica el paquete donde se encuentra la clase Libro

import simulacro2.enums.Genero;

/**
 * La clase Libro representa un libro con título, autor y género literario.
 * Sirve como estructura base para gestionar colecciones de libros.
 *
 * @author Tu Nombre
 * @version 1.0
 */
public class Libro {

    /** Título del libro */
    private String titulo;

    /** Autor del libro */
    private String autor;

    /** Género literario del libro */
    private Genero genero;

    /**
     * Constructor que inicializa un libro con su título, autor y género.
     *
     * @param titulo título del libro
     * @param autor autor del libro
     * @param genero género literario del libro
     */
    public Libro(String titulo, String autor, Genero genero) {
        this.titulo = titulo; // Asigna el título recibido al atributo titulo
        this.autor = autor;   // Asigna el autor recibido al atributo autor
        this.genero = genero; // Asigna el género recibido al atributo genero
    }

    /**
     * Obtiene el título del libro.
     *
     * @return el título del libro
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Modifica el título del libro.
     *
     * @param titulo nuevo título
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo; // Actualiza el atributo titulo
    }

    /**
     * Obtiene el autor del libro.
     *
     * @return el autor del libro
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Modifica el autor del libro.
     *
     * @param autor nuevo autor
     */
    public void setAutor(String autor) {
        this.autor = autor; // Actualiza el atributo autor
    }

    /**
     * Obtiene el género literario del libro.
     *
     * @return el género del libro
     */
    public Genero getGenero() {
        return genero;
    }

    /**
     * Modifica el género del libro.
     *
     * @param genero nuevo género literario
     */
    public void setGenero(Genero genero) {
        this.genero = genero; // Actualiza el atributo genero
    }

    /**
     * Devuelve una representación textual del libro,
     * formateada con título, autor y género.
     *
     * @return texto descriptivo del libro
     */
    @Override
    public String toString() {
        return String.format(
                "Libro: %nTitulo: %s, Autor: %s, Genero: %s%n",
                this.titulo,    // Inserta el título en el formato
                this.autor,     // Inserta el autor en el formato
                this.genero     // Inserta el género en el formato
        );
    }
}
