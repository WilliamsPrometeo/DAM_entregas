package segunda_evaluacion.prueba4.repository;

import segunda_evaluacion.prueba4.exceptions.InvalidAnimalException;
import segunda_evaluacion.prueba4.exceptions.InvalidDateException;
import segunda_evaluacion.prueba4.models.Animal;
import segunda_evaluacion.prueba4.models.enums.Habitat;

import java.time.LocalDate;
import java.util.Map;

public interface ZooRepository {

    Map<Animal, Habitat> getAnimals();

    void addAnimal(Animal animal, Habitat habitat);

    Animal getAnimal(String id);

    boolean eliminarAnimal(String id);

    void guardar();

    void cargar();

    boolean animalValido(String idAnimal)
            throws InvalidAnimalException;

    boolean fechaValida(LocalDate registro)
            throws InvalidDateException;



}
