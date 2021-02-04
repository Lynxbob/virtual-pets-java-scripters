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
        health -= 10 ;
        hunger += 10 ;
        thirst += 10 ;
        boredom += 10 ;
        oilLevel -=10 * walkModifier;
        isDeadCheck();
        walkModifier=1;

    }
    @Override
    public String toString() {
        return "robotic dog: " + name;
    }

}
