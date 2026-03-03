package gestion_zoo.service;

import gestion_zoo.dao.ZooDAO;
import gestion_zoo.exceptions.InvalidAnimalException;
import gestion_zoo.exceptions.InvalidDateException;
import gestion_zoo.models.Animal;
import gestion_zoo.models.enums.TipoHabitat;
import gestion_zoo.repository.ZooRepository;


import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class ZooService implements ZooRepository {
    private static Map<Animal, TipoHabitat> animales = new LinkedHashMap<>();
    private final ZooDAO dao = new ZooDAO();

    @Override
    public Map<Animal, TipoHabitat> getAnimales() {
        return Map.copyOf(animales);
    }

    public void addAnimales (Animal animal, TipoHabitat tipoHabitat) {
        animales.put(animal, tipoHabitat);
    }

    @Override
    public void addAnimal(Animal animal,TipoHabitat tipoHabitat) {
        animales.put(animal, tipoHabitat);
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
        Animal animal= getAnimal(idAnimal);
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
    public boolean animalValida(String idAnimalAnimal) throws InvalidAnimalException {
        for (Animal animal : animales.keySet()) {
            if (animal.getIdAnimal().equals(idAnimalAnimal)) {
                throw new InvalidAnimalException("Codigo de animal no valido");
            }
        }
        return true;
    }

    @Override
    public boolean fechaValida(LocalDate registro) throws InvalidDateException {
        if (registro.isBefore(LocalDate.now())) {
            throw new InvalidDateException("La fecha de entrada no puede ser anterior a la de hoy");
        }
        return true;
    }
}
