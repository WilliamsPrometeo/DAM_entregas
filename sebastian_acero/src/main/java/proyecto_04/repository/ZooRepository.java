package proyecto_04.repository;

import proyecto_04.models.Animal;
import proyecto_04.models.enums.Habitad;

import java.util.Map;

public interface ZooRepository {

    Map<Animal, Habitad> getAnimals();
    void addAnimal(Animal animal, Habitad habitad);

    Animal getAnimal(String nombre);
    boolean eliminarAnimal(String nombre);

    void guardar();
    void cargar();

    boolean existeAnimal(String nombre) throws Exception;
    boolean existeHabitad(String nombre) throws Exception;
}
