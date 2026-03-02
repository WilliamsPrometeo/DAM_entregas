package zoo.repository;

import zoo.exceptions.InvalidAnimalException;
import zoo.exceptions.InvalidDateException;
import zoo.models.Animal;
import zoo.models.enums.Habitat;

import java.time.LocalDate;
import java.util.Map;

public interface ZooRepository {

    Map<Animal, Habitat> getHabitats();

    Map<Animal, Habitat> getAnimals();
    void addAnimal(Animal animal);

    Animal getAnimal(String animalId);
    boolean eliminarAnimal(String animalId);

    void guardar();
    void cargar();

    boolean existeAnimal(String animalId) throws InvalidAnimalException;
    boolean fechaValida(LocalDate entrada, LocalDate salida) throws InvalidDateException;
}
