package proyecto_04.repository;

import proyectos.proyecto_04.exceptions.InvalidAnimalException;
import proyectos.proyecto_04.exceptions.InvalidDateException;
import proyectos.proyecto_04.models.Animal;
import proyectos.proyecto_04.models.enums.TipoHabitats;

import java.time.LocalDate;
import java.util.Map;

public interface AnimalRepository {
    Map<Animal, TipoHabitats> getAnimales();
    void addAnimal(Animal animal, TipoHabitats tipoHabitats);

    Animal getAnimal(String id);
    boolean eliminarAnimal(String id);

    void guardar();
    void cargar();

    boolean animalValido(String id) throws InvalidAnimalException;
    boolean fechaValida(LocalDate registro) throws InvalidDateException;

}