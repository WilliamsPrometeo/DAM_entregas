package zoo.service;

import dao.Zoo.ZooDAO;
import exceptions.InvalidAnimalException;
import models.Animal;
import models.enums.Habitat;
import repository.ZooRepository;

import java.util.Map;

public class ZooService {

    private ZooRepository repository;
    private ZooDAO dao;

    public ZooService(ZooRepository repository, ZooDAO dao) {
        this.repository = repository;
        this.dao = dao;
    }

    public void registrarAnimal(Animal animal, Habitat habitat)
            throws InvalidAnimalException {

        if (repository.findById(animal.getId()) != null) {
            throw new InvalidAnimalException("Ya existe un animal con ese ID.");
        }

        repository.save(animal, habitat);
    }

    public Map<Animal, Habitat> listar() {
        return repository.findAll();
    }

    public Animal buscar(String id) {
        return repository.findById(id);
    }

    public boolean eliminar(String id) {
        return repository.delete(id);
    }

    public void guardar() {
        dao.saveToFile(repository.findAll());
    }

    public void cargar() {
        Map<Animal, Habitat> data = dao.loadFromFile();
        if (data != null) {
            repository.setData(data);
        }
    }
}
