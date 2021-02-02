package virtual_pet;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


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
        pet.tick();
        pet.tick();
        pet.tick();
        pet.tick();

        test.feedOnePet("mike");

        assertEquals(initialHunger + 10, pet.getHunger());
        assertEquals(0,pet2.getHunger());

    }
    @Test
    public void shouldFeedAllPets() {
        VirtualPetShelter test = new VirtualPetShelter();
        VirtualPet pet = new VirtualPet("mike");
        VirtualPet pet2 = new VirtualPet("mikey");
        test.takeIn(pet);
        test.takeIn(pet2);
        for(int i = 0 ; i < 4; i++) {
            pet.tick();
            pet2.tick();
        }
        test.feedAllPets();

        assertEquals(10, pet.getHunger());
        assertEquals(10,pet2.getHunger());

    }
    @Test
    public void shouldWaterOnePet() {
        VirtualPetShelter test = new VirtualPetShelter();
        VirtualPet pet = new VirtualPet("mike");
        VirtualPet pet2 = new VirtualPet("mikey");
        test.takeIn(pet);
        int initialThirst = pet.getThirst();
        pet.tick();
        pet.tick();
        pet.tick();
        pet.tick();

        test.waterOnePet("mike");

        assertEquals(initialThirst + 10, pet.getThirst());
        assertEquals(0,pet2.getThirst());

    }
    @Test
    public void shouldWaterAllPets() {
        VirtualPetShelter test = new VirtualPetShelter();
        VirtualPet pet = new VirtualPet("mike");
        VirtualPet pet2 = new VirtualPet("mikey");
        test.takeIn(pet);
        test.takeIn(pet2);
        for(int i = 0 ; i < 4; i++) {
            pet.tick();
            pet2.tick();
        }
        test.waterAllPets();

        assertEquals(10, pet.getThirst());
        assertEquals(10,pet2.getThirst());

    }
    @Test
    public void shouldPlayWithOnePet() {
        VirtualPetShelter test = new VirtualPetShelter();
        VirtualPet pet = new VirtualPet("mike");
        VirtualPet pet2 = new VirtualPet("mikey");
        test.takeIn(pet);
        int initialBoredom = pet.getBoredom();
        pet.tick();
        pet.tick();
        pet.tick();
        pet.tick();

        test.playWithOnePet("mike");

        assertEquals(initialBoredom + 10, pet.getBoredom());
        assertEquals(0,pet2.getBoredom());

    }
    @Test
    public void shouldPlayWithAllPets() {
        VirtualPetShelter test = new VirtualPetShelter();
        VirtualPet pet = new VirtualPet("mike");
        VirtualPet pet2 = new VirtualPet("mikey");
        test.takeIn(pet);
        test.takeIn(pet2);
        for(int i = 0 ; i < 4; i++) {
            pet.tick();
            pet2.tick();
        }
        test.playWithAllPets();

        assertEquals(10, pet.getBoredom());
        assertEquals(10,pet2.getBoredom());

    }
    @Test
    public void shouldBatheOnePet() {
        VirtualPetShelter test = new VirtualPetShelter();
        VirtualPet pet = new VirtualPet("mike");
        VirtualPet pet2 = new VirtualPet("mikey");
        test.takeIn(pet);
        int initialHealth = pet.getHealth();
        pet.tick();
        pet.tick();
        pet.tick();
        pet.tick();

        test.batheOnePet("mike");

        assertEquals(initialHealth - 10, pet.getHealth());
        assertEquals(100,pet2.getHealth());

    }
    @Test
    public void shouldBatheAllPets() {
        VirtualPetShelter test = new VirtualPetShelter();
        VirtualPet pet = new VirtualPet("mike");
        VirtualPet pet2 = new VirtualPet("mikey");
        test.takeIn(pet);
        test.takeIn(pet2);
        for(int i = 0 ; i < 4; i++) {
            pet.tick();
            pet2.tick();
        }
        test.batheAllPets();

        assertEquals(90, pet.getHealth());
        assertEquals(90,pet2.getHealth());

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
