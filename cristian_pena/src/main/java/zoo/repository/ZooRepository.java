package zoo.repository;

import zoo.exceptions.InvalidAnimalException;
import zoo.exceptions.InvalidDateException;
import zoo.models.Animal;
import zoo.models.enums.Habitat;

import java.time.LocalDate;
import java.util.Map;

public interface ZooRepository {
    Map<Animal, Habitat> getAnimal();
    void addAnimal(Animal animal, Habitat habitat);

    Animal getAnimal(String idAnimal);
    boolean eliminarAnimal(String idAnimal);

    void guardar();
    void cargar();

    boolean animalValidado(String codigoReserva) throws InvalidAnimalException;
    boolean fechaValida(LocalDate registro) throws InvalidDateException;

}
