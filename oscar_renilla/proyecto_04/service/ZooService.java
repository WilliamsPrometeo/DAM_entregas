package programacion.simulacros_Proyectos.segundaEval.proyecto_04.service;

import programacion.simulacros_Proyectos.segundaEval.proyecto_04.dao.ZooDAO;
import programacion.simulacros_Proyectos.segundaEval.proyecto_04.exceptions.InvalidAnimalException;
import programacion.simulacros_Proyectos.segundaEval.proyecto_04.exceptions.InvalidDateException;
import programacion.simulacros_Proyectos.segundaEval.proyecto_04.models.Animal;
import programacion.simulacros_Proyectos.segundaEval.proyecto_04.models.enums.Habitat;
import programacion.simulacros_Proyectos.segundaEval.proyecto_04.reposiroty.ZooRepository;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class ZooService implements ZooRepository {
    private static Map<Animal, Habitat> ubicaciones = new LinkedHashMap<>();
    private final ZooDAO dao = new ZooDAO();

    @Override
    public Map<Animal, Habitat> getUbicaciones() {
        return Map.copyOf(ubicaciones);
    }

    @Override
    public void addAnimal(Animal animal, Habitat habitat) {
        ubicaciones.put(animal, habitat);
    }

    @Override
    public Animal getAnimal(String id) {
        for (Animal animal : ubicaciones.keySet()) {
            if (animal.getId().equals(id)) {
                return animal;
            }
        }
        return null;
    }

    @Override
    public boolean eliminarAnimal(String id) {
        Animal animal = getAnimal(id);
        if (animal != null) {
            ubicaciones.remove(animal);
            return true;
        }
        return false;
    }

    @Override
    public void guardar() {
        dao.guardar(ubicaciones);
    }

    @Override
    public void cargar() {
        ubicaciones = dao.cargar();
    }

    @Override
    public boolean animalValido(String idAnimal) throws InvalidAnimalException {
        for (Animal animal : ubicaciones.keySet()) {
            if (animal.getId().equals(idAnimal)) {
                throw new InvalidAnimalException("Codigo del animal no válido.");
            }
        }
        return false;
    }

    @Override
    public boolean fechaValida(LocalDate registro) {
        if (registro.isBefore(LocalDate.now())) {
            throw new InvalidDateException("La fecha de entrada no puede ser anterior a la de hoy");
        }
        return false;
    }
}
