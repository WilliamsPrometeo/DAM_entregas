package proyecto4.repository;

import proyecto4.exceptions.InvalidAnimalException;
import proyecto4.exceptions.InvalidDateException;
import proyecto4.models.Animal;
import proyecto4.models.enums.Habitat;

import java.time.LocalDate;
import java.util.Map;

public interface ZooRepository {
    Map<Animal, Habitat> getAnimales();

    void addAnimal(Animal animal,  Habitat habitat);

    Animal getAnimal(String idAnimal);
    boolean eliminarAnimal(String idAnimal);

    void guardar();
    void cargar();

    boolean registroValido(String idAnimal) throws InvalidAnimalException;
    boolean fechaValida(LocalDate fecha)throws InvalidDateException;
}
