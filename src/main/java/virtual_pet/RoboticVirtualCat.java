package virtual_pet;

public class RoboticVirtualCat extends RoboticVirtualPet  {
    public RoboticVirtualCat(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Robotic Cat: " + name;
    }
}
