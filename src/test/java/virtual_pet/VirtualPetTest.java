package virtual_pet;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VirtualPetTest {
    @Test
    public void shouldBeAbleToCreatePet() {
        VirtualPet pet = new VirtualPet("Java");
    }
    @Test
    public void petShouldHaveName() {
        VirtualPet underTest = new VirtualPet("Jeff");

        String expected = underTest.getName();

        assertEquals(expected, "Jeff");
    }
    @Test
    public void shouldHaveDefaultHunger() {
        VirtualPet underTest = new VirtualPet("Steve");

        int expected = underTest.getHunger();

        assertEquals(expected, 0);
    }
    @Test
    public void shouldHaveDefaultThirst() {
        VirtualPet underTest = new VirtualPet("Steve");

        int expected = underTest.getThirst();

        assertEquals(expected, 0);
    }
    @Test
    public void shouldHaveDefaultBoredom() {
        VirtualPet underTest = new VirtualPet("Steve");

        int expected = underTest.getBoredom();

        assertEquals(expected, 0);
    }
    @Test
    public void shouldHaveDefaultHealth() {
        VirtualPet underTest = new VirtualPet("Steve");

        int expected = underTest.getHealth();

        assertEquals(expected, 100);
    }
    @Test
    public void shouldTickHunger() {
        VirtualPet pet = new VirtualPet("Kendrick");
        int initialHunger = pet.getHunger();
        pet.tick();
        int hungerAfterTick = pet.getHunger();
        assertEquals(initialHunger + 10, hungerAfterTick);
    }
    @Test
    public void shouldTickHealth() {
        VirtualPet pet = new VirtualPet("Kendrick");
        int initialHealth = pet.getHealth();
        pet.tick();
        int healthAfterTick = pet.getHealth();
        assertEquals(initialHealth - 10, healthAfterTick);
    }
    @Test
    public void shouldTickThirst() {
        VirtualPet pet = new VirtualPet("Kendrick");
        int initialThirst = pet.getThirst();
        pet.tick();
        int thirstAfterTick = pet.getThirst();
        assertEquals(initialThirst + 10, thirstAfterTick);
    }
}
