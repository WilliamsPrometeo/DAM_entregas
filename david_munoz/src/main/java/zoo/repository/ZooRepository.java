package zoo.repository;

import models.Animal;
import models.enums.Habitat;

import java.util.Map;

public interface ZooRepository {

    void save(Animal animal, Habitat habitat);

    Animal findById(String id);

    boolean delete(String id);

    Map<Animal, Habitat> findAll();

    void setData(Map<Animal, Habitat> data);
}