package virtual_pet;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean isGameRunning = true;
        VirtualPet pet = intro(input);

        while (isGameRunning){

            instructions(pet);
            commands(pet, input);
            pet.tick();
            
        }


    }

    public static VirtualPet intro(Scanner input) {
        System.out.println("Welcome to the Java scripters virtual pet game!");
        System.out.println("What would you like to name your pet?");
        String petName = input.nextLine();
        VirtualPet pet = new VirtualPet(petName);
        System.out.println("Say hello to your new pet " + pet.getName() + "!");
        return pet;
    }

    public static void instructions(VirtualPet pet) {
        System.out.println("To interact with " + pet.getName() + ", enter '1' to feed "
                + pet.getName() + ".");
        System.out.println("Enter '2' to give your pet a bath.");
        System.out.println("Enter '3' to give your pet water.");
        System.out.println("Enter '4' to play with your pet.");
        System.out.println("To see how your pet is doing, enter '5'.");
        System.out.println("and if your would like to leave, enter '0'.");
    }



    public static void commands(VirtualPet pet, Scanner input) {
        int command = input.nextInt();
        switch (command) {
            case 0:
                System.exit(0);
            case 1:
                pet.eat();
                break;
            case 2:
                pet.bath();
                break;
            case 3:
                pet.drink();
                break;
            case 4:
                pet.play();
                break;
            case 5:
                pet.status();
                instructions(pet);
                commands(pet, input);
                break;

            default :
                System.out.println("Not a valid instruction, please enter a new command");

                instructions(pet);
                commands(pet, input);

        }


        }
    }
