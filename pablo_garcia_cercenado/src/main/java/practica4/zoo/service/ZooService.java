package practica4.zoo.service;

import practica4.zoo.dao.ZooDao;
import practica4.zoo.exceptions.InvalidAnimalException;
import practica4.zoo.exceptions.InvalidDateException;
import practica4.zoo.models.Animal;
import practica4.zoo.models.enums.Habitat;
import practica4.zoo.repository.ZooRepository;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class ZooService implements ZooRepository {
    private static Map<Animal, Habitat> animales = new LinkedHashMap<>();
    private final ZooDao dao = new ZooDao();

    @Override
    public Map<Animal, Habitat> getAnimales() {
        return Map.copyOf(animales);
    }

    @Override
    public void addAnimales(Animal animal, Habitat tipoHabitat) {
        animales.put(animal, tipoHabitat);
    }

    @Override
    public Animal getAnimales(String codigo) {
        for (Animal animal : animales.keySet()) {
            if (animal.getCodigoAnimal().equals(codigo)) {
                return animal;
            }
        }
        return null;
    }

    @Override
    public boolean eliminarAnimal(String codigo) {
        Animal animal = getAnimales(codigo);
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
    public boolean animalValido(String codigoAnimal) throws InvalidAnimalException {
        for (Animal animal : animales.keySet()) {
            if (animal.getCodigoAnimal().equals(codigoAnimal)) {
                throw new InvalidAnimalException("Codigo de animal no valido");
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
