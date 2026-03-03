package zoo.repository;

import exceptions.InvalidAnimalException;
import exceptions.InvalidDateException;
import models.Animal;
import models.enums.TipoHabitat;

import java.time.LocalDate;
import java.util.Map;

public interface ZooRepository {

    Map<Animal, TipoHabitat> getMapaZoo();
    void addAnimal(Animal animal, TipoHabitat tipoHabitat);

    Animal getAnimal (String codigo);
    boolean eliminarAnimal(String codigo);

    void guardar();
    void cargar();

    boolean existeAnimal(String codigo) throws InvalidAnimalException;
    boolean existeFecha(LocalDate fechaNacimiento) throws InvalidDateException;
}
