package zoo.repository;

import models.Animal;
import models.enums.Habitat;

import java.util.HashMap;
import java.util.Map;

public class ZooRepositoryImpl implements ZooRepository {

    private Map<Animal, Habitat> ubicaciones = new HashMap<>();

    @Override
    public void save(Animal animal, Habitat habitat) {
        ubicaciones.put(animal, habitat);
    }

    @Override
    public Animal findById(String id) {
        for (Animal animal : ubicaciones.keySet()) {
            if (animal.getId().equalsIgnoreCase(id)) {
                return animal;
            }
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Animal encontrado = findById(id);
        if (encontrado != null) {
            ubicaciones.remove(encontrado);
            return true;
        }
        return false;
    }

    @Override
    public Map<Animal, Habitat> findAll() {
        return ubicaciones;
    }

    @Override
    public void setData(Map<Animal, Habitat> data) {
        this.ubicaciones = data;
    }
}