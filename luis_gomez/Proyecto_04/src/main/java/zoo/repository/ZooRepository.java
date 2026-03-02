package zoo.repository;

import zoo.exceptions.InvalidAnimalException;
import zoo.exceptions.InvalidDateException;
import zoo.models.Animal;
import zoo.models.enums.TipoHabitat;

import java.time.LocalDate;
import java.util.Map;

public interface ZooRepository {

    Map<Animal, TipoHabitat> getAnimales();
    void addAnimal(Animal animal, TipoHabitat tipoHabitat);

    Animal getAnimal(String id);
    boolean eliminarAnimal(String id);

    void guardar();
    void cargar();

    boolean animalValido (String id) throws InvalidAnimalException;
    boolean fechaValida (LocalDate fechaRegistro) throws InvalidDateException;
}
