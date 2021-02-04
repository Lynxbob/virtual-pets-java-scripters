package virtual_pet;

import java.util.*;

public class Application {
    private static Map<String, VirtualPet> petSelection = new HashMap<>();
    // the reason to add the map: the map is the way we are holding the pets, so that we can switch between pets.
    private static VirtualPetShelter shelter = new VirtualPetShelter();
    //tests if were at the shelter, which lets us print out different options
    private static boolean atShelter;

    //this is where the game runs
    public static void main(String[] args) {
        fillPetShelter();
        Scanner input = new Scanner(System.in);
        boolean isGameRunning = true;
        VirtualPet pet = introAndMakePet(input);


        while (isGameRunning) {
            printInstructions(pet);
            pet = processCommands(pet, input);
            tickAllPets();
            isGameRunning = checkForDeath();
        }


    }

    //adds pets to the shelter so that its not empty during the program.
    public static void fillPetShelter() {
        VirtualPet pet = new VirtualPet("bob");
        shelter.takeIn(pet);
        pet = new VirtualPet("amy");
        shelter.takeIn(pet);
        pet = new VirtualPet("miguel");
        shelter.takeIn(pet);


    }


    //method to choose what pet to create
    public static VirtualPet chooseStartingPet(Scanner input, String name) {
        VirtualPet pet;
        System.out.println("What type of pet do you want to create?");
        System.out.println("Press 1 for robotic dog");
        System.out.println("Press 2 for robotic cat");
        System.out.println("Press 3 for organic dog");
        System.out.println("Press 4 for organic cat");
        int command = input.nextInt();

        switch (command) {
            case 1:
                pet = new RoboticVirtualDog(name);
                break;
            case 2:
                pet = new RoboticVirtualCat(name);
                break;

            case 3:
                pet = new OrganicVirtualDog(name);
                break;

            case 4:
                pet = new OrganicVirtualCat(name);
                break;

            default:
                System.out.println("Not a valid instruction,please enter a new command");
                return chooseStartingPet(input, name);

        }

        return pet;


    }

    //intro for the game
    public static VirtualPet introAndMakePet(Scanner input) {
        System.out.println("Welcome to the Java scripters virtual pet game!");
        System.out.println("What would you like to name your pet?");
        String petName = input.nextLine();
        VirtualPet pet = chooseStartingPet(input,petName);
        System.out.println("Say hello to your new pet " + pet.getName() + "!");
        petSelection.put(pet.getName().toLowerCase(), pet);
        return pet;
    }

    //prints out the different instructions before prompting for user input
    public static void printInstructions(VirtualPet pet) {
        System.out.println("If you would like to leave the application, enter '0'.");
        System.out.println("To interact with " + pet.getName() + ", enter '1' to bathe "
                + pet.getName() + ".");
        System.out.println("Enter '2' to feed your pet.");
        System.out.println("Enter '3' to give your pet water.");
        System.out.println("Enter '4' to play with your pet.");
        System.out.println("To see how your pet is doing, enter '5'.");


        //prints out different options whether or not you're at the shelter
        if (!atShelter) {
            System.out.println("To visit the pet shelter, press '6'.");
            System.out.println("To switch the pet you are interacting with, press '7'.");
        } else {
            System.out.println("To stop interacting with the pet, press '6'.");
        }
        if (pet instanceof RoboticVirtualPet) {
            System.out.println("To oil your pet, press '8'. ");
        } else {
            System.out.println("To clean your pet's cage/litter box, press '8'.");
        }
        if (pet instanceof Walkable) {
            System.out.println("To walk your pet,press '9'.");
        }
    }

    //prints out instructions specifically for the pet shelter
    public static void printShelterInstructions() {
        System.out.println("To exit the program, press '0'.");
        System.out.println("To interact with one pet, press '1'.");
        System.out.println("Press '2' to adopt a pet.");
        System.out.println("Press '3' to return a pet to the shelter.");
        System.out.println("Press '4' to feed all the pets.");
        System.out.println("Press '5' to give water to all the pets.");
        System.out.println("Press '6' to bathe all the pets.");
        System.out.println("Press '7' to play with all the pets.");
        System.out.println("Press '8' to check the pets stats.");
        System.out.println("Press '9' to leave the shelter.");
    }

