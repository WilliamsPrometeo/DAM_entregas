public class Vehiculo {
    private static int contador = 0;
    private static int id;
    private String marca;
    private String matricula;

    public Vehiculo() {
        id++;
    }
    public Vehiculo( String marca, String matricula) {
        this.id=contador++;
        this.marca = marca;
        this.matricula = matricula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return String.format("Vehiculo %d: %nMatricula: %10s, Marca: %8s",id,matricula,marca);
    }
}
