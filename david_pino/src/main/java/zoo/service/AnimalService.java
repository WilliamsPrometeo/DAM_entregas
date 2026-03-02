package zoo.service;

import zoo.dao.ZooDAO;
import zoo.exceptions.InvalidAnimalException;
import zoo.exceptions.InvalidDateException;
import zoo.models.Animal;
import zoo.models.AnimalAve;
import zoo.models.enums.Habitat;
import zoo.repository.ZooRepository;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class AnimalService implements ZooRepository {
    private static Map<Animal, Habitat> habitats = new LinkedHashMap<>();
    private final ZooDAO dao = new ZooDAO();

    @Override
    public Map<Animal, Habitat> getHabitats() {
        return Map.copyOf(habitats);
    }

    @Override
    public Map<Animal, Habitat> getAnimals() {
        return Map.of();
    }

    @Override
    public void addAnimal(Animal animal) {
        habitats.put(animal, habitats.get(animal));
    }

    @Override
    public Animal getAnimal(String animalId) {
        for (Animal animal : habitats.keySet()) {
            if (animal.getAnimalId().equals(animalId)) {
                return animal;
            }
        }
        return null;
    }

    @Override
    public boolean eliminarAnimal(String animalId) {
        Animal animal = getAnimal(animalId);
        if (animal != null) {
            habitats.remove(animal);
            return true;
        }
        return false;
    }

    @Override
    public void guardar() {
        dao.guardar(habitats);
    }

    @Override
    public void cargar() {
        habitats = dao.cargar();
    }

    @Override
    public boolean existeAnimal(String animalId) throws InvalidAnimalException {
        for (Animal animal : habitats.keySet()) {
            if (animal.getAnimalId().equals(animalId)) {
                throw new InvalidAnimalException("Id de animal inválido");
            }
        }
        return true;
    }

    @Override
    public boolean fechaValida(LocalDate entrada, LocalDate salida) throws InvalidDateException {
        if (entrada.isAfter(salida)) {
            throw new InvalidDateException("La fecha de registro no puede ser anterior a la fecha de entrada");
        }
        if (entrada.isBefore(LocalDate.now())) {
            throw new InvalidDateException("La fecha de registro no puede ser anterior a la de hoy");
        }
        if (entrada.getYear() > LocalDate.now().getYear() + 1) {
            throw new InvalidDateException("La fecha de registro no puede ser superior al año " + LocalDate.now().getYear() + 1);
        }
        return true;
    }

    public void addAnimal(AnimalAve animalAve) {
    }
}


