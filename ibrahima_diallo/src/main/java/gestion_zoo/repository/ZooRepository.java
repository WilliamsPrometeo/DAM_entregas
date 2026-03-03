package gestion_zoo.repository;

import gestion_zoo.exceptions.InvalidAnimalException;
import gestion_zoo.exceptions.InvalidDateException;
import gestion_zoo.models.Animal;
import gestion_zoo.models.enums.TipoHabitat;

import java.time.LocalDate;
import java.util.Map;

public interface ZooRepository {

    Map<Animal, TipoHabitat> getAnimales();
    void addAnimal(Animal animal, TipoHabitat tipoHabitat);

    Animal getAnimal(String idAnimal);
    boolean eliminarAnimal(String codigo);

    void guardar();
    void cargar();

    boolean animalValida(String idAnimalAnimal) throws InvalidAnimalException;
    boolean fechaValida(LocalDate registro) throws InvalidDateException;

}
