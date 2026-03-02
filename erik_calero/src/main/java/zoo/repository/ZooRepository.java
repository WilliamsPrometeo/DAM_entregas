package zoo.repository;

import zoo.exceptions.InvalidAnimalExceptions;
import zoo.exceptions.InvalidDateExceptions;
import zoo.models.Animal;
import zoo.models.enums.TipoHabitad;

import java.time.LocalDate;
import java.util.Map;

public interface ZooRepository {
    Map<Animal,  TipoHabitad> getAnimales();

    void addAnimales(Animal animal, TipoHabitad tipoHabitad);

    Map<Animal, TipoHabitad> getAnimal();
    void addAnimal(Animal animal, TipoHabitad tipoHabitad);

    Animal getAnimal(String codigoAnimal);
    boolean  removeAnimal(String codigoAnimal);

    Animal getAnimales(String codigo);

    boolean eliminarAnimal(String codigo);

    void guardar();
    void cargar();

    boolean reservaValida(String codidoAnimal) throws InvalidAnimalExceptions;

    boolean animalValido(String codigoAnimal) throws InvalidAnimalExceptions;

    boolean fechaValida(LocalDate registro) throws InvalidDateExceptions;
}
