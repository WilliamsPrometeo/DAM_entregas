package zoo.service;

import zoo.dao.ZooDAO;
import zoo.exceptions.InvalidAnimalException;
import zoo.exceptions.InvalidDateException;
import zoo.models.Animal;
import zoo.models.enums.TipoHabitat;
import zoo.repository.ZooRepository;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class ZooService implements ZooRepository {
    private static Map<Animal, TipoHabitat> ubicaciones = new LinkedHashMap<>();
    private final ZooDAO dao = new ZooDAO();

    @Override
    public Map<Animal, TipoHabitat> getAnimales() {
        if (ubicaciones.isEmpty()) {
            System.out.println("Lamentablemente hemos matado a todos los animales");
        }
        return Map.copyOf(ubicaciones);
    }

    @Override
    public void addAnimal(Animal animal, TipoHabitat tipoHabitat) {
        ubicaciones.put(animal, tipoHabitat);
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
    public boolean animalValido(String id) throws InvalidAnimalException {
        for (Animal animal : ubicaciones.keySet()) {
            if (animal.getId().equals(id)) {
                throw new InvalidAnimalException("El codigo del animal no es valido");
            }
        }
        return true;
    }

    @Override
    public boolean fechaValida(LocalDate fechaRegistro) throws InvalidDateException {
        if (fechaRegistro.isBefore(LocalDate.now())) {
            throw new InvalidDateException("La fecha de registro no puede ser anterior a la de hoy");
        }
        return true;
    }
}
