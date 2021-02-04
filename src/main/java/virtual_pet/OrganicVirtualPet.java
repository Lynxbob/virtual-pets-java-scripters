package virtual_pet;

public abstract class OrganicVirtualPet extends VirtualPet{
    protected int cageCleanliness;
    protected int deathModifier;

    public OrganicVirtualPet(String name) {
        super(name);
        cageCleanliness = 100;
        deathModifier = 1;
    }

    public void setCageCleanliness(int cageCleanliness) {
        this.cageCleanliness = cageCleanliness;
    }

    public void clean() {
        cageCleanliness += 30;
        if( cageCleanliness > 100 ) {
            cageCleanliness = 100;
        }
    }

    @Override
    public void tick() {
        health -= 4 * deathModifier;
        hunger += 4 * deathModifier;
        thirst += 4 * deathModifier;
        boredom += 4 * deathModifier;
        cageCleanliness -= 10 * deathModifier;
        isDeadCheck();
    }

}
