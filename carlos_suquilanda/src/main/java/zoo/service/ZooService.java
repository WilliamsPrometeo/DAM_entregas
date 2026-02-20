package zoo.service;

import dao.ZooDAO;
import models.Animal;
import models.enums.TipoHabitat;

import java.util.LinkedHashMap;
import java.util.Map;

public class ZooService {
    private static Map<Animal, TipoHabitat> mapaZoo = new LinkedHashMap<>();
    private final ZooDAO dao = new ZooDAO();

    @Override
    public Map<Animal, TipoHabitat> getMapaZoo() {
        return Map.copyOf(mapaZoo);
    }

    @Override
    public void addAnimal(Animal animal, TipoHabitat tipoHabitat) {
        mapaZoo.put(animal, tipoHabitat);
    }

    @Override
    public Animal getAnimal (codigo)


}
