package proyecto3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pelicula {
    private String codigo;
    private String titulo;
    private String director;
    private LocalDate fecha_publicacion;
    private Genero genero;

    /**
     * AQUI GENERO LAS CONDICIONES DE LOS CUALES APLICO LOS ATRIBUTOS  COMO CODIGO ETC
     * @param codigo
     * @param director
     * @param titulo
     * @param fecha_publicacion
     * @param genero
     */
    public Pelicula(String codigo, String director, String titulo, LocalDate fecha_publicacion, Genero genero) {
        this.codigo = codigo;
        this.director = director;
        this.titulo = titulo;
        this.fecha_publicacion = fecha_publicacion;
        this.genero = genero;
    }

    /**
     * OBTIENE EL CODIGO DE LA PALICULA
     * @return RETORNA EL CODIGO
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * ESTABLECE EL COGIDO DE LA PELIOCULA
     * @param codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * OBTIENE EL TIRULO DE LA PELICULKA
     * @return EL TITULO
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * ESTABLECE EL TITULO DE LA PELICULA
     * @param titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * OBTIENE EL DIRECTIOR DE LA PELICULA
     * @return EL DIRECTOR
     */
    public String getDirector() {
        return director;
    }

    /**
     * ESTABLECE EL DIRECTOR DE LA PELICULA
     * @param director
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * OBTIENE LA FECHA DE ESTRENO
     * @return LA FECHA DE LA PUBLICACNION OSEA DEL ESTRENO
     */
    public LocalDate getFecha_publicacion() {
        return fecha_publicacion;
    }

    /**
     * ESTABELCE LA FECHA DE PUBLICACION
     * @param fecha_publicacion
     */

    public void setFecha_publicacion(LocalDate fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    /**
     * OBTIENE EL GENERO DE LA PELICULA
     * @return LO RETORNA
     */
    public Genero getGenero() {
        return genero;
    }

    /**
     * ESTABLECE EL GENERO DE LA PELIUCLA
     * @param genero
     */

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    /**
     * DEVUELVE EN SI UN STRING CON LOS ATRIBUTOIS INGRESADOS DE LA PELICULA
     * @return INFORMACION DE LA PELICUKLA
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        String fecha_formateada = fecha_publicacion.format(formatter);
        return String.format("Codigo: %10s | Director: %8s | titulo: %8s | fecha_publicacion: %10s | Genero %10s ", codigo, director, titulo, fecha_formateada, genero);
    }

    /**
     * LO QUE HACE AQUI ES MAS O MENOS COMPARA LA PELICIA CON UN OBNJETO
     * @param obj   the reference object with which to compare.
     * @return SI LAS PELICULAS SON IGUALES RETORNA FALSE
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Pelicula pelicula = (Pelicula) obj;
        return this.getCodigo() != null ? this.codigo.equals(pelicula.getCodigo()) : pelicula.getCodigo() == null;
    }

    /**
     * LO QUE HACE AQUI ES GENERAR EL CODIGO HASH
     * @return RETORNA EL CODIGO HASG
     */
    @Override
    public int hashCode() {
        return codigo != null ? codigo.hashCode() : 0;
    }
}
