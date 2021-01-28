package virtual_pet;

import java.util.Scanner;

public class Application {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        VirtualPet pet = intro(input);
        instructions(pet);

    }
    public static VirtualPet intro(Scanner input){
        System.out.println("Welcome to the Java scripters virtual pet game!");
        System.out.println("What would you like to name your pet?");
        String petName = input.nextLine();
        VirtualPet pet = new VirtualPet(petName);
        System.out.println("Say hello to your new pet " + pet.getName() + "!");
        return pet;
    }
    public static void instructions(VirtualPet pet){
        System.out.println("To interact with " + pet.getName() + ", enter '1' to feed "
                        + pet.getName() + ".");
        System.out.println("Enter '2' to give your pet a bath.");
        System.out.println("Enter '3' to give your pet water.");
        System.out.println("Enter '4' to play with your pet.");
        System.out.println("To see how your pet is doing, enter '5'.");
        System.out.println("and if your would like to leave, enter '0'.");
    }

}
