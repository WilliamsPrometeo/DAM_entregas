package zoo.service;

import zoo.dao.ZooDao;
import zoo.exceptions.InvalidAnimalExceptions;
import zoo.exceptions.InvalidDateExceptions;
import zoo.models.Animal;
import zoo.models.enums.TipoHabitad;
import zoo.repository.ZooRepository;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class ZooService implements ZooRepository {
    private static Map<Animal, TipoHabitad> animales = new LinkedHashMap<>();
    private final ZooDao dao = new ZooDao();

    @Override
    public Map<Animal,  TipoHabitad> getAnimales() {
        return Map.copyOf(animales);
    }

    @Override
    public void addAnimales(Animal animal, TipoHabitad tipoHabitat) {
        animales.put(animal, tipoHabitat);
    }

    @Override
    public Map<Animal, TipoHabitad> getAnimal() {
        return Map.of();
    }

    @Override
    public void addAnimal(Animal animal, TipoHabitad tipoHabitad) {

    }

    @Override
    public Animal getAnimal(String codigoAnimal) {
        return null;
    }

    @Override
    public boolean removeAnimal(String codigoAnimal) {
        return false;
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
    public boolean reservaValida(String codidoAnimal) throws InvalidAnimalExceptions {
        return false;
    }

    @Override
    public boolean animalValido(String codigoAnimal) throws InvalidAnimalExceptions {
        for (Animal animal : animales.keySet()) {
            if (animal.getCodigoAnimal().equals(codigoAnimal)) {
                throw new InvalidAnimalExceptions("Codigo de animal no valido");
            }
        }
        return true;
    }

    @Override
    public boolean fechaValida(LocalDate registro) throws InvalidDateExceptions {
        if (registro.isBefore(LocalDate.now())) {
            throw new InvalidDateExceptions("La fecha de registro no puede ser anterior a la de hoy");
        }
        return true;
    }
}
