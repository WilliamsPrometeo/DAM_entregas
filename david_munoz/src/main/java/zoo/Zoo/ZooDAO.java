package zoo.Zoo;

import models.Animal;
import models.enums.Habitat;

import java.util.Map;

public interface ZooDAO {

    void saveToFile(Map<Animal, Habitat> data);

    Map<Animal, Habitat> loadFromFile();
}
