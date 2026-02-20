package proyecto04.zoo.service;

import proyecto04.zoo.dao.ZooDAO;
import proyecto04.zoo.exceptions.InvalidAnimalException;
import proyecto04.zoo.exceptions.InvalidDateException;
import proyecto04.zoo.models.Animal;
import proyecto04.zoo.models.enums.Habitat;
import proyecto04.zoo.repository.ZooRepository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ZooService implements ZooRepository {

    private static Map<Animal, Habitat> ubicaciones = new LinkedHashMap<>();
    private final ZooDAO dao = new ZooDAO();

    @Override
    public Map<Animal, Habitat> getAnimal() {

        return Map.copyOf(ubicaciones);
    }

    @Override
    public void addAnimal(Animal animal,Habitat habitat) {

        ubicaciones.put(animal, habitat);
    }

    @Override
    public Animal getAnimal(String id) {
        for (Animal animal : ubicaciones.keySet()) {
            if (animal.getIdAnimal().equals(id)) {
                return animal;
            }
        }
        return null;
    }

    @Override
    public boolean eliminarAnimal(String codigo) {
        Animal animal = getAnimal(codigo);
        if (animal != null) {
            ubicaciones.remove(animal);
            return true;
        }
        return false;
    }

    @Override
    public void guardar() {

        dao.guardar(ubicaciones);
    }

    @Override
    public void cargar() {

        ubicaciones = dao.cargar();
    }

    @Override
    public boolean animalValido(String idAnimal) throws InvalidAnimalException {
        for (Animal animal : ubicaciones.keySet()) {
            if (animal.getIdAnimal().equals(idAnimal)) {
                throw new InvalidAnimalException("Id animal no valido");
            }
        }
        return true;
    }

    @Override
    public boolean registroValido(LocalDate fecharegistro) throws InvalidDateException {
        if (fecharegistro.isBefore(LocalDate.now())) {
            throw new InvalidDateException("La fecha de registro no puede ser anterior a la de hoy");
        }
        return true;
    }
}
