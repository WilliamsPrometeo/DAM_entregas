package zoo.service;

import zoo.dao.AnimalDAO;
import zoo.exceptions.InvalidAnimalException;
import zoo.exceptions.InvalidDateException;
import zoo.models.Animal;
import zoo.models.enums.Habitat;
import zoo.repository.ZooRepository;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class AnimalService implements ZooRepository {
    private static Map<Animal, Habitat> animals = new LinkedHashMap<>();
    private final AnimalDAO dao = new AnimalDAO();

    @Override
    public Map<Animal, Habitat> ubicaciones() {
        return Map.of();
    }

    @Override
    public Map<Animal, Habitat> getAnimals() {
        return Map.copyOf(animals);
    }

    @Override
    public void registrarAnimal(Animal animal, Habitat habitat) {
        animals.put(animal, habitat);
    }


    @Override
    public Animal getAnimal(String id) {
        for (Animal animal : animals.keySet()) {
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
            animals.remove(animal);
            return true;
        }
        return false;
    }

    @Override
    public void guardar() { dao.guardar(animals); }

    @Override
    public void cargar() { animals = dao.cargar();}

    @Override
    public boolean existeAnimal(String id) throws InvalidAnimalException {
        for (Animal animal : animals.keySet()) {
            if (animal.getId().equals(id)) {
                throw new InvalidAnimalException("Animal ya existe");
            }
        }
        return true;
    }

    @Override
    public boolean fechaValida(LocalDate fechaRegistro) throws InvalidDateException {
        if (fechaRegistro.getYear() > LocalDate.now().getYear() + 1) {
            throw new InvalidDateException("Fecha invalida ");
        }
        return true;
    }
}
