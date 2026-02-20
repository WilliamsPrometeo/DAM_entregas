package practica4.zoo.repository;

import practica4.zoo.exceptions.InvalidAnimalException;
import practica4.zoo.exceptions.InvalidDateException;
import practica4.zoo.models.Animal;
import practica4.zoo.models.enums.Habitat;

import java.time.LocalDate;
import java.util.Map;

public interface ZooRepository {

    Map<Animal, Habitat> getAnimales();
    void addAnimales(Animal animal, Habitat tipoHabitat);

    Animal getAnimales(String codigo);
    boolean eliminarAnimal(String codigo);

    void guardar();
    void cargar();

    boolean animalValido(String codigoAnimal) throws InvalidAnimalException;
    boolean fechaValida(LocalDate registro) throws InvalidDateException;

}
