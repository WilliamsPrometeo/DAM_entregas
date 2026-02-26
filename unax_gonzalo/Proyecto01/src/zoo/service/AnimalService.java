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
        private static Map<Animal, Habitat> datos = new LinkedHashMap<>();
        private final AnimalDAO dao = new AnimalDAO();


    @Override
    public Map<Animal, Habitat> ubicaciones() {
        return Map.copyOf(datos);
    }

    @Override
    public void addAnimal(Animal animal, Habitat habitat) {
        datos.put(animal, habitat);
    }

    @Override
    public Animal getAnimal(String codigo) {
        for (Animal animal : datos.keySet()) {
            if (animal.getIdAnimal().equals(codigo)) {
                return animal;
            }
        }
        return null;
    }

    @Override
    public boolean eliminarAnimal(String codigo) {
        Animal animal = getAnimal(codigo);
        if (animal != null) {
            datos.remove(animal);
            return true;
        }
        return false;
    }
    @Override
    public void guardar() {
        dao.guardar(datos);
    }

    @Override
    public void cargar() {
        datos = dao.cargar();
    }

    @Override
    public boolean animalValido(String idAnimal) throws InvalidAnimalException {
        for (Animal animal : datos.keySet()) {
            if (animal.getIdAnimal().equals(idAnimal)) {
                throw new InvalidAnimalException("Codigo de animal no valido");
            }
        }
        return true;
    }

    @Override
    public boolean fechaValida(LocalDate registro) throws InvalidDateException {
        if (registro.isBefore(LocalDate.now())) {
            throw new InvalidDateException("La fecha de inicio no puede ser anterior a la de hoy");
        }
        if (registro.getYear() > LocalDate.now().getYear() + 1) {
            throw new InvalidDateException("La fecha de inicio no puede ser superior al año " + LocalDate.now().getYear() + 1);
        }
        return true;
    }
}
