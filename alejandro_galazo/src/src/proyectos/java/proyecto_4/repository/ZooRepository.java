package proyecto_4.repository;

import proyecto_4.exceptions.InvalidAnimalException;
import proyecto_4.exceptions.InvalidDateException;
import proyecto_4.models.Animal;
import proyecto_4.models.enums.Habitat;

import java.time.LocalDate;
import java.util.Map;

public interface ZooRepository {
    Map<Animal, Habitat> getAnimales();
    void addAnimal(Animal animal, Habitat habitat);

    Animal getAnimal(String codigo);
    boolean eliminarAnimal(String codigo);

    void guardar();
    void cargar();

    boolean animalValido(String codigoAnimal) throws InvalidAnimalException;
    boolean fechaValida(LocalDate fecha_adquisicion) throws InvalidDateException;
}
