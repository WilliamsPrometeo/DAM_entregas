package zoologico.service;

import ejercicioEvaluable.mvc.dao.ZooDao;
import ejercicioEvaluable.mvc.exception.InvalidAnimalException;
import ejercicioEvaluable.mvc.exception.InvalidDateException;
import ejercicioEvaluable.mvc.models.Animal;
import ejercicioEvaluable.mvc.models.enums.Habitat;
import ejercicioEvaluable.mvc.repository.ZooRepository;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class ZooService implements ZooRepository {
    private static Map<Animal, Habitat> animals = new LinkedHashMap<>();
    private static final ZooDao zooDao = new ZooDao();

    @Override
    public Map<Animal, Habitat> getAnimales() {
        return Map.copyOf(animals);
    }

    @Override
    public void addAnimal(Animal animal, Habitat habitat) {
        animals.put(animal, habitat);
    }

    @Override
    public boolean animalValido(String idAnimal) throws InvalidAnimalException {
        for (Animal animal : animals.keySet()) {
            if (animal.getId().equals(idAnimal)) {
                throw new  InvalidAnimalException("El código no es correcto");
            }
        }
        return true;
    }

    @Override
    public boolean fechaValida(LocalDate fecha) throws InvalidDateException {
        if(fecha.isBefore(LocalDate.now())) {
            throw new InvalidDateException("La fecha no puede ser anterior a la actual");
        }
        return true;
    }

    @Override
    public Animal getAnimal(String idAnimal) {
        for (Animal animal : animals.keySet()) {
            if (animal.getId().equals(idAnimal)) {
                return animal;
            }
        }
        return null;
    }

    @Override
    public boolean eliminarAnimal(String idAnimal) {
        Animal animal = getAnimal(idAnimal);
        if (animal != null) {
            animals.remove(animal);
            return true;
        }
        return false;
    }

    @Override
    public void guardar() {
        zooDao.guardar(animals);
    }

    @Override
    public void cargar() {
        animals = zooDao.cargar();
    }
}
