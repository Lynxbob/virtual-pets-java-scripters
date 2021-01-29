package virtual_pet;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean isGameRunning = true;
        VirtualPet pet = introAndMakePet(input);

        while (isGameRunning){
            printInstructions(pet);
            processCommands(pet, input);
            pet.tick();
            isGameRunning = checkForDeath(pet);
        }



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
        System.out.println("and if your would like to leave, enter '0'.");
    }

    public static boolean checkForDeath(VirtualPet pet) {
        if(pet.isDead()) {
            System.out.println("Your pet has died! Game over!");
            return false;
        }
        return true;
    }



    public static void processCommands(VirtualPet pet, Scanner input) {
        int command = input.nextInt();
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
                processCommands(pet, input);
                break;

            default :
                System.out.println("Not a valid instruction, please enter a new command.");
                printInstructions(pet);
                processCommands(pet, input);

        }


        }
    }
