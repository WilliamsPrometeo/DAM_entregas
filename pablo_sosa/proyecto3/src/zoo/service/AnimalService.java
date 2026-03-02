package zoo.service;

import zoo.dao.AnimalDAO;
import zoo.exceptions.InvalidAnimalException;
import zoo.exceptions.InvalidDateException;
import zoo.models.Animal;
import zoo.models.enums.Habitat;
import zoo.repository.AnimalRepository;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class AnimalService implements AnimalRepository {
    private static Map<Animal, Habitat> ubicaciones = new LinkedHashMap<>();
    private final AnimalDAO dao = new AnimalDAO();

    @Override
    public Map<Animal, Habitat> ubicaciones() {
        return Map.of();
    }

    @Override
    public Map<Animal, Habitat> habitatAsignado() {
        return Map.copyOf(ubicaciones);
    }

    @Override
    public void addAnimal(Animal animal,Habitat habitat) {
        ubicaciones.put(animal,habitat);
    }

    @Override
    public Animal getAnimal (String codigo) {
        for (Animal animal : ubicaciones.keySet()) {
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
    public void cargar() { dao.cargar(ubicaciones); }



    @Override
    public boolean fechaRegistro(LocalDate registro) throws InvalidDateException {
        return false;
    }

    @Override
    public boolean animalValido(String codigoAnimal) throws InvalidAnimalException {
        for (Animal animal : ubicaciones().keySet()) {
            if (animal.getCodigoAnimal().equals(codigoAnimal)) {
                throw new InvalidAnimalException("Codigo de animal no valido");
            }
        }
        return true;
    }

    public boolean fechaValida(LocalDate registro) throws InvalidDateException {
        if (registro.isBefore(LocalDate.now())) {
            throw new InvalidDateException("La fecha de registro no puede ser anterior a la de hoy");
        }
        if (registro.getYear() > LocalDate.now().getYear() + 1) {
            throw new InvalidDateException("La fecha de inicio no puede ser superior al año " + LocalDate.now().getYear() + 1);
        }
        return true;
    }

}
