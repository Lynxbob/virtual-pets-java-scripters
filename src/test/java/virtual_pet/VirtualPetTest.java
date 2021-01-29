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

    @Test
    public void shouldTickBoredom() {
        VirtualPet pet = new VirtualPet("Kendrick");
        int initialBoredom = pet.getBoredom();
        pet.tick();
        int boredomAfterTick = pet.getBoredom();
        assertEquals(initialBoredom + 10, boredomAfterTick);
    }

    @Test
    public void shouldEat() {
        VirtualPet pet = new VirtualPet("bob");
        int initialHunger = pet.getHunger();
        pet.tick();
        pet.tick();
        pet.eat();
        int actualHunger = pet.getHunger();
        assertEquals(initialHunger, actualHunger);

    }

    @Test
    public void shouldDrink() {
        VirtualPet pet = new VirtualPet("bob");
        int initialThirst = pet.getThirst();
        pet.tick();
        pet.tick();
        pet.tick();
        pet.tick();
        pet.drink();
        int actualThirst = pet.getThirst();
        assertEquals(initialThirst + 10, actualThirst);

    }

    @Test
    public void shouldPlay() {
        VirtualPet pet = new VirtualPet("bob");
        int initialBoredom = pet.getBoredom();
        pet.tick();
        pet.tick();
        pet.tick();
        pet.tick();
        pet.play();
        int actualBoredom = pet.getBoredom();
        assertEquals(initialBoredom + 10, actualBoredom);

    }

    @Test
    public void shouldBath() {
        VirtualPet pet = new VirtualPet("bob");
        int initialHealth = pet.getHealth();
        pet.tick();
        pet.tick();
        pet.bath();
        int actualHealth = pet.getHealth();
        assertEquals(initialHealth, actualHealth);

    }

    @Test
    public void dieByHunger() {
        VirtualPet pet = new VirtualPet("bob");
        for (int i = 0; i < 10; i++) {
            pet.tick();
            pet.play();
            pet.drink();
            pet.bath();
        }
        assertEquals(true, pet.isDead());

    }

    @Test
    public void dieByThirst() {
        VirtualPet pet = new VirtualPet("bob");
        for (int i = 0; i < 10; i++) {
            pet.tick();
            pet.play();
            pet.eat();
            pet.bath();
        }
        assertEquals(true, pet.isDead());

    }

    @Test
    public void dieBySickness() {
        VirtualPet pet = new VirtualPet("bob");
        for (int i = 0; i < 10; i++) {
            pet.tick();
            pet.play();
            pet.eat();
            pet.drink();
        }
        assertEquals(true, pet.isDead());

    }

    @Test
    public void runningAway() {
        VirtualPet pet = new VirtualPet("bob");
        for (int i = 0; i < 10; i++) {
            pet.tick();
            pet.eat();
            pet.drink();
            pet.bath();
        }
        assertEquals(true, pet.isDead());

    }

}
