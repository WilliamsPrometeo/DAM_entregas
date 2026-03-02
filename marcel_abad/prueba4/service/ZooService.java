package segunda_evaluacion.prueba4.service;

import segunda_evaluacion.prueba4.dao.ZooDAO;
import segunda_evaluacion.prueba4.exceptions.InvalidAnimalException;
import segunda_evaluacion.prueba4.exceptions.InvalidDateException;
import segunda_evaluacion.prueba4.models.Animal;
import segunda_evaluacion.prueba4.models.enums.Habitat;
import segunda_evaluacion.prueba4.repository.ZooRepository;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class ZooService implements ZooRepository {

    private static Map<Animal, Habitat> animals = new LinkedHashMap<>();

    private static ZooDAO dao = new ZooDAO();


    @Override
    public Map<Animal, Habitat> getAnimals() {
        return Map.copyOf(animals);
    }

    @Override
    public void addAnimal(Animal animal, Habitat habitat) {
        animals.put(animal, habitat);

    }

    @Override
    public Animal getAnimal(String id) {

        for (Animal animal : animals.keySet()) {

            if (animal.getIdAnimal().equals(id)) {
                return animal;
            }
        }
        return null;
    }

    @Override
    public boolean eliminarAnimal(String id) {

        Animal animal = getAnimal(id);

        if (animal != null) {
            animals.remove(animal);
            return true;
        }
        return false;
    }

    @Override
    public void guardar() {
        dao.guardar(animals);

    }

    @Override
    public void cargar() {
        animals = dao.cargar();

    }

    @Override
    public boolean animalValido(String idAnimal) {

        for (Animal animal : animals.keySet()) {
            if (animal.getIdAnimal().equals(idAnimal)) {
                throw new InvalidAnimalException("Animal no valido");
            }
        }
        return true;
    }

    @Override
    public boolean fechaValida(LocalDate registro) {

        if (registro.isAfter(LocalDate.now())) {
            throw new InvalidDateException("Fecha de registro no puede ser superior a la actual");
        }
        return true;
    }
}
