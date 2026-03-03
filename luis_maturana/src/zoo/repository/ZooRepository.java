package zoo.repository;

import zoo.exceptions.InvalidAnimalException;
import zoo.exceptions.InvalidDateException;
import zoo.models.Animal;
import zoo.models.enums.Habitat;

import java.time.LocalDate;
import java.util.Map;

public interface ZooRepository {

    Map<Animal, Habitat> ubicaciones();

    Map<Animal, Habitat> getAnimals();

    void registrarAnimal(Animal animal, Habitat habitat);

    Animal getAnimal(String id);
    boolean eliminarAnimal(String id);

    void guardar();
    void cargar();

    boolean existeAnimal(String id) throws InvalidAnimalException;
    boolean fechaValida(LocalDate fechaRegistro) throws InvalidDateException;
}
