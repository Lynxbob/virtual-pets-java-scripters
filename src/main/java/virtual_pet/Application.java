package virtual_pet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {
    private static Map<String, VirtualPet> petSelection = new HashMap<>();
    // the reason to add the map: the map is the way we are holding the pets, so that we can switch between pets.
    private static VirtualPetShelter shelter = new VirtualPetShelter();
    private static boolean atShelter;

    public static void main(String[] args) {
        fillPetShelter();
        Scanner input = new Scanner(System.in);
        boolean isGameRunning = true;
        VirtualPet pet = introAndMakePet(input);
        petSelection.put(pet.getName(), pet);
//        put adds the pet to the map.


        while (isGameRunning) {
            printInstructions(pet);
            pet = processCommands(pet, input);
            tickAllPets();
            isGameRunning = checkForDeath(pet);
        }


    }

    public static void fillPetShelter() {
        VirtualPet pet = new VirtualPet("bob");
        shelter.takeIn(pet);
        pet = new VirtualPet("Amy");
        shelter.takeIn(pet);
        pet = new VirtualPet("miguel");
        shelter.takeIn(pet);


    }

    public static VirtualPet introAndMakePet(Scanner input) {
        System.out.println("Welcome to the Java scripters virtual pet game!");
        System.out.println("What would you like to name your pet?");
        String petName = input.nextLine();
        VirtualPet pet = new VirtualPet(petName);
        System.out.println("Say hello to your new pet " + pet.getName() + "!");
        return pet;
    }

    public static void printInstructions(VirtualPet pet) {
        System.out.println("To interact with " + pet.getName() + ", enter '1' to bathe "
                + pet.getName() + ".");
        System.out.println("Enter '2' to feed your pet.");
        System.out.println("Enter '3' to give your pet water.");
        System.out.println("Enter '4' to play with your pet.");
        System.out.println("To see how your pet is doing, enter '5'.");
        System.out.println("and if your would like to leave the application, enter '0'.");


        if (!atShelter) {
            System.out.println("To visit the pet shelter, press '6'.");
            System.out.println("To switch the pet you are interacting with, press '7'");
        } else {
            System.out.println("to stop interacting press 6");
        }
    }

    public static void printShelterInstructions() {
        System.out.println("To interact with one pet, press 1");
        System.out.println("press 2 to adopt a pet");
        System.out.println("press 3 to return a pet to the shelter");
        System.out.println("press 4 to feed all the pets");
        System.out.println("press 5 to give water to all the pets");
        System.out.println("press 6 to bathe all the pets");
        System.out.println("press 7 to play with all the pets");
        System.out.println("press 8 to check the pets stats");
        System.out.println("press 9 to leave the shelter");
    }


    public static boolean checkForDeath() {
        for (VirtualPet pet: petSelection.values()){
            if (pet.isDead()){
                petSelection.remove(pet.getName());
            }
        }
        if (petSelection.size() == 0){
            return false;
        }
        return true;

    }


    public static VirtualPet processCommands(VirtualPet pet, Scanner input) {
        int command = input.nextInt();
        input.nextLine();
        switch (command) {
            case 0:
                System.out.println("Exiting the application..");
                System.exit(0);
            case 1:
                System.out.println("You gave your pet a bath.");
                pet.bath();
                break;
            case 2:
                System.out.println("You gave your pet food.");
                pet.eat();
                break;
            case 3:
                System.out.println("You gave your pet water.");
                pet.drink();
                break;
            case 4:
                System.out.println("You played with your pet.");
                pet.play();
                break;
            case 5:
                pet.status();
                printInstructions(pet);
                pet = processCommands(pet, input);
                break;
            case 6:
                if (!atShelter) {
                    System.out.println("you went to the shelter");
                    atShelter = true;
                    tickAllPets();
                } else {
                    System.out.println("stop interacting with " + pet.getName());
                }
                printShelterInstructions();
                processShelterCommands(input);

                break;
            case 7:
                if (!atShelter) {
                    System.out.println("What pet would you like to interact with?");
                    listAllPets();
                    String name = input.nextLine();
                    pet = petSelection.get(name);
                    break;
                }
// all long as our last case is always this one, then it will run an invalid command

            default:
                System.out.println("Not a valid instruction, please enter a new command.");
                printInstructions(pet);
                pet = processCommands(pet, input);

        }
        if (atShelter) {
            printInstructions(pet);
            pet = processCommands(pet, input);
        } else {

            atShelter = false;
        }
        return pet;
    }

    public static void processShelterCommands(Scanner input) {
        VirtualPet pet;
        int command = input.nextInt();
        String name;
        input.nextLine();
        switch (command) {
            case 0:
                System.out.println("Exiting the application..");
                System.exit(0);
            case 1:
                System.out.println("What pet would you like to interact with.");
                listAllShelterPets();
                name = input.nextLine();
                pet = shelter.getMapOfPets().get(name);
//                this will go into shelter, get the map(list of pets) and bring back the pet we asked for
                printInstructions(pet);
                processCommands(pet, input);
                break;
            case 2:
                System.out.println("what pet would you like to adopt");
                listAllShelterPets();
                name = input.nextLine();
                pet = shelter.adopt(name);
                petSelection.put(pet.getName(), pet);
                System.out.println("say hello to your new pet " + pet.getName() + "!");
                break;
            case 3:
                System.out.println("what pet would you like to return");
                listAllPets();
                name = input.nextLine();
                shelter.takeIn(petSelection.get(name));
                petSelection.remove(name);
                System.out.println("Say goodbye to " + name);
                break;
            case 4:
                System.out.println("You feed all the pets");
                shelter.feedAllPets();
                break;
            case 5:
                System.out.println("You gave water to all the pets");
                shelter.waterAllPets();
                break;
            case 6:
                System.out.println("your gave all the pets a bath");
                shelter.batheAllPets();
                break;
            case 7:
                System.out.println("you played with all the pets");
                shelter.playWithAllPets();
                break;
            case 8:
                shelter.printStatusOfAllPets();

                break;
            case 9:
                System.out.println("see you next time!");
                atShelter = false;
                return;
            default:
                System.out.println("Not a valid instruction, please enter a new command.");

        }
        tickAllShelterPets();
        printShelterInstructions();
        processShelterCommands(input);

    }

    public static void tickAllPets() {
        for (VirtualPet pet : petSelection.values()) {
            pet.tick();
        }
//            Goes through each pet
    }
    public static void tickAllShelterPets() {
        for (VirtualPet pet : shelter.getListOfPets()) {
            pet.tick();
        }
//            Goes through each pet
    }

    public static void listAllPets() {
        for (VirtualPet pet : petSelection.values()) {
            System.out.print(pet.getName() + ", ");
        }
        System.out.println();
    }

    public static void listAllShelterPets() {
        for (VirtualPet pet : petSelection.values()) {
            System.out.print(pet.getName() + ", ");
        }
        System.out.println();
    }

}
