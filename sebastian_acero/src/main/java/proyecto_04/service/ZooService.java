package proyecto_04.service;

import proyecto_04.dao.ZooDao;
import proyecto_04.exception.InvalidDateException;
import proyecto_04.models.Animal;
import proyecto_04.models.enums.Habitad;
import proyecto_04.repository.ZooRepository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ZooService implements ZooRepository {
    private static Map<Animal, Habitad> animales = new HashMap<>();
    private final ZooDao dao = new ZooDao();

    @Override
    public Map<Animal, Habitad> getAnimals() {
        return Map.copyOf(animales);
    }

    @Override
    public void addAnimal(Animal animal, Habitad habitad) {
        animales.put(animal, habitad);

    }

    @Override
    public Animal getAnimal(String nombre) {
        for (Animal animal : animales.keySet()) {
            if(animal.getId().equals(nombre)){
                return animal;
            }
        }
        return null;
    }

    @Override
    public boolean eliminarAnimal(String nombre) {
        Animal animal = getAnimal(nombre);
        if(animal != null){
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
    public boolean existeAnimal(String idAnimal) throws Exception {
        for (Animal animal : animales.keySet()) {
            if(animal.getId().equals(idAnimal)){
                throw new InvalidDateException("Id de animal no valido");
            }
        }
        return false;
    }

    @Override
    public boolean existeHabitad(String nombre) throws Exception {
        return false;
    }

    public boolean fechaValida(LocalDate entrada) throws InvalidDateException {
        if (entrada.isAfter(getAnimal(animales))) {
            throw new InvalidDateException("La fecha de salida no puede ser anterior a la de entrada");
        }
        if (entrada.isBefore(LocalDate.now())) {
            throw new InvalidDateException("La fecha de entrada no puede ser anterior a la de hoy");
        }
        if (entrada.getYear() > LocalDate.now().getYear() + 1) {
            throw new InvalidDateException("La fecha de entrada no puede ser superior al año " + LocalDate.now().getYear() + 1);
        }
        return true;
    }
}
