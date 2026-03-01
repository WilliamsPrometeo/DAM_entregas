package proyecto4.service;

import proyecto4.dao.AnimalDAO;
import proyecto4.exceptions.InvalidAnimalException;
import proyecto4.exceptions.InvalidDateException;
import proyecto4.models.Animal;
import proyecto4.models.enums.Habitat;
import proyecto4.repository.ZooRepository;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class ZooService implements ZooRepository {
    private static Map<Animal, Habitat> animales = new LinkedHashMap<>();
    private final AnimalDAO animalDAO = new AnimalDAO();

    @Override
    public Map<Animal, Habitat> getAnimales() {
        return Map.copyOf(animales);
    }

    @Override
    public void addAnimal(Animal animal, Habitat habitat) {
        animales.put(animal, habitat);
    }

    @Override
    public Animal getAnimal(String idAnimal) {
        for (Animal animal : animales.keySet()) {
            if (animal.getIdAnimal().equals(idAnimal)) {
                return animal;
            }
        }
        return null;
    }

    @Override
    public boolean eliminarAnimal(String idAnimal) {
        Animal animal = getAnimal(idAnimal);
        if (animal != null) {
            animales.remove(animal);
            return true;
        }
        return false;
    }

    @Override
    public void guardar() {
        animalDAO.guardar(animales);
    }

    @Override
    public void cargar() {
        animales=animalDAO.cargar();
    }

    @Override
    public boolean registroValido(String idAnimal) throws InvalidAnimalException {
        for  (Animal animal : animales.keySet()) {
            if (animal.getIdAnimal().equals(idAnimal)) {
                throw new InvalidAnimalException("Código de registro invalido, el animal ya existe");
            }
        }
        return true;
    }

    @Override
    public boolean fechaValida(LocalDate fecha) throws InvalidDateException {
        if(fecha.isBefore(LocalDate.now())){
            throw new InvalidDateException("Fecha invalida, el registro no puede ser anterior a hoy.");
        }
        if(fecha.getYear()>LocalDate.now().getYear()+1){
            throw new InvalidDateException("El límite para la fecha de registro es de 1 año.");
        }
        return true;
    }
}
