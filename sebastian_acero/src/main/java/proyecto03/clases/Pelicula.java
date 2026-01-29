package proyecto03.clases;

import proyecto03.enums.Genero;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pelicula {
    private String codigo;
    private String titulo;
    private String director;
    private Genero genero;
    private LocalDate fechaEstreno;

    public Pelicula(String codigo, String titulo, String director, Genero genero, LocalDate fechaEstreno) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.director = director;
        this.genero = genero;
        this.fechaEstreno = fechaEstreno;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(LocalDate fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecha_formateada = fechaEstreno.format(formatter);
        return String.format("Codigo: %5s | Titulo: %5s | Director: %5s | Genero: %5s | Fecha de estreno: %5s", codigo, titulo, director, genero, fecha_formateada);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pelicula pelicula = (Pelicula) obj;
        return this.codigo != null ? this.codigo.equals(pelicula.getCodigo()) : pelicula.getCodigo() == null;
        }

    @Override
    public int hashCode() {
        return codigo !=null ? codigo.hashCode() : 0;
    }
}



