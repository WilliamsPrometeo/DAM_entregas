package practica_04.service;

import practica_04.dao.AnimalDAO;
import practica_04.exceptions.InvalidAnimalException;
import practica_04.exceptions.InvalidDateException;
import practica_04.models.Animal;
import practica_04.models.enums.Habitat;
import practica_04.repository.AnimalRepository;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class AnimalService implements AnimalRepository {
    private static Map<Animal, Habitat> Ubicaciones = new LinkedHashMap<>();
    private final AnimalDAO dao = new AnimalDAO();

    public Map<Animal, Habitat> getUbicacion() {
        return Map.copyOf(Ubicaciones);
    }

    @Override
    public void addAnimal(Animal animal, Habitat Habitat) {
        Ubicaciones.put(animal, Habitat);
    }

    @Override
    public Animal getUbicacion(String id) {
        return null;
    }

    @Override
    public Animal getAnimal(String codigo) {
        for (Animal animal : Ubicaciones.keySet()) {
            if (animal.getId().equals(codigo)) {
                return animal;
            }
        }
        return null;
    }

    @Override
    public boolean eliminarAnimal(String codigo) {
        Animal animal = getAnimal(codigo);
        if (animal != null) {
            Ubicaciones.remove(animal);
            return true;
        }
        return false;
    }

    @Override
    public void guardar() {
        dao.guardar(Ubicaciones);
    }

    @Override
    public void cargar() {
        Ubicaciones = dao.cargar();
    }

    @Override
    public boolean animalValido(String id) throws InvalidAnimalException {
        for (Animal animal : Ubicaciones.keySet()) {
            if (animal.getId().equals(id)) {
                throw new InvalidAnimalException("Codigo de animal no valido");
            }
        }
        return true;
    }

    @Override
    public boolean fechaValida(LocalDate entrada, LocalDate salida) throws InvalidDateException {
        if (entrada.isBefore(LocalDate.now())) {
            throw new InvalidDateException("La fecha de registro no puede ser anterior a la de hoy");
        }
        if (entrada.getYear() > LocalDate.now().getYear() + 1) {
            throw new InvalidDateException("La fecha de registro no puede ser superior al año " + LocalDate.now().getYear() + 1);
        }
        return true;
    }
}