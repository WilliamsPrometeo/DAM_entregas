package proyecto04.zoo.repository;

import proyecto04.zoo.exceptions.InvalidAnimalException;
import proyecto04.zoo.exceptions.InvalidDateException;
import proyecto04.zoo.models.Animal;
import proyecto04.zoo.models.enums.Habitat;

import java.time.LocalDate;
import java.util.Map;

public interface ZooRepository {
    Map<Animal, Habitat> getAnimal();
    void addAnimal(Animal animal,  Habitat habitat);

    Animal getAnimal(String id);
    boolean eliminarAnimal(String  id);

    void guardar();
    void cargar();

    boolean animalValido (String idanimal) throws InvalidAnimalException;
    boolean registroValido(LocalDate fecharegistro) throws InvalidDateException;
}
