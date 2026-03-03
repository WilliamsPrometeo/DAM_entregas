package proyecto_04.repository;



import proyecto_04.exceptions.InvalidAnimalException;
import proyecto_04.exceptions.InvalidDateException;
import proyecto_04.models.Animal;
import proyecto_04.models.enums.Habitat;

import java.time.LocalDate;
import java.util.Map;

public interface AnimalRepository {
    Map<Animal, Habitat> getUbicaciones();
    void addAnimal(Animal animal, Habitat habitat);
    Animal getAnimal(String id);
    boolean eliminarAnimal(String id);
    void guardar();
    void cargar();
    boolean idValido(String id) throws InvalidAnimalException;
    boolean fechaValida(LocalDate fecha) throws proyecto_04.exceptions.InvalidDateException;
}
