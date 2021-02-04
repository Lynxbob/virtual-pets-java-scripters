package virtual_pet;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class VirtualPetShelterTest {
    @Test
    public void canCreateVirtualPetShelter() {
        VirtualPetShelter test = new VirtualPetShelter();
    }
    
    @Test 
    public void shouldTakeInPetToShelter() {
        VirtualPetShelter test = new VirtualPetShelter();
        VirtualPet pet = new VirtualPet("mike");
        Collection<VirtualPet> list = test.getListOfPets                                                                                          ();
        test.takeIn(pet);
        
        assertThat(list).contains(pet);


    }
    @Test
    public void shouldAdoptPetOutOfShelter() {
        VirtualPetShelter test = new VirtualPetShelter();
        VirtualPet pet = new VirtualPet("mike");
        Collection<VirtualPet> list = test.getListOfPets();
        test.takeIn(pet);
        VirtualPet adoptedPet = test.adopt("mike");

        assertThat(list).doesNotContain(pet);
        assertThat(pet).isEqualTo(adoptedPet);


    }
    @Test
    public void shouldFeedOnePet() {
        VirtualPetShelter test = new VirtualPetShelter();
        VirtualPet pet = new VirtualPet("mike");
        VirtualPet pet2 = new VirtualPet("mikey");
        test.takeIn(pet);
        int initialHunger = pet.getHunger();

        test.feedOnePet("mike");


        assertTrue(initialHunger  == pet.getHunger() + 30 || pet.getHunger() == 0);

    }
    @Test
    public void shouldFeedAllPets() {
        VirtualPetShelter test = new VirtualPetShelter();
        VirtualPet pet = new VirtualPet("mike");
        VirtualPet pet2 = new VirtualPet("mikey");
        int initialHunger = pet.getHunger();
        int initialHunger2 = pet2.getHunger();
        test.takeIn(pet);
        test.takeIn(pet2);
        test.feedAllPets();

        assertTrue(initialHunger  == pet.getHunger() + 30 || pet.getHunger() == 0);
        assertTrue(initialHunger2  == pet2.getHunger() + 30 || pet2.getHunger() == 0);

    }
    @Test
    public void shouldWaterOnePet() {
        VirtualPetShelter test = new VirtualPetShelter();
        VirtualPet pet = new VirtualPet("mike");
        VirtualPet pet2 = new VirtualPet("mikey");
        test.takeIn(pet);
        int initialThirst = pet.getThirst();

        test.waterOnePet("mike");


        assertTrue(initialThirst  == pet.getThirst() + 30 || pet.getThirst() == 0);

    }
    @Test
    public void shouldWaterAllPets() {
        VirtualPetShelter test = new VirtualPetShelter();
        VirtualPet pet = new VirtualPet("mike");
        VirtualPet pet2 = new VirtualPet("mikey");
        test.takeIn(pet);
        test.takeIn(pet2);
        int initialThirst = pet.getThirst();
        int initialThirst2 = pet2.getThirst();
        test.waterAllPets();

        assertTrue(initialThirst  == pet.getThirst() + 30 || pet.getThirst() == 0);
        assertTrue(initialThirst2  == pet2.getThirst() + 30 || pet2.getThirst() == 0);

    }
    @Test
    public void shouldPlayWithOnePet() {
        VirtualPetShelter test = new VirtualPetShelter();
        VirtualPet pet = new VirtualPet("mike");
        VirtualPet pet2 = new VirtualPet("mikey");
        test.takeIn(pet);
        int initialBoredom = pet.getBoredom();

        test.playWithOnePet("mike");


        assertTrue(initialBoredom  == pet.getBoredom() + 30 || pet.getBoredom() == 0);

    }
    @Test
    public void shouldPlayWithAllPets() {
        VirtualPetShelter test = new VirtualPetShelter();
        VirtualPet pet = new VirtualPet("mike");
        VirtualPet pet2 = new VirtualPet("mikey");
        test.takeIn(pet);
        test.takeIn(pet2);
        int initialBoredom = pet.getBoredom();
        int initialBoredom2 = pet2.getBoredom();
        test.playWithAllPets();

        assertTrue(initialBoredom  == pet.getBoredom() + 30 || pet.getBoredom() == 0);
        assertTrue(initialBoredom2  == pet2.getBoredom() + 30 || pet2.getBoredom() == 0);

    }
    @Test
    public void shouldBatheOnePet() {
        VirtualPetShelter test = new VirtualPetShelter();
        VirtualPet pet = new VirtualPet("mike");
        VirtualPet pet2 = new VirtualPet("mikey");
        test.takeIn(pet);
        int initialHealth = pet.getHealth();

        test.batheOnePet("mike");


        assertTrue(initialHealth  == pet.getHealth() - 30 || pet.getHealth() == 100);

    }
    @Test
    public void shouldBatheAllPets() {
        VirtualPetShelter test = new VirtualPetShelter();
        VirtualPet pet = new VirtualPet("mike");
        VirtualPet pet2 = new VirtualPet("mikey");
        test.takeIn(pet);
        test.takeIn(pet2);
        int initialHealth = pet.getHealth();
        int initialHealth2 = pet2.getHealth();
        test.batheAllPets();

        assertTrue(initialHealth == pet.getHealth() - 30 || pet.getHealth() == 100);
        assertTrue(initialHealth2  == pet2.getHealth() - 30 || pet2.getHealth() == 100);


    }
    @Test
    public void shouldPrintStatusOfAllPets() {
        VirtualPetShelter test = new VirtualPetShelter();
        VirtualPet pet = new VirtualPet("mike");
        VirtualPet pet2 = new VirtualPet("mikey");
        test.takeIn(pet);
        test.takeIn(pet2);

        test.printStatusOfAllPets();


    }
}
