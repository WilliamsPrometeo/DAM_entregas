package proyecto4.service;

import proyecto4.dao.AnimalDAO;
import proyecto4.models.Animal;
import proyecto4.models.enums.Habitat;
import proyecto4.repository.ZooRepository;
import proyecto4.exceptions.InvalidDateException;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class ZooService implements ZooRepository {
    private static Map<Animal, Habitat> ubicaciones = new LinkedHashMap<>();
    private final AnimalDAO dao = new AnimalDAO();


    @Override
    public Map<Animal, Habitat> getAnimals() {
        return Map.copyOf(ubicaciones);
    }

    @Override
    public void addAnimal(Animal animal, Habitat habitat) {
        ubicaciones.put(animal, habitat);
    }

    @Override
    public Animal getAnimal(String Animales) {
        for (Animal animal : ubicaciones.keySet()) {
            if (animal.getIdAnimal().equals(animal)) {
                return animal;
            }
        }
        return null;
    }

    @Override
    public boolean eliminarReserva(String animales) {
        Animal animal = getAnimal(animales);
        if (animal != null) {
            ubicaciones.remove(animal);
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
    public boolean reservaValida(String idAnimal) {

        for (Animal animal : ubicaciones.keySet()) {
            if (animal.getIdAnimal().equals(idAnimal)) {
                throw new RuntimeException("ID de animal existente");
            }
        }

        return true;
    }

    @Override
    public boolean fechaValida(LocalDate fechaRegistro) {

        if (fechaRegistro.isBefore(LocalDate.now())) {
            throw new InvalidDateException("Fecha de registro de animal no puede ser anterior a hoy.");
        }
        return false;
    }

    @Override
    public Animal getAnimals(String codigo) {
        return null;
    }
}
