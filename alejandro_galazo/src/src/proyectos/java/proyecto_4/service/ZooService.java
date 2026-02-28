package proyecto_4.service;

import proyecto_4.dao.ZooDAO;
import proyecto_4.exceptions.InvalidAnimalException;
import proyecto_4.exceptions.InvalidDateException;
import proyecto_4.models.Animal;
import proyecto_4.models.enums.Habitat;
import proyecto_4.repository.ZooRepository;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class ZooService implements ZooRepository {
    private static Map<Animal, Habitat> animales = new LinkedHashMap<>();
    private final ZooDAO dao = new ZooDAO();

    @Override
    public Map<Animal, Habitat> getAnimales() {
        return Map.copyOf(animales);
    }

    @Override
    public void addAnimal(Animal animal, Habitat habitat) {

    }

    @Override
    public Animal getAnimal(String codigo) {
        for (Animal animal : animales.keySet()) {
            if (animal.getCodigoAnimal().equals(codigo)) {
                return animal;
            }
        }
        return null;
    }

    @Override
    public boolean eliminarAnimal(String codigo) {
        Animal animal = getAnimal(codigo);
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
    public boolean fechaValida(LocalDate fecha_adquisicion) throws InvalidDateException {
        if (fecha_adquisicion.isBefore(LocalDate.now())) {
            throw new InvalidDateException("La fecha de adquisicion no puede ser anterior a la de hoy");
        }
        if (fecha_adquisicion.getYear() > LocalDate.now().getYear() + 1) {
            throw new InvalidDateException("La fecha de entrada no puede ser superior al año " + LocalDate.now().getYear() + 1);
        }
        return true;
    }
}
