package virtual_pet;

public class VirtualPet {

    private String name;
    private int age;
    private int health, hunger, thirst, boredom;

    public VirtualPet(String name) {
        this.name = name;
        this.age = 0;
        this.hunger = 0;
        this.health = 100;
        this.thirst = 0;
        this.boredom = 0;

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getHealth() {
        return health;
    }

    public int getHunger() {
        return hunger;
    }

    public int getThirst() {
        return thirst;
    }

    public int getBoredom() {
        return boredom;
    }

    public void tick() {
        health -=10;
        hunger +=10;
        thirst +=10;
        boredom +=10;

    }
}
