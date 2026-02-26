package entrega4.service;

import entrega4.dao.ZooDAO;
import entrega4.exceptions.InvalidAnimalException;
import entrega4.exceptions.InvalidDateException;
import entrega4.models.Animal;
import entrega4.models.enums.Habitat;
import entrega4.repository.ZooRepository;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class ZooService implements ZooRepository {
    private static Map<Animal, Habitat> ubicaciones =  new LinkedHashMap<>();
    private final ZooDAO dao = new ZooDAO();

    @Override
    public Map<Animal, Habitat> getAnimal() {
        return Map.copyOf(ubicaciones);
    }

    @Override
    public void addAnimal(Animal animal, Habitat habitat) {
        ubicaciones.put(animal, habitat);
    }

    @Override
    public Animal getAnimal(String id_animal) {
        for(Animal animal : ubicaciones.keySet()){
            if(animal.getId_animal().equals(id_animal)){
                return animal;
            }
        }
        return null;
    }

    @Override
    public boolean eliminarAnimal(String id_animal) {
        Animal animal = getAnimal(id_animal);
        if(animal != null){
            ubicaciones.remove(animal);
            return true;
        }
        return false;
    }

    public void guardar() {
        dao.guardar(ubicaciones);
    }

    public void cargar() {
        ubicaciones = dao.cargar();
    }

    @Override
    public boolean existeAnimal(String id_animal) throws InvalidAnimalException {
        for(Animal animal : ubicaciones.keySet()){
            if(animal.getId_animal().equals(id_animal)){
                throw new InvalidAnimalException("Id de animal no válido");
            }
        }
        return true;
    }

    @Override
    public boolean fechaValida(LocalDate fecha) throws InvalidDateException {
        if(fecha.isAfter(LocalDate.now())){
            throw new InvalidDateException("Fecha invalida");
        }
        return true;
    }
}
