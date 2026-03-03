package proyectos_gordos.zoo.repository;

import proyectos_gordos.zoo.exceptions.InvalidAnimalException;
import proyectos_gordos.zoo.exceptions.InvalidDateException;
import proyectos_gordos.zoo.models.Animal;
import proyectos_gordos.zoo.models.enums.Habitat;

import java.time.LocalDate;
import java.util.Map;

public interface ZooRepository {

    Map<Animal, Habitat> getAnimal();
    void addAnimal(Animal animal, Habitat habitat);

    Animal getAnimal(String id);
    boolean eliminarAnimal(String id);

    void guardar();
    void cargar();

    boolean existeAnimal(String id) throws InvalidAnimalException;
    boolean fechaValida (LocalDate fechaEntrada) throws InvalidDateException;



}
