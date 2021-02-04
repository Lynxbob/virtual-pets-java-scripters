package virtual_pet;

import java.util.*;

public class VirtualPetShelter {
    //Map Keys always are lowercase for consistency in terms of reading, Pet names ignore case however
    private Map<String, VirtualPet> mapOfPets;

    public VirtualPetShelter() {
        mapOfPets = new HashMap<>();
    }

    public Map<String,VirtualPet> getMapOfPets() {
        return mapOfPets;
    }

    public Collection<VirtualPet> getListOfPets() {
        return mapOfPets.values();
    }

    public void takeIn(VirtualPet pet) {
        mapOfPets.put(pet.getName().toLowerCase(), pet);
    }

    public VirtualPet adopt(String name) {
        name = name.toLowerCase();
        VirtualPet petToAdopt = mapOfPets.get(name);
        mapOfPets.remove(name);
        return petToAdopt;
    }

    public void feedOnePet(String name) {
        mapOfPets.get(name).eat();
    }

    public void feedAllPets() {
        for(VirtualPet pet : mapOfPets.values()) {
            pet.eat();
        }
    }
    public void waterOnePet(String name) {
        mapOfPets.get(name).drink();
    }

    public void waterAllPets() {
        for(VirtualPet pet : mapOfPets.values()) {
            pet.drink();
        }
    }
    public void playWithOnePet(String name) {
        mapOfPets.get(name).play();
    }

    public void playWithAllPets() {
        for(VirtualPet pet : mapOfPets.values()) {
            pet.play();
        }
    }
    public void batheOnePet(String name) {
        mapOfPets.get(name).bath();
    }

    public void batheAllPets() {
        for(VirtualPet pet : mapOfPets.values()) {
            pet.bath();
        }
    }

    public void removeDeadPet(VirtualPet pet) {
        if(pet.isDead()) {
            mapOfPets.remove(pet.getName().toLowerCase());
        }
    }

    public void printStatusOfAllPets() {
        System.out.println("| Name     | " + "Boredom |" + " Hunger | " + "Thirst | " + "Health |");
        System.out.println("-------------------------------------------------");
        for(VirtualPet pet: mapOfPets.values()) {
            System.out.printf("| %-8s | %3d     | %3d    | %3d    | %3d    |", pet.getName(), pet.getBoredom(),pet.getHunger(),
                    pet.getThirst(),pet.getHealth());
            System.out.println();
        }
    }
}
