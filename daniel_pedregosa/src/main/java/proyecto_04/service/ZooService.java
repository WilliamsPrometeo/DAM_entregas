package proyecto_04.service;



import proyecto_04.dao.ZooDAO;
import proyecto_04.exceptions.InvalidAnimalException;
import proyecto_04.models.Animal;
import proyecto_04.models.enums.Habitat;
import proyecto_04.repository.AnimalRepository;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class ZooService implements AnimalRepository {
    private static Map<Animal, Habitat> ubicaciones = new LinkedHashMap<>();
    private final ZooDAO dao = new ZooDAO();

    @Override
    public Map<Animal, Habitat> getUbicaciones() {
        return Map.copyOf(ubicaciones);
    }

    @Override
    public void addAnimal(Animal animal, Habitat habitat) {
        ubicaciones.put(animal, habitat);
    }

    @Override
    public Animal getAnimal(String id) {
        for (Animal a : ubicaciones.keySet()) {
            if (a.getId().equals(id)) return a;
        }
        return null;
    }

    @Override
    public boolean eliminarAnimal(String id) {
        Animal a = getAnimal(id);
        if (a != null) {
            ubicaciones.remove(a);
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
    public boolean idValido(String id) throws InvalidAnimalException {
        if (id == null || id.isBlank()) throw new InvalidAnimalException("El id no puede ser nulo o vacío");
        String regex = "^[A-Z]{3}[0-9]{2}$";
        if (!id.matches(regex)) throw new InvalidAnimalException("El id debe tener el formato 3 letras mayúsculas y 2 números (ej: ABC12)");

        for (Animal a : ubicaciones.keySet()) {
            if (a.getId().equals(id)) throw new InvalidAnimalException("Ya existe un animal con ese id");
        }
        return true;
    }

    @Override
    public boolean fechaValida(LocalDate fecha) throws proyecto_04.exceptions.InvalidDateException {
        if (fecha.isBefore(LocalDate.now())) {
            throw new proyecto_04.exceptions.InvalidDateException("La fecha de entrada no puede ser anterior a la de hoy");
        }
        if (fecha.getYear() > LocalDate.now().getYear() + 1) {
            throw new proyecto_04.exceptions.InvalidDateException("La fecha de entrada no puede ser superior al año " + LocalDate.now().getYear() + 1);
        }
        return false;
    }
}
