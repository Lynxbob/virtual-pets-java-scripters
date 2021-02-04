package virtual_pet;

public abstract class OrganicVirtualPet extends VirtualPet{
    protected int cageCleanliness;
    protected int deathModifier;

    public OrganicVirtualPet(String name) {
        super(name);
        cageCleanliness = 100;
        deathModifier = 1;
    }

    public void clean() {
        cageCleanliness += 30;
        if( cageCleanliness > 100 ) {
            cageCleanliness = 100;
        }
    }

    @Override
    public void tick() {
        health -= 10 * deathModifier;
        hunger += 10 * deathModifier;
        thirst += 10 * deathModifier;
        boredom += 10 * deathModifier;
        cageCleanliness -= 10 * deathModifier;
        isDeadCheck();
    }

}