    //checks to see if a pet has died. if all pets have died, the game ends.
    public static boolean checkForDeath() {
        int size = petSelection.values().size();
        //you cant use a foreach loop to iterate through a collection backwards, so we make the collection an arrayList
        Collection<VirtualPet> petCollection = petSelection.values();
        List<VirtualPet> petList = new ArrayList<>(petCollection);

        //iterates through the loop backwards so that when it removes pets it doesnt interfere with the rest of the array(this code wont
        //work with a for each loop)
        for (int i = size - 1; i >= 0; i--) {
            if (petList.get(i).isDead()) {
                petSelection.remove(petList.get(i).getName().toLowerCase());
            }
        }
        if (petSelection.size() == 0) {
            System.out.println("All of your pets have died! Game Over!");
            return false;
        }
        return true;
    }

    //does the same thing as the checkForDeath method, but it specifically removes pets from the shelter that have died.
    public static void checkForShelterDeaths() {
        int size = shelter.getListOfPets().size();
        Collection<VirtualPet> petCollection = shelter.getListOfPets();
        List<VirtualPet> petList = new ArrayList<>(petCollection);

        for (int i = size - 1; i >= 0; i--) {
            if (petList.get(i).isDead()) {
                shelter.removeDeadPet(petList.get(i));
            }
        }
    }

    //takes user input to process whichever command is needed
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
                    System.out.println("You went to the shelter.");
                    atShelter = true;
                    tickAllPets();
                } else {
                    System.out.println("You stopped interacting with " + pet.getName() + ".");
                }
                printShelterInstructions();
                processShelterCommands(input);

                break;
            case 7:
                //if not at shelter, then asks which of your pets to interact with. if at the shelter, skips case 7 and prints default.
                if (!atShelter) {
                    System.out.println("What pet would you like to interact with?");
                    listAllPets();
                    String name = input.nextLine().toLowerCase();
                    pet = petSelection.get(name);
                    break;
                }
// all long as our last case is always this one, then it will run an invalid command

            default:
                System.out.println("Not a valid instruction, please enter a new command.");
                printInstructions(pet);
                pet = processCommands(pet, input);

        }
        //if at the shelter, then it will stay in the loop so that it will continue to let you interact with whatever pet you like
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
                System.out.println("What pet would you like to interact with?");
                listAllShelterPets();
                name = input.nextLine().toLowerCase();
                pet = shelter.getMapOfPets().get(name);
//                this will go into shelter, get the map(list of pets) and bring back the pet we asked for
                printInstructions(pet);
                processCommands(pet, input);
                break;
            case 2:
                System.out.println("What pet would you like to adopt?");
                listAllShelterPets();
                name = input.nextLine();
                pet = shelter.adopt(name);
                petSelection.put(pet.getName().toLowerCase(), pet);
                System.out.println("say hello to your new pet " + pet.getName() + "!");
                break;
            case 3:
                System.out.println("What pet would you like to return?");
                listAllPets();
                name = input.nextLine().toLowerCase();
                shelter.takeIn(petSelection.get(name));
                petSelection.remove(name);
                System.out.println("Say goodbye to " + name + "!");
                break;
            case 4:
                System.out.println("You feed all the pets.");
                shelter.feedAllPets();
                break;
            case 5:
                System.out.println("You gave water to all the pets.");
                shelter.waterAllPets();
                break;
            case 6:
                System.out.println("You gave all the pets a bath.");
                shelter.batheAllPets();
                break;
            case 7:
                System.out.println("You played with all the pets.");
                shelter.playWithAllPets();
                break;
            case 8:
                shelter.printStatusOfAllPets();
                printShelterInstructions();
                processShelterCommands(input);
                return;
            case 9:
                System.out.println("See you next time!");
                atShelter = false;
                return;
            default:
                System.out.println("Not a valid instruction, please enter a new command.");

        }
        //changes stats of the shelter pets, checks if any have died, then stays in the loop until user specifies to leave.
        tickAllShelterPets();
        checkForShelterDeaths();
        printShelterInstructions();
        processShelterCommands(input);

    }

    //enhancement of tick that allows you to tick any of your pets
    public static void tickAllPets() {
        for (VirtualPet pet : petSelection.values()) {
            pet.tick();
        }
//            Goes through each pet
    }

    //ticks all pets
    public static void tickAllShelterPets() {
        for (VirtualPet pet : shelter.getListOfPets()) {
            pet.tick();
        }
//            Goes through each pet
    }

    //prints out a list of pets names, so you know which you can choose between
    public static void listAllPets() {
        System.out.println(petSelection.values());
    }

    //prints out a list of shelter pets' names, so you know which you can choose between
    public static void listAllShelterPets() {
        System.out.println(shelter.getMapOfPets().values());
    }

}
