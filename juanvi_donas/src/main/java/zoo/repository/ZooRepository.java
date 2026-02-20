package zoo.repository;

import java.util.Map;
import zoo.models.Animal;
import zoo.models.enums.Habitat;

public interface ZooRepository {

    void addAnimal(Animal animal, Habitat habitat);

    Animal findById(String id);

    void removeById(String id);

    Map<Animal, Habitat> findAll();

    void setData(Map<Animal, Habitat> data);
}