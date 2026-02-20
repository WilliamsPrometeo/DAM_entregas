package proyecto4.repository;

import proyecto4.models.Animal;
import proyecto4.models.enums.Habitat;

import java.time.LocalDate;
import java.util.Map;

public interface ZooRepository {

    Map<Animal, Habitat> getAnimals();

    void addAnimal(Animal animal, Habitat habitat);

    Animal getAnimal(String Animales);

    boolean eliminarReserva(String animales);

    void guardar();

    void cargar();

    boolean reservaValida(String idAnimal);

    boolean fechaValida(LocalDate fechaRegistro);

    Animal getAnimals(String codigo);
}
