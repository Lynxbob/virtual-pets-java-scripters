package virtual_pet;

public class OrganicVirtualCat extends VirtualPet implements Organic{

    private int cageCleanliness;
    private int deathModifier;
    public OrganicVirtualCat(String name) {
        super(name);
        cageCleanliness = 100;
        deathModifier = 1;
    }

    @Override
    public void clean() {
        System.out.println("You clean your cats' litter box.");
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

    @Override
    public void isDeadCheck() {
        super.isDeadCheck();
        if(cageCleanliness <= 40) {
            System.out.println("Your cat's litter box is starting to become very dirty.");
            deathModifier = 2;
        }
        if(cageCleanliness <= 0) {
            System.out.println("Your cat's litter box is filthy and needs cleaned immediately.");
            deathModifier = 3;
            cageCleanliness = 0;
        }

    }

    @Override
    public void status() {
        super.status();
        cageStatus();
    }

    public void cageStatus() {
        if (cageCleanliness <= 100 && cageCleanliness >= 80) {
            System.out.println(name + "'s litter box is in good condition.");
        } else if (cageCleanliness < 80 && cageCleanliness >= 50) {
            System.out.println(name + "'s litter box is relatively clean.");
        } else if (cageCleanliness < 50 && cageCleanliness >= 30) {
            System.out.println(name + "'s litter box is starting to become very dirty.");
        } else {
            System.out.println(name + "'s litter box is filthy and needs cleaned immediately.");
        }
    }

    @Override
    public String toString() {
        return "Cat: " + name;
    }

}
