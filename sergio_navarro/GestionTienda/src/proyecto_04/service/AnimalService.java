package proyecto_04.service;

import proyectos.proyecto_04.dao.AnimalDAO;
import proyectos.proyecto_04.exceptions.InvalidAnimalException;
import proyectos.proyecto_04.exceptions.InvalidDateException;
import proyectos.proyecto_04.models.Animal;
import proyectos.proyecto_04.models.enums.TipoHabitats;
import proyectos.proyecto_04.repository.AnimalRepository;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class AnimalService implements AnimalRepository {
    private static Map<Animal, TipoHabitats> animales = new LinkedHashMap<>();
    private final AnimalDAO dao = new AnimalDAO();

    @Override
    public Map<Animal, TipoHabitats> getAnimales() {
        return Map.copyOf(animales);
    }

    @Override
    public void addAnimal(Animal animal,TipoHabitats tipoHabitats) {
        animales.put(animal, tipoHabitats);
    }

    @Override
    public Animal getAnimal(String id) {
        for (Animal animal : animales.keySet()) {
            if (animal.getId().equals(id)) {
                return animal;
            }
        }
        return null;
    }

    @Override
    public boolean eliminarAnimal(String id) {
        Animal animal = getAnimal(id);
        if (animal != null) {
            animales.remove(animal);
            return true;
        }
        return false;
    }

    @Override
    public void guardar() {
        dao.guardar(animales);
    }

    @Override
    public void cargar() {
        animales = dao.cargar();
    }

    @Override
    public boolean animalValido(String id) throws InvalidAnimalException {
        for (Animal animal : animales.keySet()) {
            if (animal.getId().equals(id)) {
                throw new InvalidAnimalException("ID del animal no valido");
            }
        }
        return true;
    }

    @Override
    public boolean fechaValida(LocalDate registro) throws InvalidDateException {
        if (registro.isBefore(LocalDate.now())) {
            throw new InvalidDateException("La fecha de registro no puede ser anterior a la de hoy");
        }
        return true;
    }
}