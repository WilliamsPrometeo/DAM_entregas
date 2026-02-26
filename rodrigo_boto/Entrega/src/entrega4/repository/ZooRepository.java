package entrega4.repository;

import entrega4.exceptions.InvalidAnimalException;
import entrega4.exceptions.InvalidDateException;
import entrega4.models.Animal;
import entrega4.models.enums.Habitat;

import java.time.LocalDate;
import java.util.Map;

public interface ZooRepository {
    Map<Animal, Habitat> getAnimal();
    void addAnimal(Animal animal, Habitat habitat);

    Animal getAnimal(String id_animal);
    boolean eliminarAnimal(String id_animal);
    void guardar();
    void cargar();
    boolean existeAnimal(String id_animal) throws InvalidAnimalException;
    boolean fechaValida(LocalDate fecha) throws InvalidDateException;
}
