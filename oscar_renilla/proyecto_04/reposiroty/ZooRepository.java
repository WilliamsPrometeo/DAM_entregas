package programacion.simulacros_Proyectos.segundaEval.proyecto_04.reposiroty;

import programacion.simulacros_Proyectos.segundaEval.proyecto_04.exceptions.InvalidAnimalException;
import programacion.simulacros_Proyectos.segundaEval.proyecto_04.exceptions.InvalidDateException;
import programacion.simulacros_Proyectos.segundaEval.proyecto_04.models.Animal;
import programacion.simulacros_Proyectos.segundaEval.proyecto_04.models.enums.Habitat;

import java.time.LocalDate;
import java.util.Map;

public interface ZooRepository {

    Map<Animal, Habitat> getUbicaciones();
    void addAnimal(Animal animal, Habitat habitat);

    Animal getAnimal(String id);
    boolean eliminarAnimal(String id);

    void guardar();
    void cargar ();

    boolean animalValido(String idAnimal) throws InvalidAnimalException;
    boolean fechaValida(LocalDate registro) throws InvalidDateException;
}
