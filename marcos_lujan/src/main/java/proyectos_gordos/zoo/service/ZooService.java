package proyectos_gordos.zoo.service;

import proyectos_gordos.zoo.dao.ZooDAO;
import proyectos_gordos.zoo.exceptions.InvalidAnimalException;
import proyectos_gordos.zoo.exceptions.InvalidDateException;
import proyectos_gordos.zoo.models.Animal;
import proyectos_gordos.zoo.models.enums.Habitat;
import proyectos_gordos.zoo.repository.ZooRepository;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class ZooService implements ZooRepository {

    private static Map<Animal, Habitat> animales = new LinkedHashMap<>();
    private static final ZooDAO dao = new ZooDAO();

    @Override
    public Map<Animal, Habitat> getAnimal() {
        return Map.copyOf(animales);
    }

    @Override
    public void addAnimal(Animal animal, Habitat habitat) { animales.put(animal, habitat); }


    @Override
    public Animal getAnimal(String id) {
        for (Animal animal : animales.keySet()) {
            if(animal.getId().equals(id)){
                return animal;
            }
        }
        return null;
    }

    @Override
    public boolean eliminarAnimal(String id) {
        Animal animal1 = getAnimal(id);
        if(animal1 != null){
            animales.remove(animal1);
            return true;
        }
        return false;
    }

    @Override
    public void guardar() { dao.guardar(animales);}

    @Override
    public void cargar() { dao.cargar();}

    @Override
    public boolean existeAnimal(String id) throws InvalidAnimalException {
        for(Animal animal : animales.keySet()){
            if(animal.getId().equals(id)){
                throw new InvalidAnimalException("Código no válido, animal ya existe!!!");
            }
        }
        return true;
    }


    @Override
    public boolean fechaValida(LocalDate fechaEntrada) throws InvalidDateException {
        if (fechaEntrada.isBefore(LocalDate.now())) {
            throw new InvalidDateException("La fecha de entrada no puede ser anterior a la de hoy");
        }
        if (fechaEntrada.getYear() > LocalDate.now().getYear() + 1) {
            throw new InvalidDateException("La fecha de entrada no puede ser superior al año " + LocalDate.now().getYear() + 1);
        }
        return true;
    }


}
