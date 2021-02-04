package virtual_pet;

public class RoboticVirtualDog extends RoboticVirtualPet implements Walkable {

    private int walkModifier;

    public RoboticVirtualDog(String name) {
        super(name);
        walkModifier=1;
    }


    @Override
    public void walk() {
        boredom -=50;
        if (boredom<0){
            boredom=0;
        }
        walkModifier=2;
    }
    @Override
    public void tick() {
        health -= 4 ;
        hunger += 4 ;
        thirst += 4 ;
        boredom += 4 ;
        oilLevel -= 4 * walkModifier;
        isDeadCheck();
        walkModifier=1;

    }
    @Override
    public String toString() {
        return "Robotic Dog: " + name;
    }

}
