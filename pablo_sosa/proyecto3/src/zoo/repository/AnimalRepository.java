package zoo.repository;

import zoo.exceptions.InvalidAnimalException;
import zoo.exceptions.InvalidDateException;
import zoo.models.Animal;
import zoo.models.enums.Habitat;

import java.time.LocalDate;
import java.util.Map;

public interface AnimalRepository {
    Map<Animal, Habitat> ubicaciones();


    Map<Animal, Habitat> habitatAsignado();

    void addAnimal(Animal animal, Habitat habitat);

    Animal getAnimal(String codigo);
    boolean eliminarAnimal(String codigo);

    void guardar();
    void cargar();


    boolean fechaRegistro(LocalDate registro) throws InvalidDateException;

    boolean animalValido(String numAnimal) throws InvalidAnimalException;

    boolean fechaValida(LocalDate fecharegistro) throws InvalidDateException;

}
