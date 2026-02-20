package zoologico.repository;

import ejercicioEvaluable.mvc.exception.InvalidAnimalException;
import ejercicioEvaluable.mvc.exception.InvalidDateException;
import ejercicioEvaluable.mvc.models.Animal;
import ejercicioEvaluable.mvc.models.enums.Habitat;

import java.time.LocalDate;
import java.util.Map;

public interface ZooRepository {

    Map<Animal, Habitat> getAnimales();
    void addAnimal(Animal animal,  Habitat habitat);

    boolean animalValido(String idAnimal) throws InvalidAnimalException;
    boolean fechaValida(LocalDate fecha) throws InvalidDateException;

    Animal getAnimal(String idAnimal);
    boolean eliminarAnimal(String idAnimal);

    void guardar();
    void cargar();
}
