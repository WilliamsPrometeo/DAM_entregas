package zoo.service;

import zoo.dao.ZooDAO;
import zoo.exceptions.InvalidAnimalException;
import zoo.exceptions.InvalidDateException;
import zoo.models.Animal;
import zoo.models.enums.Habitat;
import zoo.repository.ZooRepository;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class ZooService implements ZooRepository {
    private static Map<Animal, Habitat> ubicaciones = new LinkedHashMap<>();
    private final ZooDAO dao = new ZooDAO();

    @Override
    public Map<Animal, Habitat> getAnimal() {
        return Map.copyOf(ubicaciones);
    }
    @Override
    public void addAnimal(Animal animal,Habitat habitat) {
        ubicaciones.put(animal, habitat);
    }
    @Override
    public Animal getAnimal(String idAnimal) {
        for (Animal animal : ubicaciones.keySet()) {
            if (animal.getId().equals(idAnimal)) {
                return animal ;
            }
        }
        return null;
    }
    public boolean eliminarAnimal(String idAnimal) {
        Animal animal = getAnimal(idAnimal);
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
    public boolean animalValidado(String idAnimal) throws InvalidAnimalException {
        for (Animal animal : ubicaciones.keySet()) {
            if (animal.getId().equals(idAnimal)) {
                throw new InvalidAnimalException("ID no válido");
            }
        }
        return true;
    }
    public boolean fechaValida(LocalDate registro) throws InvalidDateException {

        if (registro.getYear() > LocalDate.now().getYear() + 1) {
            throw new InvalidDateException("La fecha de registro no puede ser superior al año " + LocalDate.now().getYear() + 1);
        }
        return true;
    }
}

