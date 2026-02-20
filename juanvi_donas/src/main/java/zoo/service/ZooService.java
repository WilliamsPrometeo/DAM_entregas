package zoo.service;

import java.util.Map;

import zoo.models.Animal;
import zoo.models.enums.Habitat;
import zoo.repository.ZooRepository;

public class ZooService {

    private ZooRepository repository;

    public ZooService(ZooRepository repository) {
        this.repository = repository;
    }

    public void registrarAnimal(Animal animal, Habitat habitat) {

        if (repository.findById(animal.getId()) != null) {
            throw new IllegalArgumentException("Ya existe un animal con ese ID.");
        }

        repository.addAnimal(animal, habitat);
    }

    public Animal buscarAnimal(String id) {
        return repository.findById(id);
    }

    public void eliminarAnimal(String id) {
        repository.removeById(id);
    }

    public Map<Animal, Habitat> listar() {
        return repository.findAll();
    }

    public void reemplazarDatos(Map<Animal, Habitat> data) {
        repository.setData(data);
    }
}