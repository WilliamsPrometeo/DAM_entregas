package zoo.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Mamifero extends Animal{
    private int mamifero;
    private int numPatas;

    /**
     * implemento el contructor con sus atributos
     * coomo codigo animal fecharegistro
     * @param codigoAnimal
     * @param fechaRegistro
     * @param numPatas
     */
    public Mamifero(String codigoAnimal, LocalDate fechaRegistro, int numPatas) {
        super(codigoAnimal, String.valueOf(fechaRegistro));
        this.mamifero=numPatas;

    }

    /**
     * aplicop el getmamifero con su retorno
     * @return
     */
    public int getMamifero() {
        return mamifero;
    }

    /**
     * implemento su set del atributo mamifero con su equivalencia
     * @param mamifero
     */
    public void setMamifero(int mamifero) {
        this.mamifero = mamifero;
    }

    /**
     * implemento el getTipoAnimal con el retorno vacio
     * @return
     */
    @Override
    public String getTipoAnimal() {
        return "";
    }

    /**
     * creao que override del gethabitad en donde verifico el retonro de sus equivalencias
     * @return
     */
    @Override
    public String getHabitad(){
        return " habitad ";
    }

    /**
     * realizo el override para poder concatenar las salidas de este por lo que implemento los atributos
     * @return concateno las salidas
     */
    @Override
    public String toString(){
        DateTimeFormatter dft = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String registro = getFechaRegistro().format(String.valueOf(dft));
        return  String.format("animal mamifero: %s - %s - %s - %s", getCodigoAnimal(),registro,this.numPatas,getHabitad());
    }
}

