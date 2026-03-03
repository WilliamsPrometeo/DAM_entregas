package practica_04.repository;

import practica_04.exceptions.InvalidAnimalException;
import practica_04.exceptions.InvalidDateException;
import practica_04.models.Animal;
import practica_04.models.enums.Habitat;

import java.time.LocalDate;
import java.util.Map;

public interface AnimalRepository {

    Map<Animal, Habitat> getUbicacion();
    void addAnimal(Animal animal, Habitat Habitat);

    Animal getUbicacion(String id);

    Animal getAnimal(String codigo);

    boolean eliminarAnimal(String id);

    void guardar();
    void cargar();

    boolean animalValido(String id) throws InvalidAnimalException;
    boolean fechaValida(LocalDate entrada, LocalDate salida) throws InvalidDateException;

}
